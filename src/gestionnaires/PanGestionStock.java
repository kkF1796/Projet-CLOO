/*** 
 * 
 * 	Cette classe permet de créer l'affichage du stock et la gestion de ses évènements.
 * 
 * ***/


package gestionnaires;

import java.awt.BorderLayout;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import user.Gestionnaire;

public class PanGestionStock extends JPanel {
		
	
	private JButton ajout=new JButton("Ajouter");
	private JButton refresh=new JButton("Refresh");
	private JButton suppr=new JButton("Supprimer");
	
	public PanGestionStock(Gestionnaire gestionnaire){
		
		JTable tableau= new JTable(gestionnaire.getTableStock().getModele());
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(tableau),BorderLayout.CENTER);
		
		gestionnaire.setActionListenerAjout(this);
			
		gestionnaire.setActionListenerSuppr(this);
		
		gestionnaire.setActionListenerRefresh(this);
		
		JPanel panneauButton= new JPanel();
		panneauButton.add(this.ajout);
		panneauButton.add(this.refresh);
		panneauButton.add(this.suppr);
		
		this.add(panneauButton, BorderLayout.SOUTH);
	
		
	}
	
	public JButton getAjout(){
		return this.ajout;
	}
	
	public JButton getRefresh(){
		return this.refresh;
	}
	
	public JButton getSuppr(){
		return this.suppr;
	}

}// end class
