package com.code9.beershop.exception;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseBody> handleValidationExceptions(
		MethodArgumentNotValidException ex) {
		HttpStatus responseStatus = HttpStatus.BAD_REQUEST;
		ErrorResponseBody body = ErrorResponseBody.builder()
			.errors(extractErrorMessages(ex))
			.statusCode(responseStatus)
			.build();
		return new ResponseEntity<>(body, responseStatus);
	}

	private List<String> extractErrorMessages(final MethodArgumentNotValidException ex) {
		List<String> response = new ArrayList<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			response.add(error.getDefaultMessage());
		});
		return response;
	}

}
