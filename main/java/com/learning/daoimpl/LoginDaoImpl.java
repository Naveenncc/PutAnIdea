/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learning.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learining.data.EditProfileData;
import com.learining.data.RegisterFormData;
import com.learning.dao.LoginDao;

/**
 * The Class LoginDaoImpl handles login operations.
 */
public class LoginDaoImpl extends DataBaseConnectimpl implements LoginDao
{

	/** The con. */
	private final Connection con = connectDataBase();

	/*
	 * (non-Javadoc)
	 *
	 * @see com.learning.dao.LoginDao#checkEmail(java.lang.String)
	 */
	@Override
	public boolean checkEmail(String email)
	{
		PreparedStatement statement = null;
		final String sql = "SELECT EMAIL FROM CUSTOMER WHERE EMAIL=?";
		try
		{

			statement = con.prepareStatement(sql);
			statement.setString(1, email);
			final ResultSet rs = statement.executeQuery();
			if (rs.next())
			{
				return true;
			}
		}
		catch (final SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.learning.dao.LoginDao#getPasswordForUser(java.lang.String)
	 */
	@Override
	public String getPasswordForUser(String userName)
	{

		PreparedStatement statement = null;
		String pwd = null;
		final String sql = "select PWD from customer where EMAIL=?";
		try
		{

			statement = con.prepareStatement(sql);
			statement.setString(1, userName);
			final ResultSet rs = statement.executeQuery();

			while (rs.next())
			{
				pwd = rs.getString("PWD");
			}
		}
		catch (final SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pwd;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.learning.dao.LoginDao#getUserData(java.lang.String)
	 */
	@Override
	public RegisterFormData getUserData(String email)
	{
		final RegisterFormData userData = new RegisterFormData();
		PreparedStatement statement = null;
		final String sql = "SELECT * FROM CUSTOMER WHERE EMAIL=?";
		try
		{

			statement = con.prepareStatement(sql);
			statement.setString(1, email);
			final ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				userData.setPassword(rs.getString("PWD"));
				userData.setEmail(rs.getString("EMAIL"));
				userData.setDate(rs.getString("DOB"));
				userData.setFirstName(rs.getString("FIRSTNAME"));
				userData.setLastName(rs.getString("LASTNAME"));
				userData.setPhone(rs.getString("PHONE"));
				userData.setImagePath(rs.getString("PROFILEPIC"));
			}
		}
		catch (final SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return userData;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.learning.dao.LoginDao#register(com.learining.data.RegisterFormData)
	 */
	@Override
	public boolean register(RegisterFormData registerFormData)
	{
		PreparedStatement statement = null;
		final String sql = "INSERT INTO CUSTOMER (EMAIL, PWD, FIRSTNAME, LASTNAME, DOB, PHONE, PROFILEPIC)"
				+ " VALUES (?,?,?,?,?,?,?)";
		try
		{

			statement = con.prepareStatement(sql);
			statement.setString(1, registerFormData.getEmail());
			statement.setString(2, registerFormData.getPassword());
			statement.setString(3, registerFormData.getFirstName());
			statement.setString(4, registerFormData.getLastName());
			statement.setString(5, registerFormData.getDate());
			statement.setString(6, registerFormData.getPhone());
			statement.setString(7, registerFormData.getImagePath());
			statement.executeQuery();
		}
		catch (final SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.learning.dao.LoginDao#updateProfile(com.learining.data.EditProfileData
	 * )
	 */
	@Override
	public boolean updateProfile(EditProfileData editProfileData)
	{
		PreparedStatement statement = null;
		boolean successFlag = true;
		final String sql = "UPDATE CUSTOMER SET PROFILEPIC = COALESCE(?,PROFILEPIC),PHONE = COALESCE(?,PHONE),DOB = COALESCE(?,DOB),PWD = COALESCE(?,PWD) WHERE EMAIL=?";
		try
		{

			statement = con.prepareStatement(sql);
			statement.setString(1, editProfileData.getImagePath());
			statement.setString(2, editProfileData.getPhone());
			statement.setString(3, editProfileData.getDate());
			statement.setString(4, editProfileData.getPwd());
			statement.setString(5, editProfileData.getEmail());
			statement.executeQuery();
		}
		catch (final SQLException e)
		{
			// TODO Auto-generated catch block
			successFlag = false;
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return successFlag;

	}
}
