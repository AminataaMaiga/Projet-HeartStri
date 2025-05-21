package test_unitaires;
import cartes.Carte;
import cartes.CarteFactory;
import cartes.Deck;
import org.junit.jupiter.api.Test;
import jeu.Combat;
import jeu.Joueur;
import jeu.Main;
import jeu.Hero;
import jeu.HeroType;
import jeu.Combat;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class CombatTest {

	public static void main(String[] args) {
		
		
		CarteFactory c=new CarteFactory();
		List<Carte> carte=c.genererSetInitial();
		
		
		Hero h1=new Hero(HeroType.MAGE);
		Deck deck1=c.genererDeckAleatoire(carte, 30);
		
		Joueur aminata= new Joueur("aminata",deck1,h1,1);
		
		
		Hero h2=new Hero(HeroType.CHASSEUR);
		Deck deck2=c.genererDeckAleatoire(carte, 30);
		
		Joueur balla= new Joueur("balla",deck2,h2,2);
		
		aminata.tirerCarteTour1();
		balla.tirerCarteTour1();
		
		System.out.println("------------- Debut combat -------------");
		
		
		Combat combat =new Combat();
		combat.simulerCombat(aminata, balla);
		
		
		

	}
	
	
	
	
}


