package com.mindtree.adminusermvc.exception;

public class AdminUserException extends Exception {

	public AdminUserException() {

	}

	public AdminUserException(String description) {
		super(description);
	
	}

	public AdminUserException(Throwable description) {
		super(description);
	
	}

	public AdminUserException(String description, Throwable cause) {
		super(description, cause);
	
	}

	public AdminUserException(String description, Throwable cause, boolean arg2, boolean arg3) {
		super(description, cause, arg2, arg3);
	
	}

}
