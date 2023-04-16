package com.mycompany.agileutils;

import java.util.Vector;

public class Team {

    private String name;
    public Vector<TeamMember> members = new Vector<>();

    public Team(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team{");
        sb.append("name=").append(name);
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

}
