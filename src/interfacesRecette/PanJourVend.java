package interfacesRecette;

import java.awt.Dimension;

import java.awt.GridLayout;

import javax.swing.*;

import interfacesUnit.*;
import outils.DateVente;
import personne.*;
import user.Gestionnaire;

public class PanJourVend extends JPanel{
	
	private PanJournee panJour= new PanJournee();
	private PanVendeur panVend= new PanVendeur();
			
	public PanJourVend(){
		//this.setBorder(BorderFactory.createTitledBorder("Recette du jour"));
		this.setLayout(new GridLayout(2,1));
		panJour.setPreferredSize(new Dimension(300,75));
		panVend.setPreferredSize(new Dimension(300,75));
		this.add(panJour);
		this.add(panVend);
	}
	
	public DateVente getJour(){
		return panJour.getDateVente();
	}
	
	public Vendeur getVendeur(){
		return panVend.getVendeur();
	}
	
	public double getRecette(Gestionnaire gestionnaire){
		double recette=0;
		
		int reponse = JOptionPane.showConfirmDialog(null, this, 
				"Recette journalière", JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.PLAIN_MESSAGE);
		
		if(reponse == JOptionPane.OK_OPTION){
			DateVente date= this.getJour();
			Vendeur vendeur = this.getVendeur();
			
			// chercher calcul de la recette dans historique des ventes
			 recette=(gestionnaire.getHistorique()).getRecetteJV(date,vendeur);
			 
			JOptionPane.showMessageDialog(this, "Recette journalière: \n"+ 
					"Date: "+date.print()+"\n"+"Vendeur: "+vendeur.print()
					+"Total: "+recette);
		
		}
		
		return recette;
	}

}// end class
