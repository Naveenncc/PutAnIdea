package com.learning.solr;


import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.learining.data.IndexDataModel;
import com.learning.dao.SolrDao;


public class IdeaSolrDocumentFactory
{
	private static final Logger logger = LoggerFactory.getLogger(IdeaSolrDocumentFactory.class);
	
	
	public SolrInputDocument createSolrDocument(final IndexDataModel indexData){
		SolrInputDocument doc = new SolrInputDocument();
		 logger.info("creating Document for"+ indexData.getiUid());
	      doc.addField("id",indexData.getiUid());
	      doc.addField("cat", indexData.getCategory());
	      doc.addField("idea", indexData.getIdeaHeading());
	      doc.addField("ideaquestion", indexData.getIdea());
	      doc.addField("user", indexData.getUser());
	      return doc;
		
	}
}
