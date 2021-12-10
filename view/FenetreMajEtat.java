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
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.dao.DaoGsbFrais;
import com.modele.Etat;
import com.principal.Main;

public class FenetreMajEtat extends JFrame {
JLabel lId,lLibelle;
//JTextField fId,fLibelle;
JFormattedTextField fId,fLibelle;
JButton bEnvoyer, bQuitter;
//permet d'obtenir la connexion a la base de donnee
DaoGsbFrais d=new DaoGsbFrais();
Etat etat;

public FenetreMajEtat() throws ParseException {
	JFrame f=new JFrame("MAJ des Etats");
	f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	//Version numero 1
	/*f.setLayout(new BorderLayout());
	JPanel p1=new JPanel(new GridLayout(2,1));
	JPanel p2=new JPanel(new GridLayout(2,1));
	JPanel p3=new JPanel(new FlowLayout());
	JPanel p4=new JPanel(new FlowLayout());
	f.setResizable(false);
	lId=new JLabel("Id");
	lLibelle=new JLabel("Libelle");
	fId=new JTextField(10);
	fLibelle=new JTextField(10);
	bButton=new JButton("Envoyer");
	p1.add(lId);p2.add(fId);
	p1.add(lLibelle);p2.add(fLibelle);
	p3.add(p1);
	p3.add(p2);
	p4.add(bButton);
	f.add(p3,BorderLayout.CENTER);
	f.add(p4,BorderLayout.SOUTH);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.pack();
	f.setVisible(true);*/
	
	//Version numero 2
	/*f.setLayout(new GridLayout(3,1,20,20));
    JPanel p1=new JPanel(new GridLayout(1,2,5,20));
    JPanel p2=new JPanel(new GridLayout(1,2,5,20));
    JPanel p3=new JPanel(new GridLayout(1,1,20,20));
    lId=new JLabel("Id");
	lLibelle=new JLabel("Libelle");
	fId=new JTextField(10);
	fLibelle=new JTextField(10);
	bButton=new JButton("Envoyer");
	p1.add(lId);p1.add(fId);
	p2.add(lLibelle);p2.add(fLibelle);
	p3.add(bButton);
	f.add(p1);
	f.add(p2);
	f.add(p3);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setResizable(false);
	f.pack();
	f.setVisible(true);
	*/
	
	//Version numero 3
	lId=new JLabel("Id");
	lLibelle=new JLabel("Libelle");
	fId=new JFormattedTextField(new MaskFormatter("**"));
	fLibelle=new JFormattedTextField(new MaskFormatter("**********"));
	fId.setColumns(4);
	fLibelle.setColumns(10);
	bEnvoyer=new JButton("Envoyer");
	bQuitter=new JButton("Quitter");
	f.setSize(300,300);
	f.setLayout(new GridBagLayout());
	GridBagConstraints c=new GridBagConstraints();
	c.insets=new Insets(5,5,5,5);
	c.gridx=0;
	c.gridx=0;
	c.ipadx=5;
    c.ipady=5;
	f.add(lId,c);
	c.gridx=1;
	c.gridy=0;
	c.ipadx=5;
    c.ipady=5;
	f.add(fId, c);
	c.gridx=0;
	c.gridy=1;
	c.ipadx=5;
    c.ipady=5;
	f.add(lLibelle, c);
	c.gridx=1;
	c.gridy=1;
	c.ipadx=5;
    c.ipady=5;
	f.add(fLibelle, c);
	c.gridx=1;
	c.gridy=2;
	c.ipadx=5;
    c.ipady=5;
    f.setResizable(false);
    ActionListener create=new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (Main.getAction().equals("create")) {
			etat=new Etat(fId.getText().toString(),fLibelle.getText().toString());
			d.InsertEtat(etat);
			Object[] row1= {fId.getText().toString(),fLibelle.getText().toString()};
			FenetreTableauEtat.setRow1(row1);
			FenetreTableauEtat.getM().insertRow(FenetreTableauEtat.getM().getRowCount(), row1);
			f.setVisible(false);
			}
			if (Main.getAction().equals("modify")) {
			etat=new Etat(fId.getText().toString(),fLibelle.getText().toString());
			d.updateEtat(etat);
			Object[] row1= {fId.getText().toString(),fLibelle.getText().toString()};
			FenetreTableauEtat.setRow1(row1);
			FenetreTableauEtat.getM().setValueAt(fId.getText().toString(), FenetreTableauEtat.getTable().getSelectedRow(), 0);
			FenetreTableauEtat.getM().setValueAt(fLibelle.getText().toString(), FenetreTableauEtat.getTable().getSelectedRow(), 1);
			f.setVisible(false);
			}
			
			if (Main.getAction().equals("delete")) {
				etat=new Etat(fId.getText().toString(),fLibelle.getText().toString());
				d.deleteEtat(etat);
				FenetreTableauEtat.getM().removeRow(FenetreTableauEtat.getTable().getSelectedRow());
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
    f.add(bEnvoyer, c);
    c.gridx = 0;
    c.gridy = 2;
    c.ipadx = 5;
    c.ipady = 5;
    	f.add(bQuitter,c);
    	f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	f.setVisible(true);
	 JDialog dialog=new JDialog(f,Dialog.ModalityType.APPLICATION_MODAL);
	 dialog.pack();
	 f.setLocationRelativeTo(null);
	 
		
}
}
