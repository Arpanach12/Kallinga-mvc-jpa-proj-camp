package com.mindtree.librarymanagementsystem.security.jwt;

import static com.mindtree.librarymanagementsystem.security.constant.SecurityConstant.APP_SECRET_KEY;
import static com.mindtree.librarymanagementsystem.security.constant.SecurityConstant.EXPIRATION_TIME;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.mindtree.librarymanagementsystem.security.entity.LMSUserDetail;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * @author M1049006
 *
 */
@Component
public class JwtTokenProvider {

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

/*==================================GENERATING THE TOKEN STARTS==================================*/
	
	public String generateToken(Authentication auth) {
		LMSUserDetail user = (LMSUserDetail)auth.getPrincipal();
		Date now = new Date(System.currentTimeMillis());
		//Getting the EXPIRATION_TIME from constant file
		Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
		//Since we cannot store long in the token, we parse it to String.
		String userId = Long.toString(user.getUserId());
		
		
		Map<String, Object> claimsUserDetails = new HashMap<String, Object>();
		claimsUserDetails.put("id", userId);
		claimsUserDetails.put("username", user.getUsername());
		claimsUserDetails.put("fullName", user.getFullName());
		
		logger.debug("-----TOKEN GENERATED-----");
		//-> This will be generating the JWT Token for us when we provide a valid username and password
		return Jwts.builder()
				   .setSubject(userId)
				   .setClaims(claimsUserDetails)
				   .setIssuedAt(now)
				   .setExpiration(expiryDate)
				   .signWith(SignatureAlgorithm.HS512, APP_SECRET_KEY)
				   .compact();
	}
	 
	/*==================================GENERATING THE TOKEN ENDS==================================*/
	
/*==================================VALIDATING THE TOKEN STARTS==================================*/
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser()
				.setSigningKey(APP_SECRET_KEY)
				.parse(token);
			return true;
		} catch (SignatureException ex) {
			logger.debug("Invalid JWT Signature");
		} catch (MalformedJwtException ex) {
			logger.debug("Invalid JWT Token");
		} catch (ExpiredJwtException ex) {
			logger.debug("Expired JWT Token");
		} catch (UnsupportedJwtException EX) {
			logger.debug("Unsupported JWT Token");
		} catch (IllegalArgumentException ex) {
			logger.debug("JWT Claims string is empty!");
		}
		return false;
	}
	
	
	/*==================================VALIDATING THE TOKEN ENDS==================================*/
	
	/*==================================GETTING THE USER ID FROM TOKEN STARTS==================================*/
	
	public String getUserNameFromJwt(String token) {
		Claims claim = Jwts.parser()
						   .setSigningKey(APP_SECRET_KEY)
						   .parseClaimsJws(token)
						   .getBody();
		String id = (String)claim.get("username");
		return id;
	}
	
	/*==================================GETTING THE USER ID FROM TOKEN ENDS==================================*/
	
}
