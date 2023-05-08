/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import SCRUM.ScrumProyect;
import SCRUM.ScrumTeam;
import com.mycompany.agileutils.Requirement;
import com.mycompany.agileutils.Team;
import com.mycompany.agileutils.TeamMember;
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
    /**
     * TODO: Preguntar si los requerimientos se pueden eliminar
     */
    @Test
    public void requirements() {
        String requirement = "Esta es una prueba de requerimientos";

        this.proyect.requirements.add(new Requirement(requirement));
        assertEquals(requirement, this.proyect.requirements.get(0).getDescription());
    }

    @Test
    public void Teams() {
        String equipoExiste = "Equipo de prueba";
        String equipoNoExiste = "Equipo de prueba que no existe";

        proyect.createTeam(equipoExiste);

        // referenciar si existe
        assertNotNull(proyect.getTeam(equipoExiste));

        // retornar null si no
        assertNull(proyect.getTeam(equipoNoExiste));

        proyect.removeTeam(equipoExiste);
        assertNull(proyect.getTeam(equipoExiste));
        
        proyect.createTeam(equipoExiste);
        assertNotNull(proyect.getTeam(equipoExiste));
    }

//    @Test
//    public void teamMembers() {
//        String equipoExiste = "Equipo de prueba";
//        
//        ScrumTeam selectedTeam = proyect.getTeam(equipoExiste);
//        selectedTeam.members.add(new TeamMember("Persona de prueba"));
//        System.out.println(proyect.getTeam(equipoExiste));
//    }
}
