package interfacesUnit;

import java.awt.Dimension;

import javax.swing.*;

import stock.Medicament;

public class PanMedicament extends JPanel{
	
	private JTextField saisieMedic= new JTextField();
	private JTextField typeMedic= new JTextField();
	
	public PanMedicament(){
		
		this.setBorder(BorderFactory.createTitledBorder("Achats"));
		this.add(new JLabel("Médicament: "));
		saisieMedic.setPreferredSize(new Dimension(100,25));
		this.add(saisieMedic);
		this.add(new JLabel("Type: "));
		typeMedic.setPreferredSize(new Dimension(100,25));
		this.add(typeMedic);
	}
	
	public Medicament getMedicament(){
		String nom=this.saisieMedic.getText(); 
		//int qte=((Number) (this.qteMedic).getValue()).intValue();
		String type= this.typeMedic.getText();
		
		return new Medicament(nom,type,0);
	}

}// end class
