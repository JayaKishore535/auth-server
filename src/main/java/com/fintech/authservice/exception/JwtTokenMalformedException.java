package com.fintech.authservice.exception;

import javax.naming.AuthenticationException;

public class JwtTokenMalformedException extends AuthenticationException {

	private static final long serialVersionUID = 1L;


	private ErrorDetails errorDetails;
	private Throwable throwable;

	public JwtTokenMalformedException(ErrorDetails errorDetails,Throwable throwable) {
		super();
		this.errorDetails = errorDetails;
		this.throwable = throwable;
	}

	public JwtTokenMalformedException(ErrorDetails errorDetails) {
		super();
		this.errorDetails = errorDetails;
		this.throwable = null;
	}

	public ErrorDetails getErrorDetails() {
		return errorDetails;
	}

	public Throwable getThrowable() {
		return throwable;
	}


}
