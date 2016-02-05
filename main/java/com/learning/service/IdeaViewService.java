package com.learning.service;

import java.util.List;

import com.learining.data.IndexDataModel;
import com.learining.data.RegisterFormData;
import com.learining.data.SuggestionData;

public interface IdeaViewService
{
public IndexDataModel getIdeaForIUid(String iUid);
public List<SuggestionData> getSuggestionsForIdea(String iUid);
public boolean addSuggestion(SuggestionData suggestionData,RegisterFormData currentUser);
public boolean addAnIdea(IndexDataModel addAnIdeaData);
}
