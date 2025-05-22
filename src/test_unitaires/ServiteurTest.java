package test_unitaires;

import cartes.Serviteur;
import cartes.TypeServiteur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test unitaire pour la classe Serviteur.
 * Teste les comportements de base des objets de type Serviteur.
 * @author Fatoumata
 */
public class ServiteurTest {

    private Serviteur s1;
    private Serviteur s2;

    /**
     * Initialise deux serviteurs avant chaque test.
     */
    @BeforeEach
    void setUp() {
        s1 = new Serviteur(TypeServiteur.ORC);      // nom : "Orc", mana : 2, attaque : 3, PV : 10, spé : "Charge"
        s2 = new Serviteur(TypeServiteur.SOLDAT);   // nom : "Soldat", mana : 1, attaque : 2, PV : 1, spé : "Aucun effet"
    }

    /**
     * Vérifie que les getters renvoient les bonnes valeurs.
     */
    @Test
    void testGetters() {
        assertEquals("Orc", s1.getNom());
        assertEquals(2, s1.getMana());
        assertEquals(3, s1.getPointAttaque());
        assertEquals(10, s1.getPointVie());
        assertEquals("Charge", s1.getActionSpeciale());
    }

    /**
     * Vérifie que la méthode recevoircoup() diminue les PV correctement.
     */
    @Test
    void testRecevoirCoup() {
        s1.recevoircoup(2);
        assertEquals(8, s1.getPointVie());
    }

    /**
     * Vérifie qu’un serviteur meurt correctement quand il reçoit trop de dégâts.
     */
    @Test
    void testRecevoirCoupMort() {
        s2.recevoircoup(5);
        assertTrue(s2.estMort());
        assertEquals(0, s2.getPointVie()); // Les PV doivent être ramenés à 0
    }

    /**
     * Vérifie le comportement de l'attaque d'un serviteur sur un autre.
     */
    @Test
    void testAttaquer() {
        s1.attaquer(s2);
        assertEquals(0, s2.getPointVie());
        assertTrue(s2.estMort());
    }

    /**
     * Vérifie le comportement de la méthode estMort().
     */
    @Test
    void testEstMort() {
        assertFalse(s1.estMort());
        s1.recevoircoup(10);
        assertTrue(s1.estMort());
    }

    /**
     * Vérifie que la méthode soigner() augmente correctement les PV.
     */
    @Test
    void testSoigner() {
        s1.recevoircoup(4);
        assertEquals(6, s1.getPointVie());
        s1.soigner(3);
        assertEquals(9, s1.getPointVie());
    }

    /**
     * Vérifie que la méthode augmenterAttaque() augmente bien les points d’attaque.
     */
    @Test
    void testAugmenterAttaque() {
        int pa = s1.getPointAttaque();
        s1.augmenterAttaque(2);
        assertEquals(pa + 2, s1.getPointAttaque());
    }
}
