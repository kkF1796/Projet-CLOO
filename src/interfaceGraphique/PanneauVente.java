/*** 
 * 
 * 	Cette classe permet de créer le panneau relatif à la saisie d'une vente.
 * 
 * ***/

package interfaceGraphique;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import outils.*;
import personne.*;
import stock.*;
import vente.*;

public class PanneauVente extends  PanVenteModel{
	
	// informations relatives aux achats
	private JTextField saisieMedic= new JTextField();
	private JSpinner qteMedic=new JSpinner();
	private JTextField typeMedic= new JTextField();
	private JButton addAchats= new JButton("Ajouter");
	private JLabel ecranPrix= new JLabel("0.0");
	private JLabel ecran= new JLabel(" ");
	
	
	// contient la liste des achats enregistrés
	private ListeAchats listeAchats=new ListeAchats();
	
	
	
	public PanneauVente(Stock stock){
		
		super();
		
		int large=250;
		int longueur=700;
		
		this.setPreferredSize(new Dimension(longueur,large));
		
		
		JPanel panAchats= new JPanel();
		//panFacture.setPreferredSize(new Dimension(longueur/2,large/4));
		panAchats.setBorder(BorderFactory.createTitledBorder("Achats"));
		panAchats.add(new JLabel("Médicament: "));
		saisieMedic.setPreferredSize(new Dimension(100,25));
		panAchats.add(saisieMedic);
		panAchats.add(new JLabel("Type: "));
		typeMedic.setPreferredSize(new Dimension(100,25));
		panAchats.add(typeMedic);
		panAchats.add(new JLabel("Quantité: "));
		qteMedic.setPreferredSize(new Dimension(50,25));
		panAchats.add(qteMedic);
		panAchats.add(addAchats);
		
		JPanel panFacture= new JPanel(/*new GridLayout(1,2)*/);
		//panFacture.setPreferredSize(new Dimension(longueur/2,large/4));
		panFacture.setBorder(BorderFactory.createTitledBorder("Facture"));
		panFacture.add(new JLabel("Prix: "));
		panFacture.add(ecranPrix);
		
		
		JPanel panStock= new JPanel(/*new GridLayout(1,2)*/);
		//panFacture.setPreferredSize(new Dimension(longueur/2,large/4));
		panStock.setBorder(BorderFactory.createTitledBorder("Stock"));
		panStock.add(new JLabel("Gestion Stock: "));
		panStock.add(ecran);
		
		
		this.addAchats.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev){
				
				Medicament medicDemande=getMedicament();
				
				if(stock.containsMedicament(medicDemande)){
					Medicament medicStock=stock.selectMedicament(medicDemande);
					
					if(medicStock.getQteAjout() >= medicDemande.getQteAjout()){ 
						medicDemande.setPrix(medicStock.getPrix());
						listeAchats.addMedicament(medicDemande);
						
						ecranPrix.setText(String.valueOf(listeAchats.getPrix()));
						
						ecran.setText("Ajouté à la liste des achats.");
						
					}else{
						ecran.setText("Quantité insuffisante du médicament en stock.");
					}
					
				}else{
					ecran.setText("Medicament non disponible en stock.");
				}
								
				// faire un récapitulatif des médiaments sur un écran ???
				// écrire les Warnings sur un écran
			}
		});
		
		this.setLayout(new GridLayout(3,2));
		this.add(panAchats);
		this.add(panStock);
		this.add(panFacture);
		
	}
	
	
	public Medicament getMedicament(){
		String nom=this.saisieMedic.getText(); 
		int qte=((Number) (this.qteMedic).getValue()).intValue();
		String type= this.typeMedic.getText();
		
		return new Medicament(nom,type,qte);
	}
	
	public ListeAchats getListeAchats(){
		return this.listeAchats;
	}
	
	public Vente getVente(){
		return new Vente(super.getClient(),super.getVendeur(), this.listeAchats, super.getDateVente() );
	}

}// end class
