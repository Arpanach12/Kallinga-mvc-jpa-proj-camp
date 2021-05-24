package com.mindtree.igmanagement.exceptions.serviceexceptions;

import com.mindtree.igmanagement.exceptions.IgManagementException;

public class IgManagementServiceException extends IgManagementException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IgManagementServiceException() {
	}

	public IgManagementServiceException(String description) {
		super(description);
	}

	public IgManagementServiceException(Throwable description) {
		super(description);
	}

	public IgManagementServiceException(String description, Throwable arg1) {
		super(description, arg1);
	}

	public IgManagementServiceException(String description, Throwable arg1, boolean arg2, boolean arg3) {
		super(description, arg1, arg2, arg3);
	}

}
