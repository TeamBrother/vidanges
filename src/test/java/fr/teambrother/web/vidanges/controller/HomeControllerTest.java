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
	 * Une instance de la classe � tester.
	 */
	private static HomeController controller;

	/**
	 * Initialisation de l'instance � tester.
	 */
	@BeforeAll
	static void init() {
		controller = new HomeController();
	}

	/**
	 * Test de la m�thode {@link HomeController#getHome(String)}.
	 */
	@Test
	void testGetHome() {

		// Doit contenir le nom � tester
		String name = null;
		// Doit contenir le model and view retourn�
		ModelAndView mav = null;
		// Doit contenir le model retourn�
		Map<String, Object> model = null;
		// Doit contenir le nom affich�
		String nom = null;

		// Premier test avec le param�re "name" renseign�
		name = "Chinjto";
		mav = controller.getHome(name);
		assertEquals(mav.getViewName(), ViewConstants.VIEW_NAME_HOME);
		model = mav.getModel();
		assertTrue(model.containsKey(ModelConstants.KEY_NOM));
		nom = (String) model.get(ModelConstants.KEY_NOM);
		assertEquals(name, nom);

		// Second test avecle param�tre "name" non renseign�
		name = null;
		mav = controller.getHome(name);
		assertEquals(mav.getViewName(), ViewConstants.VIEW_NAME_HOME);
		model = mav.getModel();
		assertTrue(model.containsKey(ModelConstants.KEY_NOM));
		nom = (String) model.get(ModelConstants.KEY_NOM);
		assertEquals(name, nom);

	}

}
