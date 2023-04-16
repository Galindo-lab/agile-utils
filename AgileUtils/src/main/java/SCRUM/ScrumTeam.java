package SCRUM;

import com.mycompany.agileutils.Team;
import com.mycompany.agileutils.TeamMember;
import java.util.Vector;

public class ScrumTeam extends Team {

    private ScrumMaster scrumMaster;

    public ScrumTeam(String name) {
        super(name);
        this.scrumMaster = null;
    }

    public ScrumMaster getScrumMaster() {
        return scrumMaster;
    }

    public void setScrumMaster(TeamMember scrumMaster) {
        this.scrumMaster = (ScrumMaster) scrumMaster;
    }

}
