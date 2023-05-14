package com.mycompany.agileutils;

import SCRUM.ScrumProyect;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import net.sf.mpxj.MPXJException;

/**
 *
 * @author Eduar
 */
public class AgileUtils {

    public static void main(String[] args) throws IOException, ParseException, MPXJException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        
        
        ScrumProyect proyect = new ScrumProyect("ProyectoPrueba", "hola");
        proyect.load("ProyectoPrueba.mpx");
        
        System.out.println(proyect.taskboard);
        
        //System.out.println(proyect);
        
//        var proyect = new Proyect("ProyectoPrueba", "hola");
//        proyect.taskboard.add(
//                new Task(
//                    1,
//                    "hola",
//                    "holad",
//                    formatter.parse("01-04-2023"),
//                    formatter.parse("10-04-2023")
//                )
//        );
//        
//        proyect.taskboard.getByID(1).setStatus(Task.DONE);
//        
//        proyect.taskboard.add(
//                new Task(
//                    2,
//                    "hola 2",
//                    "hola w",
//                    formatter.parse("03-04-2023"),
//                    formatter.parse("6-04-2023")
//                )
//        );
//        
//        proyect.createTeam("Equipo de prueba");
//        var a = proyect.getTeam("Equipo de prueba");
//        a.addMember(new TeamMember(1,"Jhon Doe"));
//        a.addMember(new TeamMember(2,"Luis Perez"));
//        
//        //a.getMember("Jhon Doe")
//        
//        proyect.createTeam("test team");
//        a = proyect.getTeam("test team");
//        a.addMember(new TeamMember(3,"Fransisco Lopez"));
//        a.addMember(new TeamMember(4,"Carmen"));
//        
//        proyect.taskboard.getByID(1).teamMember = a.getMember("Carmen");
//        
//        proyect.getFile().setPath(Paths.get(""));
//        proyect.getFile().export();
//        
//        
    }
}
