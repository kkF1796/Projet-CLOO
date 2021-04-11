package interfacesRecette;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interfacesUnit.PanClient;
import interfacesUnit.PanJournee;
import interfacesUnit.PanMois;
import outils.DateVente;
import personne.Client;
import user.Gestionnaire;

public class PanMoisClient extends JPanel{
	
	private PanMois panMois= new PanMois();
	private PanClient panClient= new PanClient();
			
	public PanMoisClient(){
		//this.setBorder(BorderFactory.createTitledBorder("Recette du mois"));
		this.setLayout(new GridLayout(2,1));
		panMois.setPreferredSize(new Dimension(350,100));
		panClient.setPreferredSize(new Dimension(350,100));
		this.add(panMois);
		this.add(panClient);
	}
	
	public String getMois(){
		return panMois.getMois();
	}
	
	public int getAnnee(){
		return panMois.getAnnee();
	}
	
	public Client getClient(){
		return panClient.getClient();
	}
	
	
	public double getRecette(Gestionnaire gestionnaire){
		double recette=0;
		
		int reponse = JOptionPane.showConfirmDialog(null, this, 
				"Recette mensuelle", JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.PLAIN_MESSAGE);
		
		if(reponse == JOptionPane.OK_OPTION){
			String mois=this.getMois();
			int annee=this.getAnnee();
			
			Client client= this.getClient();
			
			// chercher calcul de la recette dans historique des ventes
			recette=(gestionnaire.getHistorique()).getRecetteMC(mois,annee,client);
			 
			JOptionPane.showMessageDialog(this, "Recette mensuelle: \n"+ 
					"Mois: "+ mois+"\n"+"Annee: "+ annee+"\n"+"Client: "+ client.print()+"\n"
					+"Total: "+recette);
		
		}
		
		return recette;
	}

}// end class
