package controleur;

import frontiere.Clavier;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public Boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	
	public Etal[] trouverEtalVendeur(String produit) {
		Gaulois[] vendeur = village.rechercherVendeursProduit(produit);
		int nbVendeur = vendeur.length;
		Etal[] listeEtal = new Etal[nbVendeur];
		
		for (int i = 0; i<nbVendeur ; i++) {
			listeEtal[i] = controlTrouverEtalVendeur.trouverEtalVendeur(vendeur[i].getNom());//village.rechercherEtal(vendeur[i]);
		}
		
		return listeEtal;
	}
	
	public void afficherVendeur(Etal[] listeEtal) {
		StringBuilder message = new StringBuilder();
		
		for (int i = 0; i<listeEtal.length;i++) {
			if(listeEtal[i].getVendeur()!=null) {
				message.append(i).append(" - ").append(listeEtal[i].getVendeur().getNom()).append("\n");
			}
		}
		System.out.println(message);
	}
	
	public void acheterProduit(Etal etal, String nomAcheteur, String produit) {
		StringBuilder message = new StringBuilder();
		if (etal.getVendeur()!=null) {
			message.append(nomAcheteur).append(" se déplace jusqu'à l'étal du vendeur ").append(etal.getVendeur().getNom()).append("\n");
			message.append("Bonjour ").append(nomAcheteur).append("\n");
			System.out.println(message);
			int quantiteAcheter = Clavier.entrerEntier("Combien de "+produit+" voulez-vous acheter ?\n");
			etal.acheterProduit(quantiteAcheter);
			System.out.println(nomAcheteur+ " achète "+ quantiteAcheter + " à "+etal.getVendeur().getNom());
		}
	}
	
}
