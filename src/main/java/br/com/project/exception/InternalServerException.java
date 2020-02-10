package br.com.project.exception;
public class InternalServerException extends RuntimeException{

	private static final long serialVersionUID = 5000349070832946751L;

	public InternalServerException(final String message) {
		super(message);
	}
}