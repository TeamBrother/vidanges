/**
 * 
 */
package fr.teambrother.web.vidanges.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Classe contr�leur qu g�re mes url de base
 * 
 * @author chinjto
 * @version 1.0
 *
 */
@Controller
public class HomeController {

	/**
	 * M�thode qui traite l'url "/"
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView getHome(@RequestParam(value = "nom", defaultValue = "World") String name) {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("nom", name);
		return mav;
	}

}
