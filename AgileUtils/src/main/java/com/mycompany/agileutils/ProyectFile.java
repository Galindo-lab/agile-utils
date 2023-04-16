package com.mycompany.agileutils;

public class ProyectFile {

    private String path;

    public ProyectFile(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProyectFile{");
        sb.append("path=").append(path);
        sb.append('}');
        return sb.toString();
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
