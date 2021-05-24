package com.mindtree.librarymanagementsystem.modules.transaction.exception;

public class TransactionApplicationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3129378096601349163L;

	public TransactionApplicationException() {
		super();
	}

	public TransactionApplicationException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public TransactionApplicationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public TransactionApplicationException(String arg0) {
		super(arg0);
	}

	public TransactionApplicationException(Throwable arg0) {
		super(arg0);
	}
	
	
}
