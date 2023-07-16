package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Verifydata {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		String Project_Name="amazon";
		try {
			Driver driver=new Driver();
			 conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement stat = conn.createStatement();
			String query="Select* from project";
		ResultSet res = stat.executeQuery(query);
		boolean flag=false;
		while(res.next())
		{
			String value = res.getString(4);
			if(value.equalsIgnoreCase(Project_Name))
			{
				System.out.println("project is created");
				flag=true;
				break;
			}
		}
		if(!flag)
		{
			System.out.println("project is not created");
		}
			
		} finally {
			conn.close();
		}
		
	}

}
