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
	
	// méthode qui vérifie si un médicament est dans le stock
	 public boolean containsMedicament(Medicament medicament){
		  return this.stock.contains(medicament); 		  
	  }
	 
	 // méthode qui ajout un médicament un stock
	 public boolean addMedicamentStock(Medicament medicament){
		  if(!containsMedicament(medicament)){
			  this.stock.add(medicament);
			  return true;
		  }else{
			  return false;
		  }
	  }
	 
	 // méthode qui modifie quantité d'un médicament déjà existant
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
	 
	//méthode qui modifie la quantité d'un médicament déjà existant
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
	  
	  // méthode  qui supprime un médicament du stock
	  public boolean removeMedicamentStock(Medicament medicament){		  
		  for (Medicament medicaments : stock) {
			  if(medicaments.equals(medicament)){
				  this.stock.remove(medicaments);
				  return true;
			  }
		  }
		  return false;
	  }
	  
	  //méthode qui affiche le descriptif des médicaments du stock
	  public String print(){
		  String print=" INVENTAIRE DU STOCK" +"\n"+" ***********************"+"\n"+
				  "Nom (type) +quantite à ajouter au stock : prix"+"\n";
		  for (Medicament medicament : stock) {
			 print+=medicament.print()+"\n \n";
		  }
		  return print;
	  }
	  
	  //méthode qui sélectionne et retourne le médicaments est aussi possible
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
	  
	  
	  // méthode qui fait une mise à jour du stock après une vente
	  public void update(ListeAchats liste){
		  for(Medicament achat: liste.getAchats()){
			  this.removeMedicament(achat);
		  }
	  }

}// end class
