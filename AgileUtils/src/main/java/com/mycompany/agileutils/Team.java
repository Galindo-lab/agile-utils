package com.mycompany.agileutils;

import java.util.Vector;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Resource;

public class Team {

    private String name;
    public Vector<TeamMember> members = new Vector<>();

    public Team(String name) {
        this.name = name;
    }

    void export(ProjectFile projectFile) {
        for (TeamMember member : this.members) {
            Resource resource = projectFile.addResource();
     
            resource.setGroup(this.name);
            member.export(resource);
        }
    }
    
    public void add(TeamMember teamMember)
    {
        this.members.add(teamMember);
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
