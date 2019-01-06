package fr.teambrother.web.vidanges.dao;

public class DAOException extends RuntimeException {

	/** Num�ro de s�rie g�n�r� al�atoirement. **/
	private static final long serialVersionUID = 8514988950249470495L;

	public DAOException(String message) {
		super(message);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

}