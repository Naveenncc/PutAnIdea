package com.learining.data;

import java.util.List;

public class IdeaSearchData
{
private String id;
private String idea;
private String ideaQuestion;
private String user;
private List<String> category;
private String imagePath;
private String firstName;
private String lastName;
private String likes;
private String dislikes;
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
public String getIdeaQuestion()
{
	return ideaQuestion;
}
public void setIdeaQuestion(String ideaQuestion)
{
	this.ideaQuestion = ideaQuestion;
}
public String getId()
{
	return id;
}
public void setId(String id)
{
	this.id = id;
}
public String getIdea()
{
	return idea;
}
public void setIdea(String idea)
{
	this.idea = idea;
}
public String getUser()
{
	return user;
}
public void setUser(String user)
{
	this.user = user;
}

public List<String> getCategory()
{
	return category;
}
public void setCategory(List<String> category)
{
	this.category = category;
}
public String getImagePath()
{
	return imagePath;
}
public void setImagePath(String imagePath)
{
	this.imagePath = imagePath;
}
public String getLikes()
{
	return likes;
}
public void setLikes(String likes)
{
	this.likes = likes;
}
public String getDislikes()
{
	return dislikes;
}
public void setDislikes(String dislikes)
{
	this.dislikes = dislikes;
}
}
