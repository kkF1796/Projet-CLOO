package interfacesUnit;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import outils.DateVente;
import stock.Medicament;
import user.Gestionnaire;

public class PanIntervalleDate extends JPanel{
	
	private String[] moisEnum= {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août",
			"Septembre","Octobre","Novembre","Décembre"};
	
	// informations relatives à la date
	private JComboBox jour1= new JComboBox();
	private JComboBox mois1= new JComboBox(moisEnum);
	private JComboBox annee1= new JComboBox();

	
	// informations relatives à la date
	private JComboBox jour2= new JComboBox();
	private JComboBox mois2= new JComboBox(moisEnum);
	private JComboBox annee2= new JComboBox();
	
	
	public PanIntervalleDate(){
		
		int large=150;
		int longueur=200;
		
		this.setPreferredSize(new Dimension(longueur,large));
		this.setBorder(BorderFactory.createTitledBorder("Dates"));

	
		int i;
		for(i=1;i<=31;i++){
			jour1.addItem(Integer.toString(i));
			jour2.addItem(Integer.toString(i));
		}
		for(i=2023;i>=2001;i--){
			annee1.addItem(Integer.toString(i));
			annee2.addItem(Integer.toString(i));
		}
		
		JPanel date1=new JPanel();
		date1.add(new JLabel("Du: "));
		date1.add(jour1);
		date1.add(mois1);
		date1.add(annee1);
		
		JPanel date2=new JPanel();
		date2.add(new JLabel("Au: "));
		date2.add(jour2);
		date2.add(mois2);
		date2.add(annee2);
		
		
		this.setLayout(new GridLayout(2,1));
		this.add(date1);
		this.add(date2);
	}
	
	public DateVente getDateVente1(){
		int jour= Integer.parseInt((this.jour1).getSelectedItem().toString());
		String mois= (this.mois1).getSelectedItem().toString();
		int annee= Integer.parseInt((this.annee1).getSelectedItem().toString());
		
		return new DateVente(jour,mois,annee);
	}
	
	public DateVente getDateVente2(){
		int jour= Integer.parseInt((this.jour2).getSelectedItem().toString());
		String mois= (this.mois2).getSelectedItem().toString();
		int annee= Integer.parseInt((this.annee2).getSelectedItem().toString());
		
		return new DateVente(jour,mois,annee);
	}
	
	
	public double getRecette(Gestionnaire gestionnaire){
		double recette=0;
		
		int reponse = JOptionPane.showConfirmDialog(null, this, 
				"Recette hebdomadaire", JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.PLAIN_MESSAGE);
		
		if(reponse == JOptionPane.OK_OPTION){
			DateVente date1= this.getDateVente1();
			DateVente date2= this.getDateVente2();
			
			// chercher calcul de la recette dans historique des ventes
			recette=(gestionnaire.getHistorique()).getRecetteST(date1,date2);
			 
			JOptionPane.showMessageDialog(this, "Recette hebdomadaire: \n"+ 
					"Du: "+date1.print()+"\n"+"Au: "+date2.print()
					+"\n"+"Total: "+recette);
		
		}
		
		return recette;
	}

}// end class
