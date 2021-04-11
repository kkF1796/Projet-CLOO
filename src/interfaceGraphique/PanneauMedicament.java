/*** 
 * 
 * 	Cette classe permet de créer le panneau relatif à la saisie d'un médicament
 * pour ajout au stock.
 * 
 * ***/

package interfaceGraphique;

import java.awt.*;
import javax.swing.*;

public class PanneauMedicament extends JPanel{
	
	private JTextField saisieNom = new JTextField();
	private JTextField saisieType = new JTextField();
	private JTextField saisiePrix= new JTextField();
	private JTextField saisieQteAjout= new JTextField(); 
	
	public PanneauMedicament(){
		JPanel panneauLabels= new JPanel(new GridLayout(4,1,5,5));
		panneauLabels.add(new JLabel("Nom: "));
		panneauLabels.add(new JLabel("Type: "));
		panneauLabels.add(new JLabel("Prix: "));
		panneauLabels.add(new JLabel("Quantité à ajouter: "));
		
		JPanel panneauSaisie= new JPanel(new GridLayout(4,1,5,5));
		panneauSaisie.add(this.saisieNom);
		panneauSaisie.add(this.saisieType);
		panneauSaisie.add(this.saisiePrix);
		panneauSaisie.add(this.saisieQteAjout);
		
		setLayout(new BorderLayout(5,5));
		add(panneauLabels, BorderLayout.WEST);
		add(panneauSaisie, BorderLayout.CENTER);
		//add(new JScrollPane(saisieAdresse), BorderLayout.SOUTH);
	}
	
	/*public String getTitre(){
		return (String) this.saisieTitre.getSelectedItem();
	}*/
	
	public String getNom(){
		return this.saisieNom.getText();
	}
	
	public String getType(){
		return this.saisieType.getText();
	}
	
	public String getPrix(){
		return this.saisiePrix.getText();
	}
	
	public String getQteAjout(){
		return this.saisieQteAjout.getText();
	}

}// end class
