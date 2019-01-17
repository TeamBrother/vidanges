package fr.teambrother.web.vidanges.dao;

import java.util.List;

import fr.teambrother.web.vidanges.bean.Entretien;

public interface EntretienDAO extends DAO<Entretien> {

	/**
	 * @param voiture
	 * @return
	 */
	List<Entretien> listerParVoiture(Entretien entretien);

}
