package com.mycompany.agileutils;

public class TeamMember {

    private String name;

    public TeamMember(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TeamMember{");
        sb.append("name=").append(name);
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
