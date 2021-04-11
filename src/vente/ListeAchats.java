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
	
	// méthode qui vérifie si un médicament est dans la liste
	 public boolean containsMedicament(Medicament medicament){
		  return this.listeAchats.contains(medicament); 		  
	  }
	 
	 // méthode qui ajout un médicament à la liste
	 public boolean addMedicamentListe(Medicament medicament){
		  if(!containsMedicament(medicament)){
			  this.listeAchats.add(medicament);
			  this.prix += medicament.getPrix()*medicament.getQteAjout();
			  return true;
		  }else{
			  return false;
		  }
	  }
	 
	 // méthode qui modifie quantité d'un médicament déjà existant
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
	 
	//méthode qui modifie la quantité d'un médicament déjà existant
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
	  
	  // méthode  qui supprime un médicament de la liste
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
	  
	  //méthode qui affiche le descriptif des médicaments de la liste
	  public String print(){
		  String print="Liste des Achats" +"\n"+"\n"+" ***********************"+"\n"+
				  "Nom (type) +quantite à ajouter au stock : prix"+"\n";
		  for (Medicament medicament : listeAchats) {
			 print+=medicament.print()+"\n \n";
		  }
		  
		  print+=" ***********************"+"\n"+"Total: "+ this.prix;
		  return print;
	  }
	  
	  //méthode qui sélectionne et retourne le médicaments 
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
