package fr.teambrother.web.vidanges.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Entretien {

	@Id
	private Long id;
	private Date date;
	@ManyToOne
	@JoinColumn(name = "idVoiture")
	private Voiture voiture;
	private String commentaire;

	@Override
	public String toString() {
		return date + " " + voiture;
	}

}
