package user;

import interfaceGraphique.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import gestionnaires.PanGestionStock;
import gestionnaires.PanHistoVentes;

public class Fenetre extends JFrame{

	private JTabbedPane onglet;
	
	public Fenetre(Gestionnaire gestionnaire){
		this.setLocationRelativeTo(null);
		this.setTitle("Gestion de Pharmacie");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,400);
		
		int toucheRaccourci=java.awt.Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
		
		JMenuItem menuQuitter= new JMenuItem("Quitter",'Q');
		menuQuitter.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					if(JOptionPane.showConfirmDialog(null, "Voulez-vous quitter ?",
							"Quitter", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
						System.exit(0);						
					}
				}
			});
		
		JMenuBar barreMenu= new JMenuBar();
		this.setJMenuBar(barreMenu);
		JMenu menuFichier= new JMenu("Fichier");
		barreMenu.add(menuFichier);
		menuFichier.add(menuQuitter);
		

		onglet = new JTabbedPane();
		
		
		onglet.add("Stock", new PanGestionStock(gestionnaire));
		onglet.add("Ventes", new PanHistoVentes(gestionnaire));
		onglet.add("Recettes", new PanRecette(gestionnaire));
		
		
		this.getContentPane().add(onglet);
		this.setVisible(true);
	}
}
