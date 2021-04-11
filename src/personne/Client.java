package personne;

public class Client extends RolePersonne{
	
	//private Personne personne;
	private int numSec;
	
	public Client(){
	}
	
	public Client(Personne personne, int numSec){
		super(personne);
		this.numSec=numSec;
	}
	
	public int getNumSec(){
		return numSec;
	}
	
	public boolean equals(Object obj){
		boolean flag=false;
		if(obj instanceof Client) {
			flag= ((this.getPersonne()).equals(((Client) obj).getPersonne()))
				&& (this.numSec ==((Client) obj).numSec);
		}
		return flag;
	}
	
	public String print(){
		//System.out.println(personne.print());
		return (super.print()+" ( "+ Integer.toString(numSec)+" ) ");
	}
}
