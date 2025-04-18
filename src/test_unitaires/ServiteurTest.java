package test_unitaires;

import cartes.Serviteur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fatoumata 
 */
public class ServiteurTest {

    private Serviteur s1;
    private Serviteur s2;

    @BeforeEach
    void setUp() {
        s1 = new Serviteur("Orc", 2, 3, 5, "Charge");
        s2 = new Serviteur("Troll", 3, 2, 4, "");
    }

    @Test
    void testGetters() {
        assertEquals("Orc", s1.getNom());
        assertEquals(2, s1.getMana());
        assertEquals(3, s1.getPointAttaque());
        assertEquals(5, s1.getPointVie());
        assertEquals("Charge", s1.getActionSpeciale());
    }

    @Test
    void testRecevoirCoup() {
        s1.recevoircoup(2);
        assertEquals(3, s1.getPointVie());
    }

    @Test
    void testRecevoirCoupMort() {
        s2.recevoircoup(5);
        assertTrue(s2.estMort());
        assertEquals(0, s2.getPointVie()); // Tu forces à 0 dans recevoirCoup()
    }

    @Test
    void testAttaquer() {
        s1.attaquer(s2);
        assertEquals(1, s2.getPointVie());
    }

    @Test
    void testEstMort() {
        assertFalse(s1.estMort());
        s1.recevoircoup(10);
        assertTrue(s1.estMort());
    }

    @Test
    void testGenererServiteurAleatoire() {
        Serviteur alea = Serviteur.genererServiteurAleatoire();
        assertNotNull(alea);
        assertTrue(alea.getMana() >= 1 && alea.getMana() <= 6);
        assertTrue(alea.getPointAttaque() >= 1 && alea.getPointAttaque() <= 6);
        assertTrue(alea.getPointVie() >= 2 && alea.getPointVie() <= 7);
    }
}
