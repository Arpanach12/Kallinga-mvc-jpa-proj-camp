package com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception;

public class NoSuchTokenPresentException extends TransactionServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1746829320368562476L;

	public NoSuchTokenPresentException() {
		super();
	}

	public NoSuchTokenPresentException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public NoSuchTokenPresentException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoSuchTokenPresentException(String arg0) {
		super(arg0);
	}

	public NoSuchTokenPresentException(Throwable arg0) {
		super(arg0);
	}

}
