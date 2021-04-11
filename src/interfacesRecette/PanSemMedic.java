package interfacesRecette;

import java.awt.Dimension;

import java.awt.GridLayout;

import javax.swing.*;

import interfacesUnit.*;
import outils.DateVente;
import personne.Vendeur;
import stock.Medicament;
import user.Gestionnaire;

public class PanSemMedic extends JPanel{
	
	private PanIntervalleDate dates = new PanIntervalleDate();
	private PanMedicament panMedic=new PanMedicament();
	
	public PanSemMedic(){
		
		this.setBorder(BorderFactory.createTitledBorder("Recette de la semaine"));
		this.setLayout(new GridLayout(2,1));
		dates.setPreferredSize(new Dimension(350,75));
		panMedic.setPreferredSize(new Dimension(350,75));
		this.add(dates);
		this.add(panMedic);
		
	}
	
	public DateVente getDateVente1(){		
		return dates.getDateVente1();
	}
	
	public DateVente getDateVente2(){		
		return dates.getDateVente2();
	}
	
	public Medicament getMedicament(){
		return panMedic.getMedicament();
	}
	
	
	public double getRecette(Gestionnaire gestionnaire){
		double recette=0;
		
		int reponse = JOptionPane.showConfirmDialog(null, this, 
				"Recette hebdomadaire", JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.PLAIN_MESSAGE);
		
		if(reponse == JOptionPane.OK_OPTION){
			DateVente date1= this.getDateVente1();
			DateVente date2= this.getDateVente2();
			
			Medicament medic =this.getMedicament();
			
			// chercher calcul de la recette dans historique des ventes
			recette=(gestionnaire.getHistorique()).getRecetteSM(date1,date2,medic);
			 
			JOptionPane.showMessageDialog(this, "Recette habdomadaire: \n"+ 
					"Du: "+date1.print()+"\n"+"Au: "+date2.print()+"\n"+"Médicament: "
					+medic.getNom()+" ("+medic.getType()+") "
					+"\n"+"Total: "+recette);
		
		}
		
		return recette;
	}

}// end class
