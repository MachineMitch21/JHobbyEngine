package JHobbyEngine;

import org.lwjgl.system.MemoryStack;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL33.*;

public class GLShader {
    private int type;
    private int id;

    public GLShader(int type) {
        this.type = type;
        this.id = 0;
    }

    public void destroy() {
        glDeleteShader(this.id);
    }

    public boolean create(String src, StringCallback cb) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer result = stack.mallocInt(1);
            IntBuffer logLength = stack.mallocInt(1);

            glShaderSource(this.id, src);
            glCompileShader(this.id);

            glGetShaderiv(this.id, GL_COMPILE_STATUS, result);
            glGetShaderiv(this.id, GL_INFO_LOG_LENGTH, logLength);

            if (result.get(0) == GL_FALSE) {
                ByteBuffer err = stack.malloc(logLength.get(0));
                glGetShaderInfoLog(this.id, logLength, err);

                if (cb != null) {
                    cb.callback(err.toString());
                }
                this.id = 0;
                return false;
            }
        }
        return true;
    }

    public int getType() {
        return this.type;
    }

    public int getId() {
        return this.id;
    }
}
