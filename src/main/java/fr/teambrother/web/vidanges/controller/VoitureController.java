/**
 * 
 */
package fr.teambrother.web.vidanges.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.teambrother.web.vidanges.bean.Voiture;
import fr.teambrother.web.vidanges.repository.EntretienRepository;
import fr.teambrother.web.vidanges.repository.VoitureRepository;

/**
 * Classe contr�leur qu g�re mes url de base
 * 
 * @author chinjto
 * @version 1.0
 *
 */
@Controller
public class VoitureController {

	private static final String MENU = "voiture";

	@Autowired
	private VoitureRepository voitureRepository;

	@Autowired
	private EntretienRepository entretienRepository;

	@RequestMapping("/voiture/list")
	public ModelAndView getVoitures() {
		ModelAndView mav = new ModelAndView("voiture/list");
		mav.addObject("menu", MENU);
		mav.addObject("voitures", voitureRepository.findAll());
		return mav;
	}

	@RequestMapping("/voiture/detail")
	public ModelAndView getVoiture(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("voiture/detail");
		mav.addObject("menu", MENU);
		Voiture voiture = voitureRepository.findById(id).get();
		mav.addObject("voiture", voiture);
		mav.addObject("entretiens", entretienRepository.findByVoiture(voiture));
		return mav;
	}

}
