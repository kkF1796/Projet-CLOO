package interfacesRecette;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interfacesUnit.PanClient;
import interfacesUnit.PanIntervalleDate;
import outils.DateVente;
import personne.Client;
import user.Gestionnaire;

public class PanSemClient extends JPanel{
	
	private PanIntervalleDate dates = new PanIntervalleDate();
	private PanClient panClient=new PanClient();
	
	public PanSemClient(){
		
		//this.setBorder(BorderFactory.createTitledBorder("Recette de la semaine"));
		this.setLayout(new GridLayout(2,1));
		dates.setPreferredSize(new Dimension(350,100));
		panClient.setPreferredSize(new Dimension(350,100));
		this.add(dates);
		this.add(panClient);
		
	}
	
	public DateVente getDateVente1(){		
		return dates.getDateVente1();
	}
	
	public DateVente getDateVente2(){		
		return dates.getDateVente2();
	}
	
	public Client getClient(){
		return panClient.getClient();
	}
	
	public double getRecette(Gestionnaire gestionnaire){
		double recette=0;
		
		int reponse = JOptionPane.showConfirmDialog(null, this, 
				"Recette hebdomadaire", JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.PLAIN_MESSAGE);
		
		if(reponse == JOptionPane.OK_OPTION){
			DateVente date1= this.getDateVente1();
			DateVente date2= this.getDateVente2();
			
			Client client =this.getClient();
			
			// chercher calcul de la recette dans historique des ventes
			recette=(gestionnaire.getHistorique()).getRecetteSC(date1,date2,client);
			 
			JOptionPane.showMessageDialog(this, "Recette hebdomadaire: \n"+ 
					"Du: "+date1.print()+"\n"+"Au: "+date2.print()+"\n"+"Client: "+client.print()
					+"\n"+"Total: "+recette);
		
		}
		
		return recette;
	}

}// end class
