package com.modele;

public class LigneFraisForfait {
	private String idVisiteur;
	private String mois;
	private String idFraisForfait;
	private int quantite;
	public LigneFraisForfait() {
		
		// TODO Auto-generated constructor stub
	}
	public LigneFraisForfait(String idVisiteur, String mois, String idFraisForfait, int quantite) {
		this.idVisiteur = idVisiteur;
		this.mois = mois;
		this.idFraisForfait = idFraisForfait;
		this.quantite = quantite;
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
	public String getIdFraisForfait() {
		return idFraisForfait;
	}
	public void setIdFraisForfait(String idFraisForfait) {
		this.idFraisForfait = idFraisForfait;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFraisForfait == null) ? 0 : idFraisForfait.hashCode());
		result = prime * result + ((idVisiteur == null) ? 0 : idVisiteur.hashCode());
		result = prime * result + ((mois == null) ? 0 : mois.hashCode());
		result = prime * result + quantite;
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
		LigneFraisForfait other = (LigneFraisForfait) obj;
		if (idFraisForfait == null) {
			if (other.idFraisForfait != null)
				return false;
		} else if (!idFraisForfait.equals(other.idFraisForfait))
			return false;
		if (idVisiteur == null) {
			if (other.idVisiteur != null)
				return false;
		} else if (!idVisiteur.equals(other.idVisiteur))
			return false;
		if (mois == null) {
			if (other.mois != null)
				return false;
		} else if (!mois.equals(other.mois))
			return false;
		if (quantite != other.quantite)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LigneFraisForfait [idVisiteur=" + idVisiteur + ", mois=" + mois + ", idFraisForfait=" + idFraisForfait
				+ ", quantite=" + quantite + "]";
	}
	
	
}
