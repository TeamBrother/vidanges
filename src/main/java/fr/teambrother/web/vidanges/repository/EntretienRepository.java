package fr.teambrother.web.vidanges.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.teambrother.web.vidanges.bean.Entretien;
import fr.teambrother.web.vidanges.bean.Voiture;

@Repository
public interface EntretienRepository extends CrudRepository<Entretien, Long> {

	Iterable<Entretien> findByVoiture(Voiture voiture);

}
