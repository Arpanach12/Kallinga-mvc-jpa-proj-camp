package com.mindtree.adminusermvc.exception;

public class AdminUserServiceException extends AdminUserException {

	public AdminUserServiceException() {
	}

	public AdminUserServiceException(String description) {
		super(description);
	}

	public AdminUserServiceException(Throwable description) {
		super(description);
	}

	public AdminUserServiceException(String description, Throwable cause) {
		super(description, cause);
	}

	public AdminUserServiceException(String description, Throwable cause, boolean arg2, boolean arg3) {
		super(description, cause, arg2, arg3);
	}

}
