package interfacesRecette;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interfacesUnit.PanClient;
import interfacesUnit.PanIntervalleDate;
import interfacesUnit.PanVendeur;
import outils.DateVente;
import personne.Client;
import personne.Vendeur;
import user.Gestionnaire;

public class PanSemVend extends JPanel{
	
	private PanIntervalleDate dates = new PanIntervalleDate();
	private PanVendeur panVendeur=new PanVendeur();
	
	public PanSemVend(){
		
		//this.setBorder(BorderFactory.createTitledBorder("Recette de la semaine"));
		this.setLayout(new GridLayout(2,1));
		dates.setPreferredSize(new Dimension(250,10));
		panVendeur.setPreferredSize(new Dimension(250,100));
		this.add(dates);
		this.add(panVendeur);
		
	}
	
	public DateVente getDateVente1(){		
		return dates.getDateVente1();
	}
	
	public DateVente getDateVente2(){		
		return dates.getDateVente2();
	}
	
	public Vendeur getVendeur(){
		return panVendeur.getVendeur();
	}
	
	public double getRecette(Gestionnaire gestionnaire){
		double recette=0;
		
		int reponse = JOptionPane.showConfirmDialog(null, this, 
				"Recette hebdomadaire", JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.PLAIN_MESSAGE);
		
		if(reponse == JOptionPane.OK_OPTION){
			DateVente date1= this.getDateVente1();
			DateVente date2= this.getDateVente2();
			
			Vendeur vendeur =this.getVendeur();
			
			// chercher calcul de la recette dans historique des ventes
			recette=(gestionnaire.getHistorique()).getRecetteSV(date1,date2,vendeur);
			 
			JOptionPane.showMessageDialog(this, "Recette hebdomadaire: \n"+ 
					"Du: "+date1.print()+"\n"+"Au: "+date2.print()+"\n"+"Vendeur: "+vendeur.print()
					+"\n"+"Total: "+recette);
		
		}
		
		return recette;
	}

}
