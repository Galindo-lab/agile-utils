package SCRUM;

import com.mycompany.agileutils.Activity;
import com.mycompany.agileutils.Proyect;
import com.mycompany.agileutils.Requirement;
import com.mycompany.agileutils.Team;
import com.mycompany.agileutils.UserHistory;
import java.time.Period;
import java.util.Vector;


public class ScrumProyect extends Proyect {

    public Vector<Risk> risks = new Vector<>();
    public Vector<Evaluation> evaluations = new Vector<>();
    public Vector<ScrumTeam> teams = new Vector<>();
    
    public ScrumBacklog backlog = new ScrumBacklog();

    public ScrumProyect(String name, String objetive) {
        super(name, objetive);
    }

    public ScrumTeam getTeam(String name) {
        int teamIndex = -1;
        
        for (int i = 0; i < this.teams.size(); i++) {
            String teamName = this.teams.get(i).getName();
        
            if (teamName.equals(name)) {
                teamIndex = i;
                break;
            }
        }
        
        if (teamIndex == -1) {
            // No existe un equipo con ese nombre
            return null;
        }
        
        return this.teams.get(teamIndex);
    }

}
