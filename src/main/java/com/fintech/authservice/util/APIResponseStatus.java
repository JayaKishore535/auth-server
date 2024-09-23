package com.fintech.authservice.util;

import lombok.Data;

@Data
public class APIResponseStatus {

	private int statusCode;
	private String message;
	private Integer errorCode;
	private String errorType = null;
}
	