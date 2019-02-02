package fr.teambrother.web.vidanges.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Voiture {

	@Id
	private Long id;
	private String couleur;
	private String marque;
	private String modele;
	@ManyToOne
	@JoinColumn(name = "idProprietaire")
	private Proprietaire proprietaire;

	@Override
	public String toString() {
		return marque + " " + modele + " (" + proprietaire + ")";
	}

}
