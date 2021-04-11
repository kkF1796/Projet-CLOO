package personne;

public class Vendeur extends RolePersonne{
	
	//private Personne personne;
	
	public Vendeur(){
	}
	
	public Vendeur(Personne personne){
		super(personne);
	}
	
	public boolean equals(Object obj){
		boolean flag=false;
		if(obj instanceof Vendeur) {
			flag= ((this.getPersonne()).equals(((Vendeur) obj).getPersonne()));
		}
		return flag;
	}
	
	public String print(){
		return super.print();
	}
	

}// end class
