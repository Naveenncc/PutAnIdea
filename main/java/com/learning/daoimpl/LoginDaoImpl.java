package com.learning.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learining.data.EditProfileData;
import com.learining.data.RegisterFormData;
import com.learning.dao.LoginDao;

public class LoginDaoImpl extends DataBaseConnectimpl implements LoginDao {

	private Connection con = connectDataBase();
	
	@Override
	public String getPasswordForUser(String userName) {
		
		PreparedStatement statement = null;
		String pwd =null;
		String sql = "select PWD from customer where EMAIL=?";
		try {
			
			statement = con.prepareStatement(sql);
			statement.setString(1, userName);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				pwd = rs.getString("PWD");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pwd;
	}

	@Override
	public boolean register(RegisterFormData registerFormData)
	{
		PreparedStatement statement = null;
		String sql = "INSERT INTO CUSTOMER (EMAIL, PWD, FIRSTNAME, LASTNAME, DOB, PHONE, PROFILEPIC)"
				+ " VALUES (?,?,?,?,?,?,?)";
		try {
			
			statement = con.prepareStatement(sql);
			statement.setString(1, registerFormData.getEmail());
			statement.setString(2, registerFormData.getPassword());
			statement.setString(3, registerFormData.getFirstName());
			statement.setString(4, registerFormData.getLastName());
			statement.setString(5, registerFormData.getDate());
			statement.setString(6, registerFormData.getPhone());
			statement.setString(7,registerFormData.getImagePath());
			statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean checkEmail(String email)
	{
		PreparedStatement statement = null;
	String sql = "SELECT EMAIL FROM CUSTOMER WHERE EMAIL=?";
	try {
		
		statement = con.prepareStatement(sql);
		statement.setString(1, email);
		ResultSet rs = statement.executeQuery();
		if(rs.next()){
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	// TODO Auto-generated method stub
	return false;
	}

	@Override
	public RegisterFormData getUserData(String email)
	{
		RegisterFormData userData = new RegisterFormData();
		PreparedStatement statement = null;
	String sql = "SELECT * FROM CUSTOMER WHERE EMAIL=?";
	try {
		
		statement = con.prepareStatement(sql);
		statement.setString(1, email);
		ResultSet rs = statement.executeQuery();
		while(rs.next()){
			userData.setPassword(rs.getString("PWD")); 
			userData.setEmail(rs.getString("EMAIL"));
			userData.setDate(rs.getString("DOB"));
			userData.setFirstName(rs.getString("FIRSTNAME"));
			userData.setLastName(rs.getString("LASTNAME"));
			userData.setPhone(rs.getString("PHONE"));
			userData.setImagePath(rs.getString("PROFILEPIC"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	// TODO Auto-generated method stub
	return userData;
	
	}

	@Override
	public boolean updateProfile(EditProfileData editProfileData)
	{
		PreparedStatement statement = null;
		boolean successFlag = true;
	String sql = "UPDATE CUSTOMER SET PROFILEPIC = COALESCE(?,PROFILEPIC),PHONE = COALESCE(?,PHONE),DOB = COALESCE(?,DOB),PWD = COALESCE(?,PWD) WHERE EMAIL=?";
	try {
		
		statement = con.prepareStatement(sql);
		statement.setString(1,editProfileData.getImagePath());
		statement.setString(2,editProfileData.getPhone());
		statement.setString(3,editProfileData.getDate());
		statement.setString(4,editProfileData.getPwd());
		statement.setString(5,editProfileData.getEmail());
		statement.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		successFlag = false;
		e.printStackTrace();
	}

	// TODO Auto-generated method stub
	return successFlag;
	
	}
}
