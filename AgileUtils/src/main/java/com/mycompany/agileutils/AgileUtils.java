package com.mycompany.agileutils;

import SCRUM.ScrumProyect;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import net.sf.mpxj.Duration;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Resource;
import net.sf.mpxj.ResourceAssignment;
import net.sf.mpxj.TimeUnit;
import net.sf.mpxj.mpx.MPXWriter;
import net.sf.mpxj.writer.ProjectWriter;

/**
 *
 * @author Eduar
 */
public class AgileUtils {

    public static void main(String[] args) throws IOException, ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        var proyect = new ScrumProyect("Proyecto prueba", "hola");
        proyect.taskboard.addActivity(
                new Task(
                    1,
                    "hola",
                    "holad",
                    formatter.parse("01-04-2023"),
                    formatter.parse("10-04-2023")
                )
        );
        
        proyect.taskboard.getByID(1).setStatus(Task.DONE);
        System.out.println(proyect.taskboard.getByID(1).getDurationDays());
        
        proyect.taskboard.addActivity(
                new Task(
                        2,
                    "hola 2",
                    "hola w",
                    formatter.parse("01-04-2023"),
                    formatter.parse("10-04-2023")
                )
        );
        
        proyect.export();

//
//        ProjectFile project = new ProjectFile();
//
//        Resource resource = project.addResource();
//        resource.setName("Recurso");
//
//        Task task = project.addTask();
//        task.setName("StackOverflow Example Task");
//        task.setStart(formatter.parse("01-04-2023"));
//        task.setDuration(Duration.getInstance(3, TimeUnit.DAYS));
//        task.setWork(Duration.getInstance(15, TimeUnit.HOURS));
//        task.setRemainingWork(Duration.getInstance(15, TimeUnit.HOURS));
////        
//        ResourceAssignment resourceAssignment = task.addResourceAssignment(resource);
//        resourceAssignment.setStart(formatter.parse("01-04-2023"));
//        resourceAssignment.setWork(Duration.getInstance(15, TimeUnit.HOURS));
//        resourceAssignment.setRemainingWork(Duration.getInstance(15, TimeUnit.HOURS));
//        With this sample data we know we only have one resource assignment
//        ResourceAssignment assignment = task.getResourceAssignments().get(0);
//        Set remaining work seems to be the driver for MS Project assignment.setRemainingWork(Duration.getInstance(3, TimeUnit.DAYS));
//                task.setActualWork(Duration.getInstance(123, TimeUnit.HOURS));
//        task.setActualDuration(Duration.getInstance(100, TimeUnit.HOURS));
//        ProjectWriter writer = new MPXWriter();
//        writer.write(project, "example.mpx");
    }
}
