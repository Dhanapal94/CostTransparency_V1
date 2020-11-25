package ct.intit;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ct.utilities.ExcelUtility;
import ct.utilities.Mail;
import ct.utilities.Readconfig;

public class Base  {

	public static WebDriver driver;
	protected String homeProject = System.getProperty("user.dir");
	public static String validationFailureInformation="";
	protected static String excelPath = System.getProperty("user.dir")+"\\CTData.xlsx";
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest test;		
	public Logger log; 
	public static int rowCount;
	public static String destination ;
	public static File src ;
	public static File dest ;
	public static TakesScreenshot ts;
	public static final String SUCCESSMESSAGE="Saved successfully";
	public static final String RESETSUCCESSMESSAGE="Reset completed";
	public static final String VALIDATIONINVALIDMESSAGE="Not a valid quanity";
	public static final String NOCHANGESMESSAGE ="No changes detected";
	public static  String childTest;
	public static String reportname;
	

	// *****  TEST ****** //

	public String id, memberIdentifer, HICN, firstName,lastName, dateOfBirth, primaryPhone, primaryLanguage, address, city,
	state, zipCode, memberPlan, planName, deductibeSpentOutNetwork, deductibeLimitOutNetwork,
	deductibeSpentInNetwork, deductibeLimitInNetwork, oopSpentOutNetwork, oopLimitOutNetwork, oopSpentInNetwork,
	oopLimitInNetwork, serviceRefrenceNumber, hscID, dateOfProcedure, procedureCode, facility,
	procedureCodeDescription, providerFirstName, providerLastName,providerAddress, providerState, providerCity, providerZipcode,
	providerSpeciality, providerNetworkStatus, ccsCategory;

	public static int count =0,rowInitialCount=1;
	public static int passCount=0;
	public static boolean keepBrowserFlag=false;

	@BeforeSuite
	public void setExtent() throws Exception
	{
		ExtentReport.setExtentReport();
	}	


	@AfterSuite
	public void removeExtent()
	{
		extent.flush();
		Mail.getMail();
	}


	@AfterTest
	public void removingFlags()
	{
		keepBrowserFlag=false;		
	}


	@BeforeClass
	public void setUp() throws Exception
	{
		if(keepBrowserFlag==false)
		{
			driver=Baseinit.setupDriver();
		}
	}


	@AfterClass
	public void tearDown() throws Exception
	{
		if(childTest.equalsIgnoreCase("Yes"))
		{
			System.out.println("Failed informations are :"+validationFailureInformation);
			addFailureInformation(validationFailureInformation,rowInitialCount);
			System.out.println("PASS COUNT is :"+passCount);
			passCount=0;
			validationFailureInformation="";
			rowInitialCount++;
			ExcelUtility.setExcelFile(excelPath, "MemberDemographics");
			String nextMemberid=ExcelUtility.getCellData(rowInitialCount, 5);
			if(!nextMemberid.equals(Readconfig.getMemberID()))
			{
				closeDriver();
				keepBrowserFlag=false;
			}
			else
			{
				keepBrowserFlag=true;
			}
		}

		else
		{
			closeDriver();
		}
	}


	public  void closeDriver()
	{
		driver.quit();
		driver=null;
	}


	public static String resultName(String name)
	{
		int start = 0;
		String res = name;

		for(int i=0;i<res.length();i++)
		{
			char c = res.charAt(i);
			if(c=='T')
			{
				start=i;
				break;
			}

		}	
		res=res.replace(res.substring(start,res.length()),"")+"; ";
		res = res.substring(0, 1).toUpperCase() + res.substring(1); 		
		return res;

	}

	public static void addFailureInformation(String result,int rowcount) throws Exception
	{

		int colcount= ExcelUtility.getCellCount(0)-1;	
		ExcelUtility.setCellData(excelPath,result, rowcount, colcount);

	}

	public static void validationFailureInformations(String val)
	{
		String failureInformation = resultName(val);
		validationFailureInformation=validationFailureInformation+failureInformation;
	}



}
