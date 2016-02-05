/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learning.dao;

import java.util.List;

import com.learining.data.IndexDataModel;

/**
 * The Interface SolrDao fetches all the ideas from solr documents.
 */
public interface SolrDao
{

	/**
	 * Gets the all ideas.
	 *
	 * @return the all ideas
	 */
	public List<IndexDataModel> getAllIdeas();
}
