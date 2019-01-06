package fr.teambrother.web.vidanges.dao;

public class DAOConfigurationException extends RuntimeException {

	/** Numéro de série généré aléatoirement. **/
	private static final long serialVersionUID = 5597449513087065946L;

	public DAOConfigurationException(String message) {
		super(message);
	}

	public DAOConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOConfigurationException(Throwable cause) {
		super(cause);
	}

}