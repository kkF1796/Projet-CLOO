/*** 
 * 
 * 	Cette classe permet de g�rer des Exceptions sur la quantit� en stock, 
 * notamment le fait qu'il ne peut pas y avoir de quantit� n�gative.
 * 
 * ***/

package exceptions;


public class QteStockException extends Exception{
	
	// m�thode permettant de g�rer un exception sur la quantit� en stock
	public QteStockException(){
		System.err.println(" ");
		System.err.println(" Il n'y a pas assez de m�dicaments � retirer.");
	}

}
