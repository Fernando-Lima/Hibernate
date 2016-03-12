package br.edu.unoesc.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DAOException extends Exception {

	private static final long serialVersionUID = 5093346828738795858L;
	private String mensagem;

	public DAOException(String mensagem) {
		super();
		this.mensagem = mensagem;
	}

	public DAOException(String mensagem, Throwable t) {
		super(mensagem, t);
		this.mensagem = mensagem;
	}

}
