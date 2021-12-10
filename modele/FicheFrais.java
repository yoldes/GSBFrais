package com.modele;

import java.util.Date;

public class FicheFrais
{
	private String	idVisiteur;
	private String	mois;
	private int		nbJustificatifs;
	private double	montantValide;
	private Date	dateModif;
	private String	idEtat;

	public FicheFrais(String idVisiteur, String mois, int nbJustificatifs, double montantValide, Date dateModif, String idEtat)
	{
		this.idVisiteur			= idVisiteur;
		this.mois 				= mois;
		this.nbJustificatifs	= nbJustificatifs;
		this.montantValide 		= montantValide;
		this.dateModif 			= dateModif;
		this.idEtat 			= idEtat;
	}
	
	public String getIdVisiteur() {
		return idVisiteur;
	}

	public void setIdVisiteur(String idVisiteur) {
		this.idVisiteur = idVisiteur;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public int getNbJustificatifs() {
		return nbJustificatifs;
	}

	public void setNbJustificatifs(int nbJustificatifs) {
		this.nbJustificatifs = nbJustificatifs;
	}

	public double getMontantValide() {
		return montantValide;
	}

	public void setMontantValide(double montantValide) {
		this.montantValide = montantValide;
	}

	public Date getDateModif() {
		return dateModif;
	}

	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}

	public String getIdEtat() {
		return idEtat;
	}

	public void setIdEtat(String idEtat) {
		this.idEtat = idEtat;
	}

	@Override
	public String toString() {
		return "FicheFrais [idVisiteur=" + idVisiteur + ", mois=" + mois + ", nbJustificatifs=" + nbJustificatifs
				+ ", montantValide=" + montantValide + ", dateModif=" + dateModif + ", idEtat=" + idEtat + "]";
	}
}