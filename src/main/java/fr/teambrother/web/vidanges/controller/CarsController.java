/**
 * 
 */
package fr.teambrother.web.vidanges.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Classe contrôleur qu gère mes url de base
 * 
 * @author chinjto
 * @version 1.0
 *
 */
@Controller
public class CarsController {

	/**
	 * Méthode qui traite l'url "/voitures"
	 * 
	 * @return
	 */
	@RequestMapping("/voiture/list")
	public ModelAndView getCars() {
		ModelAndView mav = new ModelAndView("voiture/list");
		String[] cars = { "Citroen", "Renault", "Peugeot" };
		mav.addObject("voitures", cars);
		return mav;
	}

}
