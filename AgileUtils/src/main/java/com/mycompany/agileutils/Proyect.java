package com.mycompany.agileutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.mpxj.ProjectFile;
import org.apache.commons.io.FilenameUtils;

public class Proyect {

    private String name;
    private String objetive;
    private Path path;

    public Vector<Requirement> requirements = new Vector<>();
    public TaskBoard taskboard;
    public Vector<UserHistory> stories = new Vector<>();
    public Vector<Team> teams = new Vector<>();

    public Proyect(String name, String objetive) {
        this.name = name;
        this.objetive = objetive;
        this.taskboard = new TaskBoard();
        this.path = Paths.get(name+".mpx");
    }

    /**
     * Exporta el archivo a MPP
     */
    public void export() {
        var projectFile = new ProjectFile();
        System.out.println("");
        var exporter = new ProyectFileExporter(this, projectFile);

        try {
            exporter.write();
        } catch (IOException ex) {
            Logger.getLogger(Proyect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Crea un equipo nuevo en el equipo
     *
     * @param name
     */
    public void createTeam(String name) {
        this.teams.add(new Team(name));
    }

    /**
     * Busca el nombre del equipo y obtiene el indice en el vector de Teams
     *
     * @param name
     * @return
     */
    private int getTeamByIndex(String name) {
        int teamIndex = -1;

        for (var i = 0; i < this.teams.size(); i++) {
            String teamName = this.teams.get(i).getName();

            if (teamName.equals(name)) {
                teamIndex = i;
                break;
            }
        }

        return teamIndex;
    }

    /**
     * Elimina un equipo por nombre
     *
     * @param name
     */
    public void removeTeam(String name) {
        var teamIndex = this.getTeamByIndex(name);
        if (teamIndex != -1) {
            this.teams.remove(teamIndex);
        } else {
            System.out.println("El equipo no existe");
        }
    }

    /**
     * Obtiene un equipo por nombre, retorna null si no existe
     *
     * @param name
     * @return team
     */
    public Team getTeam(String name) {
        var teamIndex = this.getTeamByIndex(name);
        if (teamIndex == -1) {
            return null;
        }
        return this.teams.get(teamIndex);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjetive() {
        return this.objetive;
    }

    public void setObjetive(String objetive) {
        this.objetive = objetive;
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
            this.path = path.resolve(name.concat(".mpx"));
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
}