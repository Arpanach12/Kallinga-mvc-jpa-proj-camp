package com.mindtree.igmanagement.exceptions.serviceexceptions;

public class TotalProjectRevenueExceedsAccountRevenueException extends IgManagementServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TotalProjectRevenueExceedsAccountRevenueException() {
	}

	public TotalProjectRevenueExceedsAccountRevenueException(String description) {
		super(description);
	}

	public TotalProjectRevenueExceedsAccountRevenueException(Throwable description) {
		super(description);
	}

	public TotalProjectRevenueExceedsAccountRevenueException(String description, Throwable arg1) {
		super(description, arg1);
	}

	public TotalProjectRevenueExceedsAccountRevenueException(String description, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(description, arg1, arg2, arg3);
	}

}
