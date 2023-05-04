package com.mycompany.agileutils;

import java.util.Vector;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Resource;

public class Team {

    private String name;
    private Vector<TeamMember> members = new Vector<>();

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
    
    public TeamMember getMemberByID(int id)
    {
        int index = this.getMemberIndexByName(name);
        
        if (index != -1) {
            return this.members.get(index);
        }
        
        return null;
    }
    
    public int getMemberIndexByID(int id)
    {
        for (int i = 0; i < this.members.size(); i++) {
            if (this.members.get(i).getId() == id) {
                return i;
            }
        }
        
        return -1;
    }
    
    public int getMemberIndexByName(String name)
    {
        for (int i = 0; i < this.members.size(); i++) {
            if (this.members.get(i).getName().equals(name)) {
                return i;
            }
        }
        
        return -1;
    }
    
    public TeamMember getMember(String name)
    {
        int index = this.getMemberIndexByName(name);
        
        if (index != -1) {
            return this.members.get(index);
        }
        
        return null;
    }
    
    public void addMember(TeamMember teamMember)
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
