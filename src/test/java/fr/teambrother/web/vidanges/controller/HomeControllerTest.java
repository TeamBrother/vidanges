package fr.teambrother.web.vidanges.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import fr.teambrother.web.vidanges.constant.ModelConstants;
import fr.teambrother.web.vidanges.constant.ViewConstants;

/**
 * Test de la classe {@link HomeController}.
 * 
 * @author chinjto
 * @version 1.0
 */
class HomeControllerTest {

	/**
	 * Une instance de la classe à tester.
	 */
	private static HomeController controller;

	/**
	 * Initialisation de l'instance à tester.
	 */
	@BeforeAll
	static void init() {
		controller = new HomeController();
	}

	/**
	 * Test de la méthode {@link HomeController#getHome(String)}.
	 */
	@Test
	void testGetHome() {

		// Doit contenir le nom à tester
		String name = null;
		// Doit contenir le model and view retourné
		ModelAndView mav = null;
		// Doit contenir le model retourné
		Map<String, Object> model = null;
		// Doit contenir le nom affiché
		String nom = null;

		// Premier test avec le paramère "name" renseigné
		name = "Chinjto";
		mav = controller.getHome(name);
		assertEquals(mav.getViewName(), ViewConstants.VIEW_NAME_HOME);
		model = mav.getModel();
		assertTrue(model.containsKey(ModelConstants.KEY_NOM));
		nom = (String) model.get(ModelConstants.KEY_NOM);
		assertEquals(name, nom);

		// Second test avecle paramètre "name" non renseigné
		name = null;
		mav = controller.getHome(name);
		assertEquals(mav.getViewName(), ViewConstants.VIEW_NAME_HOME);
		model = mav.getModel();
		assertTrue(model.containsKey(ModelConstants.KEY_NOM));
		nom = (String) model.get(ModelConstants.KEY_NOM);
		assertEquals(name, nom);

	}

}
