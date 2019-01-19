package fr.teambrother.web.vidanges.bean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Entretien {

	private Long id;
	private Date date;
	private Voiture voiture;
	private String commentaire;

}
