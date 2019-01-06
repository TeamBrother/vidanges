package fr.teambrother.web.vidanges.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.stereotype.Repository;

@Repository("daoFactory")
public class DAOFactory {

	private static final String FICHIER_PROPERTIES = "dao.properties";
	private static final String PROPERTY_URL = "db.url";
	private static final String PROPERTY_DRIVER = "db.driver";
	private static final String PROPERTY_USER = "db.user";
	private static final String PROPERTY_PASSWORD = "db.password";

	private String url;
	private String username;
	private String password;

	/**
	 * M�thode charg�e de r�cup�rer les informations de connexion � la base de
	 * donn�es, charger le driver JDBC et retourner une instance de la Factory
	 */
	public DAOFactory() throws DAOConfigurationException {
		Properties properties = new Properties();
		String driver;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream fichierProperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);
		if (fichierProperties == null) {
			throw new DAOConfigurationException("Le fichier properties " + FICHIER_PROPERTIES + " est introuvable.");
		}
		try {
			properties.load(fichierProperties);
			url = properties.getProperty(PROPERTY_URL);
			driver = properties.getProperty(PROPERTY_DRIVER);
			username = properties.getProperty(PROPERTY_USER);
			password = properties.getProperty(PROPERTY_PASSWORD);
		} catch (IOException e) {
			throw new DAOConfigurationException("Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e);
		}
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DAOConfigurationException("Le driver est introuvable dans le classpath.", e);
		}
	}

	/**
	 * M�thode charg�e de fournir une connexion � la base de donn�es
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

}
