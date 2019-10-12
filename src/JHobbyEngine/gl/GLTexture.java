package JHobbyEngine.gl;

import JHobbyEngine.StringCallback;

import static org.lwjgl.opengl.GL33.*;

public class GLTexture {
    private int id;

    public GLTexture() {
        this.id = glGenTextures();
    }

    public void create(String fileData, StringCallback cb) {

    }
}
