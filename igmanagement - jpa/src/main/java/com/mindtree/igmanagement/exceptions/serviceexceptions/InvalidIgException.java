package com.mindtree.igmanagement.exceptions.serviceexceptions;

public class InvalidIgException extends IgManagementServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidIgException() {
	}

	public InvalidIgException(String description) {
		super(description);
	}

	public InvalidIgException(Throwable description) {
		super(description);
	}

	public InvalidIgException(String description, Throwable arg1) {
		super(description, arg1);
	}

	public InvalidIgException(String description, Throwable arg1, boolean arg2, boolean arg3) {
		super(description, arg1, arg2, arg3);
	}

}
