/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learning.dao;

import com.learining.data.EditProfileData;
import com.learining.data.RegisterFormData;

/**
 * The Interface LoginDao handles login operations.
 */
public interface LoginDao
{

	/**
	 * Check email.
	 *
	 * @param email
	 *            the email
	 * @return true, if successful
	 */
	public boolean checkEmail(String email);

	/**
	 * Gets the password for user.
	 *
	 * @param userName
	 *            the user name
	 * @return the password for user
	 */
	public String getPasswordForUser(String userName);

	/**
	 * Gets the user data.
	 *
	 * @param email
	 *            the email
	 * @return the user data
	 */
	public RegisterFormData getUserData(String email);

	/**
	 * Register.
	 *
	 * @param registerFormData
	 *            the register form data
	 * @return true, if successful
	 */
	public boolean register(RegisterFormData registerFormData);

	/**
	 * Update profile.
	 *
	 * @param editProfileData
	 *            the edit profile data
	 * @return true, if successful
	 */
	public boolean updateProfile(EditProfileData editProfileData);
}
