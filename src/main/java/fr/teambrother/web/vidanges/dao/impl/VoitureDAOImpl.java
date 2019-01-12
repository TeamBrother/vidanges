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

import fr.teambrother.web.vidanges.bean.Voiture;
import fr.teambrother.web.vidanges.dao.DAOException;
import fr.teambrother.web.vidanges.dao.DAOFactory;
import fr.teambrother.web.vidanges.dao.ProprietaireDAO;
import fr.teambrother.web.vidanges.dao.VoitureDAO;

@Repository("voitureDAO")
public class VoitureDAOImpl implements VoitureDAO {

	private static final String TABLE_NAME = "voiture";

	private static final String TABLE_COLUMNS = "couleur, marque, modele, idproprietaire";

	private static final String SQL_CREATE = "INSERT INTO " + TABLE_NAME + " (" + TABLE_COLUMNS
			+ ") VALUES (?, ?, ?, ?)";

	private static final String SQL_READ = "SELECT id, " + TABLE_COLUMNS + " FROM " + TABLE_NAME + " WHERE id = ?";

//	private static final String SQL_UPDATE = "UPDATE " + TABLE_COLUMNS + " SET ? = ? WHERE id = ?";

	private static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

	private static final String SQL_LIST = "SELECT id, " + TABLE_COLUMNS + " FROM " + TABLE_NAME + " ORDER BY marque";

	@Autowired
	private DAOFactory daoFactory;

	@Autowired
	private ProprietaireDAO proprietaireDAO;

	public VoitureDAOImpl() {
	}

	public void creer(Voiture voiture) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {
			/* R�cup�ration d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_CREATE, true, voiture.getCouleur(),
					voiture.getMarque(), voiture.getModele(), voiture.getProprietaire().getId());
			int statut = preparedStatement.executeUpdate();
			/* Analyse du statut retourn� par la requ�te d'insertion */
			if (statut == 0) {
				throw new DAOException("�chec de la cr�ation de la voiture, aucune ligne ajout�e dans la table.");
			}
			/* R�cup�ration de l'id auto-g�n�r� par la requ�te d'insertion */
			valeursAutoGenerees = preparedStatement.getGeneratedKeys();
			if (valeursAutoGenerees.next()) {
				/* Puis initialisation de la propri�t� id du bean Utilisateur avec sa valeur */
				voiture.setId(valeursAutoGenerees.getLong(1));
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
	public Voiture trouver(Long id) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Voiture voiture = null;
		try {
			/* R�cup�ration d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_READ, false, id);
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
			if (resultSet.next()) {
				voiture = map(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}
		return voiture;
	}

	public void modifier(Voiture voiture) throws DAOException {
		// TODO Auto-generated method stub
	}

	public void supprimer(Voiture voiture) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			/* R�cup�ration d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_DELETE, false, voiture.getId());
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}
	}

	public List<Voiture> lister() throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Voiture> list = new ArrayList<Voiture>();
		try {
			/* R�cup�ration d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_LIST, false);
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
			while (resultSet.next()) {
				Voiture voiture = map(resultSet);
				list.add(voiture);
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
	 * entre une ligne issue de la table des voitures (un ResultSet) et un bean
	 * {@link Voiture}.
	 */
	private Voiture map(ResultSet resultSet) throws SQLException {
		Voiture voiture = new Voiture();
		voiture.setId(resultSet.getLong("id"));
		voiture.setCouleur(resultSet.getString("couleur"));
		voiture.setMarque(resultSet.getString("marque"));
		voiture.setModele(resultSet.getString("modele"));
		voiture.setProprietaire(proprietaireDAO.trouver(resultSet.getLong("idproprietaire")));
		return voiture;
	}

}
