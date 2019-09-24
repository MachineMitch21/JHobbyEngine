package JHobbyEngine;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
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

        IntBuffer result = IntBuffer.allocate(1);
        IntBuffer logLength = IntBuffer.allocate(1);

        glGetProgramiv(this.id, GL_LINK_STATUS, result);
        glGetProgramiv(this.id, GL_INFO_LOG_LENGTH, logLength);

        if (result.get(0) == GL_FALSE) {
            ByteBuffer err = ByteBuffer.allocateDirect(logLength.get(0));
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

    public void setBoolean(String name, boolean val) {
        int loc = glGetUniformLocation(this.id, name);
        glUniform1i(this.id, (val ? 1 : 0));
    }

    public void setInteger(String name, int val) {
        int loc = glGetUniformLocation(this.id, name);
        glUniform1i(loc, val);
    }

    public void setFloat(String name, float val) {
        int loc = glGetUniformLocation(this.id, name);
        glUniform1f(loc, val);
    }

    public void setVector2(String name, float v1, float v2) {
        int loc = glGetUniformLocation(this.id, name);
        glUniform2f(loc, v1, v2);
    }

    public void setVector3(String name, float v1, float v2, float v3) {
        int loc = glGetUniformLocation(this.id, name);
        glUniform3f(loc, v1, v2, v3);
    }

    public void setVector4(String name, float v1, float v2, float v3, float v4) {
        int loc = glGetUniformLocation(this.id, name);
        glUniform4f(loc, v1, v2, v3, v4);
    }
}
