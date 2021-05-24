package com.mindtree.librarymanagementsystem.modules.user.exception.service;

import com.mindtree.librarymanagementsystem.modules.user.exception.UserException;

/**
 * @author M1056078
 *
 */
public class NoMoreReissue extends UserException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoMoreReissue() {
		super();
	}

	public NoMoreReissue(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public NoMoreReissue(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoMoreReissue(String arg0) {
		super(arg0);
	}

	public NoMoreReissue(Throwable arg0) {
		super(arg0);
	}

}
