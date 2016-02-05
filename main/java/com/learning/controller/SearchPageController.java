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

import com.blogspot.radialmind.xss.XSSFilter;
import com.learining.data.IdeaSearchData;
import com.learning.service.IdeaSolrResultService;
import com.learning.solr.IdeaIndexer;

@Controller
public class SearchPageController
{
	private static final Logger logger = LoggerFactory.getLogger(SearchPageController.class);
	@Autowired
	private IdeaIndexer ideaIndexer;
	@Autowired
	private IdeaSolrResultService ideaSolrResultService;
	
	@RequestMapping(value = "/adminui", method = RequestMethod.GET)
	public String adminUi(Model model) {
		return "adminpage";
	}
	@RequestMapping(value = "/adminindex", method = RequestMethod.GET)
	public String adminIndex(Model model) {
		logger.info("in home page");
		boolean successFlag = true;
		try
		{
			ideaIndexer.indexIdeas();
		}
		catch (IOException e)
		{
			successFlag = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SolrServerException e)
		{
			successFlag = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("successFlag",successFlag);
		return "adminpage";
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String dosearch(@RequestParam(value="searchTerm") String searchTerm,Model model) {
		List<IdeaSearchData> ideaSearchData = ideaSolrResultService.getSolrResult(searchTerm);
		model.addAttribute("ideaSearchData",ideaSearchData);
		model.addAttribute("searchTerm",searchTerm);
		return "homepage";
	}
}
