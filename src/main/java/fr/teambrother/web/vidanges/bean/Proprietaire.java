/**
 * 
 */
package fr.teambrother.web.vidanges.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * classe concernant les infos du propri�taire du v�hicule
 *
 * @author s6raphin
 * @version 1.0
 */
@Getter
@Setter
public class Proprietaire {

	private Long id;
	private String nom;
	private String prenom;
	private String adresse;

}
