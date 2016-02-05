package com.learning.dao;

import java.util.List;

import com.learining.data.IndexDataModel;
import com.learining.data.RegisterFormData;
import com.learining.data.SuggestionData;

public interface IdeaViewDao
{
	public IndexDataModel getIdeaForIUid(String iUid);
	public List<SuggestionData> getSuggestionsForIdea(String iUid);
	public boolean addSuggestion(SuggestionData suggestionData,RegisterFormData currentUser);
	public boolean addAnIdea(IndexDataModel addAnIdeaData);
}
