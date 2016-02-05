/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learining.data;

import java.util.List;

/**
 * The Class ValidationResponse contains validation response data.
 */
public class ValidationResponse
{

	/** The status. */
	private String status;

	/** The error message list. */
	private List errorMessageList;

	/**
	 * Gets the error message list.
	 *
	 * @return the error message list
	 */
	public List getErrorMessageList()
	{
		return errorMessageList;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * Sets the error message list.
	 *
	 * @param errorMessageList
	 *            the new error message list
	 */
	public void setErrorMessageList(List errorMessageList)
	{
		this.errorMessageList = errorMessageList;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}
}
