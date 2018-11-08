package fr.teambrother.web.vidanges.bean;

import java.awt.Color;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Bean stockant les informations d'une voiture.
 * 
 * @author chinjto
 * @version 1.0
 */
@Getter
@Setter
public class Voiture {

	/** Immatriculation de la voiture. **/
	private String immatriculation;

	/** Date de première immatriculation de la voiture. **/
	private Date datePremiereImmatriculation;

	/** Date du dernier contrôle technique de la voiture. **/
	private Date dateDernierControleTechnique;

	/** Couleur de la voiture. **/
	private Color couleur;

	/** Marque de la voiture. **/
	private String marque;

}
