/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learning.solr;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class IdeaSolrQueryConvertor handles creation of solr query.
 */
public class IdeaSolrQueryConvertor
{

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(IdeaSolrQueryConvertor.class);

	/**
	 * Convert query.
	 *
	 * @param searchTerms
	 *            the search terms
	 * @return the solr query
	 */
	public SolrQuery convertQuery(List<String> searchTerms)
	{
		final SolrQuery query = new SolrQuery();
		final String searchQuery = createQuery(searchTerms);
		query.setQuery(searchQuery);
		// query.addFilterQuery("cat:electronics","store:amazon");
		// query.setFields("id","price","merchant","cat","store");
		query.setStart(0);
		query.set("defType", "edismax");
		return query;

	}

	/**
	 * Creates the query.
	 *
	 * @param searchTerms
	 *            the search terms
	 * @return the string
	 */
	public String createQuery(final List<String> searchTerms)
	{
		final StringBuilder searchQuery = new StringBuilder();
		for (int i = 0; i < searchTerms.size(); i++)
		{
			searchQuery.append("idea:").append(searchTerms.get(i));
			if (i != searchTerms.size() - 1)
			{
				searchQuery.append(" OR ");
			}
		}
		return searchQuery.toString();
	}
}
