package com.mycompany.agileutils;

import java.util.Iterator;
import java.util.Vector;
import net.sf.mpxj.ProjectFile;

public class TaskBoard {

    public Vector<Task> activities = new Vector<>();

    public void addActivity(Task activity) {
        activities.add(activity);
    }

    public void removeActivity(int id) {
        activities.remove(id);
    }
    
    public int size()
    {
        return this.activities.size();
    }
    
    /**
     * Obtener una actividad por su id interno
     * @param id
     * @return 
     */
    public Task getByID(int id)
    {
        
        for (int i = 0; i < this.activities.size(); i++) {
            if (this.activities.get(i).getId() == id) {
                return this.activities.get(i);
            }
        }
        
        return null;
    }
    
    /**
     * Obtiene el id por posicion
     * @param index
     * @return 
     */
    public Task get(int index)
    {
        return activities.get(index);
    }
    
    /**
     * Covierte el taskboard del proyecto en actividades para el proyecto en
     * MPXJ
     * @param project
     */
    public void export(ProjectFile project) {
        for (int i = 0; i < this.activities.size(); i++) {
            this.activities.get(i).export(project.addTask());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TaskBoard{");
        sb.append("activities=").append(activities);
        sb.append('}');
        return sb.toString();
    }

}
