package com.mycompany.agileutils;

/*
holaaa
*/

public class UserHistory {

    private String title;
    private String description;
    private String aceptationCriteria;

    public UserHistory(String title, String description, String aceptationCriteria) {
        this.title = title;
        this.description = description;
        this.aceptationCriteria = aceptationCriteria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserHistory{");
        sb.append("title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", aceptationCriteria=").append(aceptationCriteria);
        sb.append('}');
        return sb.toString();
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAceptationCriteria() {
        return this.aceptationCriteria;
    }

    public void setAceptationCriteria(String aceptationCriteria) {
        this.aceptationCriteria = aceptationCriteria;
    }

}
