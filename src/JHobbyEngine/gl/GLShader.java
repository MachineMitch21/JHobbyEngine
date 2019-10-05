package JHobbyEngine.gl;

import JHobbyEngine.StringCallback;
import JHobbyEngine.io.FileUtilities;
import org.lwjgl.system.MemoryStack;
import java.io.IOException;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL33.*;

public class GLShader {
    private int type;
    private int id;

    public GLShader(int type) {
        this.type = type;
        this.id = glCreateShader(type);
    }
    
    public GLShader(int type, String file) {
    	this.type = type;
    	this.id = glCreateShader(type);
    	try {
	    	this.create(FileUtilities.readFile(file), (String err) -> { System.out.println(err); });
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
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
