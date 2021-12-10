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
import java.text.ParseException;
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
import com.modele.FraisForfait;
import com.principal.Main;
public class FenetreTableauFraisForfait extends JFrame {
	FenetreMajFraisForfait f1;
 static String[] title={"Id", "Libelle", "Montant",};
 static DefaultTableModel m=new DefaultTableModel(null,title);
 DaoGsbFrais d=new DaoGsbFrais();
 static Object[] row1;
 static JTable table;
 JLabel libelle=new JLabel("Saisie des FraisForfaits");
public FenetreTableauFraisForfait() {
	JFrame f=new JFrame("Mise a jour des Frais");
	JPanel p=new JPanel(new GridLayout(4,4));
	f.setLayout(new GridBagLayout());
	JButton create, modify, delete,quitter;
	f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	create = new JButton("creation");
	modify=new JButton("modify");
	modify.setEnabled(false);
	delete=new JButton("delete");
	delete.setEnabled(false);
	quitter=new JButton("quitter");
	p.add(create);
	p.add(modify);
	p.add(delete);
	p.add(quitter);
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
						f1=new FenetreMajFraisForfait();
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
							String vLibelle=(m.getValueAt(table.getSelectedRow(),1)).toString();
							String vMontant=(m.getValueAt(table.getSelectedRow(),2)).toString();
							 try {
								f1=new FenetreMajFraisForfait();
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							 f1.fId.setText(vId);
							 f1.fLibelle.setText(vLibelle);
							 f1.fMontant.setText(vMontant);
							 
							 modify.setEnabled(false);	
						
					}
				});
		   }
		
		   
			 if (arg0.getSource()==delete) {
				   EventQueue.invokeLater(new Runnable() {
						

						@Override
						public void run() {
							 Main.setAction("delete");
							 System.out.println("delete");
								String vId=(m.getValueAt(table.getSelectedRow(),0)).toString();
								String vLibelle=(m.getValueAt(table.getSelectedRow(),1)).toString();
								String vMontant=(m.getValueAt(table.getSelectedRow(),2)).toString();


								 try {
									f1=new FenetreMajFraisForfait();
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								 f1.fId.setText(vId);
								 f1.fLibelle.setText(vLibelle);
								 f1.fMontant.setText(vMontant);
								 delete.setEnabled(false);
							
						}
					});

			   }
			 
			 if (arg0.getSource()==quitter) {
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
				quitter.addActionListener(a);
				table.addMouseListener(ml);
				initTableau();
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
		
		
	
	
			 
}


public void initTableau() {
	ArrayList<FraisForfait> listeFraisforait=d.selectAllFraisForfait();
    for (FraisForfait e1:listeFraisforait) {
    	Object[] row1= {e1.getId(),e1.getLibelle(),e1.getMontant()};
		FenetreTableauFraisForfait.setRow1(row1);
		FenetreTableauFraisForfait.getM().insertRow(FenetreTableauFraisForfait.getM().getRowCount(), row1);
    }
	
}

public FenetreMajFraisForfait getF1() {
	return f1;
}

public void setF1(FenetreMajFraisForfait f1) {
	this.f1 = f1;
}
public static DefaultTableModel getM() {
	return m;
}
public static void setM(DefaultTableModel m) {
	FenetreTableauFraisForfait.m = m;
}
public static Object[] getRow1() {
	return row1;
}
public static void setRow1(Object[] row1) {
	FenetreTableauFraisForfait.row1 = row1;
}


public static JTable getTable() {
	return table;
}


public static void setTable(JTable table) {
	FenetreTableauFraisForfait.table = table;
}

	
}

//persistance - mapper 