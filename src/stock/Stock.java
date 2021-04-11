package stock;

import java.util.*;

import exceptions.QteStockException;
import vente.*;


public class Stock {
	
	private ArrayList<Medicament> stock= new ArrayList();
	
	public Stock(){
	}
	
	public Stock(ArrayList<Medicament> stock){
		this.stock=stock;
	}
	
	public ArrayList<Medicament> getStock(){
		return stock;
	}
	
	// m�thode qui v�rifie si un m�dicament est dans le stock
	 public boolean containsMedicament(Medicament medicament){
		  return this.stock.contains(medicament); 		  
	  }
	 
	 // m�thode qui ajout un m�dicament un stock
	 public boolean addMedicamentStock(Medicament medicament){
		  if(!containsMedicament(medicament)){
			  this.stock.add(medicament);
			  return true;
		  }else{
			  return false;
		  }
	  }
	 
	 // m�thode qui modifie quantit� d'un m�dicament d�j� existant
	 public void addMedicament(Medicament medicament){
		 if(containsMedicament(medicament)){
			 for (Medicament medicaments : stock) {
				  if(medicaments.equals(medicament)){
					  //medicaments.remQteAjout(medicament.getQteAjout());
					  medicaments.addQteAjout(medicament.getQteAjout());
				  }
			  }
		  }else{
			  addMedicamentStock(medicament); 
		  }
	 }
	 
	//m�thode qui modifie la quantit� d'un m�dicament d�j� existant
	  public boolean removeMedicament(Medicament medicament){
		  boolean flag=false;
		  for (Medicament medicaments : stock) {
			  if(medicaments.equals(medicament)){
				  
				 // medicaments.addQteAjout(medicament.getQteAjout() );
				  
				  try{
					  medicaments.remQteAjout(medicament.getQteAjout());
					  flag=true;
				  }catch(QteStockException e){
					  flag=false;  
				  }
				  break;
			  }
		  }
		  return flag;
	  }
	  
	  // m�thode  qui supprime un m�dicament du stock
	  public boolean removeMedicamentStock(Medicament medicament){		  
		  for (Medicament medicaments : stock) {
			  if(medicaments.equals(medicament)){
				  this.stock.remove(medicaments);
				  return true;
			  }
		  }
		  return false;
	  }
	  
	  //m�thode qui affiche le descriptif des m�dicaments du stock
	  public String print(){
		  String print=" INVENTAIRE DU STOCK" +"\n"+" ***********************"+"\n"+
				  "Nom (type) +quantite � ajouter au stock : prix"+"\n";
		  for (Medicament medicament : stock) {
			 print+=medicament.print()+"\n \n";
		  }
		  return print;
	  }
	  
	  //m�thode qui s�lectionne et retourne le m�dicaments est aussi possible
	  public Medicament selectMedicament(Medicament medicament){
		  Medicament medic =new Medicament();
		  for (Medicament medicaments : stock) {
			  if(medicaments.equals(medicament)){
				  medic=medicaments;
			  }
		  }
		  return medic;
	  }
	  
	  public Object[][] toObject(){
		  Object[][] data=new Object[stock.size()][4];
		  int i=0;
		  for(Medicament med: this.stock){
			  data[i][0]=med.getNom();
			  data[i][1]=med.getType();
			  data[i][2]=med.getPrix();
			  data[i][3]=med.getQteAjout();
			  i++;
		  }
		  return data;
	  }
	  
	  
	  // m�thode qui fait une mise � jour du stock apr�s une vente
	  public void update(ListeAchats liste){
		  for(Medicament achat: liste.getAchats()){
			  this.removeMedicament(achat);
		  }
	  }

}// end class
