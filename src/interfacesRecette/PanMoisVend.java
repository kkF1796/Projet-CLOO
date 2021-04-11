package interfacesRecette;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

import interfacesUnit.*;
import outils.DateVente;
import personne.*;
import user.Gestionnaire;

public class PanMoisVend extends JPanel{
	
	private PanMois panMois= new PanMois();
	private PanVendeur panVend= new PanVendeur();
			
	public PanMoisVend(){
		//this.setBorder(BorderFactory.createTitledBorder("Recette du mois"));
		this.setLayout(new GridLayout(2,1));
		panMois.setPreferredSize(new Dimension(150,100));
		panVend.setPreferredSize(new Dimension(150,100));
		this.add(panMois);
		this.add(panVend);
	}
	
	public String getMois(){
		return panMois.getMois();
	}
	
	public Vendeur getVendeur(){
		return panVend.getVendeur();
	}
	
	public int getAnnee(){
		return panMois.getAnnee();
	}
	
	
	public double getRecette(Gestionnaire gestionnaire){
		double recette=0;
		
		int reponse = JOptionPane.showConfirmDialog(null, this, 
				"Recette mensuelle", JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.PLAIN_MESSAGE);
		
		if(reponse == JOptionPane.OK_OPTION){
			String mois=this.getMois();
			int annee=this.getAnnee();
			
			Vendeur vendeur= this.getVendeur();
			
			// chercher calcul de la recette dans historique des ventes
			recette=(gestionnaire.getHistorique()).getRecetteMV(mois,annee,vendeur);
			 
			JOptionPane.showMessageDialog(this, "Recette mensuelle: \n"+ 
					"Mois: "+ mois+"\n"+"Annee: "+ annee+"\n"+"Vendeur: "+ vendeur.print()+"\n"
					+"Total: "+recette);
		
		}
		
		return recette;
	}

}// end class
