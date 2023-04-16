package SCRUM;

public class Risk {

    private String type;
    private String description;
    private int impact;

    public Risk(String type, String description, int impact) {
        this.type = type;
        this.description = description;
        this.impact = impact;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Risk{");
        sb.append("type=").append(type);
        sb.append(", description=").append(description);
        sb.append(", impact=").append(impact);
        sb.append('}');
        return sb.toString();
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImpact() {
        return this.impact;
    }

    public void setImpact(int impact) {
        this.impact = impact;
    }

}
