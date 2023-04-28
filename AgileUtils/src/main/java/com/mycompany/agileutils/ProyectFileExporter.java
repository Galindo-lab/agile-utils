/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agileutils;

import java.io.IOException;
import net.sf.mpxj.Duration;
import net.sf.mpxj.PercentCompleteType;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.TimeUnit;
import net.sf.mpxj.mpx.MPXWriter;
import net.sf.mpxj.writer.ProjectWriter;

/**
 * Clase para exportar el proyect a un archivo MPXJ
 *
 * @author Eduar
 */
public class ProyectFileExporter {

    private ProjectFile projectFile; // arhivo MPXJ
    private Proyect project; // parte de la bibloteca para AGIL

    /**
     * Constructor
     *
     * @param project Proyecto de AGIL-UTILS
     * @param projectFile Proyecto de MPXJ
     */
    public ProyectFileExporter(Proyect project, ProjectFile projectFile) {
        this.project = project;
        this.projectFile = projectFile;
    }

    /**
     * Escribe el archivo MPX
     *
     * @throws IOException
     */
    public void write() throws IOException {
        // exportar tareas
        project.taskboard.export(projectFile);
        
        // exportar miembros y equipos
        for (Team team : project.teams) {
            team.export(projectFile);
        }

        ProjectWriter writer = new MPXWriter();
        writer.write(projectFile, "example.mpx");
    }

}
