package com.mindtree.classmanagementmvc.exception;

public class ClassManagementException extends Exception {

	public ClassManagementException() {
	}

	public ClassManagementException(String description) {
		super(description);
	}

	public ClassManagementException(Throwable description) {
		super(description);
	}

	public ClassManagementException(String description, Throwable cause) {
		super(description, cause);
	}

	public ClassManagementException(String description, Throwable cause, boolean arg2, boolean arg3) {
		super(description, cause, arg2, arg3);
	}

}
