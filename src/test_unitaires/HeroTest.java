package test_unitaires;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import jeu.Hero;

public class HeroTest {

    @Test
    public void testRecevoirDegats() {
        Hero hero = new Hero("Mage", "Pouvoir : inflige 1 dégât",1);
        hero.recevoirDegats(10);
        assertEquals(20, hero.getPointsDeVie());
    }

    @Test
    public void testEstMort() {
        Hero hero = new Hero("Guerrier", "Pouvoir : gagne 2 armures",1);
        hero.recevoirDegats(40);
        assertTrue(hero.estMort());
    }
}
