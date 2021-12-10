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
import java.text.DecimalFormat;
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
import javax.swing.text.NumberFormatter;

import com.dao.DaoGsbFrais;
import com.modele.FicheFrais;
import com.principal.Main;

public class FenetreMajFicheFrais extends JFrame
{
	JLabel lIdEtat, lIdVisiteur, lMois, lMontantValide, lNbJustificatifs, lDateModif;
	JFormattedTextField fIdEtat, fIdVisiteur, fMois, fMontantValide, fNbJustificatifs, fDateModif;
	JButton bEnvoyer, bQuitter;
	DaoGsbFrais d = new DaoGsbFrais();
	FicheFrais fichefrais;

	public FenetreMajFicheFrais() throws ParseException
	{
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		JFrame f = new JFrame("MAJ des Fiche de Frais");
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.setSize(550, 450);
		f.setResizable(false);
		f.setLayout(new GridBagLayout());
		
		lDateModif 		= new JLabel("Date");
		lIdEtat 		= new JLabel("Id Etat");
		lIdVisiteur		= new JLabel("Id Visiteur");
		lMois			= new JLabel("Mois");
		lNbJustificatifs= new JLabel("Nb Justificatifs");
		lMontantValide	= new JLabel("Montant Valide");
		
		fDateModif		= new JFormattedTextField(new MaskFormatter("**/**/****"));
		fIdEtat 		= new JFormattedTextField(new MaskFormatter("**"));
		fIdVisiteur		= new JFormattedTextField(new MaskFormatter("****"));
		fMois			= new JFormattedTextField(new MaskFormatter("******"));
		fNbJustificatifs= new JFormattedTextField(new MaskFormatter("***********"));
		fMontantValide	= new JFormattedTextField(new MaskFormatter("************"));

		fDateModif.setColumns(9);
		fIdEtat.setColumns(9);
		fIdVisiteur.setColumns(9);
		fMois.setColumns(9);
		fNbJustificatifs.setColumns(9);
		fMontantValide.setColumns(9);

		bQuitter	= new JButton("Quitter");
		bEnvoyer	= new JButton("Envoyer");

		GridBagConstraints c = new GridBagConstraints();
		c.insets	= new Insets(8, 8, 8, 8);
		c.gridx=0;
		c.gridy=0;
		c.ipadx = 10;
		c.ipady = 10;
		f.add(lIdVisiteur, c);
		c.gridx = 1;
		c.gridy = 0;
		c.ipadx = 10;
		c.ipady = 10;
		f.add(fIdVisiteur, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.ipadx = 10;
		c.ipady = 10;
		f.add(lMois, c);
		c.gridx = 1;
		c.gridy = 1;
		c.ipadx = 10;
		c.ipady = 10;
		f.add(fMois, c);

		c.gridx = 0;
		c.gridy = 2;
		c.ipadx = 10;
		c.ipady = 10;
		f.add(lNbJustificatifs, c);
		c.gridx = 1;
		c.gridy = 2;
		c.ipadx = 10;
		c.ipady = 10;
		f.add(fNbJustificatifs, c);

		c.gridx = 0;
		c.gridy = 3;
		c.ipadx = 10;
		c.ipady = 10;
		f.add(lMontantValide, c);
		c.gridx = 1;
		c.gridy = 3;
		c.ipadx = 10;
		c.ipady = 10;
		f.add(fMontantValide, c);

		c.gridx	= 0;
		c.gridy	= 4;
		c.ipadx = 10;
		c.ipady = 10;
		f.add(lDateModif, c);
		c.gridx = 1;
		c.gridy = 4;
		c.ipadx = 10;
		c.ipady = 10;
		f.add(fDateModif, c);
		
		c.gridx	= 0;
		c.gridy	= 5;
		c.ipadx = 10;
		c.ipady = 10;
		f.add(lIdEtat, c);
		c.gridx = 1;
		c.gridy = 5;
		c.ipadx = 10;
		c.ipady = 10;
		f.add(fIdEtat, c);
		
		c.gridx = 0;
		c.gridy = 6;
		c.ipadx = 10;
		c.ipady = 10;

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
						try
						{
							String str1 = fNbJustificatifs.getText();
							String replace = str1.replaceAll(" ", "");
							int nbjustif = Integer.parseInt(replace);
							fichefrais = new FicheFrais(fIdVisiteur.getText().toString(),
														fMois.getText().toString(), 
														nbjustif,
														Double.parseDouble(fMontantValide.getText().toString()),
														df.parse(fDateModif.getText().toString()),
														fIdEtat.getText().toString());
						}
						catch (NumberFormatException a)
						{
							// TODO Auto-generated catch block
							a.printStackTrace();
						}
					}
					catch (ParseException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					d.InsertFicheFrais(fichefrais);
					Object[] row1 =	{
										fIdVisiteur.getText().toString(),
										fMois.getText().toString(),
										fNbJustificatifs.getText().toString(),
										fMontantValide.getText().toString(), 
										fDateModif.getText().toString(),
										fIdEtat.getText().toString()
									};
					FenetreTableauFicheFrais.setRow1(row1);
					FenetreTableauFicheFrais.getM().insertRow(FenetreTableauFicheFrais.getM().getRowCount(), row1);
					f.setVisible(false);
				}
				
				if (Main.getAction().equals("modify"))
				{
					try
					{
						String str1 = fNbJustificatifs.getText();
						String replace = str1.replaceAll(" ", "");
						int nbjustif = Integer.parseInt(replace);
						fichefrais = new FicheFrais(fIdVisiteur.getText().toString(),
													fMois.getText().toString(), 
													nbjustif,
													Double.parseDouble(fMontantValide.getText().toString()),
													df.parse(fDateModif.getText().toString()),
													fIdEtat.getText().toString());
					} 
					catch (ParseException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					d.updateFicheFrais(fichefrais);	
					try
					{
						Object[] row1 = {
											df.parse(fDateModif.getText().toString()),
											fIdEtat.getText().toString(),
											fIdVisiteur.getText().toString(),
											fMois.getText().toString(),
											fNbJustificatifs.getText().toString(),
											fMontantValide.getText().toString()
										};
						FenetreTableauFicheFrais.setRow1(row1);
						FenetreTableauFicheFrais.getM().setValueAt(fIdVisiteur.getText().toString(), FenetreTableauFicheFrais.getTable().getSelectedRow(), 0);
						FenetreTableauFicheFrais.getM().setValueAt(fMois.getText().toString(), FenetreTableauFicheFrais.getTable().getSelectedRow(), 1);
						FenetreTableauFicheFrais.getM().setValueAt(fNbJustificatifs.getText().toString(), FenetreTableauFicheFrais.getTable().getSelectedRow(), 2);
						FenetreTableauFicheFrais.getM().setValueAt(fMontantValide.getText().toString(), FenetreTableauFicheFrais.getTable().getSelectedRow(), 3);
						FenetreTableauFicheFrais.getM().setValueAt(fDateModif.getText().toString(), FenetreTableauFicheFrais.getTable().getSelectedRow(), 4);
						FenetreTableauFicheFrais.getM().setValueAt(fIdEtat.getText().toString(), FenetreTableauFicheFrais.getTable().getSelectedRow(), 5);
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
						String str1 = fNbJustificatifs.getText();
						String replace = str1.replaceAll(" ", "");
						int nbjustif = Integer.parseInt(replace);
						fichefrais = new FicheFrais(fIdVisiteur.getText().toString(),
													fMois.getText().toString(), 
													nbjustif,
													Double.parseDouble(fMontantValide.getText().toString()),
													df.parse(fDateModif.getText().toString()),
													fIdEtat.getText().toString());
					}
					catch (ParseException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					d.deleteFicheFrais(fichefrais);
					FenetreTableauFicheFrais.getM().removeRow(FenetreTableauFicheFrais.getTable().getSelectedRow());
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
		c.gridx = 1;
		c.gridy = 6;
		c.ipadx = 10;
		c.ipady = 10;
    	f.add(bEnvoyer,c);
    	//f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	f.setVisible(true);
    	JDialog dialog = new JDialog(f,Dialog.ModalityType.APPLICATION_MODAL);
    	dialog.pack();
    	f.setLocationRelativeTo(null);
	}
}