/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SCRUM;

import com.mycompany.agileutils.Artifact;
import com.mycompany.agileutils.Backlog;
import java.util.Vector;

/**
 *
 * @author Eduar
 */
public class ScrumBacklog implements Artifact, Backlog {

    public Vector<String> log = new Vector<>();

    @Override
    public void display() {
        System.out.println(log);
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void addItem(Object o) {
        log.add(o.toString());
    }

    @Override
    public void removeItem(int id) {
        log.remove(id);
    }

}
