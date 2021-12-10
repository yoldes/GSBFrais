package com.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import com.view.*;

public class MenuPrincipal {
public MenuPrincipal() {
	JFrame frame=new JFrame("Gestion des frais");
	frame.setLayout(new GridLayout(1,1));
	JLabel libelle=new JLabel("APPLICATION DE GESTION DES FRAIS ");
	libelle.setHorizontalAlignment(JLabel.CENTER);
	Font font = new Font("Arial",Font.BOLD,40);
	libelle.setFont(font);
	frame.add(libelle);
	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	JMenuBar menuBar=new JMenuBar();
	JMenu tableMenu=new JMenu("table");
	JMenu ListeMenu=new JMenu("liste");
	menuBar.add(tableMenu);
	menuBar.add(ListeMenu);
	JMenuItem etatMenu=new JMenuItem("etat");
	tableMenu.add(etatMenu);
	JMenuItem visiteurMenu=new JMenuItem("visiteur");
	tableMenu.add(visiteurMenu);
	JMenuItem fraisMenu=new JMenuItem("frais");
	tableMenu.add(fraisMenu);
	JMenuItem ficheMenu=new JMenuItem("fiche");
	tableMenu.add(ficheMenu);
	JMenuItem quitMenu=new JMenuItem("quitter");
	tableMenu.add(quitMenu);
	frame.setJMenuBar(menuBar);
	frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
	frame.setVisible(true);
	ActionListener listener=new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (arg0.getSource()==etatMenu) {
	
				Runnable r= new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						  FenetreTableauEtat f=new FenetreTableauEtat();	
					}
					  
				  };
				  EventQueue.invokeLater(r);
			}
			if (arg0.getSource()==fraisMenu) {
				
				Runnable r= new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						FenetreTableauFraisForfait f=new FenetreTableauFraisForfait();	
					}
					  
				  };
				  EventQueue.invokeLater(r);
			} 
			
			if (arg0.getSource()==visiteurMenu) {
				
				Runnable r= new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						FenetreTableauVisiteur f=new FenetreTableauVisiteur();	
					}
					  
				  };
				  EventQueue.invokeLater(r);
			} 

			if (arg0.getSource()==ficheMenu) {
				
				Runnable r= new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						FenetreTableauFicheFrais f=new FenetreTableauFicheFrais();	
					}
					  
				  };
				  EventQueue.invokeLater(r);
			} 

			if (arg0.getSource()==quitMenu) {
		    frame.dispose();	  
		      }
			
		}
		
		
	};
	etatMenu.addActionListener(listener);
	fraisMenu.addActionListener(listener);
	visiteurMenu.addActionListener(listener);
	ficheMenu.addActionListener(listener);
	quitMenu.addActionListener(listener);
	
}
      
}
