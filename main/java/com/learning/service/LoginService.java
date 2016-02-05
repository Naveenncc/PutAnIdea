package com.learning.service;

import com.learining.data.EditProfileData;
import com.learining.data.LoginData;
import com.learining.data.RegisterFormData;

public interface LoginService {

	public boolean verifyUser(LoginData loginData);
	public boolean register(RegisterFormData registerFormData);
	public boolean checkEmail(String email);
	public RegisterFormData getUserData(String email);
	public boolean updateProfile(EditProfileData editProfileData, String email);
}
