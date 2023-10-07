package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Readdatajdbc {

	public static void main(String[] args) throws SQLException {
	
		Connection conn=null;
		try {
			Driver driver=new Driver();
			 conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement stat = conn.createStatement();
			String query="Select * from project";
		ResultSet res = stat.executeQuery(query);
		while(res.next())
		{
			String value = res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4)+" "+res.getString(5)+" "+res.getString(6);
			System.out.println(value);
		}
	  } 
		finally 
		{
			conn.close();
		}
		
	}

}
