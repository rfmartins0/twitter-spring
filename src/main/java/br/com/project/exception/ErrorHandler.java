package br.com.project.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.gson.Gson;

import feign.FeignException;

@RestControllerAdvice
public class ErrorHandler {



	@ResponseBody
	@ExceptionHandler(ValidateException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String validateExceptionHandler(final ValidateException ex) {
		final ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
		String json = new Gson().toJson(errorDetails);
		return json.toString();
	}
	
	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String notFoundExceptionHandler(final NotFoundException ex) {
		final ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
		String json = new Gson().toJson(errorDetails);
		return json.toString();
	}
	
	@ResponseBody
	@ExceptionHandler(InternalServerException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String internalServerExceptionHandler(final InternalServerException ex) {
		final ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
		String json = new Gson().toJson(errorDetails);
		return json.toString();
	}

	@ResponseBody
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public String validateExceptionHandler(final DataIntegrityViolationException ex) {
		final ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
		String json = new Gson().toJson(errorDetails);
		return json.toString();
	}

	@ResponseBody
	@ExceptionHandler(FeignException.BadRequest.class)  
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleFeignStatusException(FeignException e, HttpServletResponse response) {
        response.setStatus(e.status());
        String json = new Gson().toJson(e.contentUTF8());
        return json.toString();
    }

}