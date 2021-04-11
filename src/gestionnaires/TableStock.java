/*** 
 * 
 * 	Cette classe permet de g�rer la table relative au stock.
 * 
 * ***/

package gestionnaires;

import javax.swing.*;
import javax.swing.table.*;

import stock.*;
import vente.ListeAchats;

public class TableStock {
	
	private static String [] title= {"Medicament","Type","Prix","Quantit�"};
	private DefaultTableModel table;

	public TableStock(){
		Object[][] obj = new Object[0][0];
		table= new DefaultTableModel(obj, title);
	}
	
	public TableStock(Stock stock){
		Object[][] data = stock.toObject();
		this.table= new DefaultTableModel(data, title);
	}
	
	public DefaultTableModel getModele(){
		return table;
	}
	
	public int getRow(String name){
		int row=0;
		while(row< table.getRowCount()){
			if(name.equals((String)(table.getValueAt(row,0)))){
				break;
			}
			row++;
		}
		return row;
	}
		
	// m�thode qui ajoute un m�dicament d�j� connu au stock (un �l�ment)
	public Stock addMedicament(String [] e, Stock stock){		
	 Medicament medic =new Medicament(e[0],Double.parseDouble(e[2]),e[1],Integer.parseInt(e[3]));
		 if(stock.containsMedicament(medic)){
			int row=this.getRow((String) e[0]);
			int value= Integer.parseInt((String) table.getValueAt(row,3)) + Integer.parseInt(e[3]);// -
						 
			table.setValueAt(Integer.toString(value),row,3);
			 
		  }else{
			  table.addRow(e);
		  }
		 
		 stock.addMedicament(medic);

		 return stock;
		// stock=refresh();
	 } 
	
	public Stock removeMedicament(String [] e, Stock stock){
		Medicament medic =new Medicament(e[0],Double.parseDouble(e[2]),e[1],Integer.parseInt(e[3]));
		
		if(stock.containsMedicament(medic)){
			stock.removeMedicamentStock(medic);
			
			int row=this.getRow((String) e[0]);
			table.removeRow(row);
			
			// stock=refresh()
		
		}
			// stock=refresh()
		return stock;
	  }
	

	
	// m�thode refresh() qui v�rifie lien entre stock et Table
	// revient � faire un 'commit' dans une base de donn�es
	public Stock refresh(Stock stock){
		
		int i=0;
		Stock rStock=new Stock();
		while(i< table.getRowCount()){
	
			Medicament medic = new Medicament( (table.getValueAt(i, 0)).toString(),
					Double.valueOf(( table.getValueAt(i, 2)).toString()),  (table.getValueAt(i, 1)).toString(),
					Integer.valueOf((table.getValueAt(i, 3)).toString()) ); 
			
			rStock.addMedicament(medic);
			i++;
		}
		
		return rStock;
	}
	
	
	// m�thode qui update la table apr�s une vente
	public void update(ListeAchats liste){
		for(Medicament achat: liste.getAchats()){
			int row=this.getRow(achat.getNom());
			int value= Integer.parseInt((String) table.getValueAt(row,3)) - achat.getQteAjout();
								// modifier signe de l'op�ration en fonction de signification de qteAJout� //+
						 
			table.setValueAt(Integer.toString(value),row,3); 
		  }
	}

}// end class
