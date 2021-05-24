package com.mindtree.igmanagement.exceptions.controllerexception;

import com.mindtree.igmanagement.exceptions.IgManagementException;

public class IgManagementControllerException extends IgManagementException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IgManagementControllerException() {
	}

	public IgManagementControllerException(String description) {
		super(description);
	}

	public IgManagementControllerException(Throwable description) {
		super(description);
	}

	public IgManagementControllerException(String description, Throwable arg1) {
		super(description, arg1);
	}

	public IgManagementControllerException(String description, Throwable arg1, boolean arg2, boolean arg3) {
		super(description, arg1, arg2, arg3);
	}

}
