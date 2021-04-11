package outils;

import vente.Facture;

public class DateVente {
	
	private int jour;
	private int mois;
	private int annee;
	
	public DateVente(){
	}
	
	public DateVente(int jour, int mois, int annee){
		this.jour=jour;
		this.mois=mois;
		this.annee=annee;
	}
	
	public DateVente(int jour, String mois, int annee){
		this.jour=jour;
		this.mois=convertMoisToInt(mois);
		this.annee=annee;
	}
	
	public int getJour(){
		return jour;
	}
	
	public int getMois(){
		return mois;
	}
	
	public String getMoisToString(){
		return this.convertMoisToString(mois);
	}
	
	public int getAnnee(){
		return annee;
	}
	
	public String convertMoisToString(int mois){
		String month="";
		switch(mois){
			case 1:
				month="Janvier";
				break;
			case 2:
				month="Fevrier";
				break;
			case 3:
				month="Mars";
				break;
			case 4:
				month="Avril";
				break;
			case 5:
				month="Mai";
				break;
			case 6:
				month="Juin";
				break;
			case 7:
				month="Juillet";
				break;
			case 8:
				month="Août";
				break;
			case 9:
				month="Septembre";
				break;
			case 10:
				month="Octobre";
				break;
			case 11:
				month="Novembre";
				break;
			case 12:
				month="Décembre";
				break;			
		}
		return month;
	}
	
	public int convertMoisToInt(String mois){
		int month=0;
		switch(mois){
			case "Janvier":
				month=1;
				break;
			case "Fevrier":
				month=2;
				break;
			case "Mars":
				month=3;
				break;
			case "Avril":
				month=4;
				break;
			case "Mai":
				month=5;
				break;
			case "Juin":
				month=6;
				break;
			case "Juillet":
				month=7;
				break;
			case "Août":
				month=8;
				break;
			case "Septembre":
				month=9;
				break;
			case "Octobre":
				month=10;
				break;
			case "Novembre":
				month=11;
				break;
			case "Décembre":
				month=12;
				break;			
		}
		return month;
	}
	
	public boolean equals(Object obj){
		boolean flag=false;
		if(obj instanceof DateVente) {
			flag= (this.jour == ((DateVente) obj).jour )
					&& (this.mois == ((DateVente) obj).mois )
					&& (this.annee == ((DateVente) obj).annee ); 
		}
		return flag;
	}

	
	public String print(){
		//return (jour+"/"+this.convertMoisToString(mois)+"/"+annee+" ");
		return (jour+"/"+mois+"/"+annee+" ");
	}
	
	public boolean dateSup(DateVente date1){ // date1 < date
		boolean flag=false;
		
		if(date1.getAnnee()< this.annee){
			flag=true;
		}else if(date1.getAnnee()> this.annee ){
			flag=false;
		}else{
				if(date1.getMois()< this.mois){
					flag=true;
				}else if(date1.getMois()> this.mois){
					flag=false;
				}else{
					if(date1.getJour()< this.jour){
						flag=true;
					}else if(date1.getJour()> this.jour){
						flag=false;
					}else{
						flag=true;
					}
				}
			}
		return flag;
		}
	
	
	
	public boolean dansIntervalle(DateVente date1, DateVente date2){
		return this.dateSup(date1) && date2.dateSup(this);
	}

}// end class
