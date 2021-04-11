package vente;

import personne.*;
import stock.*;
import outils.*;
import java.util.*;

public class Vente {
	
	private Client client;
	private Vendeur vendeur;
	private ListeAchats achats;
	private Facture facture ;
	
	public Vente(){
	}
	
	public Vente(Client client, Vendeur vendeur, ListeAchats achats, DateVente date){
		this.client=client;
		this.vendeur=vendeur;
		this.achats=achats; 
		this.facture=new Facture(achats,date);
	}
	
	public Vente(Client client, Vendeur vendeur, Facture facture){
		this.client=client;
		this.vendeur=vendeur;
		this.facture=facture;
	}
	
	public Client getClient(){
		return client;
	}
	
	public Vendeur getVendeur(){
		return vendeur;
	}
	
	public ArrayList<Medicament> getAchats(){
		return achats.getAchats();
	}
	
	public ListeAchats getListeAchats(){
		return achats;
	}
	
	public double getPrix(){
		return facture.getPrix();
	}
	
	public Facture getFacture(){
		return facture;
	}
	
	public DateVente getDate(){
		return (this.getFacture()).getDate();
	}
	
	public boolean equals(Object obj){
		boolean flag=false;
		if(obj instanceof Vente) {
			flag= ((this.client).equals(((Vente) obj).client))
				&& ((this.vendeur).equals(((Vente) obj).vendeur))
				&& ((this.facture).equals(((Vente) obj).facture));
		}
		return flag;
	}

	
	public String print(){
		String print="VENDEUR: "+vendeur.print()+"\n"+"CLIENT: "+client.print()+"\n"+"********************"
				+"\n"+"ACHATS: "+"\n";
		for(Medicament medicament: achats.getAchats()){
			//print+=medicament.getNom()+" "+medicament.getPrix()+" "+"\n";
			print+=medicament.print()+" "+"\n";
		}
		print+="********************"/*+"\n"+"FACTURE: "*/+"\n"+facture.print()+" ";
		return print+"\n";
	}
}// end class
