/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
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

/**
 * The Class IdeaViewServiceImpl fetches ideas and suggestions.
 */
public class IdeaViewServiceImpl implements IdeaViewService
{

	/** The idea view dao. */
	@Autowired
	private IdeaViewDao ideaViewDao;

	/** The login service. */
	@Autowired
	private LoginService loginService;

	/** The session. */
	@Autowired
	private HttpSession session;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.learning.service.IdeaViewService#addAnIdea(com.learining.data.
	 * IndexDataModel)
	 */
	@Override
	public boolean addAnIdea(IndexDataModel addAnIdeaData)
	{
		boolean successFlag = false;
		final RegisterFormData currentUser = (RegisterFormData) session
				.getAttribute("currentUser");
		if (null != currentUser)
		{
			addAnIdeaData.setUser(currentUser.getEmail());
			successFlag = ideaViewDao.addAnIdea(addAnIdeaData);
		}
		return successFlag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.learning.service.IdeaViewService#addSuggestion(com.learining.data
	 * .SuggestionData, com.learining.data.RegisterFormData)
	 */
	@Override
	public boolean addSuggestion(SuggestionData suggestionData,
			RegisterFormData currentUser)
	{
		final boolean suggestTextFlag = ideaViewDao.addSuggestion(
				suggestionData, currentUser);
		return suggestTextFlag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.learning.service.IdeaViewService#getIdeaForIUid(java.lang.String)
	 */
	@Override
	public IndexDataModel getIdeaForIUid(String iUid)
	{
		final IndexDataModel ideaViewData = ideaViewDao.getIdeaForIUid(iUid);
		final RegisterFormData userData = loginService.getUserData(ideaViewData
				.getUser());
		ideaViewData.setFirstName(userData.getFirstName());
		ideaViewData.setLastName(userData.getLastName());
		// TODO Auto-generated method stub
		return ideaViewData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.learning.service.IdeaViewService#getSuggestionsForIdea(java.lang.
	 * String)
	 */
	@Override
	public List<SuggestionData> getSuggestionsForIdea(String iUid)
	{
		final List<SuggestionData> suggestionDataList = ideaViewDao
				.getSuggestionsForIdea(iUid);
		// TODO Auto-generated method stub
		return suggestionDataList;
	}

}
