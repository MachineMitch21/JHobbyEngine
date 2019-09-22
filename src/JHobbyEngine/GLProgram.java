package JHobbyEngine;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;

import static org.lwjgl.opengl.GL33.*;

public class GLProgram {
    private int id;

    public GLProgram() {
        this.id = 0;
    }

    public void destroy() {
        glDeleteProgram(this.id);
    }

    public boolean create(Collection<GLShader> shaders, StringCallback cb) {
        this.id = glCreateProgram();
        for (Iterator<GLShader> it = shaders.iterator(); it.hasNext(); ) {
            GLShader shader = it.next();
            glAttachShader(this.id, shader.getId());
        }
        glLinkProgram(this.id);

        int[] result = {GL_FALSE};
        int[] logLength = {0};

        glGetProgramiv(this.id, GL_LINK_STATUS, result);
        glGetProgramiv(this.id, GL_INFO_LOG_LENGTH, logLength);

        if (result[0] == GL_FALSE) {
            ByteBuffer err = ByteBuffer.allocate(logLength[0]);
            glGetProgramInfoLog(this.id, logLength, err);
            if (cb != null) {
                cb.callback(err.toString());
            }
            return false;
        }
        return true;
    }

    public void bind() {
        glUseProgram(this.id);
    }

    public static void unbind() {
        glUseProgram(0);
    }
}
