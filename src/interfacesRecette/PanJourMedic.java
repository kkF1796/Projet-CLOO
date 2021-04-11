package interfacesRecette;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interfacesUnit.PanClient;
import interfacesUnit.PanJournee;
import interfacesUnit.PanMedicament;
import outils.DateVente;
import personne.Client;
import personne.Vendeur;
import stock.Medicament;
import user.Gestionnaire;

public class PanJourMedic extends JPanel{
	
	private PanJournee panJour= new PanJournee();
	private PanMedicament panMedic= new PanMedicament();
			
	public PanJourMedic(){
		//this.setBorder(BorderFactory.createTitledBorder("Recette du jour"));
		this.setLayout(new GridLayout(2,1));
		panJour.setPreferredSize(new Dimension(350,75));
		panMedic.setPreferredSize(new Dimension(350,75));
		this.add(panJour);
		this.add(panMedic);
	}
	
	public DateVente getJour(){
		return panJour.getDateVente();
	}
	
	public Medicament getMedic(){
		return panMedic.getMedicament();
	}
	
	
	public double getRecette(Gestionnaire gestionnaire){
		double recette=0;
		
		int reponse = JOptionPane.showConfirmDialog(null, this, 
				"Recette journalière", JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.PLAIN_MESSAGE);
		
		if(reponse == JOptionPane.OK_OPTION){
			DateVente date= this.getJour();
			Medicament medic = this.getMedic();
			
			// chercher calcul de la recette dans historique des ventes
			recette=(gestionnaire.getHistorique()).getRecetteJM(date,medic);
			 
			JOptionPane.showMessageDialog(this, "Recette journalière: \n"+ 
					"Date: "+date.print()+"\n"+"Médicament: "+medic.getNom()+" ("+medic.getType()+") "
					+"\n"+"Total: "+recette);
		
		}
		
		return recette;
	}

}// end class
