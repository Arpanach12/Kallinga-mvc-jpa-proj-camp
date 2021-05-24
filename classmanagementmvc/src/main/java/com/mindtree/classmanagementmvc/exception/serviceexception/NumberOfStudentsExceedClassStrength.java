package com.mindtree.classmanagementmvc.exception.serviceexception;

public class NumberOfStudentsExceedClassStrength extends ClassManagementServiceException {

	public NumberOfStudentsExceedClassStrength() {
	}

	public NumberOfStudentsExceedClassStrength(String description) {
		super(description);
	}

	public NumberOfStudentsExceedClassStrength(Throwable description) {
		super(description);
	}

	public NumberOfStudentsExceedClassStrength(String description, Throwable cause) {
		super(description, cause);
	}

	public NumberOfStudentsExceedClassStrength(String description, Throwable cause, boolean arg2, boolean arg3) {
		super(description, cause, arg2, arg3);
	}

}
