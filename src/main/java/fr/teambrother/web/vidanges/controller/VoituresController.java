/**
 * 
 */
package fr.teambrother.web.vidanges.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.teambrother.web.vidanges.bean.Voiture;
import fr.teambrother.web.vidanges.dao.DAOFactory;

/**
 * Classe contrôleur qu gère mes url de base
 * 
 * @author chinjto
 * @version 1.0
 *
 */
@Controller
public class VoituresController {

	/**
	 * Méthode qui traite l'url "/voitures"
	 * 
	 * @return
	 */
	@RequestMapping("/voiture/list")
	public ModelAndView getVoitures() {
		ModelAndView mav = new ModelAndView("voiture/list");
		DAOFactory daoFactory = DAOFactory.getInstance();
		List<Voiture> voitures = daoFactory.getVoitureDAO().lister();
		mav.addObject("voitures", voitures);
		return mav;
	}

}
