package ct.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngularModel;

public class ConfirmationPage extends PageObject {
	
	private static WebElement yesButton(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//span[text()='Yes']"));
	}
	
	private static WebElement NoButton(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//span[text()='No']"));
	}
	
	private static WebElement closeIconButton(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//a[@tabindex='0']/span)[2]"));
	}
	
	
	public static void clickYes(WebDriver driver) throws Exception
	{	
		mouseClick(yesButton(driver),driver);
	}
	
	public static void clickNo(WebDriver driver) throws Exception
	{	
		mouseClick(NoButton(driver),driver);
	}
	
	public static void clickCloseIconButton(WebDriver driver) throws Exception
	{	
		mouseClick(closeIconButton(driver),driver);
	}

}
