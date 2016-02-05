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

public class IdeaViewDaoImpl extends DataBaseConnectimpl implements IdeaViewDao
{
	private Connection con = connectDataBase();
	@Override
	public IndexDataModel getIdeaForIUid(String iUid)
	{
		PreparedStatement statement = null;
		IndexDataModel indexdata = new IndexDataModel();
		String sql = "select * from IDEA where IUID=?";
		try {
			
			statement = con.prepareStatement(sql);
			statement.setString(1,iUid);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				indexdata.setiUid(String.valueOf(rs.getInt("IUID")));
				indexdata.setIdea(rs.getString("IDEA"));
				indexdata.setIdeaHeading(rs.getString("IDEAHEADING"));
				indexdata.setUser(rs.getString("IDEAUSER"));
				indexdata.setCategory(rs.getString("CATEGORY"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return indexdata;
	}

	@Override
	public List<SuggestionData> getSuggestionsForIdea(String iUid)
	{
		PreparedStatement statement = null;
		List<SuggestionData> suggestionDatalist = new ArrayList<SuggestionData>();
		String sql = "SELECT SUGGESTIONS.SUID,SUGGESTIONS.IUID,SUGGESTIONS.SUGUSER,SUGGESTIONS.SUGGESTION,SUGGESTIONS.LIKES,SUGGESTIONS.DISLIKES,CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME"
				+ " FROM SUGGESTIONS INNER JOIN CUSTOMER ON SUGGESTIONS.SUGUSER=CUSTOMER.EMAIL WHERE IUID=?";
		try {
			
			statement = con.prepareStatement(sql);
			statement.setString(1,iUid);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				SuggestionData suggestionData = new SuggestionData();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return suggestionDatalist;
	}

	@Override
	public boolean addSuggestion(SuggestionData suggestionData,RegisterFormData currentUser)
	{
		PreparedStatement statement = null;
		boolean flag = true;
		String sql = "INSERT INTO SUGGESTIONS (SUID,IUID, SUGUSER, SUGGESTION)"
				+ " VALUES (SUGGESTIONSEQ.nextval,?,?,?)";
				
				try {
					
					statement = con.prepareStatement(sql);
					statement.setString(1,suggestionData.getIuid());
					statement.setString(2,suggestionData.getSugUser());
					statement.setString(3,suggestionData.getSuggestion());
					statement.executeQuery();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					flag = false;
					e.printStackTrace();
				}
		return flag;
	}

	@Override
	public boolean addAnIdea(IndexDataModel addAnIdeaData)
	{
		PreparedStatement statement = null;
	boolean flag = true;
	String sql = "INSERT INTO IDEA (IUID,IDEA,IDEAHEADING,IDEAUSER,CATEGORY)"
			+ " VALUES (IDEASEQ.nextval,?,?,?,?)";
			
			try {
				
				statement = con.prepareStatement(sql);
				statement.setString(1,addAnIdeaData.getIdea());
				statement.setString(2,addAnIdeaData.getIdeaHeading());
				statement.setString(3,addAnIdeaData.getUser());
				statement.setString(4,addAnIdeaData.getCategory());
				statement.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				flag = false;
				e.printStackTrace();
			}
	return flag;
	}

}
