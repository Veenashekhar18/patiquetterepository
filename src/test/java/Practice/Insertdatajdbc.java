package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Insertdatajdbc {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			 conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement stat = conn.createStatement();
			String query="insert into project values('TY_PROJ_1318','eleven','29/06/2023','amazon','ongoing','5')";
			int res = stat.executeUpdate(query);
			if(res==1)
			{
				System.out.println("data is created");
			}
			else
			{
				System.out.println("data is not created");
			}
		
		} finally {
			conn.close();
		}
	}

}
