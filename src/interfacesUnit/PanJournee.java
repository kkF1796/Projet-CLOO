package interfacesUnit;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import outils.DateVente;
import user.Gestionnaire;

public class PanJournee extends JPanel{
	
	private String[] moisEnum= {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août",
			"Septembre","Octobre","Novembre","Décembre"};
	
	// informations relatives à la date
	private JComboBox jour= new JComboBox();
	private JComboBox mois= new JComboBox(moisEnum);
	private JComboBox annee= new JComboBox();
	
	public PanJournee(){
		
		int large=150;
		int longueur=200;
		
		this.setPreferredSize(new Dimension(longueur,large));
		this.setBorder(BorderFactory.createTitledBorder("Saisie d'un Jour"));

	
		int i;
		for(i=1;i<=31;i++){
			jour.addItem(Integer.toString(i));
		}
		for(i=2023;i>=2001;i--){
			annee.addItem(Integer.toString(i));
		}
		
	//	JPanel date1=new JPanel();
		this.add(new JLabel("Date: "));
		this.add(jour);
		this.add(mois);
		this.add(annee);
		
	}
	
	public DateVente getDateVente(){
		int jour= Integer.parseInt((this.jour).getSelectedItem().toString());
		String mois= (this.mois).getSelectedItem().toString();
		int annee= Integer.parseInt((this.annee).getSelectedItem().toString());
		
		return new DateVente(jour,mois,annee);
	}
	
	
	public double getRecette(Gestionnaire gestionnaire){
		double recette=0;
		
		int reponse = JOptionPane.showConfirmDialog(null, this, 
				"Recette journalière", JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.PLAIN_MESSAGE);
		
		if(reponse == JOptionPane.OK_OPTION){
			DateVente date= this.getDateVente();
			
			// chercher calcul de la recette dans historique des ventes
			 recette=(gestionnaire.getHistorique()).getRecetteJT(date);
			 
			JOptionPane.showMessageDialog(this, "Recette journalière: \n"+ 
					"Date: "+date.print()+"\n"+"Total: "+recette);
		
		}
		
		return recette;
	}

}// end class
