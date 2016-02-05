/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learning.service;

import com.learining.data.EditProfileData;
import com.learining.data.LoginData;
import com.learining.data.RegisterFormData;

/**
 * The Interface LoginService handles login related operation and email
 * validation.
 */
public interface LoginService
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
	 * @param email
	 *            the email
	 * @return true, if successful
	 */
	public boolean updateProfile(EditProfileData editProfileData, String email);

	/**
	 * Verify user.
	 *
	 * @param loginData
	 *            the login data
	 * @return true, if successful
	 */
	public boolean verifyUser(LoginData loginData);
}
