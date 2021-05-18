package com.nuvu.project.exceptions;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class GlobalControllerAdvice
{

	 @ExceptionHandler(Throwable.class) 
	    public ResponseEntity<ApiException> problem(final Throwable e) {
		 	e.printStackTrace();
			List<GeneralErrorResponse> r = new ArrayList<>();
			r.add(new GeneralErrorResponse("000", e.getMessage()));


			return new ResponseEntity(r, HttpStatus.INTERNAL_SERVER_ERROR);
	    }



	    @ExceptionHandler(ApiException.class)
	    public ResponseEntity<ApiException> handleApiException(ApiException ex) {
			List<GeneralErrorResponse> r = new ArrayList<>();
			r.add(new GeneralErrorResponse(ex.getError().getCode(), ex.getError().getDescription()));
			return new ResponseEntity(r, ex.getError().getHttpCode());
	    }
   
}
