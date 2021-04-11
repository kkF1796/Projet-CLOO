/*** 
 * 
 * Cette classe permet de créer l'affichage du panneau relatif 
 * à une demande de détails sur une vente.
 * 
 * ***/

package interfaceGraphique;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import vente.*;

public class PanneauDetails extends PanVenteModel {
	
	private JTextField prix= new JTextField();
	
	public PanneauDetails(){
		
		super();
		
		int large=250;
		int longueur=700;
		
		this.setPreferredSize(new Dimension(longueur,large));
		
		JPanel panPrix= new JPanel();
		panPrix.setPreferredSize(new Dimension(longueur/2,large/4));
		panPrix.setBorder(BorderFactory.createTitledBorder("Facture"));
		panPrix.add(new JLabel("Total: "));
		prix.setPreferredSize(new Dimension(100,25));
		panPrix.add(prix);
		
		
		this.setLayout(new GridLayout(2,2));
		this.add(panPrix);
		
	}
	
	public double getPrix(){
		return Double.parseDouble((this.prix).getText());
	}
	
	public Vente getVente(){
		return new Vente(super.getClient(),super.getVendeur(), new Facture(this.getPrix(), super.getDateVente()) );
	}

}
