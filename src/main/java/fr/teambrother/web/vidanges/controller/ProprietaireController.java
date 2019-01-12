
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
import fr.teambrother.web.vidanges.dao.ProprietaireDAO;

/**
 * Classe contrôleur qu gère les url de base
 * 
 * 
 * @version 1.0
 *
 */
@Controller
public class ProprietaireController {

	@Autowired
	private ProprietaireDAO proprietaireDAO;

	@RequestMapping("/proprietaire/list")
	public ModelAndView getProprietaires() {
		ModelAndView mav = new ModelAndView("proprietaire/list");
		List<Proprietaire> proprietaires = proprietaireDAO.lister();
		mav.addObject("proprietaires", proprietaires);
		return mav;
	}

	@RequestMapping("/proprietaire/detail")
	public ModelAndView getVoiture(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("proprietaire/detail");
		Proprietaire proprietaire = proprietaireDAO.trouver(id);
		mav.addObject("proprietaire", proprietaire);
		return mav;
	}

}
