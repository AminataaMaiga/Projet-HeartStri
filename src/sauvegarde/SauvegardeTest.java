package sauvegarde;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

public class SauvegardeTest {

	private static final String FICHIER_OBJET = "test_objet.ser";
	private static final String FICHIER_INVALIDE = "test_invalide.txt";

	@AfterEach
	void nettoyer() {
		new File(FICHIER_OBJET).delete();
		new File(FICHIER_INVALIDE).delete();
	}

	@Test
	void testChargerObjet_ObjetValide() throws IOException {
		// Sérialisation d'une chaîne de caractères
		String texte = "Bonjour sauvegarde";
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FICHIER_OBJET))) {
			out.writeObject(texte);
		}
		Object resultat = Sauvegarde.chargerObjet(FICHIER_OBJET);
		assertNotNull(resultat, "L'objet chargé ne doit pas être null");
		assertTrue(resultat instanceof String, "L'objet chargé doit être une String");
		assertEquals(texte, resultat, "Le contenu doit être identique");
	}

	@Test
	void testChargerObjet_FichierInexistant() {
		Object resultat = Sauvegarde.chargerObjet("fichier_inexistant.ser");
		assertNull(resultat, "Le résultat doit être null si le fichier n'existe pas");
	}

	@Test
	void testChargerObjet_DonneesInvalides() throws IOException {
		// Écriture de texte non sérialisé
		try (FileWriter fw = new FileWriter(FICHIER_INVALIDE)) {
			fw.write("ceci n'est pas un objet sérialisé");
		}
		Object resultat = Sauvegarde.chargerObjet(FICHIER_INVALIDE);
		assertNull(resultat, "Le résultat doit être null si le fichier ne contient pas un objet sérialisé");
	}
}