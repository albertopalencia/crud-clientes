package com.nuvu.project.enums;

import lombok.Getter;

import org.springframework.http.HttpStatus;

@Getter
public enum ErrorEnum {
    STORAGE_URL_PUT("050","Error guardando datos",HttpStatus.INTERNAL_SERVER_ERROR),
    STORAGE_URL_GET("051","Error consultando listado de datos",HttpStatus.INTERNAL_SERVER_ERROR),
    STORAGE_URL_GET_LIST("052","Error consultando datos",HttpStatus.INTERNAL_SERVER_ERROR);
	
	private String code;
	private String description;
	private HttpStatus httpCode;
	
	ErrorEnum(String code, String description,HttpStatus httpCode) {
		this.code=code;
		this.description = description;
		this.httpCode = httpCode;
	}

}
