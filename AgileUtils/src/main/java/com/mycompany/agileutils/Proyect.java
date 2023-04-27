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

    public Proyect(String name, String objetive) {
        this.name = name;
        this.objetive = objetive;
        this.taskboard = new TaskBoard();
    }

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


}
