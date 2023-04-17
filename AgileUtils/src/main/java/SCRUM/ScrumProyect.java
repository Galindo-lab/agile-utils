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

    private int getTeamIndex(String name) {
        int teamIndex = -1;

        for (var i = 0; i < this.teams.size(); i++) {
            String teamName = this.teams.get(i).getName();

            if (teamName.equals(name)) {
                teamIndex = i;
                break;
            }
        }

        return teamIndex;
    }

    public void createTeam(String name) {
        this.teams.add(new ScrumTeam(name));
    }

    public void removeTeam(String name) {
        var teamIndex = this.getTeamIndex(name);
        if (teamIndex != -1) {
            this.teams.remove(teamIndex);
        } else {
            System.out.println("El equipo no existe");
        }
    }

    public ScrumTeam getTeam(String name) {
        var teamIndex = this.getTeamIndex(name);
        if (teamIndex == -1) {
            return null;
        }
        return this.teams.get(teamIndex);
    }

}
