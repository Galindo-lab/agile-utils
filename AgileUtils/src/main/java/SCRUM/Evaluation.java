package SCRUM;

import java.util.Date;

public class Evaluation {

    private Date date;
    private String description;
    private String result;

    public Evaluation(Date date, String description, String result) {
        this.date = date;
        this.description = description;
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Evaluation{");
        sb.append("date=").append(date);
        sb.append(", description=").append(description);
        sb.append(", result=").append(result);
        sb.append('}');
        return sb.toString();
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
