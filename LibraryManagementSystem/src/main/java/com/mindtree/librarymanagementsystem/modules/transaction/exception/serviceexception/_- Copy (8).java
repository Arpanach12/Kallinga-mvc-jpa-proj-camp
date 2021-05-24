package com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception;

import com.mindtree.librarymanagementsystem.modules.transaction.exception.TransactionApplicationException;

public class TransactionServiceException extends TransactionApplicationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -36937683115673980L;

	public TransactionServiceException() {
		super();
	}

	public TransactionServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public TransactionServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public TransactionServiceException(String arg0) {
		super(arg0);
	}

	public TransactionServiceException(Throwable arg0) {
		super(arg0);
	}

	
}
