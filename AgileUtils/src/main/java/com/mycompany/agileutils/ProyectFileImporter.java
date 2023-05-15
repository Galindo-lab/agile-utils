/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agileutils;

import java.util.Locale;
import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Resource;
import net.sf.mpxj.mpx.MPXReader;

/**
 *
 * @author Eduar
 */
public class ProyectFileImporter {
    private ProyectFile projectFile;
    private Proyect project;

    public ProyectFileImporter(Proyect project, ProyectFile projectFile) {
        this.projectFile = projectFile;
        this.project = project;
    }
    
    
    public void loadTeamMembers(ProjectFile project) {
        for (Resource resource : project.getResources()) {
            String teamName = resource.getGroup();
            Team team = this.project.getTeam(teamName);

            if (team == null) {
                team = this.project.createTeam(teamName);
            }

            team.addMember(new TeamMember(resource.getName()));
        }
        
        
    }

    public void load(String name) throws MPXJException {
        MPXReader reader = new MPXReader();
        reader.setLocale(Locale.US);

        ProjectFile project = reader.read(name);

        this.loadTeamMembers(project);
        this.project.taskboard.importTasks(project);
        
        for (int i = 0; i < project.getChildTasks().size(); i++) {
            net.sf.mpxj.Task task = project.getTasks().get(i);
            
            if (task.getResourceAssignments().isEmpty()) {
                continue;
            }
            
            var member = task.getResourceAssignments().get(0);

            Team team = this.project.getTeam(member.getResource().getGroup());
            TeamMember mb = team.getMember(member.getResource().getName());
            
            this.project.taskboard.activities.get(i).setTeamMember(mb);
        }
        
    }

    public ProyectFile getProjectFile() {
        return projectFile;
    }

    public void setProjectFile(ProyectFile projectFile) {
        this.projectFile = projectFile;
    }

    public Proyect getProject() {
        return project;
    }

    public void setProject(Proyect project) {
        this.project = project;
    }
    
            
}
