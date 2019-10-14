package JHobbyEngine.gl;

import JHobbyEngine.StringCallback;
import org.lwjgl.BufferUtils;

import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL33.*;

public class GLTexture {
    private int id;

    public GLTexture() {
        this.id = glGenTextures();
    }

    public void create(BufferedImage image, boolean readAlpha, StringCallback cb) {
        int[] pixels = new int[image.getWidth() * image.getHeight()];
        pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());

        final int BYTES_PER_PIXEL = (readAlpha ? 4 : 3);

        ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * BYTES_PER_PIXEL);

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixel = pixels[y * image.getWidth() + x];
                buffer.put((byte) ((pixel >> 16) & 0xFF));
                buffer.put((byte) ((pixel >> 8) & 0xFF));
                buffer.put((byte) (pixel & 0xFF));
                if (readAlpha) {
                    buffer.put((byte) ((pixel >> 24) & 0xFF));
                }
            }
        }

        buffer = buffer.flip();

        glBindTexture(GL_TEXTURE_2D, this.id);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

        final int colorFormat = (BYTES_PER_PIXEL == 4 ? GL_RGBA : GL_RGB);

        glTexImage2D(GL_TEXTURE_2D, 0, colorFormat, image.getWidth(), image.getHeight(), 0, colorFormat, GL_UNSIGNED_BYTE, buffer);
        glBindTexture(GL_TEXTURE_2D, 0);
    }

    public void destroy() {
        glDeleteTextures(this.id);
    }

    public void bind(int unit) {
        glBindTexture(GL_TEXTURE_2D, this.id);
        glActiveTexture(GL_TEXTURE0 + unit);
    }

    public void setWrap(int param) {
        glBindTexture(GL_TEXTURE_2D, this.id);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, param);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, param);
        glBindTexture(GL_TEXTURE_2D, 0);
    }

    public void setMinFilter(int param) {
        glBindTexture(GL_TEXTURE_2D, this.id);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, param);
        glBindTexture(GL_TEXTURE_2D, 0);
    }

    public void setMagFilter(int param) {
        glBindTexture(GL_TEXTURE_2D, this.id);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, param);
        glBindTexture(GL_TEXTURE_2D, 0);
    }

    public int getId() { return this.id; }
}
