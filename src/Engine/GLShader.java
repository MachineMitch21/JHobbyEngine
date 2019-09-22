package Engine;

import java.nio.ByteBuffer;

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
        int[] result = {GL_FALSE};
        int[] logLength = {0};

        glShaderSource(this.id, src);
        glCompileShader(this.id);

        glGetShaderiv(this.id, GL_COMPILE_STATUS, result);
        glGetShaderiv(this.id, GL_INFO_LOG_LENGTH, logLength);

        if (result[0] == GL_FALSE) {
            ByteBuffer err = ByteBuffer.allocate(logLength[0]);
            glGetShaderInfoLog(this.id, logLength, err);

            if (cb != null) {
                cb.callback(err.toString());
            }
            this.id = 0;
            return false;
        }
        return true;
    }
}
