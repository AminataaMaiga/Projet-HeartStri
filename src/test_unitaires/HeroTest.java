package test_unitaires;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import jeu.Hero;
import jeu.HeroType;

public class HeroTest {

    @Test
    public void testRecevoirDegats() {
        Hero hero = new Hero(HeroType.MAGE);
        hero.recevoirDegats(10);
        assertEquals(20, hero.getPointsDeVie());
    }

    @Test
    public void testEstMort() {
        Hero hero = new Hero(HeroType.DRUIDE);
        hero.recevoirDegats(40);
        assertTrue(hero.estMort());
    }
}
