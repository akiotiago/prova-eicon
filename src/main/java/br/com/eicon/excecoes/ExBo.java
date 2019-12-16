package br.com.eicon.excecoes;

public class ExBo extends RuntimeException {

	private static final long serialVersionUID = -3418463965393059044L;

	public ExBo() {
		super();
	}

	public ExBo(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExBo(String message, Throwable cause) {
		super(message, cause);
	}

	public ExBo(String message) {
		super(message);
	}

	public ExBo(Throwable cause) {
		super(cause);
	}
	
}
