package com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception;

public class NoRequestPresentException extends TransactionServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8283544291945302875L;

	public NoRequestPresentException() {
		super();
	}

	public NoRequestPresentException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public NoRequestPresentException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoRequestPresentException(String arg0) {
		super(arg0);
	}

	public NoRequestPresentException(Throwable arg0) {
		super(arg0);
	}
	
	
}
