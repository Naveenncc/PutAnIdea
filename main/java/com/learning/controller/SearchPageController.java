/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learning.controller;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.learining.data.IdeaSearchData;
import com.learning.service.IdeaSolrResultService;
import com.learning.solr.IdeaIndexer;

/**
 * The Class SearchPageController handles request for search operation.
 */
@Controller
public class SearchPageController
{

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(SearchPageController.class);

	/** The idea indexer. */
	@Autowired
	private IdeaIndexer ideaIndexer;

	/** The idea solr result service. */
	@Autowired
	private IdeaSolrResultService ideaSolrResultService;

	/**
	 * Admin index.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(
			value = "/adminindex", method = RequestMethod.GET)
	public String adminIndex(Model model)
	{
		logger.info("in home page");
		boolean successFlag = true;
		try
		{
			ideaIndexer.indexIdeas();
		}
		catch (final IOException e)
		{
			successFlag = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (final SolrServerException e)
		{
			successFlag = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("successFlag", successFlag);
		return "adminpage";
	}

	/**
	 * Admin ui.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(
			value = "/adminui", method = RequestMethod.GET)
	public String adminUi(Model model)
	{
		return "adminpage";
	}

	/**
	 * Dosearch.
	 *
	 * @param searchTerm
	 *            the search term
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(
			value = "/search", method = RequestMethod.GET)
	public String dosearch(@RequestParam(
			value = "searchTerm") String searchTerm, Model model)
	{
		final List<IdeaSearchData> ideaSearchData = ideaSolrResultService
				.getSolrResult(searchTerm);
		model.addAttribute("ideaSearchData", ideaSearchData);
		model.addAttribute("searchTerm", searchTerm);
		return "homepage";
	}
}
