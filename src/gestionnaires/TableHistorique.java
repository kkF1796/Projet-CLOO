/*** 
 * 
 * 	Cette classe permet de gérer la table de l'historique des ventes.
 * 
 * ***/

package gestionnaires;

import javax.swing.table.AbstractTableModel;

import javax.swing.table.*;

import outils.DateVente;
import personne.*;
import vente.*;
import stock.*;

public class TableHistorique{
	
	
	private static String [] title={"Date","Prenom Client","Nom Client","Num. Séc. Sociale",
			"Prenom Vendeur", "Nom Vendeur","Total"};
	private DefaultTableModel table;

	public TableHistorique(){
		Object[][] obj = new Object[0][0];
		table= new DefaultTableModel(obj, title);
	}
	

	public TableModel getModele() {
		return table;
	}
	
	
	public void addVente(Vente vente){
		String [] e= {(vente.getDate()).print(), (vente.getClient()).getPrenom(),
				(vente.getClient()).getNom(), Integer.toString((vente.getClient()).getNumSec()),
				(vente.getVendeur()).getPrenom(),(vente.getVendeur()).getNom(), 
				Double.toString(vente.getPrix())};
		table.addRow(e);
	}
	
	public void update(DateVente date1, DateVente date2){
		int i=0;
		
		//int[] ind = new int[rows];
		//int index=0;
		
		while(i<table.getRowCount()){
			
			String str=(table.getValueAt(i,0)).toString();
			String[] tab=str.split("/");
			
			int jour=Integer.valueOf(tab[0]);
			int mois=Integer.valueOf(tab[1]);
			int annee=Integer.valueOf(tab[2].substring(0, tab[2].length()-1));
			
			DateVente date=new DateVente(jour,mois,annee);
						
	
			if(date.dansIntervalle(date1,date2)){
				table.removeRow(i);
				i=0;
			}else{
				i++;
			}
		}
	}
	
	public HistoriqueVente refresh(HistoriqueVente historique){
		HistoriqueVente rHist=new HistoriqueVente();
		
		int i=0;
		
		while(i<table.getRowCount()){
			String str=(table.getValueAt(i,0)).toString();
			String[] tab=str.split("/");
			int jour=Integer.valueOf(tab[0]);
			int mois=Integer.valueOf(tab[1]);
			int annee=Integer.valueOf(tab[2].substring(0, tab[2].length()-1));
			DateVente date=new DateVente(jour,mois,annee);
			
			String prenom=(table.getValueAt(i,1)).toString();
			String nom=(table.getValueAt(i,2)).toString();
			int num=Integer.parseInt((table.getValueAt(i,3)).toString());
			Client client=new Client(new Personne(nom, prenom), num);
			
			prenom=(table.getValueAt(i,4)).toString();
			nom=(table.getValueAt(i,5)).toString();
			Vendeur vendeur= new Vendeur(new Personne(nom, prenom));
			
			double prix=Double.parseDouble((table.getValueAt(i,6)).toString());
			
			Vente v=new Vente(client,vendeur, new Facture(prix, date) );
			
			if(historique.containsVente(v)){
				Vente vente=historique.selectVente(v);
				rHist.addVente(vente);
			}
			
			i++;
		}
		
		return rHist;
	}

}// end class
