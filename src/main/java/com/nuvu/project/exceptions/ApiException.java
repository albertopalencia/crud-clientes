package com.nuvu.project.exceptions;


import com.nuvu.project.enums.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiException extends RuntimeException{

	 private ErrorEnum error;
}
