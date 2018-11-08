package fr.teambrother.web.vidanges.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.awt.Color;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Test de la classe {@link Voiture}.
 * 
 * @author chinjto
 * @version 1.0
 */
class VoitureTest {

	/**
	 * Une instance de la classe à tester.
	 */
	private static Voiture voiture;

	private static final Color TEST_VALUE_COULEUR = Color.BLACK;
	private static final Date TEST_VALUE_DATE_DERNIER_CT = new Date(System.currentTimeMillis());
	private static final Date TEST_VALUE_DATE_PREMIERE_IMMAT = new Date(System.currentTimeMillis());
	private static final String TEST_VALUE_IMMAT = "AA-111-AA";
	private static final String TEST_VALUE_MARQUE = "Peugeot";

	/**
	 * Initialisation de l'instance à tester.
	 */
	@BeforeAll
	static void init() {
		voiture = new Voiture();
		voiture.setCouleur(TEST_VALUE_COULEUR);
		voiture.setDateDernierControleTechnique(TEST_VALUE_DATE_DERNIER_CT);
		voiture.setDatePremiereImmatriculation(TEST_VALUE_DATE_PREMIERE_IMMAT);
		voiture.setImmatriculation(TEST_VALUE_IMMAT);
		voiture.setMarque(TEST_VALUE_MARQUE);
	}

	@Test
	void testImmatriculation() {
		assertEquals(TEST_VALUE_IMMAT, voiture.getImmatriculation());
		final String immatriculation = "ZZ-999-ZZ";
		voiture.setImmatriculation(immatriculation);
		assertEquals(immatriculation, voiture.getImmatriculation());
		assertNotEquals(TEST_VALUE_IMMAT, voiture.getImmatriculation());
	}

	@Test
	void testDatePremiereImmatriculation() {
		assertEquals(TEST_VALUE_DATE_PREMIERE_IMMAT, voiture.getDatePremiereImmatriculation());
		final Date datePremiereImmatriculation = new Date(System.currentTimeMillis());
		voiture.setDatePremiereImmatriculation(datePremiereImmatriculation);
		assertEquals(datePremiereImmatriculation, voiture.getDatePremiereImmatriculation());
		assertNotEquals(TEST_VALUE_DATE_PREMIERE_IMMAT, voiture.getDatePremiereImmatriculation());
	}

	@Test
	void testDateDernierControleTechnique() {
		assertEquals(TEST_VALUE_DATE_DERNIER_CT, voiture.getDateDernierControleTechnique());
		final Date dateDernierControleTechnique = new Date(System.currentTimeMillis());
		voiture.setDateDernierControleTechnique(dateDernierControleTechnique);
		assertEquals(dateDernierControleTechnique, voiture.getDateDernierControleTechnique());
		assertNotEquals(TEST_VALUE_DATE_DERNIER_CT, voiture.getDateDernierControleTechnique());
	}

	@Test
	void testCouleur() {
		assertEquals(TEST_VALUE_COULEUR, voiture.getCouleur());
		final Color couleur = Color.WHITE;
		voiture.setCouleur(couleur);
		assertEquals(couleur, voiture.getCouleur());
		assertNotEquals(TEST_VALUE_COULEUR, voiture.getCouleur());
	}

	@Test
	void testMarque() {
		assertEquals(TEST_VALUE_MARQUE, voiture.getMarque());
		final String marque = "Citroën";
		voiture.setMarque(marque);
		assertEquals(marque, voiture.getMarque());
		assertNotEquals(TEST_VALUE_MARQUE, voiture.getMarque());
	}

}
