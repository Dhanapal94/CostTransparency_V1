package ct.utilities;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetDBConnection {

	public static void appendToPath(){
		String dir=System.getProperty("user.dir")+ File.separatorChar+"sql_resourse"+File.separatorChar;
		String path = System.getProperty("java.library.path");
		path = dir + ";" + path;
		System.setProperty("java.library.path", path);
		try {
			final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
			sysPathsField.setAccessible(true);
			sysPathsField.set(null, null);

		}
		catch (Exception ex){
			throw new RuntimeException(ex);
		}
		System.out.println("**************** Sql dll set ****************");
	}

	public static Connection getConnection() throws  ClassNotFoundException, SQLException

	{
		//This will fix the dll path of SQL server :: it should be in the java run time path .
		appendToPath();
		String url = Readconfig.getDBUrl();
		//String url = "jdbc:sqlserver://DBVET32618;databaseName=costtransp;integratedSecurity=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(url);
		System.out.println("**************** Connected to Microsfost server **************** ");
		return conn;
	}


}
