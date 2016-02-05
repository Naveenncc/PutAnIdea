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

import com.learining.data.IdeaSearchData;
import com.learining.data.IndexDataModel;
import com.learining.data.RegisterFormData;
import com.learining.data.SuggestionData;
import com.learning.service.IdeaViewService;

@Controller
public class IdeaViewController
{
	private static final Logger logger = LoggerFactory.getLogger(IdeaViewController.class);
	@Autowired
	private IdeaViewService ideaViewService;
	
	@RequestMapping(value = "/ideaview", method = RequestMethod.GET)
	public String getIdeaAndSuggetion(@RequestParam(value="iuid") String iUid,Model model) {
		IndexDataModel ideadata = ideaViewService.getIdeaForIUid(iUid);
		List<SuggestionData> suggestionDataList = ideaViewService.getSuggestionsForIdea(iUid);
		model.addAttribute("ideaData",ideadata);
		model.addAttribute("suggestionDataList",suggestionDataList);
		return "ideaviewpage";
	}
	
	@RequestMapping(value = "/addsuggestion", method = RequestMethod.POST)
	public String addSuggestion(SuggestionData suggestionData,Model model,HttpSession session) {
		RegisterFormData currentUser = (RegisterFormData) session.getAttribute("currentUser");
		boolean suggestFlag = false;
		if(null != currentUser){
		suggestFlag = ideaViewService.addSuggestion(suggestionData,currentUser);
		}
		return "redirect:/ideaview?iuid="+suggestionData.getIuid();
	}
	@RequestMapping(value = "/addanidea", method = RequestMethod.POST)
	public String addAnIdea(IndexDataModel addAnIdeaData,Model model,HttpServletRequest request) {
		boolean successFlag = ideaViewService.addAnIdea(addAnIdeaData);
		String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}
}
