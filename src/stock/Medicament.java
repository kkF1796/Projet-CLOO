package stock;

import exceptions.QteStockException;

public class Medicament {
	
	private String nom;
	private double prix;
	private String type;
	private int qteAjout; // est interprétée comme étant la quantité en stock
	
	public Medicament(){
	}
	
	public Medicament(String nom, double prix, String type, int qteAjout){
		this.nom=nom;
		this.prix=prix;
		this.type=type;
		this.qteAjout=qteAjout;
	}
	
	public Medicament(String nom, double prix,String type){
		this.nom=nom;
		this.prix=prix;
		this.type=type;
		this.qteAjout=0;
	}
	
	public Medicament(String nom, String type,int qteAjout){
		this.nom=nom;
		this.prix=0.0;
		this.type=type;
		this.qteAjout=qteAjout;
	}
	
	public String getNom(){
		return nom;
	}
	
	public double getPrix(){
		return prix;
	}
	
	public void setPrix(double prix){
		this.prix=prix;
	}
	
	public String getType(){
		return type;
	}
	
	public int getQteAjout(){
		return qteAjout;
	}
	
	// ajouter Exception try /catch pour quantité limitée en stock
	public void remQteAjout(int ajout) throws QteStockException{
		//this.qteAjout -= ajout; 
		int qteAjout =this.qteAjout - ajout;
		if(qteAjout < 0){
			//qteAjout=0;
			throw new QteStockException();
		}else{
			this.qteAjout=qteAjout;
		}
	}
	
	public void addQteAjout(int ajout){
		this.qteAjout += ajout ; 
	}
	
	public boolean equals(Object obj){
		boolean flag=false;
		if(obj instanceof Medicament) {
			flag= ((this.nom).equals(((Medicament) obj).nom));
				//&& ((this.type).equals(((Medicament) obj).type));
		}
		return flag;
	}
	
	
	// Ou version qui retourne un String pour ensuite être affichée
	public String print(){
		return (this.nom+" ("+this.type+") +"+Integer.toString(qteAjout)+" : "+Double.toString(prix)+" -." + " ");
	}

}//end class
