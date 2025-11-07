package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		StringBuilder message = new StringBuilder();
		if (infosMarche.length==0) {
			message.append("Le marché est vide, revenez plus tard.");
		} else {
			message.append(nomAcheteur).append(", vous trouverez au marché :");
			int i = 0;
			while (i<infosMarche.length) {
				String vendeur = infosMarche[i];
				i++;
				String quantite = infosMarche[i];
				i++;
				String produit = infosMarche[i];
				i++;
				message.append("- ").append(vendeur).append(" qui vend").append(quantite).append(" ").append(produit).append("\n");
			}
		}
		
		System.out.println(message);
	}
}
