package sauvegarde;
import java.io.*;

public class Sauvegarde {

	public static Object chargerObjet(String nomFichier) {
	    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomFichier))) {
	        Object obj = in.readObject();
	        System.out.println("✔ Chargement réussi depuis : " + nomFichier);
	        return obj;
	    } catch (IOException e) {
	        System.err.println("Erreur IO : " + e.getMessage());
	    } catch (ClassNotFoundException e) {
	        System.err.println(" Classe non trouvée : " + e.getMessage());
	    }
	    return null;
	}
	/////

}
