package interfaceGraphique;

import java.awt.Dimension;

import java.awt.GridLayout;

import javax.swing.*;

import interfacesUnit.*;
import outils.DateVente;
import personne.Client;
import personne.Personne;
import personne.Vendeur;

public class PanVenteModel extends JPanel{
	
	
	private PanJournee panDate =new PanJournee();
	
	private PanClient panClient=new PanClient();
	
	private PanVendeur panVendeur= new PanVendeur();
	
	
	public PanVenteModel(){
		
		int large=250;
		int longueur=700;
		
		this.setPreferredSize(new Dimension(longueur,large));

		
		this.setLayout(new GridLayout(2,2));
		this.add(panDate);
		this.add(panClient);
		this.add(panVendeur);
		this.add(panDate);
		
	}// end construct
	
	public DateVente getDateVente(){
		return panDate.getDateVente();
	}
	
	public Client getClient(){
		return panClient.getClient();
	}
	
	public Vendeur getVendeur(){		
		return panVendeur.getVendeur();
	}

}//end class
