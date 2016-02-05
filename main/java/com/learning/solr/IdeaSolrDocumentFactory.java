/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learning.solr;

import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learining.data.IndexDataModel;

/**
 * A factory for creating IdeaSolrDocument objects.
 */
public class IdeaSolrDocumentFactory
{

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(IdeaSolrDocumentFactory.class);

	/**
	 * Creates a new IdeaSolrDocument object.
	 *
	 * @param indexData
	 *            the index data
	 * @return the solr input document
	 */
	public SolrInputDocument createSolrDocument(final IndexDataModel indexData)
	{
		final SolrInputDocument doc = new SolrInputDocument();
		logger.info("creating Document for" + indexData.getiUid());
		doc.addField("id", indexData.getiUid());
		doc.addField("cat", indexData.getCategory());
		doc.addField("idea", indexData.getIdeaHeading());
		doc.addField("ideaquestion", indexData.getIdea());
		doc.addField("user", indexData.getUser());
		return doc;

	}
}
