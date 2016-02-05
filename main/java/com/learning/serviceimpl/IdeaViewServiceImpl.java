package com.learning.serviceimpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.learining.data.IndexDataModel;
import com.learining.data.RegisterFormData;
import com.learining.data.SuggestionData;
import com.learning.dao.IdeaViewDao;
import com.learning.service.IdeaViewService;
import com.learning.service.LoginService;

public class IdeaViewServiceImpl implements IdeaViewService
{
@Autowired
private IdeaViewDao ideaViewDao; 
@Autowired
private LoginService loginService;

@Autowired
private HttpSession session;
	@Override
	public IndexDataModel getIdeaForIUid(String iUid)
	{
		IndexDataModel ideaViewData = ideaViewDao.getIdeaForIUid(iUid);
		RegisterFormData userData = loginService.getUserData(ideaViewData.getUser());
		ideaViewData.setFirstName(userData.getFirstName());
		ideaViewData.setLastName(userData.getLastName());
		// TODO Auto-generated method stub
		return ideaViewData;
	}

	@Override
	public List<SuggestionData> getSuggestionsForIdea(String iUid)
	{
		List<SuggestionData> suggestionDataList = ideaViewDao.getSuggestionsForIdea(iUid);
		// TODO Auto-generated method stub
		return suggestionDataList;
	}

	@Override
	public boolean addSuggestion(SuggestionData suggestionData,RegisterFormData currentUser)
	{
		boolean suggestTextFlag = ideaViewDao.addSuggestion(suggestionData,currentUser);
		return suggestTextFlag;
	}

	@Override
	public boolean addAnIdea(IndexDataModel addAnIdeaData)
	{
		boolean successFlag = false;
		RegisterFormData currentUser = (RegisterFormData) session.getAttribute("currentUser");
		if(null!=currentUser){
		addAnIdeaData.setUser(currentUser.getEmail());
	    successFlag = ideaViewDao.addAnIdea(addAnIdeaData);
		}
		return successFlag;
	}

}
