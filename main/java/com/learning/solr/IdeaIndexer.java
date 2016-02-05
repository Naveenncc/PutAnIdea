/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learning.solr;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.learining.data.IndexDataModel;
import com.learning.dao.SolrDao;

/**
 * The Class IdeaIndexer handles indexing operation.
 */
public class IdeaIndexer
{

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(IdeaIndexer.class);

	/** The solr dao. */
	@Autowired
	private SolrDao solrDao;

	/** The idea solr document factory. */
	@Autowired
	private IdeaSolrDocumentFactory ideaSolrDocumentFactory;

	/**
	 * Index ideas.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws SolrServerException
	 *             the solr server exception
	 */
	public void indexIdeas() throws IOException, SolrServerException
	{
		try
		{
			logger.info("inside indexIdeas");
			final HttpSolrServer server = new HttpSolrServer(
					"http://localhost:8983/solr");
			final List<IndexDataModel> indexDataList = solrDao.getAllIdeas();
			for (final IndexDataModel indexDataModel : indexDataList)
			{
				final SolrInputDocument doc = ideaSolrDocumentFactory
						.createSolrDocument(indexDataModel);
				server.add(doc);
				server.commit();
				logger.info("added document " + indexDataModel.getiUid());
			}
		}
		catch (final Exception e)
		{
			logger.info("Something went wrong : " + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * public void indexSingleIdea(IndexDataModel addAnIdeaData) throws
	 * IOException, SolrServerException
	 * {
	 * try
	 * {
	 * logger.info("inside indexIdeas");
	 * HttpSolrServer server = new HttpSolrServer("http://localhost:8983/solr");
	 * SolrInputDocument doc =
	 * ideaSolrDocumentFactory.createSolrDocument(addAnIdeaData);
	 * server.add(doc);
	 * server.commit();
	 * logger.info("added document "+addAnIdeaData.getiUid());
	 * }
	 * catch (Exception e)
	 * {
	 * logger.info("Something went wrong : "+e.getMessage());
	 * // TODO Auto-generated catch block
	 * e.printStackTrace();
	 * }
	 * }
	 */
}
