package com.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.DaoGsbFrais;
import com.modele.FicheFrais;
import com.principal.Main;

public class FenetreTableauFicheFrais
{
	FenetreMajFicheFrais f1;
	DaoGsbFrais d 			= new DaoGsbFrais();
	static String[] title 	= 
		{
				"idVisiteur",
				"mois",
				"nbJustificatifs",
				"montantValide",
				"DateModif",
				"idEtat"
		};
	static DefaultTableModel m	= new DefaultTableModel(null,title);
	static Object[] row1;
	static JTable table;
	JLabel libelle = new JLabel("Saisie des Fiche de Frais");
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public FenetreTableauFicheFrais()
	{
		JFrame frame	= new JFrame("Mise a jour des Fiche de Frais");
		JPanel panel	= new JPanel(new GridLayout(4, 4));
		Font font 		= new Font("Arial", Font.BOLD, 20);
		libelle.setFont(font);
		JButton create, modify, delete, quitter;
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		create	= new JButton("creation");
		modify	= new JButton("modify");
		delete	= new JButton("delete");
		quitter	= new JButton("quitter");
		modify.setEnabled(false);
		delete.setEnabled(false);
		panel.add(create);
		panel.add(modify);
		panel.add(delete);
		panel.add(quitter);
		
		table = new JTable(m)
		{
			@Override
			public boolean isCellEditable (int row, int column)
			{
				return false;
			}
		};

		JScrollPane pn 			= new JScrollPane(table);	
		GridBagConstraints c	= new GridBagConstraints();
		c.insets	= new Insets(3, 3, 3, 3);
		c.gridx		= 1;
		c.gridy		= 0;
		frame.add(libelle, c);
		c.fill	= GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy	= 1;
		c.gridwidth = 2;
		frame.add(pn, c);
		c.anchor= GridBagConstraints.FIRST_LINE_START;
		c.gridx	= 2;
		c.gridy	= 1;
		c.gridwidth	= 1;
		frame.add(panel, c);
		
		ActionListener a = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				if (arg0.getSource() == create)
				{
					EventQueue.invokeLater(new Runnable()
					{
						@Override
						public void run()
						{				
							Main.setAction("create");
							try
							{
								f1 = new FenetreMajFicheFrais();
							}
							catch (ParseException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
				}

				if (arg0.getSource() == modify)
				{
					EventQueue.invokeLater(new Runnable()
					{
						@Override
						public void run()
						{
							Main.setAction("modify");
							String vIdVisiteur		= (m.getValueAt(table.getSelectedRow(),0)).toString();
							String vMois			= (m.getValueAt(table.getSelectedRow(),1)).toString();
							String vNbJustificatifs	= (m.getValueAt(table.getSelectedRow(),2)).toString();
							String vMontantValide	= (m.getValueAt(table.getSelectedRow(),3)).toString();
							String vDateModif		= (m.getValueAt(table.getSelectedRow(),4)).toString();
							String vIdEtat			= (m.getValueAt(table.getSelectedRow(),5)).toString();
							try
							{
								f1 = new FenetreMajFicheFrais();
							}
							catch (ParseException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							f1.fIdEtat.setText(vIdEtat);
							f1.fIdVisiteur.setText(vIdVisiteur);
							f1.fMois.setText(vMois);
							f1.fMontantValide.setText(vMontantValide);
							f1.fNbJustificatifs.setText(vNbJustificatifs);
							f1.fDateModif.setText(vDateModif);
							modify.setEnabled(false);	
						}
					});
				}
				
				if (arg0.getSource() == delete)
				{
					EventQueue.invokeLater(new Runnable()
					{
						@Override
						public void run()
						{
							Main.setAction("delete");
							String vIdVisiteur		= (m.getValueAt(table.getSelectedRow(),0)).toString();
							String vMois			= (m.getValueAt(table.getSelectedRow(),1)).toString();
							String vNbJustificatifs	= (m.getValueAt(table.getSelectedRow(),2)).toString();
							String vMontantValide	= (m.getValueAt(table.getSelectedRow(),3)).toString();
							String vDateModif		= (m.getValueAt(table.getSelectedRow(),4)).toString();
							String vIdEtat			= (m.getValueAt(table.getSelectedRow(),5)).toString();
							try
							{
								f1 = new FenetreMajFicheFrais();
							}
							catch (ParseException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							f1.fIdEtat.setText(vIdEtat);
							f1.fIdVisiteur.setText(vIdVisiteur);
							f1.fMois.setText(vMois);
							f1.fMontantValide.setText(vMontantValide);
							f1.fNbJustificatifs.setText(vNbJustificatifs);
							f1.fDateModif.setText(vDateModif);
							delete.setEnabled(false);
						}
					});
				}

				if (arg0.getSource() == quitter)
				{
					frame.dispose();
				}
			}
		};
	
		MouseListener ml = new MouseListener() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				modify.setEnabled(true);
				delete.setEnabled(true);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub		
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		};
		
		create.addActionListener(a);
		modify.addActionListener(a);
		delete.addActionListener(a);
		quitter.addActionListener(a);
		table.addMouseListener(ml);
		initTableau();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);			 
	}

	public void initTableau()
	{
		ArrayList<FicheFrais> listeFicheFrais = d.selectAllFicheFrais();
		for (FicheFrais e1:listeFicheFrais)
		{
			Object[] row1 = {
								e1.getIdVisiteur(),
								e1.getMois(),
								e1.getNbJustificatifs(),
								e1.getMontantValide(),
								df.format(e1.getDateModif()),
								e1.getIdEtat()
							};
			FenetreTableauFicheFrais.setRow1(row1);
			FenetreTableauFicheFrais.getM().insertRow(FenetreTableauFicheFrais.getM().getRowCount(), row1);
		}
	}

	public FenetreMajFicheFrais getF1() {
		return f1;
	}

	public void setF1(FenetreMajFicheFrais f1) {
		this.f1 = f1;
	}

	public static DefaultTableModel getM() {
		return m;
	}

	public static void setM(DefaultTableModel m) {
		FenetreTableauFicheFrais.m = m;
	}

	public static Object[] getRow1() {
		return row1;
	}

	public static void setRow1(Object[] row1) {
		FenetreTableauFicheFrais.row1 = row1;
	}

	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable table) {
		FenetreTableauFicheFrais.table = table;
	}
}