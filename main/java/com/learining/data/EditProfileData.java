/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learining.data;

import org.springframework.web.multipart.MultipartFile;

/**
 * The Class EditProfileData contains attributes for editing profile.
 */
public class EditProfileData
{

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The phone. */
	private String phone;

	/** The email. */
	private String email;

	/** The profileimage. */
	private MultipartFile profileimage;

	/** The pwd. */
	private String pwd;

	/** The image path. */
	private String imagePath;

	/** The date. */
	private String date;

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate()
	{
		return date;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * Gets the image path.
	 *
	 * @return the image path
	 */
	public String getImagePath()
	{
		return imagePath;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone()
	{
		return phone;
	}

	/**
	 * Gets the profileimage.
	 *
	 * @return the profileimage
	 */
	public MultipartFile getProfileimage()
	{
		return profileimage;
	}

	/**
	 * Gets the pwd.
	 *
	 * @return the pwd
	 */
	public String getPwd()
	{
		return pwd;
	}

	/**
	 * Sets the date.
	 *
	 * @param date
	 *            the new date
	 */
	public void setDate(String date)
	{
		this.date = date;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * Sets the image path.
	 *
	 * @param imagePath
	 *            the new image path
	 */
	public void setImagePath(String imagePath)
	{
		this.imagePath = imagePath;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone
	 *            the new phone
	 */
	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	/**
	 * Sets the profileimage.
	 *
	 * @param profileimage
	 *            the new profileimage
	 */
	public void setProfileimage(MultipartFile profileimage)
	{
		this.profileimage = profileimage;
	}

	/**
	 * Sets the pwd.
	 *
	 * @param pwd
	 *            the new pwd
	 */
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

}
