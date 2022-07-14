package com.vitamin.security;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	private String secret = "OOVI_SECRET";

	public JwtUser validate(String token) {

		JwtUser jwtUser = null;
		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

			jwtUser = new JwtUser();

			jwtUser.setUsername(body.getSubject());
			jwtUser.setId(Integer.parseInt((String) body.get("userId")));

			jwtUser.setRole((String) body.get("role"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jwtUser;

	}

}
