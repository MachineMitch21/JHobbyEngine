package JHobbyEngine.resource;

public abstract class Resource<T> {

    protected Resource(Class<T> classType) {

    }

    String fileName = "";

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }
}
