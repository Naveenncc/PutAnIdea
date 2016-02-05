/*
 * This is the property of Mr.Naveen C C
 * The code may not be copied, translated or distributed
 * in any manner (electronic, web or printed) without the prior written
 * consent of Naveen C C, with the exception of properly-attributed
 * quotations and other "fair use" exemptions provided for under copyright law
 * Copyright © 2016 Naveen C C. All rights reserved.
 */
package com.learning.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learining.data.IndexDataModel;
import com.learining.data.RegisterFormData;
import com.learining.data.SuggestionData;
import com.learning.dao.IdeaViewDao;

// TODO: Auto-generated Javadoc
/**
 * The Class IdeaViewDaoImpl handles inserting idea and suggestion.
 */
public class IdeaViewDaoImpl extends DataBaseConnectimpl implements IdeaViewDao
{

	/** The con. */
	private final Connection con = connectDataBase();

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.learning.dao.IdeaViewDao#addAnIdea(com.learining.data.IndexDataModel)
	 */
	@Override
	public boolean addAnIdea(IndexDataModel addAnIdeaData)
	{
		PreparedStatement statement = null;
		boolean flag = true;
		final String sql = "INSERT INTO IDEA (IUID,IDEA,IDEAHEADING,IDEAUSER,CATEGORY)"
				+ " VALUES (IDEASEQ.nextval,?,?,?,?)";

		try
		{

			statement = con.prepareStatement(sql);
			statement.setString(1, addAnIdeaData.getIdea());
			statement.setString(2, addAnIdeaData.getIdeaHeading());
			statement.setString(3, addAnIdeaData.getUser());
			statement.setString(4, addAnIdeaData.getCategory());
			statement.executeQuery();

		}
		catch (final SQLException e)
		{
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.learning.dao.IdeaViewDao#addSuggestion(com.learining.data.SuggestionData
	 * , com.learining.data.RegisterFormData)
	 */
	@Override
	public boolean addSuggestion(SuggestionData suggestionData,
			RegisterFormData currentUser)
	{
		PreparedStatement statement = null;
		boolean flag = true;
		final String sql = "INSERT INTO SUGGESTIONS (SUID,IUID, SUGUSER, SUGGESTION)"
				+ " VALUES (SUGGESTIONSEQ.nextval,?,?,?)";

		try
		{

			statement = con.prepareStatement(sql);
			statement.setString(1, suggestionData.getIuid());
			statement.setString(2, suggestionData.getSugUser());
			statement.setString(3, suggestionData.getSuggestion());
			statement.executeQuery();

		}
		catch (final SQLException e)
		{
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.learning.dao.IdeaViewDao#getIdeaForIUid(java.lang.String)
	 */
	@Override
	public IndexDataModel getIdeaForIUid(String iUid)
	{
		PreparedStatement statement = null;
		final IndexDataModel indexdata = new IndexDataModel();
		final String sql = "select * from IDEA where IUID=?";
		try
		{

			statement = con.prepareStatement(sql);
			statement.setString(1, iUid);
			final ResultSet rs = statement.executeQuery();

			while (rs.next())
			{
				indexdata.setiUid(String.valueOf(rs.getInt("IUID")));
				indexdata.setIdea(rs.getString("IDEA"));
				indexdata.setIdeaHeading(rs.getString("IDEAHEADING"));
				indexdata.setUser(rs.getString("IDEAUSER"));
				indexdata.setCategory(rs.getString("CATEGORY"));
			}
		}
		catch (final SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return indexdata;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.learning.dao.IdeaViewDao#getSuggestionsForIdea(java.lang.String)
	 */
	@Override
	public List<SuggestionData> getSuggestionsForIdea(String iUid)
	{
		PreparedStatement statement = null;
		final List<SuggestionData> suggestionDatalist = new ArrayList<SuggestionData>();
		final String sql = "SELECT SUGGESTIONS.SUID,SUGGESTIONS.IUID,SUGGESTIONS.SUGUSER,SUGGESTIONS.SUGGESTION,SUGGESTIONS.LIKES,SUGGESTIONS.DISLIKES,CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME"
				+ " FROM SUGGESTIONS INNER JOIN CUSTOMER ON SUGGESTIONS.SUGUSER=CUSTOMER.EMAIL WHERE IUID=?";
		try
		{

			statement = con.prepareStatement(sql);
			statement.setString(1, iUid);
			final ResultSet rs = statement.executeQuery();

			while (rs.next())
			{
				final SuggestionData suggestionData = new SuggestionData();
				suggestionData.setSuid(String.valueOf(rs.getInt("SUID")));
				suggestionData.setIuid(String.valueOf(rs.getInt("IUID")));
				suggestionData.setSugUser(rs.getString("SUGUSER"));
				suggestionData.setSuggestion(rs.getString("SUGGESTION"));
				suggestionData.setLikes(rs.getString("LIKES"));
				suggestionData.setDislikes(rs.getString("DISLIKES"));
				suggestionData.setFirstName(rs.getString("FIRSTNAME"));
				suggestionData.setLastName(rs.getString("LASTNAME"));
				suggestionDatalist.add(suggestionData);
			}
		}
		catch (final SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return suggestionDatalist;
	}

}
