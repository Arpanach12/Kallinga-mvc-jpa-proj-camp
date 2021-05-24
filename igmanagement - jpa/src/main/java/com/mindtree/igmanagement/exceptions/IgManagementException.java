package com.mindtree.igmanagement.exceptions;

public class IgManagementException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IgManagementException() {
	}

	public IgManagementException(String description) {
		super(description);
	}

	public IgManagementException(Throwable description) {
		super(description);
	}

	public IgManagementException(String description, Throwable arg1) {
		super(description, arg1);
	}

	public IgManagementException(String description, Throwable arg1, boolean arg2, boolean arg3) {
		super(description, arg1, arg2, arg3);
	}

}
