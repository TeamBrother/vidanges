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

import fr.teambrother.web.vidanges.bean.Entretien;
import fr.teambrother.web.vidanges.dao.DAOException;
import fr.teambrother.web.vidanges.dao.DAOFactory;
import fr.teambrother.web.vidanges.dao.EntretienDAO;

@Repository("entretienDAO")
public class EntretienDAOImpl implements EntretienDAO {

	private static final String TABLE_NAME = "entretien";

	private static final String TABLE_COLUMNS = "date, idvoiture";

	private static final String SQL_CREATE = "INSERT INTO " + TABLE_NAME + " (" + TABLE_COLUMNS + ") VALUES (?, ?)";

	private static final String SQL_READ = "SELECT id, " + TABLE_COLUMNS + " FROM " + TABLE_NAME + " WHERE id = ?";

//	private static final String SQL_UPDATE = "UPDATE " + TABLE_COLUMNS + " SET ? = ? WHERE id = ?";

	private static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

	private static final String SQL_LIST = "SELECT id, " + TABLE_COLUMNS + " FROM " + TABLE_NAME + " ORDER BY date";

	@Autowired
	private DAOFactory daoFactory;

	public EntretienDAOImpl() {
	}

	public void creer(Entretien entretien) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_CREATE, true, entretien.getDate(),
					entretien.getIdVoiture());
			int statut = preparedStatement.executeUpdate();
			/* Analyse du statut retourné par la requête d'insertion */
			if (statut == 0) {
				throw new DAOException("Échec de la création de la entretien, aucune ligne ajoutée dans la table.");
			}
			/* Récupération de l'id auto-généré par la requête d'insertion */
			valeursAutoGenerees = preparedStatement.getGeneratedKeys();
			if (valeursAutoGenerees.next()) {
				/* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
				entretien.setId(valeursAutoGenerees.getLong(1));
			} else {
				throw new DAOException("Échec de la création de la entretien en base, aucun ID auto-généré retourné.");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}
	}

	/* Implémentation de la méthode définie dans l'interface UtilisateurDao */
	public Entretien trouver(Long id) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Entretien entretien = null;
		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_READ, false, id);
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			if (resultSet.next()) {
				entretien = map(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}
		return entretien;
	}

	public void modifier(Entretien entretien) throws DAOException {
		// TODO Auto-generated method stub
	}

	public void supprimer(Entretien entretien) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_DELETE, false, entretien.getId());
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}
	}

	public List<Entretien> lister() throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Entretien> list = new ArrayList<Entretien>();
		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_LIST, false);
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			while (resultSet.next()) {
				Entretien entretien = map(resultSet);
				list.add(entretien);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}
		return list;
	}

	/**
	 * Simple méthode utilitaire permettant de faire la correspondance (le mapping)
	 * entre une ligne issue de la table des entretiens (un ResultSet) et un bean
	 * {@link Entretien}.
	 */
	private static Entretien map(ResultSet resultSet) throws SQLException {
		Entretien entretien = new Entretien();
		entretien.setId(resultSet.getLong("id"));
		entretien.setDate(resultSet.getDate("date"));
		entretien.setIdVoiture(resultSet.getLong("idvoiture"));
		return entretien;
	}

}
