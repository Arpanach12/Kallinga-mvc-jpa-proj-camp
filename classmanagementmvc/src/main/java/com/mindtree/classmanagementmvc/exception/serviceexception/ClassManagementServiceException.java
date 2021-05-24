package com.mindtree.classmanagementmvc.exception.serviceexception;

import com.mindtree.classmanagementmvc.exception.ClassManagementException;

public class ClassManagementServiceException extends ClassManagementException {

	public ClassManagementServiceException() {
	}

	public ClassManagementServiceException(String description) {
		super(description);
	}

	public ClassManagementServiceException(Throwable description) {
		super(description);
	}

	public ClassManagementServiceException(String description, Throwable cause) {
		super(description, cause);
	}

	public ClassManagementServiceException(String description, Throwable cause, boolean arg2, boolean arg3) {
		super(description, cause, arg2, arg3);
	}

}
