package vente;

import java.util.*;
import stock.*;
import outils.*;

public class Facture {
	
	private double prix;
	private DateVente date;
	
	public Facture(){
	}
	
	public Facture(ListeAchats achats, DateVente date){
		this.prix=achats.getPrix();		
		this.date=date;
	}
	
	public Facture(double prix, DateVente date){
		this.prix=prix;
		this.date=date;
	}
	
	public double getPrix(){
		return prix;
	}
	
	public DateVente getDate(){
		return date;
	}
	
	public String print(){
		return ("Total: "+ Double.toString(prix)+" \n"+"date: "+Integer.toString(date.getJour())+"/"+Integer.toString(date.getMois())+"/"+
				Integer.toString(date.getAnnee())+"\n");
	}
	
	public boolean equals(Object obj){
		boolean flag=false;
		if(obj instanceof Facture) {
			flag= ((this.date).equals(((Facture) obj).date))
					&& (this.prix == ((Facture) obj).prix ); 
		}
		return flag;
	}

}
