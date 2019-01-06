package fr.teambrother.web.vidanges.dao;

import java.util.List;

public interface DAO<E> {

	void creer(E entite) throws DAOException;

	E trouver(Long id) throws DAOException;

	void modifier(E entite) throws DAOException;

	void supprimer(E entite) throws DAOException;

	List<E> lister() throws DAOException;

}
