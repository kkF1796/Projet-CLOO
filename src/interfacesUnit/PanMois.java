package interfacesUnit;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import outils.DateVente;
import stock.Medicament;
import user.Gestionnaire;

public class PanMois extends JPanel{
	
	private String[] moisEnum= {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août",
			"Septembre","Octobre","Novembre","Décembre"};
	
	// informations relatives à la date
	private JComboBox mois= new JComboBox(moisEnum);
	private JComboBox annee= new JComboBox();
	
	public PanMois(){
		
		int large=100;
		int longueur=200;
		
		int i;
		for(i=2023;i>=2001;i--){
			annee.addItem(Integer.toString(i));
		}
		
		this.setPreferredSize(new Dimension(longueur,large));
		this.setBorder(BorderFactory.createTitledBorder("Date"));
		
	//	JPanel date1=new JPanel();
		this.add(new JLabel("Mois: "));
		this.add(mois);
		this.add(annee);
		
	}
	
	public String getMois(){
		return (this.mois).getSelectedItem().toString();
	}
	
	public int getAnnee(){
		return Integer.parseInt((this.annee).getSelectedItem().toString());
	}
	
	
	public double getRecette(Gestionnaire gestionnaire){
		double recette=0;
		
		int reponse = JOptionPane.showConfirmDialog(null, this, 
				"Recette mensuelle", JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.PLAIN_MESSAGE);
		
		if(reponse == JOptionPane.OK_OPTION){
			String mois=this.getMois();
			int annee=this.getAnnee();
			
			// chercher calcul de la recette dans historique des ventes
			recette=(gestionnaire.getHistorique()).getRecetteMT(mois,annee);
			 
			JOptionPane.showMessageDialog(this, "Recette mensuelle: \n"+ 
					"Mois: "+ mois+"\n"+"Annee: "+ annee+"\n"+"Total: "+recette);
		
		}
		
		return recette;
	}


}// end class
