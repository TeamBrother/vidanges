/**
 * 
 */
package fr.teambrother.web.vidanges.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.teambrother.web.vidanges.bean.Entretien;
import fr.teambrother.web.vidanges.dao.EntretienDAO;

/**
 * Classe contrôleur qu gère mes url de base
 * 
 * @author chinjto
 * @version 1.0
 *
 */
@Controller
public class EntretiensController {

	@Autowired
	private EntretienDAO entretienDAO;

	/**
	 * Méthode qui traite l'url "/entretien"
	 * 
	 * @return
	 */
	@RequestMapping("/entretien/list")
	public ModelAndView getEntretiens() {
		ModelAndView mav = new ModelAndView("entretien/list");
		List<Entretien> entretiens = entretienDAO.lister();
		mav.addObject("entretiens", entretiens);
		return mav;
	}

}
