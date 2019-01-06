/**
 * 
 */
package fr.teambrother.web.vidanges.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Classe contr�leur qu g�re mes url de base
 * 
 * @author chinjto
 * @version 1.0
 *
 */
@Controller
public class AccueilController {

	/**
	 * M�thode qui traite l'url "/"
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView getAccueil(String name) {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}

}
