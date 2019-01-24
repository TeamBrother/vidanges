package fr.teambrother.web.vidanges.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * classe concernant les infos du propri�taire du v�hicule
 *
 * @author s6raphin
 * @version 1.0
 */
@Entity
@Getter
@Setter
public class Proprietaire {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private String adresse;

	@Override
	public String toString() {
		return prenom + " " + nom;
	}

}
