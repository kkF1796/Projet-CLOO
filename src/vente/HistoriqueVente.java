package vente;

import outils.*;
import stock.*;
import personne.*;
import java.util.*;

public class HistoriqueVente {
	
	private ArrayList<Vente> historique= new ArrayList();
	
	public HistoriqueVente(){
	}
	
	public HistoriqueVente(ArrayList<Vente> historique){
		this.historique=historique;
	}
	
	public ArrayList<Vente> getHistorique(){
		return historique;
	}
	
	public boolean containsVente(Vente vente){
		  return this.historique.contains(vente); 		  
	 }
	
	
	 public boolean addVente(Vente vente){
		  if(!containsVente(vente)){
			  this.historique.add(vente);
			  return true;
		  }else{
			  return false;
		  }
	  }
	
	
	 public boolean removeVente(Vente vente){		  
		  for (Vente ventes : historique) {
			  if(ventes.equals(vente)){
				  this.historique.remove(ventes);
				  return true;
			  }
		  }
		  return false;
	  }
	
	
	 public Vente selectVente(Vente vente){
		 Vente v = new Vente();
		  for (Vente ventes : historique) {
			  if(ventes.equals(vente)){
				  v=ventes;
			  }
		  }
		  return v;
	  }
	
	
	public String print(){
		String print="INVENTAIRE DES VENTES"+"\n"+" ***********************"+"\n";
		for(Vente vente:historique){
			print+=vente.print()+"\n \n";
		}
		return print;
	}
	
	
	
	/*** CALCUL DES RECETTES ***/
	
	//méthode qui renvoie la recette totale d'une journée
	public double getRecetteJT(DateVente date){
		double recette=0;
		for(Vente vente:historique){
			if(date.equals(vente.getDate())){
				recette+=vente.getPrix();
			}
		}
		return recette;
	}
	
	//méthode qui renvoie la recette par client d'une journée
	public double getRecetteJC(DateVente date, Client client){
		double recette=0;
		for(Vente vente:historique){
			if(date.equals(vente.getDate()) &&  client.equals(vente.getClient())){
				recette+=vente.getPrix();
			}
		}
		return recette;
	}
	
	// méthode qui renvoie la recette par vendeur d'une journée
	public double getRecetteJV(DateVente date, Vendeur vendeur){
		double recette=0;
		for(Vente vente:historique){
			if(date.equals(vente.getDate()) &&  vendeur.equals(vente.getVendeur())){
				recette+=vente.getPrix();
			}
		}
		return recette;
	}
	
	//méthode qui renvoie la recette par type de médicament d'une journée
	public double getRecetteJM(DateVente date, Medicament medic){
		double recette=0;
		for(Vente vente:historique){
			ListeAchats liste=vente.getListeAchats();
			if(date.equals(vente.getDate()) &&  liste.containsMedicament(medic)){
				Medicament med=liste.selectMedicament(medic);
				recette+=med.getPrix()*med.getQteAjout();
			}
		}
		return recette;
	}
	
	
	//méthode qui renvoie la recette totale d'une semaine
	public double getRecetteST(DateVente date1, DateVente date2){
		double recette=0;
		for(Vente vente:historique){
			if((vente.getDate()).dansIntervalle(date1,date2)){
				recette+=vente.getPrix();
			}
		}
		return recette;
	}
	
				
	//méthode qui renvoie la recette par client d'une semaine
	public double getRecetteSC(DateVente date1, DateVente date2,Client client){
		double recette=0;
		for(Vente vente:historique){
			if((vente.getDate()).dansIntervalle(date1,date2) && client.equals(vente.getClient())){
				recette+=vente.getPrix();
			}
		}
		return recette;
	}
				
	//méthode qui renvoie la recette par vendeur d'une semaine
	public double getRecetteSV(DateVente date1, DateVente date2,Vendeur vendeur){
		double recette=0;
		for(Vente vente:historique){
			if((vente.getDate()).dansIntervalle(date1,date2) && vendeur.equals(vente.getVendeur())){
				recette+=vente.getPrix();
			}
		}
		return recette;
	}
				
	//méthode qui renvoie la recette par type de médicament d'une semaine
	public double getRecetteSM(DateVente date1,DateVente date2, Medicament medic){
		double recette=0;
		for(Vente vente:historique){
			ListeAchats liste=vente.getListeAchats();
			if((vente.getDate()).dansIntervalle(date1,date2) &&  liste.containsMedicament(medic)){
				Medicament med=liste.selectMedicament(medic);
				recette+=med.getPrix()*med.getQteAjout();
			}
		}
		return recette;
	}
	
	
	//méthode qui renvoie la recette totale d'un mois
	public double getRecetteMT(String mois, int annee){
		double recette=0;
		for(Vente vente:historique){
			String moisV=(vente.getDate()).getMoisToString();
			int anneeV=(vente.getDate()).getAnnee();
			if(mois.equals(moisV)  &&  annee==anneeV){
				recette+=vente.getPrix();
			}
		}
		return recette;
	}
		
	//méthode qui renvoie la recette par client d'un mois
	public double getRecetteMC(String mois, int annee,Client client){
		double recette=0;
		for(Vente vente:historique){
			String moisV=(vente.getDate()).getMoisToString();
			int anneeV=(vente.getDate()).getAnnee();
			if(mois.equals(moisV)  &&  annee==anneeV  && client.equals(vente.getClient())){
				recette+=vente.getPrix();
			}
		}
		return recette;
	}
		
	//méthode qui renvoie la recette par vendeur d'un mois
	public double getRecetteMV(String mois, int annee,Vendeur vendeur){
		double recette=0;
		for(Vente vente:historique){
			String moisV=(vente.getDate()).getMoisToString();
			int anneeV=(vente.getDate()).getAnnee();
			if(mois.equals(moisV)  &&  annee==anneeV  && vendeur.equals(vente.getVendeur())){
				recette+=vente.getPrix();
			}
		}
		return recette;
	}
		
	//méthode qui renvoie la recette par type de médicament d'un mois
	public double getRecetteMM(String mois, int annee, Medicament medic){
		double recette=0;
		for(Vente vente:historique){
			String moisV=(vente.getDate()).getMoisToString();
			int anneeV=(vente.getDate()).getAnnee();
			
			ListeAchats liste=vente.getListeAchats();
			
			if(mois.equals(moisV)  &&  annee==anneeV &&  liste.containsMedicament(medic)){
				Medicament med=liste.selectMedicament(medic);
				recette+=med.getPrix()*med.getQteAjout();
			}
		}
		return recette;
	}
	

}// end class
