package user;

import interfaceGraphique.*;
import interfacesUnit.PanIntervalleDate;

import java.awt.event.*;

import javax.swing.*;

import gestionnaires.PanGestionStock;
import gestionnaires.PanHistoVentes;
import gestionnaires.TableHistorique;
import gestionnaires.TableStock;
import outils.*;
import personne.*;
import stock.*;
import vente.*;

public class Gestionnaire{
	
	private Stock stock=new Stock();
	private TableStock tableStock= new TableStock();
	
	private HistoriqueVente historique=new HistoriqueVente();
	private TableHistorique tableHistorique= new TableHistorique();

	
	public Gestionnaire(){
	}
	
	public Gestionnaire(Stock stock){
		this.stock=stock;
		this.tableStock=new TableStock(stock);
	}

	public TableStock getTableStock() {
		return tableStock;
	}
	
	
	public Stock getStock() {
		return stock;
	}

	public TableHistorique getTableHistorique() {
		return tableHistorique;
	}
	
	
	public HistoriqueVente getHistorique() {
		return historique;
	}

	
	public void setActionListenerAjout(PanGestionStock pan){
		
		(pan.getAjout()).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev){
				PanneauMedicament panneau = new PanneauMedicament();
				int reponse = JOptionPane.showConfirmDialog(null, panneau, 
						"Ajouter au Stock", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				
				
				if(reponse == JOptionPane.OK_OPTION){
					JOptionPane.showMessageDialog(panneau, "Descriptif: \n"
								+panneau.getNom()+" "+panneau.getType()
								+" "+ panneau.getPrix()+"\n"+panneau.getQteAjout());
					
					stock=tableStock.addMedicament(new String [] {panneau.getNom(), 
							panneau.getType(), panneau.getPrix(), panneau.getQteAjout()}, stock);
					
					//System.out.println(stock.print());
				}
				
			}
		});
	}// end Action Listener Ajout
	
	
	public void setActionListenerSuppr(PanGestionStock pan){
		
		(pan.getSuppr()).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev){
				
				PanneauMedicament panneau = new PanneauMedicament();
				int reponse = JOptionPane.showConfirmDialog(null, panneau, 
						"Supprimer du Stock", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				
				
				if(reponse == JOptionPane.OK_OPTION){
					JOptionPane.showMessageDialog(panneau,"Etes-vous sûr de vouloir supprimer "+panneau.getNom()+" "
							+panneau.getType()+" "+" du stock ?");
					
					stock=tableStock.removeMedicament(new String [] {panneau.getNom(), 
							panneau.getType(), panneau.getPrix(), panneau.getQteAjout()}, stock);
					
					//System.out.println(stock.print());
				}
			}
		});
	}//end Action Listener Suppr
	
	
	public void setActionListenerRefresh(PanGestionStock pan){
		
		(pan.getRefresh()).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev){
				stock=tableStock.refresh(stock);
				//System.out.println(stock.print());
			}
		});
	}// end Action Listener Refresh
	
	
	public void setActionListenerAjout(PanHistoVentes pan){
		
		(pan.getAjout()).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev){
				PanneauVente panneau = new PanneauVente(stock);
				int reponse = JOptionPane.showConfirmDialog(null, panneau, 
						"Nouvelle Vente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				
				
				
				if(reponse == JOptionPane.OK_OPTION){
					
					Vente vente=panneau.getVente();
					
					JOptionPane.showMessageDialog(panneau, "Récapitulatif de la vente: \n"+"\n"
								+vente.print());
					
					// mettre à jour le stock et la Table à partir de la Vente récupérée
					stock.update(vente.getListeAchats());
					tableStock.update(vente.getListeAchats());
					
					historique.addVente(vente);
					tableHistorique.addVente(vente);
					
					//System.out.println(stock.print());
					//System.out.println("APRES VENTE: "+ historique.print());
					
				}
				
			}
		});
		
	}//end Action Listener Ajout
	
	
	public void setActionListenerDetails(PanHistoVentes pan){
		
		(pan.getDetail()).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev){
				PanneauDetails panneau = new PanneauDetails();
				int reponse = JOptionPane.showConfirmDialog(null, panneau, 
						"Détail d'une vente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				
				
				if(reponse == JOptionPane.OK_OPTION){
					
					Vente vente= panneau.getVente();
					
					String affichage="";
					
					if(historique.containsVente(vente)){
						Vente venteHist=historique.selectVente(vente);
						affichage=venteHist.print();
					}else{
						affichage="La vente demandée n'existe pas dans l'historique.";
					}
					
					JOptionPane.showMessageDialog(panneau, "Détail de la vente: \n"+affichage);
					
				}
			}
		});
	}// end ACtion Listener Details
	
	
	public void setActionListenerSuppr(PanHistoVentes pan){
		
		(pan.getSuppr()).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev){
				PanIntervalleDate panneau = new PanIntervalleDate();
				int reponse = JOptionPane.showConfirmDialog(null, panneau, 
						"Suppression des ventes dans l'historique", JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.PLAIN_MESSAGE);
				
				
				if(reponse == JOptionPane.OK_OPTION){
					DateVente date1=panneau.getDateVente1();
					DateVente date2=panneau.getDateVente2();
					
					//JOptionPane.showMessageDialog(panneau, "Détail de la vente: \n");
					
					tableHistorique.update(date1, date2); 
					
					historique=tableHistorique.refresh(historique);
					
					
					//System.out.println("APRES REFRESH: "+ historique.print());
		
				}
			}
		});
	}// end Action Listener Supprimer

}// end class
