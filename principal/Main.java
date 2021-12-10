package com.principal;

import java.awt.EventQueue;

import com.view.FenetreMajEtat;
import com.view.FenetreTableauEtat;
import com.view.MenuPrincipal;
public class Main {
private static String action;
public static void main(String args[]){
//On cree un processus

  Runnable r= new Runnable() {

	@Override
	public void run() {
		//On lance la fenêtre principale
		// TODO Auto-generated method stub
		//ON FAIT APPEL A LA FENETRE PRINCIPAL
		  MenuPrincipal f=new MenuPrincipal();	
	}
	  
  };
  EventQueue.invokeLater(r);
}
public static String getAction() {
	return action;
}
public static void setAction(String action) {
	Main.action = action;
}


}
