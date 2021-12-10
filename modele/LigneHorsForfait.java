package com.modele;

import java.util.Date;

public class LigneHorsForfait {
	private int id;
	private String idVisiteur; 
	private String mois;
	private String libelle;
	private Date date;
	private double montant;
	public LigneHorsForfait() {
		
		// TODO Auto-generated constructor stub
	}
	public LigneHorsForfait(int id, String idVisiteur, String mois, String libelle, Date date, double montant) {
	
		this.id = id;
		this.idVisiteur = idVisiteur;
		this.mois = mois;
		this.libelle = libelle;
		this.date = date;
		this.montant = montant;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((idVisiteur == null) ? 0 : idVisiteur.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((mois == null) ? 0 : mois.hashCode());
		long temp;
		temp = Double.doubleToLongBits(montant);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneHorsForfait other = (LigneHorsForfait) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (idVisiteur == null) {
			if (other.idVisiteur != null)
				return false;
		} else if (!idVisiteur.equals(other.idVisiteur))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (mois == null) {
			if (other.mois != null)
				return false;
		} else if (!mois.equals(other.mois))
			return false;
		if (Double.doubleToLongBits(montant) != Double.doubleToLongBits(other.montant))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LigneHorsForfait [id=" + id + ", idVisiteur=" + idVisiteur + ", mois=" + mois + ", libelle=" + libelle
				+ ", date=" + date + ", montant=" + montant + "]";
	}
	
	
}
