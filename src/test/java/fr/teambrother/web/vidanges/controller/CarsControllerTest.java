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
 * Test de la classe {@link CarsController}.
 * 
 * @author chinjto
 * @version 1.0
 */
class CarsControllerTest {

	/**
	 * Une instance de la classe à tester.
	 */
	private static CarsController controller;

	/**
	 * Initialisation de l'instance à tester.
	 */
	@BeforeAll
	static void init() {
		controller = new CarsController();
	}

	/**
	 * Test de la méthode {@link CarsController#getCars()}.
	 */
	@Test
	void testGetCars() {
		ModelAndView mav = controller.getCars();
		assertEquals(mav.getViewName(), ViewConstants.VIEW_NAME_LIST_VOITURES);
		Map<String, Object> model = mav.getModel();
		assertTrue(model.containsKey(ModelConstants.KEY_VOITURES));
	}

}
