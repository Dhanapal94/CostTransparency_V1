package ct.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import ct.intit.Baseinit;



public class Readconfig {

	public static Properties prop;

	static
	{
		prop = new Properties();
		String filePath ="./Configuration\\data.properties";
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(filePath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			prop.load(fin);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String  browserName()
	{
		String browser = prop.getProperty("browser");
		return browser;
	}
	public static String applicationURL()
	{
		String url = prop.getProperty("url");
		return url;
	}

	public static String chromePath()
	{
		String chromePath = prop.getProperty("chromepath");
		return chromePath;
	}
	public static String iePath()
	{
		String iePath = prop.getProperty("IEpath");
		return iePath;
	}
	public static String getQuery()
	{
		String queryVal = prop.getProperty("Query");
		return queryVal;
	}
	public static String getDBUrl()
	{
		String dburl = prop.getProperty("DbUrl");
		return dburl;
	}

	public static String driverValue()
	{
		String driverValue = prop.getProperty("driver");
		return driverValue;
	}

	public  static void saveMemberID(String memberID) throws IOException
	{
		String filePath ="./Configuration\\data.properties";
		FileOutputStream fout = new FileOutputStream(filePath);
		String memID =memberID ;
		prop.setProperty("Memberid", memID);
		prop.store(fout,"Memberid updated");
		String urlChange ="https://costtransptest.uhc.com/memberplan?memberid="+memID;
		prop.setProperty("url", urlChange);
		fout = new FileOutputStream(filePath);
		prop.store(fout,"url updated");

	}

	public  static String getMemberID() throws IOException
	{
		return prop.getProperty("Memberid");			
	}

	public  static String getMemberIDServiceExpected() throws IOException
	{
		return prop.getProperty("MemberidSurgeryorNonSurgeryExpected");			
	}

	public  static String getCostType() throws IOException
	{
		String ct=" "+prop.getProperty("CostType")+" ";
		return ct;

	}

	public  static String getType() throws IOException
	{
		String type=prop.getProperty("Type")+" ";
		return type;

	}

	public static String getDiagnosis() throws IOException
	{
		String diagnosis = prop.getProperty("Diagnosis");
		return diagnosis;
	}


	public static void saveChromePath() throws IOException
	{
		String msid=Baseinit.userMSID();
		String location = "C:\\Users\\"+msid+"\\Documents\\MacroFiles\\chromedriver\\chromedriver.exe";
		prop.setProperty("chromepath", location);
		String filePath ="./Configuration\\data.properties";
		FileOutputStream fout = new FileOutputStream(filePath);
		prop.store(fout,"chromepath updated");

	}

	public static void saveIEPath() throws IOException
	{

		String location = "./Drivers\\IEDriverServer.exe";
		prop.setProperty("IEpath", location);
		String filePath ="./Configuration\\data.properties";
		FileOutputStream fout = new FileOutputStream(filePath);
		prop.store(fout,"IEpath updated");
		
	}
	
	public static void saveEdgePath() throws IOException 
	{
	String msid=Baseinit.userMSID();
	String location = "C:\\Users\\"+msid+"\\Documents\\MacroFiles\\edgedriver\\msedgedriver.exe";
	prop.setProperty("edgepath", location);
	String filePath ="./Configuration\\data.properties";
	FileOutputStream fout = new FileOutputStream(filePath);
	prop.store(fout,"edgepath updated");

	}

	public static String edgePath() 
	{
	String edgepath = prop.getProperty("edgepath");
	return edgepath;
	}


	public static void setActualEstimationQuery(String query) throws Exception
	{
		String filePath ="./Configuration\\data.properties";
		FileOutputStream fout = new FileOutputStream(filePath);
		prop.setProperty("ActualEstimationQuery", query);
		prop.store(fout,"ActualEstimationQueryUpdated");

	}

	public static String getActualEstimationQuery() throws Exception
	{
		String queryVal = prop.getProperty("ActualEstimationQuery");
		return queryVal;

	}

	public static void setOriginalEstimationQuery(String query) throws Exception
	{
		String filePath ="./Configuration\\data.properties";
		FileOutputStream fout = new FileOutputStream(filePath);
		prop.setProperty("OriginalEstimationQuery", query);
		prop.store(fout,"OriginalEstimationQueryUpdated");

	}

	public static String getOriginalEstimationQuery() throws Exception
	{
		String queryVal = prop.getProperty("OriginalEstimationQuery");
		return queryVal;

	}

	public static String getMailToRecipients()
	{
		String toRecipents =prop.getProperty("MailRecipientsTo");		
		return toRecipents;

	}
	
	public static String getInOrOutNetwork()
	{
		String inOrOutNetwork =prop.getProperty("InOrOutNetwork");		
		return inOrOutNetwork;

	}

}
