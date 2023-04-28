package SCRUM;

import com.mycompany.agileutils.*;
import java.util.Vector;

public class ScrumProyect extends Proyect {

    public Vector<Risk> risks = new Vector<>();
    public Vector<Evaluation> evaluations = new Vector<>();

    public ScrumBacklog backlog = new ScrumBacklog();

    public ScrumProyect(String name, String objetive) {
        super(name, objetive);
    }

}
