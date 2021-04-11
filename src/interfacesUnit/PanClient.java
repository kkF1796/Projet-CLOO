package interfacesUnit;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import personne.Client;
import personne.Personne;

public class PanClient extends JPanel{
	
	// informations relatives au client
	private JTextField nomClient= new JTextField();
	private JTextField prenomClient= new JTextField();
	private JTextField numSecClient= new JTextField();
	
	
	public PanClient(){
		
		//JPanel panClient= new JPanel(
		this.setLayout(new GridLayout(3,2));
		this.setPreferredSize(new Dimension(100,25));
		this.setBorder(BorderFactory.createTitledBorder("Client"));
		this.add(new JLabel("Prenom: "));
		prenomClient.setPreferredSize(new Dimension(100,25));
		this.add(prenomClient);
		this.add(new JLabel("Nom: "));
		nomClient.setPreferredSize(new Dimension(100,25));
		this.add(nomClient);
		this.add(new JLabel("Numéro de sécurité sociale: "));
		numSecClient.setPreferredSize(new Dimension(100,25));
		this.add(numSecClient);
	}
	
	
	public Client getClient(){
		String nom=this.nomClient.getText();
		String prenom=this.prenomClient.getText();
		int numSec=Integer.parseInt((this.numSecClient).getText());
		
		return new Client(new Personne(nom,prenom),numSec);
	}

}// end class
