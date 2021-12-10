package com.view;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.dao.DaoGsbFrais;
import com.modele.Visiteur;
import com.principal.Main;
import com.principal.Main;

public class FenetreMajVisiteur extends JFrame 
{
	JLabel lId,lNom,lPrenom,lLogin,lMdp,lAdresse,lCp,lVille,lDateEmbauche;
	JFormattedTextField fId,fNom,fPrenom,fLogin,fMdp,fAdresse,fCp,fVille,fDateEmbauche;
	JButton bEnvoyer, bQuitter;
	DaoGsbFrais d = new DaoGsbFrais();
	Visiteur visiteur;

	public FenetreMajVisiteur() throws ParseException
	{
		JFrame f = new JFrame("MAJ des Visiteurs");
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		lId		= new JLabel("Id");
		lNom	= new JLabel("Nom");
		lPrenom	= new JLabel("Prenom");
		lLogin	= new JLabel("Login");
		lMdp	= new JLabel("Mdp");
		lAdresse= new JLabel("Adresse");
		lCp		= new JLabel("Cp");
		lVille	= new JLabel("Ville");
		lDateEmbauche = new JLabel("Date Embauche");
		
		fId		= new JFormattedTextField(new MaskFormatter("****"));
		fNom	= new JFormattedTextField(new MaskFormatter("*************************"));
		fPrenom	= new JFormattedTextField(new MaskFormatter("*************************"));
		fLogin	= new JFormattedTextField(new MaskFormatter("*************************"));
		fMdp	= new JFormattedTextField(new MaskFormatter("*************************"));
		fAdresse= new JFormattedTextField(new MaskFormatter("*************************"));
		fCp		= new JFormattedTextField(new MaskFormatter("*****"));
		fVille	= new JFormattedTextField(new MaskFormatter("*************************"));
		fDateEmbauche = new JFormattedTextField(new MaskFormatter("**/**/****"));
		
		fId.setColumns(4);
		fNom.setColumns(18);
		fPrenom.setColumns(18);
		fLogin.setColumns(18);
		fMdp.setColumns(18);
		fAdresse.setColumns(18);
		fCp.setColumns(4);
		fVille.setColumns(18);
		fMdp.setColumns(18);
		bQuitter	= new JButton("quitter");
		bEnvoyer	= new JButton("Envoyer");
		f.setSize(500,600);
		f.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		
		c.insets=new Insets(8,8,8,8);
		c.gridx=0;
		c.gridy=0;
		c.ipadx=10;
		c.ipady=10;
		f.add(lId,c);
		c.gridx=1;
		c.gridy=0;
		c.ipadx=10;
		c.ipady=10;
		f.add(fId, c);

		c.gridx=0;
		c.gridy=1;
		c.ipadx=10;
		c.ipady=10;
		f.add(lNom, c);
		c.gridx=1;
		c.gridy=1;
		c.ipadx=10;
		c.ipady=10;
		f.add(fNom, c);

		c.gridx=0;
		c.gridy=2;
		c.ipadx=10;
		c.ipady=10;
		f.add(lPrenom, c);
		c.gridx=1;
		c.gridy=2;
		c.ipadx=10;
		c.ipady=10;
		f.add(fPrenom, c);

		c.gridx=0;
		c.gridy=3;
		c.ipadx=10;
		c.ipady=10;
		f.add(lLogin, c);
		c.gridx=1;
		c.gridy=3;
		c.ipadx=10;
		c.ipady=10;
		f.add(fLogin, c);

		c.gridx=0;
		c.gridy=4;
		c.ipadx=10;
		c.ipady=10;
		f.add(lMdp, c);
		c.gridx=1;
		c.gridy=4;
		c.ipadx=10;
		c.ipady=10;
		f.add(fMdp, c);

		c.gridx=0;
		c.gridy=5;
		c.ipadx=10;
		c.ipady=10;
		f.add(lAdresse, c);
		c.gridx=1;
		c.gridy=5;
		c.ipadx=10;
		c.ipady=10;
		f.add(fAdresse, c);

		c.gridx=0;
		c.gridy=6;
		c.ipadx=10;
		c.ipady=10;
		f.add(lCp, c);
		c.gridx=1;
		c.gridy=6;
		c.ipadx=10;
		c.ipady=10;
		f.add(fCp, c);

		c.gridx=0;
		c.gridy=7;
		c.ipadx=10;
		c.ipady=10;
		f.add(lVille, c);
		c.gridx=1;
		c.gridy=7;
		c.ipadx=10;
		c.ipady=10;
		f.add(fVille, c);

		c.gridx=0;
		c.gridy=8;
		c.ipadx=10;
		c.ipady=10;
		f.add(lDateEmbauche, c);
		c.gridx=1;
		c.gridy=8;
		c.ipadx=10;
		c.ipady=10;
		f.add(fDateEmbauche, c);

		c.gridx=1;
		c.gridy=10;
		c.ipadx=10;
		c.ipady=10;
		f.setResizable(false);
		

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		ActionListener create = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				if (Main.getAction().equals("create"))
				{
					try
					{
						visiteur = new Visiteur(fId.getText().toString(), fNom.getText().toString(),
								fPrenom.getText().toString(), fLogin.getText().toString(), fMdp.getText().toString(),
								fAdresse.getText().toString(), fCp.getText().toString(),fVille.getText().toString(),
								df.parse(fDateEmbauche.getText().toString()));
					} 
					catch (ParseException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					d.InsertVisiteur(visiteur);
					
						Object[] row1 = {
											fId.getText().toString(),fNom.getText().toString(),fPrenom.getText().toString(),
											fLogin.getText().toString(),fMdp.getText().toString(),fAdresse.getText().toString(),
											fCp.getText().toString(),fVille.getText().toString(),
											fDateEmbauche.getText().toString()
										};
						FenetreTableauVisiteur.setRow1(row1);
						FenetreTableauVisiteur.getM().insertRow(FenetreTableauVisiteur.getM().getRowCount(), row1);
						f.setVisible(false);			
					
				}
				if (Main.getAction().equals("modify"))
				{
					try
					{
						visiteur=new Visiteur(fId.getText().toString(),fNom.getText().toString(),fPrenom.getText().toString(),
						fLogin.getText().toString(),fMdp.getText().toString(),fAdresse.getText().toString(),
						fCp.getText().toString(),fVille.getText().toString(),df.parse(fDateEmbauche.getText().toString()));
					}
					catch (ParseException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					d.updateVisiteur(visiteur);
					try
					{
						Object[] row1= {fId.getText().toString(),fNom.getText().toString(),fPrenom.getText().toString(),
						fLogin.getText().toString(),fMdp.getText().toString(),fAdresse.getText().toString(),
						fCp.getText().toString(),fVille.getText().toString(),df.parse(fDateEmbauche.getText().toString())};
						FenetreTableauVisiteur.setRow1(row1);
						FenetreTableauVisiteur.getM().setValueAt(fId.getText().toString(), FenetreTableauVisiteur.getTable().getSelectedRow(), 0);
						FenetreTableauVisiteur.getM().setValueAt(fNom.getText().toString(), FenetreTableauVisiteur.getTable().getSelectedRow(), 1);
						FenetreTableauVisiteur.getM().setValueAt(fPrenom.getText().toString(), FenetreTableauVisiteur.getTable().getSelectedRow(), 2);
						FenetreTableauVisiteur.getM().setValueAt(fLogin.getText().toString(), FenetreTableauVisiteur.getTable().getSelectedRow(), 3);
						FenetreTableauVisiteur.getM().setValueAt(fMdp.getText().toString(), FenetreTableauVisiteur.getTable().getSelectedRow(), 4);
						FenetreTableauVisiteur.getM().setValueAt(fAdresse.getText().toString(), FenetreTableauVisiteur.getTable().getSelectedRow(), 5);
						FenetreTableauVisiteur.getM().setValueAt(fCp.getText().toString(), FenetreTableauVisiteur.getTable().getSelectedRow(), 6);
						FenetreTableauVisiteur.getM().setValueAt(fVille.getText().toString(), FenetreTableauVisiteur.getTable().getSelectedRow(), 7);
						FenetreTableauVisiteur.getM().setValueAt(fDateEmbauche.getText().toString(), FenetreTableauVisiteur.getTable().getSelectedRow(), 8);
						f.setVisible(false);
					}
					catch (ParseException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				if (Main.getAction().equals("delete"))
				{
					try
					{
						visiteur=new Visiteur(fId.getText().toString(),fNom.getText().toString(),fPrenom.getText().toString(),
						fLogin.getText().toString(),fMdp.getText().toString(),fAdresse.getText().toString(),
						fCp.getText().toString(),fVille.getText().toString(),df.parse(fDateEmbauche.getText().toString()));
					}
					catch (ParseException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					d.deleteVisiteur(visiteur);
					FenetreTableauVisiteur.getM().removeRow(FenetreTableauVisiteur.getTable().getSelectedRow());
					f.setVisible(false);
				}
			}
		};
		ActionListener quit = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				f.dispose();
			}
		};
		bQuitter.addActionListener(quit);
		bEnvoyer.addActionListener(create);
		f.add(bQuitter, c);
		c.gridx=0;
		c.gridy=10;
		c.ipadx=10;
		c.ipady=10;
		f.add(bEnvoyer,c);
    	f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	f.setVisible(true);
    	JDialog dialog=new JDialog(f,Dialog.ModalityType.APPLICATION_MODAL);
    	dialog.pack();
    	f.setLocationRelativeTo(null);
	}
}
