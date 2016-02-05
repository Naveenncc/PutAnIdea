package com.learning.dao;

import com.learining.data.EditProfileData;
import com.learining.data.RegisterFormData;

public interface LoginDao {
	
public String getPasswordForUser(String userName);
public boolean register(RegisterFormData registerFormData);
public boolean checkEmail(String email);
public RegisterFormData getUserData(String email);
public boolean updateProfile(EditProfileData editProfileData);
}
