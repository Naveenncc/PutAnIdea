package com.learining.data;

import org.springframework.web.multipart.MultipartFile;

public class EditProfileData
{
private String firstName;
private String lastName;
private String phone;
private String email;
private MultipartFile profileimage;
private String pwd;
private String imagePath;
private String date;
public String getDate()
{
	return date;
}
public void setDate(String date)
{
	this.date = date;
}
public String getImagePath()
{
	return imagePath;
}
public void setImagePath(String imagePath)
{
	this.imagePath = imagePath;
}
public String getFirstName()
{
	return firstName;
}
public void setFirstName(String firstName)
{
	this.firstName = firstName;
}
public String getLastName()
{
	return lastName;
}
public void setLastName(String lastName)
{
	this.lastName = lastName;
}
public String getPhone()
{
	return phone;
}
public void setPhone(String phone)
{
	this.phone = phone;
}
public String getEmail()
{
	return email;
}
public void setEmail(String email)
{
	this.email = email;
}
public MultipartFile getProfileimage()
{
	return profileimage;
}
public void setProfileimage(MultipartFile profileimage)
{
	this.profileimage = profileimage;
}
public String getPwd()
{
	return pwd;
}
public void setPwd(String pwd)
{
	this.pwd = pwd;
}

}
