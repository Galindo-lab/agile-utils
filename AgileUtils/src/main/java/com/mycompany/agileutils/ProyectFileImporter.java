/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agileutils;

/**
 *
 * @author Eduar
 */
public class ProyectFileImporter {
    private ProyectFile projectFile;
    private Proyect project;

    public ProyectFileImporter(ProyectFile projectFile, Proyect project) {
        this.projectFile = projectFile;
        this.project = project;
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
