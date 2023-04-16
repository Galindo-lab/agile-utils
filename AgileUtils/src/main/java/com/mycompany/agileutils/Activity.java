package com.mycompany.agileutils;

import java.util.Vector;
import java.time.Period;

public class Activity {

    static final int NOT_ASSIGNED = 0;
    static final int IN_PROGRESS = 1;
    static final int DONE = 2;

    private Period period;
    private String name;
    private String description;
    private int id;
    private int status;
    public Vector<UserHistory> stories = new Vector<>();
    public TeamMember teamMember;

    public Activity(int id, String name, String description, Period period) {
        this.period = period;
        this.name = name;
        this.description = description;
        this.id = id;
        this.status = Activity.NOT_ASSIGNED;
    }

    public Period getPeriod() {
        return this.period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Activity{");
        sb.append("period=").append(period);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", stories=").append(stories);
        sb.append(", teamMember=").append(teamMember);
        sb.append('}');
        return sb.toString();
    }
    
}
