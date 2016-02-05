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


public class IdeaIndexer
{
	private static final Logger logger = LoggerFactory.getLogger(IdeaIndexer.class);
	@Autowired
	private SolrDao solrDao;
	@Autowired
	private IdeaSolrDocumentFactory ideaSolrDocumentFactory;
	public void indexIdeas() throws IOException, SolrServerException
	{
		try
		{
			logger.info("inside indexIdeas");
			HttpSolrServer server = new HttpSolrServer("http://localhost:8983/solr");
			List<IndexDataModel> indexDataList = solrDao.getAllIdeas();
			for (IndexDataModel indexDataModel : indexDataList)
			{
				SolrInputDocument doc = ideaSolrDocumentFactory.createSolrDocument(indexDataModel);
				server.add(doc);
				server.commit();
				logger.info("added document "+indexDataModel.getiUid());
			}
		}
		catch (Exception e)
		{
			logger.info("Something went wrong : "+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*public void indexSingleIdea(IndexDataModel addAnIdeaData) throws IOException, SolrServerException
{
	try
	{
		logger.info("inside indexIdeas");
		HttpSolrServer server = new HttpSolrServer("http://localhost:8983/solr");
			SolrInputDocument doc = ideaSolrDocumentFactory.createSolrDocument(addAnIdeaData);
			server.add(doc);
			server.commit();
			logger.info("added document "+addAnIdeaData.getiUid());
	}
	catch (Exception e)
	{
		logger.info("Something went wrong : "+e.getMessage());
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}*/
}
