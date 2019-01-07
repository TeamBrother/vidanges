/**
 * 
 */
package fr.teambrother.web.vidanges.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * classe concernant les infos du propriétaire du véhicule
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
	private String numero;
	private String adresse;

	/**
	 * @return
	 */
	public Object getCodePostal() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	public Object getPays() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	public Object getVille() {
		// TODO Auto-generated method stub
		return null;
	}

}
