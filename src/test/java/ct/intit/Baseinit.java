package ct.intit;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.paulhammant.ngwebdriver.NgWebDriver;

import ct.utilities.Readconfig;

public class Baseinit  {

	static DesiredCapabilities caps = new DesiredCapabilities();
	public static WebDriver driver;

	public static String userMSID() {
		String userHome =System.getProperty("user.home");
		String separator = "\\";
		String[] str_arr=userHome.replaceAll(Pattern.quote(separator), "\\\\").split("\\\\");
		userHome=str_arr[2];
		return userHome;

	}

	public static void setBrowserPath() throws IOException
	{
		if(Readconfig.browserName().equalsIgnoreCase("chrome"))
		{
			Readconfig.chromePath();
		}

		else if (Readconfig.browserName().equalsIgnoreCase("IE"))
		{
			Readconfig.iePath();
		}
	}




	public static InternetExplorerDriver setIEDriverProperty() throws IOException{
		Readconfig.saveIEPath();
		System.setProperty("webdriver.ie.driver",Readconfig.iePath());
		caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		caps.setCapability("requireWindowFocus", true);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		@SuppressWarnings("deprecation")
		InternetExplorerDriver internetExplorerDriver = new InternetExplorerDriver(caps);
		return internetExplorerDriver;
	}

	public static EdgeDriver setEdgeDriver() throws IOException { 
		Readconfig.saveEdgePath();
		System.setProperty("webdriver.edge.driver",Readconfig.edgePath());
		caps.setCapability(EdgeDriver.DRIVER_USE_EDGE_EDGEHTML, true);
		@SuppressWarnings("deprecation")
		EdgeDriver edgeDriver = new EdgeDriver(caps);
		return edgeDriver;
	}


	public static ChromeDriver setChromeDriverProperty() throws IOException{
		Readconfig.saveChromePath();
		System.setProperty("webdriver.chrome.driver",Readconfig.chromePath());
		ChromeOptions options = new ChromeOptions();
		//options.setCapability("chrome.binary","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");  //chrome binary location specified here
		//options.setBinary("C:\\\\Program Files (x86)\\\\Google\\\\Chrome\\\\Application\\\\chrome.exe");
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		ChromeDriver chromeDriver = new ChromeDriver(options);
		return chromeDriver;
	}

	public static NgWebDriver getNGDriver(WebDriver driver) {
		NgWebDriver ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		ngDriver.waitForAngularRequestsToFinish();
		return ngDriver;
	}

	static WebDriver getDriver(String value) throws IOException{
		switch(value) {
		case "ie":
		case "IE":
		case "Ie":
		case "Internet Explorer":	
			driver =setIEDriverProperty();
			break;
		case "chrome":
		case "Chrome":
		case "CHROME":	
			driver =setChromeDriverProperty();
			break;
		case "edge":
		case "Edge":
		case "Microsoft Edge":	
			driver =setEdgeDriver();
			break;

		}
		return driver;

	}

	public static WebDriver setupDriver() throws Exception {
		//Added By Nayna
		driver=Baseinit.getDriver(Readconfig.browserName());
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Baseinit.getNGDriver(driver);
		return driver;
	}
	public static void closeDriver() {
		driver.quit();
	}


	public static void  waitForAngularRequestNGDriver(WebDriver driver) {
		NgWebDriver ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		ngDriver.waitForAngularRequestsToFinish();
	}


	public static String getScreenshot(String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String datename = d.toString().replaceAll(":", "-");
		String destination = System.getProperty("user.dir")+"\\Screenshots\\"+tname+" " +datename+"-screenshot.png";
		File dest = new File(destination);
		FileUtils.copyFile(src, dest);		
		return destination;


	}


}



