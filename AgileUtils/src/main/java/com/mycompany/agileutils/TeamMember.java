package com.mycompany.agileutils;

import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Resource;
import net.sf.mpxj.ResourceAssignment;

public class TeamMember {

    private String name;
    private String email;

    public TeamMember(String name) {
        this.name = name;
    }

    void export(Resource resource) {
        resource.setName(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TeamMember{");
        sb.append("name=").append(name);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }

}
