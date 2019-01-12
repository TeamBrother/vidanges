/**
 * 
 */
package fr.teambrother.web.vidanges.dao.impl;

import static fr.teambrother.web.vidanges.dao.DAOUtilitaire.fermeturesSilencieuses;
import static fr.teambrother.web.vidanges.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.teambrother.web.vidanges.bean.Proprietaire;
import fr.teambrother.web.vidanges.dao.DAOException;
import fr.teambrother.web.vidanges.dao.DAOFactory;
import fr.teambrother.web.vidanges.dao.ProprietaireDAO;

/**
 * TODO description
 *
 * @author s6raphin
 * @version 1.0
 */

@Repository("proprietaireDAO")
public class ProprietaireDAOImpl implements ProprietaireDAO {

	private static final String TABLE_NAME = "proprietaire";

	private static final String TABLE_COLUMNS = "nom, prenom, adresse";

	private static final String SQL_CREATE = "INSERT INTO " + TABLE_NAME + " (" + TABLE_COLUMNS + ") VALUES (?, ?, ?)";

	private static final String SQL_READ = "SELECT id, " + TABLE_COLUMNS + " FROM " + TABLE_NAME + " WHERE id = ?";

	private static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

	private static final String SQL_LIST = "SELECT id, " + TABLE_COLUMNS + " FROM " + TABLE_NAME
			+ " ORDER BY nom, prenom";

	@Autowired
	private DAOFactory daoFactory;

	public ProprietaireDAOImpl() {
	}

	public void creer(Proprietaire proprietaire) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {
			/* R�cup�ration d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_CREATE, true, proprietaire.getNom(),
					proprietaire.getPrenom(), proprietaire.getAdresse());
			int statut = preparedStatement.executeUpdate();
			/* Analyse du statut retourn� par la requ�te d'insertion */
			if (statut == 0) {
				throw new DAOException("�chec de la cr�ation de la voiture, aucune ligne ajout�e dans la table.");
			}
			/* R�cup�ration de l'id auto-g�n�r� par la requ�te d'insertion */
			valeursAutoGenerees = preparedStatement.getGeneratedKeys();
			if (valeursAutoGenerees.next()) {
				/* Puis initialisation de la propri�t� id du bean Utilisateur avec sa valeur */
				proprietaire.setId(valeursAutoGenerees.getLong(1));
			} else {
				throw new DAOException("�chec de la cr�ation de la voiture en base, aucun ID auto-g�n�r� retourn�.");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}
	}

	/* Impl�mentation de la m�thode d�finie dans l'interface UtilisateurDao */
	public Proprietaire trouver(Long id) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Proprietaire proprietaire = null;
		try {
			/* R�cup�ration d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_READ, false, id);
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
			if (resultSet.next()) {
				proprietaire = map(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}
		return proprietaire;
	}

	public void modifier(Proprietaire proprietaire) throws DAOException {
		// TODO Auto-generated method stub
	}

	public void supprimer(Proprietaire proprietaire) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			/* R�cup�ration d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_DELETE, false, proprietaire.getId());
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}
	}

	public List<Proprietaire> lister() throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Proprietaire> list = new ArrayList<Proprietaire>();
		try {
			/* R�cup�ration d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_LIST, false);
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
			while (resultSet.next()) {
				Proprietaire proprietaire = map(resultSet);
				list.add(proprietaire);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}
		return list;
	}

	/**
	 * Simple m�thode utilitaire permettant de faire la correspondance (le mapping)
	 * entre une ligne issue de la table des proprietaire (un ResultSet) et un bean
	 * {@link Proprietaire}.
	 */
	private static Proprietaire map(ResultSet resultSet) throws SQLException {
		Proprietaire proprietaire = new Proprietaire();
		proprietaire.setId(resultSet.getLong("id"));
		proprietaire.setNom(resultSet.getString("nom"));
		proprietaire.setPrenom(resultSet.getString("prenom"));
		proprietaire.setAdresse(resultSet.getString("adresse"));
		return proprietaire;
	}

}