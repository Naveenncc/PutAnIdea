/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learning.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;

import com.learining.data.IdeaSearchData;
import com.learining.data.RegisterFormData;
import com.learning.service.IdeaSolrResultService;
import com.learning.service.LoginService;
import com.learning.solr.IdeaSolrQueryConvertor;

/**
 * The Class IdeaSolrResultServiceImpl fetches solr results from solr document.
 */
public class IdeaSolrResultServiceImpl implements IdeaSolrResultService
{

	/** The idea solr query convertor. */
	@Autowired
	private IdeaSolrQueryConvertor ideaSolrQueryConvertor;

	/** The login service. */
	@Autowired
	private LoginService loginService;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.learning.service.IdeaSolrResultService#getSolrResult(java.lang.String
	 * )
	 */
	@Override
	public List<IdeaSearchData> getSolrResult(String searchTerm)
	{
		List<IdeaSearchData> IdeaDataList = new ArrayList<IdeaSearchData>();
		try
		{
			final List<String> searchTermList = splitStringByspace(searchTerm);
			final SolrQuery solQuery = ideaSolrQueryConvertor
					.convertQuery(searchTermList);

			final HttpSolrServer solr = new HttpSolrServer(
					"http://localhost:8983/solr");
			final QueryResponse response = solr.query(solQuery);
			final SolrDocumentList results = response.getResults();
			IdeaDataList = populateIdeaData(results);
		}
		catch (final SolrServerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return IdeaDataList;
	}

	/**
	 * Populate idea data.
	 *
	 * @param results
	 *            the results
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<IdeaSearchData> populateIdeaData(final SolrDocumentList results)
	{
		final List<IdeaSearchData> ideaDataList = new ArrayList<IdeaSearchData>();
		for (final SolrDocument solrDocument : results)
		{
			final IdeaSearchData ideaData = new IdeaSearchData();
			ideaData.setId((String) solrDocument.getFieldValue("id"));
			ideaData.setIdea((String) solrDocument.getFieldValue("idea"));
			ideaData.setIdeaQuestion((String) solrDocument
					.getFieldValue("ideaquestion"));
			ideaData.setCategory((List<String>) solrDocument
					.getFieldValue("cat"));
			ideaData.setUser((String) solrDocument.getFieldValue("user"));
			final RegisterFormData userData = loginService
					.getUserData((String) solrDocument.getFieldValue("user"));
			ideaData.setFirstName(userData.getFirstName());
			ideaData.setLastName(userData.getLastName());
			ideaDataList.add(ideaData);
		}
		return ideaDataList;
	}

	/**
	 * Split string byspace.
	 *
	 * @param searchString
	 *            the search string
	 * @return the list
	 */
	public List<String> splitStringByspace(String searchString)
	{
		searchString = searchString.replaceAll("[^a-zA-Z0-9 -]", "");
		final String trimString = searchString.trim().replaceAll(" +", " ");
		final List<String> searchterms = Arrays.asList(trimString.split(" "));
		return searchterms;
	}
}
