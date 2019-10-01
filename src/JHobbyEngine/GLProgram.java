package JHobbyEngine;

import JHobbyEngine.math.Vector2;
import JHobbyEngine.math.Vector3;
import JHobbyEngine.math.Vector4;
import org.lwjgl.system.MemoryStack;

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
        try (MemoryStack stack = MemoryStack.stackPush()) {
            this.id = glCreateProgram();
            for (Iterator<GLShader> it = shaders.iterator(); it.hasNext(); ) {
                GLShader shader = it.next();
                glAttachShader(this.id, shader.getId());
            }
            glLinkProgram(this.id);

            IntBuffer result = stack.mallocInt(1);
            IntBuffer logLength = stack.mallocInt(1);

            glGetProgramiv(this.id, GL_LINK_STATUS, result);
            glGetProgramiv(this.id, GL_INFO_LOG_LENGTH, logLength);

            if (result.get(0) == GL_FALSE) {
                ByteBuffer err = stack.malloc(logLength.get(0));
                glGetProgramInfoLog(this.id, logLength, err);
                if (cb != null) {
                    cb.callback(err.toString());
                }
                return false;
            }
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

    public void setFloat(String name, Float val) {
        int loc = glGetUniformLocation(this.id, name);
        glUniform1f(loc, val);
    }

    public void setVector2(String name, Float v1, Float v2) {
        int loc = glGetUniformLocation(this.id, name);
        glUniform2f(loc, v1, v2);
    }

    public void setVector3(String name, Float v1, Float v2, Float v3) {
        int loc = glGetUniformLocation(this.id, name);
        glUniform3f(loc, v1, v2, v3);
    }

    public void setVector4(String name, Float v1, Float v2, Float v3, Float v4) {
        int loc = glGetUniformLocation(this.id, name);
        glUniform4f(loc, v1, v2, v3, v4);
    }

    public void setVector2(String name, Vector2<Float> v) {
        this.setVector2(name, v.getX(), v.getY());
    }

    public void setVector3(String name, Vector3<Float> v) {
        this.setVector3(name, v.getX(), v.getY(), v.getZ());
    }

    public void setVector4(String name, Vector4<Float> v) {
        this.setVector4(name, v.getX(), v.getY(), v.getZ(), v.getW());
    }
}
