package personne;

public abstract class RolePersonne {
	
	private Personne personne;
	
	public RolePersonne(){
	}
	
	public RolePersonne(Personne personne){
		this.personne=personne;
	}
	
	public Personne getPersonne(){
		return personne;
	}
	
	public String getNom(){
		return personne.getNom();
	}
	
	public String getPrenom(){
		return personne.getPrenom();
	}
	
	public boolean equals(Object obj){
		return this.equals(obj);
	}
	
	public String print(){
		return this.personne.print();
	}

}
