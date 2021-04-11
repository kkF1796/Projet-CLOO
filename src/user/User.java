package user;

import java.io.BufferedWriter;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.JFrame;

import stock.*;
import personne.*;
import vente.*;
import outils.*;
import interfaceGraphique.*;

public class User {

	public static void main(String[] args) throws IOException {

		
		Gestionnaire gestionnaire= new Gestionnaire();
		
		Fenetre fen1 =new Fenetre(gestionnaire);
		
	
	}// end main

}// end class
