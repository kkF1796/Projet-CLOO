/*** 
 * 
 * 	Cette classe permet de gérer une demande de calcul de recette.
 * 
 * ***/

package interfaceGraphique;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import interfacesRecette.*;
import interfacesUnit.*;
import stock.Medicament;
import user.Gestionnaire;

public class PanRecette extends JPanel {
	
	private String[] periodeEnum= {"Journée","Semaine","Mois"};
	private String[] typeEnum= {"Total","Client","Vendeur","Type Médicament"};
	
	// informations relatives à la recette
	private JComboBox periode= new JComboBox(periodeEnum);
	private JComboBox type= new JComboBox(typeEnum);
	
	
	private JButton valide=new JButton("Valider");
	
	public PanRecette(Gestionnaire gestionnaire){
		
		int large=70;
		int longueur=100;
		
		this.setPreferredSize(new Dimension(longueur,large));
		this.setBorder(BorderFactory.createTitledBorder("Recette"));
		
		JPanel panPeriode=new JPanel();
		panPeriode.add(new JLabel("Période: "));
		panPeriode.add(periode);
	
		panPeriode.add(new JLabel("Type: "));
		panPeriode.add(type);
		
		
		JPanel panType=new JPanel();
		panType.add(valide);
		
		/// action listener
		this.valide.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev){
				
				String periode= getPeriode();
				String type=getType();
				
				if(periode.equals("Journée") && type.equals("Total") ){
					PanJournee pan = new PanJournee();
					pan.getRecette(gestionnaire);
				}
				if(periode.equals("Journée") && type.equals("Client") ){
					PanJourClient pan = new PanJourClient();
					pan.getRecette(gestionnaire);
				}
				if(periode.equals("Journée") && type.equals("Vendeur") ){
					PanJourVend pan = new PanJourVend();
					pan.getRecette(gestionnaire);
				}
				if(periode.equals("Journée") && type.equals("Type Médicament") ){
					PanJourMedic pan = new PanJourMedic();
					pan.getRecette(gestionnaire);
				}
				if(periode.equals("Semaine") && type.equals("Total") ){
					PanIntervalleDate pan = new PanIntervalleDate();
					pan.getRecette(gestionnaire);
				}
				if(periode.equals("Semaine") && type.equals("Client") ){
					PanSemClient pan = new PanSemClient();
					pan.getRecette(gestionnaire);
				}
				if(periode.equals("Semaine") && type.equals("Vendeur") ){
					PanSemVend pan = new PanSemVend();
					pan.getRecette(gestionnaire);
				}
				if(periode.equals("Semaine") && type.equals("Type Médicament") ){
					PanSemMedic pan = new PanSemMedic();
					pan.getRecette(gestionnaire);
				}
				if(periode.equals("Mois") && type.equals("Total") ){
					PanMois pan = new PanMois();
					pan.getRecette(gestionnaire);
				}
				if(periode.equals("Mois") && type.equals("Client") ){
					PanMoisClient pan = new PanMoisClient();
					pan.getRecette(gestionnaire);
				}
				if(periode.equals("Mois") && type.equals("Vendeur") ){
					PanMoisVend pan = new PanMoisVend();
					pan.getRecette(gestionnaire);
				}
				if(periode.equals("Mois") && type.equals("Type Médicament") ){
					PanMoisMedic pan = new PanMoisMedic();
					pan.getRecette(gestionnaire);
				}
					
			}
		});
		
		this.setLayout(new GridLayout(2,1));
		//this.setLayout(new BorderLayout(1,2));
		this.add(panPeriode);
		this.add(panType);
	}
	
	public String getPeriode(){
		return (this.periode).getSelectedItem().toString();
	}
	
	public String getType(){
		return (this.type).getSelectedItem().toString();
	}
	
	
}// end class
