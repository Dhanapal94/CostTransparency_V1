package ct.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngularModel;

public class PreSurgeryPage extends PageObject{
	
	public static WebElement costType(WebDriver driver,String ct) {
		return driver.findElement(ByAngularModel.xpath("(//div[text()='Pre Surgery ']//following::div[@class='wdgt-body row'])[1]//table/tbody/tr/td[text()='"+ct+"']"));
	}

	public static WebElement editCostType(WebDriver driver,String ct) {
		return driver.findElement(ByAngularModel.xpath("(//div[text()='Pre Surgery ']//following::div[@class='wdgt-body row'])[1]//table/tbody/tr/td[text()='"+ct+"']//preceding::td[1]/a[1]"));
	}
	
	public static void clickEdit(WebDriver driver,String costType) throws Exception
	{	
		Thread.sleep(2000);
		mouseClick(editCostType(driver,costType),driver);
	}
}

