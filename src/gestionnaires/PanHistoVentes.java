/*** 
 * 
 * Cette classe permet de gérer l'affichage de l'historique des ventes
 * ainsi que ses évènements.
 * 
 * ***/

package gestionnaires;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import user.Gestionnaire;

public class PanHistoVentes extends JPanel {
	
	private JButton ajout=new JButton("Ajouter");
	private JButton detail=new JButton("Détails");
	private JButton suppr=new JButton("Supprimer");
	
	public PanHistoVentes(Gestionnaire gestionnaire){
		
		JTable tableau= new JTable(gestionnaire.getTableHistorique().getModele());
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(tableau),BorderLayout.CENTER);
		
		gestionnaire.setActionListenerAjout(this);
		
		gestionnaire.setActionListenerDetails(this);
		
		gestionnaire.setActionListenerSuppr(this);
		
		JPanel panneauButton= new JPanel();
		panneauButton.add(this.ajout);
		panneauButton.add(this.detail);
		panneauButton.add(this.suppr);
		
		this.add(panneauButton, BorderLayout.SOUTH);
	}// end construct
	
	
	public JButton getAjout(){
		return this.ajout;
	}
	
	public JButton getDetail(){
		return this.detail;
	}
	
	public JButton getSuppr(){
		return this.suppr;
	}

}//end class
