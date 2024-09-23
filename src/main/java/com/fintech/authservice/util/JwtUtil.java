package com.fintech.authservice.util;

import java.util.Date;

import com.fintech.authservice.constant.AppConstant;
import com.fintech.authservice.exception.ErrorDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fintech.authservice.exception.JwtTokenMalformedException;
import com.fintech.authservice.exception.JwtTokenMissingException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.token.validity}")
	private long tokenValidity;

	public Claims getClaims(final String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
			return body;
		} catch (Exception e) {
			System.out.println(e.getMessage() + " => " + e);
		}
		return null;
	}

	public String generateToken(String id) {
		Claims claims = Jwts.claims().setSubject(id);
		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + tokenValidity;
		Date exp = new Date(expMillis);
		return Jwts.builder().setClaims(claims).setIssuedAt(new Date(nowMillis)).setExpiration(exp)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public void validateToken(final String token) throws JwtTokenMalformedException, JwtTokenMissingException {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
		} catch (SignatureException ex) {
			throw new JwtTokenMalformedException(new ErrorDetails(AppConstant.TOKEN_INVALID, AppConstant.ERROR_TYPE_CODE_VALIDATION,
					AppConstant.ERROR_TYPE_VALIDATION,"Invalid JWT signature"));
		} catch (MalformedJwtException ex) {
			throw new JwtTokenMalformedException(new ErrorDetails(AppConstant.TOKEN_INVALID, AppConstant.ERROR_TYPE_CODE_VALIDATION,
					AppConstant.ERROR_TYPE_VALIDATION,"Invalid JWT token"));
		} catch (ExpiredJwtException ex) {
			throw new JwtTokenMalformedException(new ErrorDetails(AppConstant.TOKEN_EXPIRED, AppConstant.ERROR_TYPE_CODE_VALIDATION,
					AppConstant.ERROR_TYPE_VALIDATION,"Expired JWT token"));
		} catch (UnsupportedJwtException ex) {
			throw new JwtTokenMalformedException(new ErrorDetails(AppConstant.TOKEN_INVALID, AppConstant.ERROR_TYPE_CODE_VALIDATION,
					AppConstant.ERROR_TYPE_VALIDATION,"Unsupported JWT token"));
		} catch (IllegalArgumentException ex) {
			throw new JwtTokenMissingException(new ErrorDetails(AppConstant.TOKEN_EMPTY, AppConstant.ERROR_TYPE_CODE_VALIDATION,
					AppConstant.ERROR_TYPE_VALIDATION,"JWT claims string is empty."));
		}
	}

}
