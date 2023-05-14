package com.mycompany.agileutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.mpx.MPXReader;
import org.apache.commons.io.FilenameUtils;

public class ProyectFile {

    private Path path;
    private Proyect project;

    public ProyectFile(Proyect project) {
        this.project = project;
        this.path = Paths.get(project.getName() + ".mpx");
    }

    
    /**
     * Exporta el archivo a MPP
     */
    public void export() {
        var projectFile = new ProjectFile();
        var exporter = new ProyectFileExporter(project, projectFile);

        try {
            exporter.write();
        } catch (IOException ex) {
            Logger.getLogger(Proyect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Path getPath() {
        return path;
    }
    
    /**
     *
     * @param path
     */
    public void setPath(Path path) {
        if (Files.isDirectory(path)) {
            // si es un idrectorio agregar el archivo
            this.path = path.resolve(project.getName().concat(".mpx"));
            return;
        }

        String extension = FilenameUtils.getExtension(path.toString());
        if (extension.toLowerCase().equals(".mpx")) {
            // si es un archivo pero con otra extencion cambiar la extencion
            String pathNoext = FilenameUtils.removeExtension(path.toString());

            this.path = Paths.get(pathNoext.concat(".mpx"));
            return;
        }

        // si es un path con un archivo .mpp
        this.path = path;
    }

    public Proyect getProject() {
        return project;
    }

    public void setProject(Proyect project) {
        this.project = project;
    }

}
