package com.learning.service;


import java.util.List;

import com.learining.data.IdeaSearchData;

public interface IdeaSolrResultService
{
public List<IdeaSearchData> getSolrResult(String searchTerm);
}
