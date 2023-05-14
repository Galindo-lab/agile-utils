package com.mycompany.agileutils;

import java.time.LocalDate;
import java.util.Vector;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import net.sf.mpxj.Duration;

/**
 *
 * @author Eduar
 */
public class Task {
    
    static final int NOT_ASSIGNED = 0;
    static final int IN_PROGRESS = 1;
    static final int DONE = 2;
    
    private Date start;
    private Date end;
    
    private String name;
    private String description;
    private int id;
    private int status;
    public Vector<UserHistory> stories = new Vector<>();
    private TeamMember teamMember;

    /**
     *
     * @param id
     * @param name
     * @param description
     * @param start
     * @param end
     */
    public Task(int id, String name, String description, Date start, Date end) {
        this.end = end;
        this.start = start;
        this.name = name;
        this.description = description;
        this.id = id;
        this.status = Task.NOT_ASSIGNED;
    }
    
    private Task() {
        
    }

    /**
     * Calcula la diferencia entre el inicio y el final en dias
     *
     * @return
     */
    public long getDurationDays() {
        long diffInMillies = end.getTime() - start.getTime();
        TimeUnit timeUnit = TimeUnit.DAYS;
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    /**
     * Convierte un task de la bibloteca AGIL y agrega a un proyecto MPXJ
     *
     * @param task
     */
    public void export(net.sf.mpxj.Task task) {
        task.setName(this.getName());
        task.setStart(this.getStart());
        task.setID(this.getId());
        //task.setPercentageComplete(this.getStatus() == Task.DONE ? 100 : 0);

        Duration foo = Duration.getInstance(this.getDurationDays(), net.sf.mpxj.TimeUnit.DAYS);
        task.setDuration(foo);
    }
    
    public static Task importTask(net.sf.mpxj.Task task) {
        Task mis = new Task();
        mis.name = task.getName();
        mis.start = task.getStart();
        mis.id = task.getID();
        
        mis.end = new Date();
        
        mis.end.setTime((long) (task.getStart().getTime() + task.getDuration().getDuration() * 86400000));
        
        
        return mis;
    }
    
    public Date getStart() {
        return start;
    }
    
    public void setStart(Date start) {
        this.start = start;
    }
    
    public Date getEnd() {
        return end;
    }
    
    public void setEnd(Date end) {
        this.end = end;
    }
    
    public Vector<UserHistory> getStories() {
        return stories;
    }
    
    public void setStories(Vector<UserHistory> stories) {
        this.stories = stories;
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
        sb.append("Task{");
        sb.append("start=").append(start);
        sb.append(", end=").append(end);
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
