/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learning.service;

import java.util.List;

import com.learining.data.IndexDataModel;
import com.learining.data.RegisterFormData;
import com.learining.data.SuggestionData;

/**
 * The Interface IdeaViewService fetches ideas and suggestions.
 */
public interface IdeaViewService
{

	/**
	 * Adds the an idea.
	 *
	 * @param addAnIdeaData
	 *            the add an idea data
	 * @return true, if successful
	 */
	public boolean addAnIdea(IndexDataModel addAnIdeaData);

	/**
	 * Adds the suggestion.
	 *
	 * @param suggestionData
	 *            the suggestion data
	 * @param currentUser
	 *            the current user
	 * @return true, if successful
	 */
	public boolean addSuggestion(SuggestionData suggestionData,
			RegisterFormData currentUser);

	/**
	 * Gets the idea for i uid.
	 *
	 * @param iUid
	 *            the i uid
	 * @return the idea for i uid
	 */
	public IndexDataModel getIdeaForIUid(String iUid);

	/**
	 * Gets the suggestions for idea.
	 *
	 * @param iUid
	 *            the i uid
	 * @return the suggestions for idea
	 */
	public List<SuggestionData> getSuggestionsForIdea(String iUid);
}
