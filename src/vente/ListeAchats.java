package vente;

import java.util.ArrayList;

import exceptions.QteStockException;
import stock.Medicament;

public class ListeAchats {
	
	private ArrayList<Medicament> listeAchats= new ArrayList();
	private double prix;
	
	
	public ListeAchats(){
		this.prix=0;
	}
	
	public ListeAchats(ArrayList<Medicament> stock){
		this.listeAchats=stock;
		this.setPrix();
	}
	
	public ArrayList<Medicament> getAchats(){
		return listeAchats;
	}
	
	public double getPrix(){
		return this.prix;
	}
	
	public void setPrix(){
		  this.prix=0;
			for (Medicament medicament : listeAchats) {
				this.prix += medicament.getPrix();  
			}
	  }
	
	// m�thode qui v�rifie si un m�dicament est dans la liste
	 public boolean containsMedicament(Medicament medicament){
		  return this.listeAchats.contains(medicament); 		  
	  }
	 
	 // m�thode qui ajout un m�dicament � la liste
	 public boolean addMedicamentListe(Medicament medicament){
		  if(!containsMedicament(medicament)){
			  this.listeAchats.add(medicament);
			  this.prix += medicament.getPrix()*medicament.getQteAjout();
			  return true;
		  }else{
			  return false;
		  }
	  }
	 
	 // m�thode qui modifie quantit� d'un m�dicament d�j� existant
	 public void addMedicament(Medicament medicament){
		 if(containsMedicament(medicament)){
			 for (Medicament medicaments : listeAchats) {
				  if(medicaments.equals(medicament)){
					  medicaments.addQteAjout(medicament.getQteAjout());
					  this.prix += medicaments.getPrix()*medicament.getQteAjout();
				  }
			  }
		  }else{
			  addMedicamentListe(medicament); 
		  }
	 }
	 
	//m�thode qui modifie la quantit� d'un m�dicament d�j� existant
	  public boolean removeMedicament(Medicament medicament){		 
		  boolean flag=false;
		  for (Medicament medicaments : listeAchats) {
			  if(medicaments.equals(medicament)){
				  
				  try{
					  medicaments.remQteAjout(medicament.getQteAjout() ); 
					  this.prix -= medicaments.getPrix()*medicament.getQteAjout();
					  flag=true;
				  }catch(QteStockException e){
					  flag=false;  
				  }
				  
				  break;
			  }
		  }
		  return flag;
	  }
	  
	  // m�thode  qui supprime un m�dicament de la liste
	  public boolean removeMedicamentListe(Medicament medicament){		  
		  for (Medicament medicaments : listeAchats) {
			  if(medicaments.equals(medicament)){
				  this.listeAchats.remove(medicaments);
				  this.prix -= medicaments.getPrix()*medicaments.getQteAjout(); 
				  return true;
			  }
		  }
		  return false;
	  }
	  
	  //m�thode qui affiche le descriptif des m�dicaments de la liste
	  public String print(){
		  String print="Liste des Achats" +"\n"+"\n"+" ***********************"+"\n"+
				  "Nom (type) +quantite � ajouter au stock : prix"+"\n";
		  for (Medicament medicament : listeAchats) {
			 print+=medicament.print()+"\n \n";
		  }
		  
		  print+=" ***********************"+"\n"+"Total: "+ this.prix;
		  return print;
	  }
	  
	  //m�thode qui s�lectionne et retourne le m�dicaments 
	  public Medicament selectMedicament(Medicament medicament){
		  Medicament medic =new Medicament();
		  for (Medicament medicaments : listeAchats) {
			  if(medicaments.equals(medicament)){
				  medic=medicaments;
			  }
		  }
		  return medic;
	  }	  

}// end class
