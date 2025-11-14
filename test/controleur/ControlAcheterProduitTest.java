package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Chef abraracourcix;
	private ControlAcheterProduit controlAcheterProduit;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		village.installerVendeur(abraracourcix, "fleurs", 10);
	}
	
	@Test
	void testControlAcheterProduit() {
		assertNotNull(controlAcheterProduit, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentiteTrue() {
		assertNotNull(controlAcheterProduit.verifierIdentite(abraracourcix.getNom()), "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testVerifierIdentiteFalse() {
		assertFalse(controlAcheterProduit.verifierIdentite("Cofidix"), "Constructeur ne renvoie pas null");
	}

	@Test
	void testTrouverEtalVendeurFalse() {
		Etal[] listeEtal = controlAcheterProduit.trouverEtalVendeur("poisson");
		assertTrue(listeEtal.length==0,"Il n'y a pas d'étals");
	}
	
	@Test
	void testTrouverEtalVendeurTrue() {
		Etal[] listeEtal = controlAcheterProduit.trouverEtalVendeur("fleurs");
		assertTrue(listeEtal.length!=0,"Il y'a des étals");
	}
	
	@Test
	void testAfficherVendeur() {
		Etal[] listeEtal = controlAcheterProduit.trouverEtalVendeur("fleurs");
		controlAcheterProduit.afficherVendeur(listeEtal);
		assertTrue(true,"Il y'a des étals");
	}

	@Test
	void testAcheterProduitTrue() {
		Gaulois cofidix = new Gaulois("Cofidix", 1);
		village.ajouterHabitant(cofidix);
		Etal[] listeEtal = controlAcheterProduit.trouverEtalVendeur("fleurs");
		controlAcheterProduit.acheterProduit(listeEtal[0], cofidix.getNom(), "fleurs", 5);
		assertTrue(listeEtal[0].getQuantite()==5,"Il y'a des étals");
	}
	
	@Test
	@DisplayName("Negative quantity -> nothing append")
	void testAcheterProduitFalse() {
		Gaulois cofidix = new Gaulois("Cofidix", 1);
		village.ajouterHabitant(cofidix);
		Etal[] listeEtal = controlAcheterProduit.trouverEtalVendeur("fleurs");
		controlAcheterProduit.acheterProduit(listeEtal[0], cofidix.getNom(), "fleurs", -5);
		assertTrue(listeEtal[0].getQuantite()==10,"Valeur négative");
	}
	
	@Test
	@DisplayName("No more products -> nothing append")
	void testAcheterProduitFalse2() {
		Gaulois cofidix = new Gaulois("Cofidix", 1);
		village.ajouterHabitant(cofidix);
		Etal[] listeEtal = controlAcheterProduit.trouverEtalVendeur("fleurs");
		controlAcheterProduit.acheterProduit(listeEtal[0], cofidix.getNom(), "fleurs", 10);
		controlAcheterProduit.acheterProduit(listeEtal[0], cofidix.getNom(), "fleurs", 1);
		assertTrue(listeEtal[0].getQuantite()==0,"Quantité vide");
	}
	
	@Test
	@DisplayName("Wrong products -> nothing append")
	void testAcheterProduitFalse3() {
		Gaulois cofidix = new Gaulois("Cofidix", 1);
		village.ajouterHabitant(cofidix);
		Etal[] listeEtal = controlAcheterProduit.trouverEtalVendeur("fleurs");
		controlAcheterProduit.acheterProduit(listeEtal[0], cofidix.getNom(), "poisson", 1);
		assertTrue(listeEtal[0].getQuantite()==10,"Quantité inchangé");
	}


	@Test
	void testObject() {
		fail("Not yet implemented");
	}

	@Test
	void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	void testClone() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	void testWait() {
		fail("Not yet implemented");
	}

	@Test
	void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	void testFinalize() {
		fail("Not yet implemented");
	}

}
