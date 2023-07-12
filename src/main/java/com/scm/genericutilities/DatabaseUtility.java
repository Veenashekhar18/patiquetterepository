package com.scm.genericutilities;

import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;



public class DatabaseUtility {
	Driver driver;
	Connection connection;
	ResultSet result;
	FileUtility flib=new FileUtility();
	String url;
	String username;
	String password;
	public DatabaseUtility() throws IOException
	{
		String filepath=flib.getfilepathfromproeritiesfile("");
		url=flib.getdatafromproperties(filepath,"url");
		username=flib.getdatafromproperties(filepath, "username");
		password=flib.getdatafromproperties(filepath,"password");
	}
public void connectdb()
{
	try
	{
		driver=new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection(url,username,password);
	}
	catch(SQLException e) {
		e.printStackTrace();
		
	}
}
public void closedb()
{
	try {
		connection.close();
	}
	catch(Exception e)
	{
		
	}
}
public ResultSet executeQuery(String query) throws SQLException
{
	result=connection.createStatement().executeQuery(query);
	return result;
}
public int executeupdate(String query) throws SQLException
{
	int result=connection.createStatement().executeUpdate(query);
	return result;
}
public boolean executeQueryandverify(String query,int columnindex,String expecteddata) throws SQLException
{
	boolean flag=false;
	result=connection.createStatement().executeQuery(query);
	while(result.next())
	{
		if(result.getString(columnindex).equals(expecteddata))
		{
			flag=true;
			break;
		}
	}
	if(flag)
	{
		System.out.println(expecteddata+"Data is verified in the database table");
		return flag;
	}
	else
	{
		System.out.println(expecteddata+"Data is not verified in the database table");
		return flag;	
	}
}
}
