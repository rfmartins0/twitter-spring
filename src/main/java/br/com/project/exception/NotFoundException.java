package br.com.project.exception;
public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = -9158955992805570172L;

	public NotFoundException(final String message) {
		super(message);
	}
}