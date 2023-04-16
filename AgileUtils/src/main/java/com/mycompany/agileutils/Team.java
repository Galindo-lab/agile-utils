package com.mycompany.agileutils;

import java.util.Vector;

public class Team {

    private String name;
    private int id;
    public Vector<TeamMember> members = new Vector<>();

    public Team(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team{");
        sb.append("name=").append(name);
        sb.append(", id=").append(id);
        sb.append(", members=").append(members);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
