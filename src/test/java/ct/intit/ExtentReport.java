package ct.intit;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ct.utilities.Readconfig;

public class ExtentReport extends Base{
	
	public static void setExtentReport()
	{
		String timeStamp = new  SimpleDateFormat("M/d/yyyy hh:mm:ss").format(new Date());
		timeStamp= timeStamp.replaceAll(":", "-");
		reportname = "Cost Transparency Test-Report "+timeStamp.replaceAll("/", "-")+".html";
		System.out.println(reportname);
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\"+reportname);
		htmlreporter.config().setDocumentTitle("Cost Transparency Automation Report");//Title of the report
		htmlreporter.config().setReportName("Functional Cost Transparency Report");//Name of the report
		htmlreporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("OS", "WINDOWS10");
		extent.setSystemInfo("Tester Name", "Dhanapal,Nayna");
		extent.setSystemInfo("Browser", Readconfig.browserName().toUpperCase());	
	}	
	

}
