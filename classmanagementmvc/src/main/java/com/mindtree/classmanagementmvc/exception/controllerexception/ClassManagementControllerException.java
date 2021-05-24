package com.mindtree.classmanagementmvc.exception.controllerexception;

import com.mindtree.classmanagementmvc.exception.ClassManagementException;

public class ClassManagementControllerException extends ClassManagementException {

	public ClassManagementControllerException() {
	}

	public ClassManagementControllerException(String description) {
		super(description);
	}

	public ClassManagementControllerException(Throwable description) {
		super(description);
	}

	public ClassManagementControllerException(String description, Throwable cause) {
		super(description, cause);
	}

	public ClassManagementControllerException(String description, Throwable cause, boolean arg2, boolean arg3) {
		super(description, cause, arg2, arg3);
	}

}
