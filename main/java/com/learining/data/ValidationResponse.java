package com.learining.data;

import java.util.List;

public class ValidationResponse
{
	private String status;
	 private List errorMessageList;
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public List getErrorMessageList()
	{
		return errorMessageList;
	}
	public void setErrorMessageList(List errorMessageList)
	{
		this.errorMessageList = errorMessageList;
	}
}
