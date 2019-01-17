/**
 * 
 */
package fr.teambrother.web.vidanges.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.teambrother.web.vidanges.bean.Entretien;
import fr.teambrother.web.vidanges.bean.Voiture;
import fr.teambrother.web.vidanges.dao.EntretienDAO;
import fr.teambrother.web.vidanges.dao.VoitureDAO;

/**
 * Classe contrôleur qu gère mes url de base
 * 
 * @author chinjto
 * @version 1.0
 *
 */
@Controller
public class VoituresController {

	@Autowired
	private VoitureDAO voitureDAO;

	@Autowired
	private EntretienDAO entretienDao;

	@RequestMapping("/voiture/list")
	public ModelAndView getVoitures() {
		ModelAndView mav = new ModelAndView("voiture/list");
		List<Voiture> voitures = voitureDAO.lister();
		mav.addObject("voitures", voitures);
		return mav;
	}

	@RequestMapping("/voiture/detail")
	public ModelAndView getVoiture(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("voiture/detail");
		Voiture voiture = voitureDAO.trouver(id);
		List<Entretien> entretiens = entretienDao.listerParVoiture(voiture);
		mav.addObject("voiture", voiture);
		mav.addObject("entretiens", entretiens);
		return mav;
	}

}
