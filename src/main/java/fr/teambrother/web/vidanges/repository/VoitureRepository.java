package fr.teambrother.web.vidanges.repository;

import org.springframework.data.repository.CrudRepository;

import fr.teambrother.web.vidanges.bean.Proprietaire;
import fr.teambrother.web.vidanges.bean.Voiture;

public interface VoitureRepository extends CrudRepository<Voiture, Long> {

	Iterable<Voiture> findByProprietaire(Proprietaire proprietaire);

}
