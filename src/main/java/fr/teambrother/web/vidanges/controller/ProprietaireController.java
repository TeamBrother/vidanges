
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

import fr.teambrother.web.vidanges.bean.Proprietaire;
import fr.teambrother.web.vidanges.bean.Voiture;
import fr.teambrother.web.vidanges.dao.ProprietaireDAO;
import fr.teambrother.web.vidanges.dao.VoitureDAO;

/**
 * Classe contr�leur qu g�re les url de base
 * 
 * 
 * @version 1.0
 *
 */
@Controller
public class ProprietaireController {

	private static final String MENU = "proprietaire";

	@Autowired
	private ProprietaireDAO proprietaireDAO;

	@Autowired
	private VoitureDAO voitureDAO;

	@RequestMapping("/proprietaire/list")
	public ModelAndView getProprietaires() {
		ModelAndView mav = new ModelAndView("proprietaire/list");
		mav.addObject("menu", MENU);
		List<Proprietaire> proprietaires = proprietaireDAO.lister();
		mav.addObject("proprietaires", proprietaires);
		return mav;
	}

	@RequestMapping("/proprietaire/detail")
	public ModelAndView getProprietaire(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("proprietaire/detail");
		mav.addObject("menu", MENU);
		Proprietaire proprietaire = proprietaireDAO.trouver(id);
		List<Voiture> voitures = voitureDAO.listerParProprietaire(proprietaire);
		mav.addObject("proprietaire", proprietaire);
		mav.addObject("voitures", voitures);
		return mav;
	}

}
