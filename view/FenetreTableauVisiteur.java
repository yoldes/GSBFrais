package com.view;
import java.awt.Dialog;
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
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.DaoGsbFrais;
import com.modele.Visiteur;
import com.principal.Main;
public class FenetreTableauVisiteur extends JFrame {
 FenetreMajVisiteur f1;
 static String[] title={"Id", "Nom", "Prenom", "Login", "Mdp", "Adresse", "CP", "Ville", "Date Embauche"};
 static DefaultTableModel m=new DefaultTableModel(null,title);
 DaoGsbFrais d=new DaoGsbFrais();
 static Object[] row1;
 static JTable table;
 JLabel libelle=new JLabel("Saisie des visiteurs");
 SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
public FenetreTableauVisiteur() {
	JFrame f=new JFrame("Mise a jour des Visiteurs");
	JPanel p=new JPanel(new GridLayout(4,4));
	f.setLayout(new GridBagLayout());
	JButton create, modify, delete,quit;
	f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	create = new JButton("creation");
	modify=new JButton("modify");
	modify.setEnabled(false);
	delete=new JButton("delete");
	delete.setEnabled(false);
	quit=new JButton("quit");
	p.add(create);
	p.add(modify);
	p.add(delete);
	p.add(quit);
	table=new JTable(m) {
		 @Override
         public boolean isCellEditable ( int row, int column )
         {
             return false;
         }
	};
    
	JScrollPane pn=new JScrollPane(table);	
	GridBagConstraints c=new GridBagConstraints();
	c.insets=new Insets(3,3,3,3);
	c.gridx=1;
	c.gridy=0;
	Font font = new Font("Arial",Font.BOLD,20);
	libelle.setFont(font);
	f.add(libelle,c);
	c.fill = GridBagConstraints.NONE;
	c.gridx=0;
	c.gridy=1;
	c.gridwidth=2;
	f.add(pn,c);
	c.anchor=GridBagConstraints.FIRST_LINE_START;
	c.gridx=2;
	c.gridy=1;
	c.gridwidth=1;
	f.add(p,c);
	ActionListener a=new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		   if (arg0.getSource()==create) {
			
			EventQueue.invokeLater(new Runnable() {
			

				@Override
				public void run() {
					Main.setAction("create");
					try {
						f1=new FenetreMajVisiteur();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			
		   }
		   if (arg0.getSource()==modify) {
			   EventQueue.invokeLater(new Runnable() {
					

					@Override
					public void run() {
						 Main.setAction("modify");
						String vId=(m.getValueAt(table.getSelectedRow(),0)).toString();
						String vNom=(m.getValueAt(table.getSelectedRow(),1)).toString();
						String vPrenom=(m.getValueAt(table.getSelectedRow(),2)).toString();
						String vLogin=(m.getValueAt(table.getSelectedRow(),3)).toString();
						String vMdp=(m.getValueAt(table.getSelectedRow(),4)).toString();
						String vAdresse=(m.getValueAt(table.getSelectedRow(),5)).toString();
						String vCp=(m.getValueAt(table.getSelectedRow(),6)).toString();
						String vVille=(m.getValueAt(table.getSelectedRow(),7)).toString();
						String vDateEmbauche = (m.getValueAt(table.getSelectedRow(),8)).toString();
						try {
							f1=new FenetreMajVisiteur();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						f1.fId.setText(vId);
						f1.fNom.setText(vNom);
						f1.fPrenom.setText(vPrenom);
						f1.fLogin.setText(vLogin);
						f1.fMdp.setText(vMdp);
						f1.fAdresse.setText(vAdresse);
						f1.fCp.setText(vCp);
						f1.fVille.setText(vVille);
						f1.fDateEmbauche.setText(vDateEmbauche);
						modify.setEnabled(false);
					}
				});
		   }
		
		   
			 if (arg0.getSource()==delete) {
				   EventQueue.invokeLater(new Runnable() {
						

						@Override
						public void run() {
							Main.setAction("delete");
							String vId=(m.getValueAt(table.getSelectedRow(),0)).toString();
							String vNom=(m.getValueAt(table.getSelectedRow(),1)).toString();
							String vPrenom=(m.getValueAt(table.getSelectedRow(),2)).toString();
							String vLogin=(m.getValueAt(table.getSelectedRow(),3)).toString();
							String vMdp=(m.getValueAt(table.getSelectedRow(),4)).toString();
							String vAdresse=(m.getValueAt(table.getSelectedRow(),5)).toString();
							String vCp=(m.getValueAt(table.getSelectedRow(),6)).toString();
							String vVille=(m.getValueAt(table.getSelectedRow(),7)).toString();
							String vDateEmbauche = (m.getValueAt(table.getSelectedRow(),8)).toString();
							try {
								f1=new FenetreMajVisiteur();
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							f1.fId.setText(vId);
							f1.fNom.setText(vNom);
							f1.fPrenom.setText(vPrenom);
							f1.fLogin.setText(vLogin);
							f1.fMdp.setText(vMdp);
							f1.fAdresse.setText(vAdresse);
							f1.fCp.setText(vCp);
							f1.fVille.setText(vVille);
							f1.fDateEmbauche.setText(vDateEmbauche);
							delete.setEnabled(false);
							
						}
					});

			   }
			 
			 if (arg0.getSource()==quit) {
				 f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
				 f.dispose();

			   }
			 
			 
		}
			
		
		
		};
		   MouseListener ml=new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
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
				quit.addActionListener(a);
				table.addMouseListener(ml);
				initTableau();
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
}


public void initTableau() {
	ArrayList<Visiteur> listeVisiteur=d.selectAllVisiteur();
    for (Visiteur e1:listeVisiteur) {
    	Object[] row1= {e1.getId(),e1.getNom(),e1.getPrenom(),e1.getLogin(),e1.getMdp(),e1.getAdresse(),e1.getCp(),
    			e1.getVille(),df.format(e1.getDateEmbauche())};
    	FenetreTableauVisiteur.setRow1(row1);
    	FenetreTableauVisiteur.getM().insertRow(FenetreTableauVisiteur.getM().getRowCount(), row1);
    }
	
}

public FenetreMajVisiteur getF1() {
	return f1;
}

public void setF1(FenetreMajVisiteur f1) {
	this.f1 = f1;
}
public static DefaultTableModel getM() {
	return m;
}
public static void setM(DefaultTableModel m) {
	FenetreTableauVisiteur.m = m;
}
public static Object[] getRow1() {
	return row1;
}
public static void setRow1(Object[] row1) {
	FenetreTableauVisiteur.row1 = row1;
}


public static JTable getTable() {
	return table;
}


public static void setTable(JTable table) {
	FenetreTableauVisiteur.table = table;
}

	
}
