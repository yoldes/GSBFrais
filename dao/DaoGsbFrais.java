package com.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.modele.Etat;
import com.modele.FicheFrais;
import com.modele.FraisForfait;
import com.modele.LigneFraisForfait;
import com.modele.LigneHorsForfait;
import com.modele.Visiteur;

public class DaoGsbFrais implements Dao {
	private Connect connection;
	private Statement statement;
	private ResultSet resultSet;
	private ArrayList<Etat> liste = new ArrayList<Etat>();
	private ArrayList<FraisForfait> listeForfait = new ArrayList<FraisForfait>();
	private ArrayList<Visiteur> listeVisiteur	= new ArrayList<Visiteur>();
	private ArrayList<FicheFrais> listeFicheFrais	= new ArrayList<FicheFrais>();

	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	

	@Override
	public void InsertEtat(Etat t) {
		// TODO Auto-generated method stub
		statement = connection.getConnection();

		try {
			statement.executeUpdate(
					"insert into etat (id, libelle) values ( '" + t.getId() + "','" + t.getLibelle() + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeConnection();
			statement = null;
			resultSet = null;
		}

	}

	@Override
	public void updateEtat(Etat t) {
		// TODO Auto-generated method stub
		statement = connection.getConnection();
		try {
			statement.executeUpdate("update etat set id='" + t.getId() + "',libelle='" + t.getLibelle() + "' where id='"
					+ t.getId() + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeConnection();
			statement = null;
			resultSet = null;
		}

	}

	@Override
	public void deleteEtat(Etat t) {
		// TODO Auto-generated method stub
		statement = connection.getConnection();
		try {
			statement.executeUpdate("delete from etat where id='" + t.getId() + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeConnection();
			statement = null;
			resultSet = null;
		}

	}

	@Override
	public ArrayList<Etat> selectAllEtat() {
		// TODO Auto-generated method stub
		statement = connection.getConnection();
		try {
			resultSet = statement.executeQuery("select * from etat");
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String libelle = resultSet.getString("libelle");
				liste.add(new Etat(id, libelle));

			}
			return this.liste;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.liste;
	}

	

	@Override
	public void InsertFraisForfait(FraisForfait t) {

		statement = connection.getConnection();

		try {
			statement.executeUpdate("insert into fraisforfait (id, libelle, montant) values ( '" + t.getId() + "','"
					+ t.getLibelle() + "','" + t.getMontant() + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeConnection();
			statement = null;
			resultSet = null;
		}
	}

	@Override
	public void updateFraisForfait(FraisForfait t) {
		// TODO Auto-generated method stub
				statement = connection.getConnection();
				try {
					statement.executeUpdate("update fraisforfait set id='" + t.getId() + "',libelle='" + t.getLibelle() + "',montant='" + t.getMontant() + "' where id='"
							+ t.getId() + "'");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					connection.closeConnection();
					statement = null;
					resultSet = null;
				}

	}

	@Override
	public void deleteFraisForfait(FraisForfait t) {
		// TODO Auto-generated method stub
				statement = connection.getConnection();
				try {
					statement.executeUpdate("delete from fraisforfait where id='" + t.getId() + "'");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					connection.closeConnection();
					statement = null;
					resultSet = null;
				}

			}

	@Override
	public ArrayList<FraisForfait> selectAllFraisForfait() {
		statement = connection.getConnection();
		try {
			resultSet = statement.executeQuery("select * from fraisforfait");
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String libelle = resultSet.getString("libelle");
				Double montant = resultSet.getDouble("montant");
				listeForfait.add(new FraisForfait(id, libelle,montant));

			}
			return this.listeForfait;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.listeForfait;
	}

	@Override
	public void InsertFicheFrais(FicheFrais t)
	{
		// TODO Auto-generated method stub
		statement = connection.getConnection();
		try 
		{
			statement.executeUpdate("INSERT INTO `fichefrais`(`idVisiteur`, `mois`, `nbJustificatifs`, `montantValide`, `dateModif`, `idEtat`) "
					+ "VALUES ('"+t.getIdVisiteur()+"', '"+t.getMois()+"', '"+t.getNbJustificatifs()+"', '"+t.getMontantValide()+"',"
					+ "'"+df.format(t.getDateModif())+"', '"+t.getIdEtat()+"')");

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			connection.closeConnection();
			statement = null;
			resultSet = null;
		}
	}
	
	@Override
	public void updateFicheFrais(FicheFrais t)
	{
		// TODO Auto-generated method stub
		statement = connection.getConnection();
		try
		{
			statement.executeUpdate("UPDATE fichefrais set dateModif='"+df.format(t.getDateModif())+"', idEtat='"+t.getIdEtat()+"', idVisiteur='"+t.getIdVisiteur()+"',"
					+ "mois='"+t.getMois()+"', nbJustificatifs='"+t.getNbJustificatifs()+"', montantValide='"+t.getMontantValide()+"'"
					+ "WHERE idVisiteur='"+t.getIdVisiteur()+"'");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			connection.closeConnection();
			statement = null;
			resultSet = null;
		}		
	}

	@Override
	public void deleteFicheFrais(FicheFrais t) 
	{
		// TODO Auto-generated method stub
		statement = connection.getConnection();
		try
		{
			statement.executeUpdate("DELETE FROM fichefrais WHERE idVisiteur='"+t.getIdVisiteur()+"'");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			connection.closeConnection();
			statement = null;
			resultSet = null;
		}
	}

	@Override
	public ArrayList<FicheFrais> selectAllFicheFrais()
	{
		// TODO Auto-generated method stub
		statement = connection.getConnection();
		try
		{			
			resultSet = statement.executeQuery("select * from fichefrais");
			while (resultSet.next())
			{
				Date	dateModif		= resultSet.getDate("datemodif");
				String 	idEtat			= resultSet.getString("idEtat");
				String 	idVisiteur		= resultSet.getString("idVisiteur");
				String 	Mois			= resultSet.getString("Mois");
				int 	nbJustificatifs	= resultSet.getInt("nbJustificatifs");
				double 	montantValide	= resultSet.getDouble("montantValide");
				listeFicheFrais.add(new FicheFrais(idVisiteur, Mois, nbJustificatifs, montantValide, dateModif, idEtat));
			}
			return this.listeFicheFrais;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.listeFicheFrais;
	}


	@Override
	public void InsertLigneFraisForfait(LigneFraisForfait t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateLigneFraisForfait(LigneFraisForfait t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLigneFraisForfait(LigneFraisForfait t) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<LigneFraisForfait> selectAllLigneFraisForfait() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void InsertLigneHorsForfait(LigneHorsForfait t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateLigneHorsForfait(LigneHorsForfait t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLigneHorsForfait(LigneHorsForfait t) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Etat> selectAllLigneHorsForfait() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void InsertVisiteur(Visiteur t) {
		// TODO Auto-generated method stub
		statement=connection.getConnection();
		try {
			statement.executeUpdate("INSERT INTO `visiteur`"
									+ "(`id`, `nom`, `prenom`, `login`, `mdp`, `adresse`, `cp`, `ville`, `dateEmbauche`) "
									+ "VALUES ('"+t.getId()+"','"+t.getNom()+"','"+t.getPrenom()+"','"+t.getLogin()+"','"+t.getMdp()+"',"
									+ "'"+t.getAdresse()+"','"+t.getCp()+"','"+t.getVille()+"','"+df.format(t.getDateEmbauche())+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.closeConnection();
			statement=null;
			resultSet=null;
		}
		
	}


	@Override
	public void updateVisiteur(Visiteur t) {
		// TODO Auto-generated method stub
		statement=connection.getConnection();
		try {
			statement.executeUpdate("UPDATE visiteur SET nom='"+t.getNom()+"',prenom='"+t.getPrenom()+"',"
									+ "login='"+t.getLogin()+"',mdp='"+t.getMdp()+"',adresse='"+t.getAdresse()+"',cp='"+t.getCp()+"',"
									+ "ville='"+t.getVille()+"',dateEmbauche='"+df.format(t.getDateEmbauche())+"' WHERE id='"+t.getId()+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.closeConnection();
			statement=null;
			resultSet=null;
		}
		
	}


	@Override
    public void deleteVisiteur(Visiteur t) {
        // TODO Auto-generated method stub
        statement=connection.getConnection();
        try {
            statement.executeUpdate("delete from lignefraisforfait where idVisiteur='"+t.getId()+"'");
            statement.executeUpdate("delete from lignefraishorsforfait where idVisiteur='"+t.getId()+"'");
            statement.executeUpdate("delete from fichefrais where idVisiteur='"+t.getId()+"'");
            statement.executeUpdate("delete from visiteur where id='"+t.getId()+"'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            connection.closeConnection();
            statement=null;
            resultSet=null;
        }
    }


	@Override
	public ArrayList<Visiteur> selectAllVisiteur() {
		// TODO Auto-generated method stub
		statement=connection.getConnection();
		try {
			resultSet=statement.executeQuery("select * from visiteur");
			while (resultSet.next()){
				String id=resultSet.getString("id");
				String nom=resultSet.getString("nom");
				String prenom=resultSet.getString("prenom");
				String login=resultSet.getString("login");
				String mdp=resultSet.getString("mdp");
				String adresse=resultSet.getString("adresse");
				String cp=resultSet.getString("cp");
				String ville=resultSet.getString("ville");
				Date dateEmbauche=resultSet.getDate("dateEmbauche");
				
				listeVisiteur.add(new Visiteur(id,nom,prenom,login,mdp,adresse,cp,ville,dateEmbauche));

			}
			return this.listeVisiteur;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.listeVisiteur;
	}

}

