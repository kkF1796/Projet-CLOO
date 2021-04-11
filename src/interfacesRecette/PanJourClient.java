package interfacesRecette;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import interfacesUnit.*;
import outils.DateVente;
import personne.Client;
import user.Gestionnaire;

public class PanJourClient extends JPanel{
	
	private PanJournee panJour= new PanJournee();
	private PanClient panClient= new PanClient();
			
	public PanJourClient(){
		//this.setBorder(BorderFactory.createTitledBorder("Recette du jour"));
		this.setLayout(new GridLayout(2,1));
		panJour.setPreferredSize(new Dimension(350,100));
		this.add(panJour);
		panClient.setPreferredSize(new Dimension(350,100));
		this.add(panClient);
	}
	
	public DateVente getJour(){
		return panJour.getDateVente();
	}
	
	public Client getClient(){
		return panClient.getClient();
	}
	
	public double getRecette(Gestionnaire gestionnaire){
		double recette=0;
		
		int reponse = JOptionPane.showConfirmDialog(null, this, 
				"Recette journalière", JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.PLAIN_MESSAGE);
		
		if(reponse == JOptionPane.OK_OPTION){
			DateVente date= this.getJour();
			Client client = this.getClient();
			
			// chercher calcul de la recette dans historique des ventes
			 recette=(gestionnaire.getHistorique()).getRecetteJC(date,client);
			 
			JOptionPane.showMessageDialog(this, "Recette journalière: \n"+ 
					"Date: "+date.print()+"\n"+"Client: "+client.print()
					+"Total: "+recette);
		
		}
		
		return recette;
	}

}// end class
