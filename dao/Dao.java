package com.dao;

import java.util.ArrayList;

import com.modele.Etat;
import com.modele.FicheFrais;
import com.modele.FraisForfait;
import com.modele.LigneFraisForfait;
import com.modele.LigneHorsForfait;
import com.modele.Visiteur;

public interface Dao {
public void InsertEtat(Etat t);
public void updateEtat(Etat t);
public void deleteEtat(Etat t);
public ArrayList<Etat> selectAllEtat();

public void InsertFicheFrais(FicheFrais t);
public void updateFicheFrais(FicheFrais t);
public void deleteFicheFrais(FicheFrais t);
public ArrayList<FicheFrais> selectAllFicheFrais();

public void InsertFraisForfait(FraisForfait t);
public void updateFraisForfait(FraisForfait t);
public void deleteFraisForfait(FraisForfait t);
public ArrayList<FraisForfait> selectAllFraisForfait();

public void InsertLigneFraisForfait(LigneFraisForfait t);
public void updateLigneFraisForfait(LigneFraisForfait t);
public void deleteLigneFraisForfait(LigneFraisForfait t);
public ArrayList<LigneFraisForfait> selectAllLigneFraisForfait();

public void InsertLigneHorsForfait(LigneHorsForfait t);
public void updateLigneHorsForfait(LigneHorsForfait t);
public void deleteLigneHorsForfait(LigneHorsForfait t);
public ArrayList<Etat> selectAllLigneHorsForfait();


public void InsertVisiteur(Visiteur t);
public void updateVisiteur(Visiteur t);
public void deleteVisiteur(Visiteur t);
public ArrayList<Visiteur> selectAllVisiteur();


}
