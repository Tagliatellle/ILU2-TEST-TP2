package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois cofidix;
	private ControlAfficherMarche controlAfficherMarche;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		cofidix = new Gaulois("Cofidix", 2);
		village.setChef(abraracourcix);
		village.installerVendeur(abraracourcix, "fleurs", 10);
		controlAfficherMarche = new ControlAfficherMarche(village);
	}
	
	@Test
	void testControlAfficherMarche() {
		assertNotNull(controlAfficherMarche, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerInfosMarche() {
		String[] marche = controlAfficherMarche.donnerInfosMarche();
		assertNotNull(marche, "Constructeur ne renvoie pas null");
	}

}
