
/**
 * 
 */
package fr.teambrother.web.vidanges.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.teambrother.web.vidanges.bean.Proprietaire;
import fr.teambrother.web.vidanges.repository.ProprietaireRepository;
import fr.teambrother.web.vidanges.repository.VoitureRepository;

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
	private ProprietaireRepository proprietaireRepository;

	@Autowired
	private VoitureRepository voitureRepository;

	@RequestMapping("/proprietaire/list")
	public ModelAndView getProprietaires() {
		ModelAndView mav = new ModelAndView("proprietaire/list");
		mav.addObject("menu", MENU);
		mav.addObject("proprietaires", proprietaireRepository.findAll());
		return mav;
	}

	@RequestMapping("/proprietaire/detail")
	public ModelAndView getProprietaire(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("proprietaire/detail");
		mav.addObject("menu", MENU);
		Proprietaire proprietaire = proprietaireRepository.findById(id).get();
		mav.addObject("proprietaire", proprietaire);
		mav.addObject("voitures", voitureRepository.findByProprietaire(proprietaire));
		return mav;
	}

}
