package com.mycompany.agileutils;

import java.util.Vector;

public class Proyect {

    private String name;
    private String objetive;
    public ProyectFile file;
    public Vector<Requirement> requirements = new Vector<>();
    public TaskBoard taskboard;
    public Vector<UserHistory> stories = new Vector<>();

    public Proyect(String name, String objetive) {
        this.name = name;
        this.objetive = objetive;
        this.taskboard = new TaskBoard();
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
        sb.append('}');
        return sb.toString();
    }

    
}
