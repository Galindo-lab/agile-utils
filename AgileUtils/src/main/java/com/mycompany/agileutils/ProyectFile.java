package com.mycompany.agileutils;

import java.nio.file.Path;
import java.nio.file.Paths;
import net.sf.mpxj.ProjectFile;

public class ProyectFile {

    private Path path;
    private ProjectFile project;

    public ProyectFile(String path) {
        this.project = new ProjectFile();
        this.path = Paths.get(path);
    }
    
    public void export(Proyect proyect)
    {
        var exporter = new ProyectFileExporter(proyect, this.project);
        
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProyectFile{");
        sb.append("path=").append(path);
        sb.append('}');
        return sb.toString();
    }

    public Path getPath() {
        return this.path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

}
