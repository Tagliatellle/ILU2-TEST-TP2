package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		StringBuilder message = new StringBuilder();
		if (controlLibererEtal.isVendeur(nomVendeur)!=null && Boolean.FALSE.equals(controlLibererEtal.isVendeur(nomVendeur))) {
			message.append("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
			
		} else {
			String[] infoEtal = controlLibererEtal.libererEtal(nomVendeur);
			if (Boolean.TRUE.equals(infoEtal[0])) {
				message.append("Vous avez vendu ");
				message.append(infoEtal[4]);
				message.append(" sur ");
				message.append(infoEtal[3]);
				message.append(" ");
				message.append(infoEtal[2]);
				message.append("\nEn revoir ");
				message.append(nomVendeur);
				message.append(", passez une bonne journée");
			}
		}
		System.out.println(message);
	}

}
