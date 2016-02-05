package com.learning.solr;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IdeaSolrQueryConvertor
{
	private static final Logger logger = LoggerFactory.getLogger(IdeaSolrQueryConvertor.class);
	
	public SolrQuery convertQuery(List<String> searchTerms){
		SolrQuery query = new SolrQuery();
		String searchQuery = createQuery(searchTerms);
	    query.setQuery(searchQuery);
	    //query.addFilterQuery("cat:electronics","store:amazon");
	    //query.setFields("id","price","merchant","cat","store");
	    query.setStart(0);    
	    query.set("defType", "edismax");
	    return query;

	}
	
	public String createQuery(final List<String> searchTerms){
		StringBuilder searchQuery = new StringBuilder();
		for (int i=0;i < searchTerms.size();i++)
		{
			searchQuery.append("idea:").append(searchTerms.get(i));
			if(i != searchTerms.size()-1){
				searchQuery.append(" OR ");
			}
		}
		return searchQuery.toString();
	}
}
