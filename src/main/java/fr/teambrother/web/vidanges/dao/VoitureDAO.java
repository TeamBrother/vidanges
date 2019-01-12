package fr.teambrother.web.vidanges.dao;

import java.util.List;

import fr.teambrother.web.vidanges.bean.Proprietaire;
import fr.teambrother.web.vidanges.bean.Voiture;

public interface VoitureDAO extends DAO<Voiture> {

	/**
	 * @param id
	 * @return
	 */
	List<Voiture> listerParProprietaire(Proprietaire proprietaire);

}
