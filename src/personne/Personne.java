package personne;

import stock.Medicament;

public class Personne {
	
	private String nom;
	private String prenom;
	
	public Personne(){
	}
	
	public Personne(String nom, String prenom){
		this.nom=nom;
		this.prenom=prenom;
	}
	
	public String getNom(){
		return nom;
	}
	
	public String getPrenom(){
		return prenom;
	}
	
	public boolean equals(Object obj){
		boolean flag=false;
		if(obj instanceof Personne) {
			flag= ((this.nom).equals(((Personne) obj).nom))
				&& ((this.prenom).equals(((Personne) obj).prenom));
		}
		return flag;
	}

	
	public String print(){
		return (prenom +" "+nom+" ");
	}
}// end class
