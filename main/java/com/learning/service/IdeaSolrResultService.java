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

import com.learining.data.IdeaSearchData;

/**
 * The Interface IdeaSolrResultService fetches solr results from solr document.
 */
public interface IdeaSolrResultService
{

	/**
	 * Gets the solr result.
	 *
	 * @param searchTerm
	 *            the search term
	 * @return the solr result
	 */
	public List<IdeaSearchData> getSolrResult(String searchTerm);
}
