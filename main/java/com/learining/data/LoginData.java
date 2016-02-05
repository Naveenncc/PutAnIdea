/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learining.data;

/**
 * The Class LoginData has properties for login model.
 */
public class LoginData
{

	/** The user name. */
	String userName;

	/** The pass word. */
	String passWord;

	/**
	 * Gets the pass word.
	 *
	 * @return the pass word
	 */
	public String getPassWord()
	{
		return passWord;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * Sets the pass word.
	 *
	 * @param passWord
	 *            the new pass word
	 */
	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName
	 *            the new user name
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
}
