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
import com.learning.dao.SolrDao;

/**
 * The Class SolrDaoImpl fetches all the ideas from solr documents.
 */
public class SolrDaoImpl extends DataBaseConnectimpl implements SolrDao
{

	/** The con. */
	private final Connection con = connectDataBase();

	/*
	 * (non-Javadoc)
	 *
	 * @see com.learning.dao.SolrDao#getAllIdeas()
	 */
	@Override
	public List<IndexDataModel> getAllIdeas()
	{
		PreparedStatement statement = null;
		final List<IndexDataModel> indexDataList = new ArrayList<IndexDataModel>();
		final String sql = "select IUID,IDEA,IDEAHEADING,IDEAUSER,CATEGORY from IDEA";
		try
		{

			statement = con.prepareStatement(sql);
			final ResultSet rs = statement.executeQuery();

			while (rs.next())
			{
				final IndexDataModel indexdata = new IndexDataModel();
				indexdata.setiUid(String.valueOf(rs.getInt("IUID")));
				indexdata.setIdea(rs.getString("IDEA"));
				indexdata.setIdeaHeading(rs.getString("IDEAHEADING"));
				indexdata.setUser(rs.getString("IDEAUSER"));
				indexdata.setCategory(rs.getString("CATEGORY"));
				indexDataList.add(indexdata);
			}
		}
		catch (final SQLException e)
		{
			e.printStackTrace();
		}

		return indexDataList;
	}

}
