/**
 * 
 */
package fr.teambrother.web.vidanges.controller;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.teambrother.web.vidanges.bean.Entretien;
import fr.teambrother.web.vidanges.bean.Voiture;
import fr.teambrother.web.vidanges.dao.VoitureDAO;
import fr.teambrother.web.vidanges.repository.EntretienRepository;

@Controller
public class EntretienController {

	private static final String MENU = "entretien";

	@Autowired
	private EntretienRepository entretienRepository;

	@Autowired
	private VoitureDAO voitureDAO;

	@RequestMapping("/entretien/ajout")
	public ModelAndView setEntretien(@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "idVoiture", required = false) String idVoiture,
			@RequestParam(value = "commentaire", required = false) String commentaire) {
		if (StringUtils.isNotEmpty(date) && StringUtils.isNotEmpty(idVoiture) && StringUtils.isNotEmpty(commentaire)) {
			Entretien entretien = new Entretien();
			entretien.setCommentaire(commentaire);
			entretien.setDate(new Date());
			Voiture voiture = new Voiture();
			voiture.setId(Long.valueOf(idVoiture));
			entretien.setVoiture(voiture);
			entretienRepository.save(entretien);
			ModelAndView mav = new ModelAndView("redirect:/entretien/detail?id=" + entretien.getId());
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("entretien/ajout");
			mav.addObject("menu", MENU);
			mav.addObject("date", date);
			mav.addObject("idVoiture", idVoiture);
			mav.addObject("commentaire", commentaire);
			mav.addObject("voitures", voitureDAO.lister());
			return mav;
		}
	}

	@RequestMapping("/entretien/list")
	public ModelAndView getEntretiens() {
		ModelAndView mav = new ModelAndView("entretien/list");
		mav.addObject("menu", MENU);
		Iterable<Entretien> entretiens = entretienRepository.findAll();
		mav.addObject("entretiens", entretiens);
		return mav;
	}

	@RequestMapping("/entretien/detail")
	public ModelAndView getEntretien(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("entretien/detail");
		mav.addObject("menu", MENU);
		Entretien entretien = entretienRepository.findOne(id);
		mav.addObject("entretien", entretien);
		return mav;
	}

	@RequestMapping("/entretien/supprimer")
	public ModelAndView deleteEntretien(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("redirect:/entretien/list");
		Entretien entretien = new Entretien();
		entretien.setId(id);
		entretienRepository.delete(entretien);
		mav.addObject("entretien", entretien);
		return mav;
	}

}
