package com.mycompany.agileutils;

public class Requirement {

    private String description;

    public Requirement(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Requirement{");
        sb.append("description=").append(description);
        sb.append('}');
        return sb.toString();
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
