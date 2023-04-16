package com.mycompany.agileutils;

public class TeamMember {

    private String name;
    private int id;

    public TeamMember(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TeamMember{");
        sb.append("name=").append(name);
        sb.append(", id=").append(id);
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
