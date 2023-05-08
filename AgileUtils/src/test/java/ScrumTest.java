/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import SCRUM.ScrumProyect;
import SCRUM.ScrumTeam;
import com.mycompany.agileutils.Requirement;
import com.mycompany.agileutils.Task;
import com.mycompany.agileutils.Team;
import com.mycompany.agileutils.TeamMember;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Eduar
 */
public class ScrumTest {

    ScrumProyect proyect;

    public ScrumTest() {
        this.proyect = new ScrumProyect(
                "Proyecto para tests",
                "El objetivo del proyecto es hacer pruebas"
        );
    }

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void requirements() {
        String requirement = "Esta es una prueba de requerimientos";

        this.proyect.requirements.add(new Requirement(requirement));
        assertEquals(requirement, this.proyect.requirements.get(0).getDescription());
    }

    @Test
    public void tasks() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        proyect.taskboard.add(
                new Task(
                        1,
                        "hola",
                        "holad",
                        formatter.parse("01-04-2023"),
                        formatter.parse("10-04-2023")
                )
        );

        proyect.taskboard.add(
                new Task(
                        2,
                        "hola 2",
                        "hola w",
                        formatter.parse("01-04-2023"),
                        formatter.parse("10-04-2023")
                )
        );

        assertNotNull(proyect.taskboard.getByID(1));
        assertNotNull(proyect.taskboard.getByID(2));
        assertNull(proyect.taskboard.getByID(0));
    }

    @Test
    public void teams() {
        proyect.createTeam("Equipo de prueba");
        proyect.createTeam("test team");

        assertNotNull(proyect.getTeam("Equipo de prueba"));
        assertNotNull(proyect.getTeam("test team"));
    }

    @Test
    public void members() {
        this.teams();
        
        var a = proyect.getTeam("Equipo de prueba");
        System.out.println(a);
        
        a.addMember(new TeamMember(1, "Jhon Doe"));
        a.addMember(new TeamMember(2, "Luis Perez"));

        a = proyect.getTeam("test team");
        a.addMember(new TeamMember(3, "Fransisco Lopez"));
        a.addMember(new TeamMember(4, "Carmen"));
        
        proyect.taskboard.getByID(1).teamMember = a.getMember("Carmen");
    }

    
    @Test
    public void export() {
        var foo = Paths.get("C:\\Users\\Eduar\\OneDrive\\Escritorio");
        
        proyect.getFile().setPath(foo);
        proyect.getFile().export();
        
        assertTrue(foo.toFile().exists());
    }
}
