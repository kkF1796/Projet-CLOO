/*** 
 * 
 * 	Cette classe permet de gérer des Exceptions sur la quantité en stock, 
 * notamment le fait qu'il ne peut pas y avoir de quantité négative.
 * 
 * ***/

package exceptions;


public class QteStockException extends Exception{
	
	// méthode permettant de gérer un exception sur la quantité en stock
	public QteStockException(){
		System.err.println(" ");
		System.err.println(" Il n'y a pas assez de médicaments à retirer.");
	}

}
