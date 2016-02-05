package com.learning.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learining.data.IndexDataModel;
import com.learning.dao.SolrDao;

public class SolrDaoImpl extends DataBaseConnectimpl implements SolrDao
{
	private Connection con = connectDataBase();
	@Override
	public List<IndexDataModel> getAllIdeas()
	{
		PreparedStatement statement = null;
		List<IndexDataModel> indexDataList = new ArrayList<IndexDataModel>();
		String sql = "select IUID,IDEA,IDEAHEADING,IDEAUSER,CATEGORY from IDEA";
		try {
			
			statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				IndexDataModel indexdata = new IndexDataModel();
				indexdata.setiUid(String.valueOf(rs.getInt("IUID")));
				indexdata.setIdea(rs.getString("IDEA"));
				indexdata.setIdeaHeading(rs.getString("IDEAHEADING"));
				indexdata.setUser(rs.getString("IDEAUSER"));
				indexdata.setCategory(rs.getString("CATEGORY"));
				indexDataList.add(indexdata);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return indexDataList;
	}

}
