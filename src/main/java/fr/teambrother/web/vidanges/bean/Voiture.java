package fr.teambrother.web.vidanges.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Voiture {

	private Long id;
	private String couleur;
	private String marque;
	private String modele;
	private Proprietaire proprietaire;

}
