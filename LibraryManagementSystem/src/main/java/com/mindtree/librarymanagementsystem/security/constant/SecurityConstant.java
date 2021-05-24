package com.mindtree.librarymanagementsystem.security.constant;

/**
 * @author M1049006
 *
 */
public class SecurityConstant {
	/*
	 * :::::::::::::::::::::::::::::::::JWT TOKEN CONSTANTS START:::::::::::::::::::::::::::::::::
	 */
	public static final String APP_SECRET_KEY = "SecretKeyToGenerateJWT";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final long EXPIRATION_TIME = 300_00000000L;
	/*
	 * :::::::::::::::::::::::::::::::::JWT TOKEN CONSTANTS END:::::::::::::::::::::::::::::::::::
	 */
}
