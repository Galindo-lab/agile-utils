package com.mycompany.agileutils;

import java.util.Vector;

public class TaskBoard {

    public Vector<Task> activities = new Vector<>();

    public void addActivity(Task activity) {
        activities.add(activity);
    }

    public void removeActivity(int id) {
        activities.remove(id);
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
