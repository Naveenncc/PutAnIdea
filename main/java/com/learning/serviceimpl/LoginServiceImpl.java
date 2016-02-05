package com.learning.serviceimpl;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learining.data.EditProfileData;
import com.learining.data.LoginData;
import com.learining.data.RegisterFormData;
import com.learning.dao.LoginDao;
import com.learning.service.LoginService;

@Component
public class LoginServiceImpl implements LoginService
{

	@Autowired
	private LoginDao logindao;

	@Autowired
	private HttpServletRequest request;

	@Override
	public boolean checkEmail(String email)
	{
		// TODO Auto-generated method stub
		return logindao.checkEmail(email);
	}

	@Override
	public RegisterFormData getUserData(String email)
	{
		return logindao.getUserData(email);
	}

	@Override
	public boolean register(RegisterFormData registerFormData)
	{
		final String imagePath = "resources/data/images/default.gif";
		registerFormData.setImagePath(imagePath);
		final boolean registerFlag = logindao.register(registerFormData);
		return registerFlag;
	}

	@Override
	public boolean updateProfile(EditProfileData editProfileData, String email)
	{
		if (!editProfileData.getProfileimage().isEmpty())
		{
			String contentType = "";
			if (editProfileData.getProfileimage().getContentType()
					.equals("image/jpeg"))
			{
				contentType = "jpg";
			}
			else if (editProfileData.getProfileimage().getContentType()
					.equals("image/png"))
			{
				contentType = "png";
			}
			else
			{
				contentType = "gif";
			}
			final String imagePath = "resources/profilepicdata/" + email + "."
					+ contentType;
			final File file = new File(
					"N:/javaprograms/spring/myProject/src/main/webapp/"
							+ imagePath);
			try
			{
				editProfileData.getProfileimage().transferTo(file);
				editProfileData.setImagePath(imagePath);
			}
			catch (final IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		editProfileData.setEmail(email);
		final boolean updateFlag = logindao.updateProfile(editProfileData);
		return updateFlag;
	}

	@Override
	public boolean verifyUser(LoginData loginData)
	{
		final String pwd = logindao.getPasswordForUser(loginData.getUserName());
		boolean flag = false;
		if (null != pwd && pwd.equals(loginData.getPassWord()))
		{
			flag = true;
		}
		return flag;
	}

}