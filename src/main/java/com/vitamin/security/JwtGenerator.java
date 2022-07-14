package com.vitamin.security;

import java.util.UUID;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	public String generate(JwtUser jwtUser) {

		Claims claims = Jwts.claims().setSubject(jwtUser.getUsername());

		claims.put("userId", String.valueOf(jwtUser.getId()));
		claims.put("role", jwtUser.getRole());

		String id = UUID.randomUUID().toString().replace("-", "");
        /*Date now = new Date();
        Date exp = new Date(System.currentTimeMillis() + (1000*30)); // 30 seconds
*/		
		return Jwts.builder().setId(id)
                /*.setIssuedAt(now)
                .setNotBefore(now)
                .setExpiration(exp)*/
				.setClaims(claims).signWith(SignatureAlgorithm.HS512, "OOVI_SECRET").compact();
	}

}
