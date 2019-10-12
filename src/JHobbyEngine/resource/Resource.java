package JHobbyEngine.resource;

public abstract class Resource {

    private String fileName = "";

    public Resource(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }
}
