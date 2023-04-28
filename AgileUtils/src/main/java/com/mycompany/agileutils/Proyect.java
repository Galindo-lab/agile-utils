package com.mycompany.agileutils;

import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.mpxj.ProjectFile;

public class Proyect {

    private String name;
    private String objetive;

    public Vector<Requirement> requirements = new Vector<>();
    public TaskBoard taskboard;
    public Vector<UserHistory> stories = new Vector<>();
    public Vector<Team> teams = new Vector<>();

    public Proyect(String name, String objetive) {
        this.name = name;
        this.objetive = objetive;
        this.taskboard = new TaskBoard();
    }

    /**
     * covierte el archivo en un MPX
     */
    public void export() {
        var projectFile = new ProjectFile();
        var exporter = new ProyectFileExporter(this, projectFile);

        try {
            exporter.write();
        } catch (IOException ex) {
            Logger.getLogger(Proyect.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void createTeam(String name) {
        this.teams.add(new Team(name));
    }

    public int getTeamIndex(String name) {
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

    public void removeTeam(String name) {
        var teamIndex = this.getTeamIndex(name);
        if (teamIndex != -1) {
            this.teams.remove(teamIndex);
        } else {
            System.out.println("El equipo no existe");
        }
    }

    public Team getTeam(String name) {
        var teamIndex = this.getTeamIndex(name);
        if (teamIndex == -1) {
            return null;
        }
        return this.teams.get(teamIndex);
    }

}
