package fr.teambrother.web.vidanges.dao;

import java.util.List;

import fr.teambrother.web.vidanges.bean.Entretien;
import fr.teambrother.web.vidanges.bean.Voiture;

public interface EntretienDAO extends DAO<Entretien> {

	/**
	 * @param voiture
	 * @return
	 */
	List<Entretien> listerParVoiture(Voiture voiture);

}
