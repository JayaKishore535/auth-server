package com.fintech.authservice.util;

import lombok.Data;

@Data
public class APIResponse {
	private APIResponseStatus responseStatus;
	private Object responseData;
}