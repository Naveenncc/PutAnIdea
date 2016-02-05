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

public class IdeaSolrResultServiceImpl implements IdeaSolrResultService
{
@Autowired
private IdeaSolrQueryConvertor ideaSolrQueryConvertor;
@Autowired
private LoginService loginService;

	@Override
	public List<IdeaSearchData> getSolrResult(String searchTerm)
	{
		List<IdeaSearchData> IdeaDataList = new ArrayList<IdeaSearchData>();
		try
		{
			List<String> searchTermList = splitStringByspace(searchTerm);
			SolrQuery solQuery = ideaSolrQueryConvertor.convertQuery(searchTermList);
			
			HttpSolrServer solr = new HttpSolrServer("http://localhost:8983/solr");
			QueryResponse response = solr.query(solQuery);
			SolrDocumentList results = response.getResults();
			IdeaDataList = populateIdeaData(results);
		}
		catch (SolrServerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return IdeaDataList;
	}

	public List<String> splitStringByspace(String searchString){
		searchString = searchString.replaceAll("[^a-zA-Z0-9 -]", "");
		String trimString = searchString.trim().replaceAll(" +", " ");
		List<String> searchterms = Arrays.asList(trimString.split(" "));
		return searchterms;
	}
	@SuppressWarnings("unchecked")
	public List<IdeaSearchData> populateIdeaData(final SolrDocumentList results)
	{
		List<IdeaSearchData> ideaDataList = new ArrayList<IdeaSearchData>();
		for (SolrDocument solrDocument : results)
		{
			IdeaSearchData ideaData = new IdeaSearchData();
			ideaData.setId((String)solrDocument.getFieldValue("id"));
			ideaData.setIdea((String)solrDocument.getFieldValue("idea"));
			ideaData.setIdeaQuestion((String)solrDocument.getFieldValue("ideaquestion"));
			ideaData.setCategory((List<String>)solrDocument.getFieldValue("cat"));
			ideaData.setUser((String)solrDocument.getFieldValue("user"));
			RegisterFormData userData = loginService.getUserData((String)solrDocument.getFieldValue("user"));
			ideaData.setFirstName(userData.getFirstName());
			ideaData.setLastName(userData.getLastName());
			ideaDataList.add(ideaData);
		}
		return ideaDataList;
	}
}
