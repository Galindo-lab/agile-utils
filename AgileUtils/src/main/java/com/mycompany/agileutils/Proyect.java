package com.mycompany.agileutils;

import java.nio.file.Paths;
import java.util.Locale;
import java.util.Vector;
import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Resource;
import net.sf.mpxj.Task;
import net.sf.mpxj.mpx.MPXReader;

public class Proyect {

    private String name;
    private String objetive;
    private ProyectFile file;

    public Vector<Requirement> requirements = new Vector<>();
    public TaskBoard taskboard;
    public Vector<UserHistory> stories = new Vector<>();
    public Vector<Team> teams = new Vector<>();

    public Proyect(String name, String objetive) {
        this.name = name;
        this.objetive = objetive;
        this.taskboard = new TaskBoard();
        this.file = new ProyectFile(this);
    }
    
    public void load(String path) throws MPXJException {
        this.file.load(path);
    }
    
    /**
     * 
     * @param path 
     */
    public void export(String path){
        this.file.setPath(Paths.get(path));
        this.file.export();
    }

    /**
     * Crea un equipo nuevo en el equipo
     *
     * @param name
     * @return
     */
    public Team createTeam(String name) {
        Team team = new Team(name);
        this.teams.add(team);
        return team;
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

    public ProyectFile getFile() {
        return file;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Proyect{");
        sb.append("name=").append(name);
        sb.append(", objetive=").append(objetive);
        sb.append(", file=").append(file);
        sb.append(", requirements=").append(requirements);
        sb.append(", taskboard=").append(taskboard);
        sb.append(", stories=").append(stories);
        sb.append(", teams=").append(teams);
        sb.append('}');
        return sb.toString();
    }

}
