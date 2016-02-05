/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learning.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.learining.data.IndexDataModel;
import com.learining.data.RegisterFormData;
import com.learining.data.SuggestionData;
import com.learning.service.IdeaViewService;

/**
 * The Class IdeaViewController handles request for adding idea.
 */
@Controller
public class IdeaViewController
{

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(IdeaViewController.class);

	/** The idea view service. */
	@Autowired
	private IdeaViewService ideaViewService;

	/**
	 * Adds the an idea.
	 *
	 * @param addAnIdeaData
	 *            the add an idea data
	 * @param model
	 *            the model
	 * @param request
	 *            the request
	 * @return the string
	 */
	@RequestMapping(
			value = "/addanidea", method = RequestMethod.POST)
	public String addAnIdea(IndexDataModel addAnIdeaData, Model model,
			HttpServletRequest request)
	{
		final boolean successFlag = ideaViewService.addAnIdea(addAnIdeaData);
		final String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	/**
	 * Adds the suggestion.
	 *
	 * @param suggestionData
	 *            the suggestion data
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@RequestMapping(
			value = "/addsuggestion", method = RequestMethod.POST)
	public String addSuggestion(SuggestionData suggestionData, Model model,
			HttpSession session)
	{
		final RegisterFormData currentUser = (RegisterFormData) session
				.getAttribute("currentUser");
		boolean suggestFlag = false;
		if (null != currentUser)
		{
			suggestFlag = ideaViewService.addSuggestion(suggestionData,
					currentUser);
		}
		return "redirect:/ideaview?iuid=" + suggestionData.getIuid();
	}

	/**
	 * Gets the idea and suggetion.
	 *
	 * @param iUid
	 *            the i uid
	 * @param model
	 *            the model
	 * @return the idea and suggetion
	 */
	@RequestMapping(
			value = "/ideaview", method = RequestMethod.GET)
	public String getIdeaAndSuggetion(@RequestParam(
			value = "iuid") String iUid, Model model)
	{
		final IndexDataModel ideadata = ideaViewService.getIdeaForIUid(iUid);
		final List<SuggestionData> suggestionDataList = ideaViewService
				.getSuggestionsForIdea(iUid);
		model.addAttribute("ideaData", ideadata);
		model.addAttribute("suggestionDataList", suggestionDataList);
		return "ideaviewpage";
	}
}
