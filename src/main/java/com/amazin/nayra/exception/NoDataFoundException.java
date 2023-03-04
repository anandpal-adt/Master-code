package com.amazin.nayra.exception;

public class NoDataFoundException extends RuntimeException {

private static final long serialVersionUID = 1L;
public static final String HttpStatus = null;
public static final String NULL_DAO = null;
public static final String DATA_ACCESS_ERROR = null;
	
	public NoDataFoundException(String message) {
		super(message);
	}
	
	
	
}


