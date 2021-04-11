package interfacesUnit;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import personne.Personne;
import personne.Vendeur;

public class PanVendeur extends JPanel{
	
	// informations relatives au vendeur
	private JTextField nomVendeur= new JTextField();
	private JTextField prenomVendeur= new JTextField();
	
	public PanVendeur(){
		//this.setPreferredSize(new Dimension(longueur/2,large/4));
		this.setLayout(new GridLayout(2,2));
		this.setBorder(BorderFactory.createTitledBorder("Vendeur"));
		this.add(new JLabel("Prenom: "));
		prenomVendeur.setPreferredSize(new Dimension(100,25));
		this.add(prenomVendeur);
		this.add(new JLabel("Nom: "));
		nomVendeur.setPreferredSize(new Dimension(100,25));
		this.add(nomVendeur);
	}
	
	public Vendeur getVendeur(){
		String nom=this.nomVendeur.getText();
		String prenom=this.prenomVendeur.getText();
		
		return new Vendeur(new Personne(nom,prenom));
	}

}// end class
