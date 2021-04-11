package interfacesRecette;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interfacesUnit.PanJournee;
import interfacesUnit.PanMedicament;
import interfacesUnit.PanMois;
import outils.DateVente;
import personne.Vendeur;
import stock.Medicament;
import user.Gestionnaire;

public class PanMoisMedic extends JPanel{
	
	private PanMois panMois= new PanMois();
	private PanMedicament panMedic= new PanMedicament();
			
	public PanMoisMedic(){
		this.setBorder(BorderFactory.createTitledBorder("Recette du mois"));
		this.setLayout(new GridLayout(2,1));
		panMois.setPreferredSize(new Dimension(150,100));
		panMedic.setPreferredSize(new Dimension(150,100));
		this.add(panMois);
		this.add(panMedic);
	}
	
	public String getMois(){
		return panMois.getMois();
	}
	
	public Medicament getMedic(){
		return panMedic.getMedicament();
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
			
			Medicament medic= this.getMedic();
			
			// chercher calcul de la recette dans historique des ventes
			recette=(gestionnaire.getHistorique()).getRecetteMM(mois,annee,medic);
			 
			JOptionPane.showMessageDialog(this, "Recette mensuelle: \n"+ 
					"Mois: "+ mois+"\n"+"Annee: "+ annee+"\n"+
					"Médicament: "+medic.getNom()+" ("+medic.getType()+") "+"\n"
					+"Total: "+recette);
		
		}
		
		return recette;
	}

}// end class
