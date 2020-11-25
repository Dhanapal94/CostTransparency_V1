package ct.utilities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GetDBUpdate {
	
	public static void dbUpdate(String query) throws ClassNotFoundException, SQLException
	{
		Connection conn = GetDBConnection.getConnection();
		Statement stmt = conn.createStatement();						
		int count = stmt.executeUpdate(query);
		System.out.println("***** 120 Days Plus is Updated *******");
		System.out.println(count+" row(s) Updated ");
	}


}
