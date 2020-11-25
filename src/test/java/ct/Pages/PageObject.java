package ct.Pages;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;



public class PageObject {

	public static boolean checkListContains(List<String>l1,List<String>l2) { 
		boolean flag=false;
		Collections.sort(l1);
		Collections.sort(l2);
		flag=l1.equals(l2);
		return flag;
	}


	public static void waitForPageLoad(WebDriver driver) {

		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				System.out.println("Current Window State       : "
						+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
				return String
						.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

	public static void waitforVisibilityElement(WebDriver driver, WebElement element){
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	@SuppressWarnings("deprecation")
	public static boolean wiatForPopUp(WebDriver driver) {
		boolean flag=false;
		WebDriverWait wait = new WebDriverWait(driver, 300);
		if(wait.until(ExpectedConditions.alertIsPresent())==null)
		{System.out.println("alert was not present");
		}
		else {
			System.out.println("alert was present");
			flag=true;
		}
		return flag;
	}
	
	public static WebElement scrollIntoView(WebDriver driver,WebElement e) { 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		js.executeScript("arguments[0].scrollIntoView(true);", e);
		highLighterMethod(e, driver);
		return e;
		}



	public static void click(WebElement element) throws InterruptedException {

		Thread.sleep(1000);
		element.click();


	}

	public static void  enterText(WebElement element,String text) {
		element.sendKeys(text);
	}

	public static void  textBoxClear(WebElement element) {
		element.clear();
	}

	public static String  getInputText(WebElement element) {
		return element.getAttribute("value");
	}

	//updated for IE ::Nayna
	public static String  getText(WebElement element) {

		String value ="";
		value=element.getText().trim();
		if(value.contentEquals(""))
		{
			value=element.getAttribute("innerHTML").trim();
		}
		//System.out.println(value);
		return value ;
	}

	public static boolean radioButtonStatus(WebElement element) throws InterruptedException {
		
		Thread.sleep(1000);

		if(element.isSelected())
		{
			return true;
		}

		else
		{
			return false;
		}
	}


	public static boolean elementStatus(WebElement element) {

		if(element.isDisplayed()&&element.isEnabled())
		{
			return true;
		}

		else
		{
			return false;
		}
	}


	public static void  mouseClick(WebElement element,WebDriver driver) throws InterruptedException {

		Thread.sleep(1000);
		highLighterMethod(element,driver);
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();

	}


	public static String  getFirstSelectedText(WebElement element) {

		Select sel = new Select(element);
		String firstSelectedOption = sel.getFirstSelectedOption().getAttribute("value");
		if(firstSelectedOption.equals("null"))
		{
			firstSelectedOption="";
		}
		return firstSelectedOption;
	}

	public static String  searchgetFirstSelectedText(WebElement element) {

		Select sel = new Select(element);
		String firstSelectedOption = sel.getFirstSelectedOption().getText();
		if(firstSelectedOption.equals("null"))
		{
			firstSelectedOption="";
		}
		else if(firstSelectedOption.equals(""))
		{
			firstSelectedOption=element.getAttribute("innerHTML");
		}

		return firstSelectedOption;
	}


	//****ScrollintoView*****


	public static void scrollElement(WebElement element,WebDriver driver) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		highLighterMethod(element,driver);

	}

	public static void  jsClick(WebElement element,WebDriver driver) throws InterruptedException {

		Thread.sleep(2000);
		highLighterMethod(element,driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);


	}


	public static String  selectText(WebElement element,String value,WebDriver driver) throws Exception {

		scrollElement(element,driver);
		highLighterMethod(element,driver);
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
		String selectedOption= sel.getFirstSelectedOption().getText();
		return selectedOption;
	}

	public static void selectFirstTextByIndex(WebElement element,WebDriver driver) throws Exception {

		scrollElement(element,driver);
		highLighterMethod(element,driver);
		Select sel = new Select(element);
		sel.selectByIndex(0);
	}

	
	public static void selectByVisibleText(WebElement element,String value,WebDriver driver) throws Exception {

		scrollElement(element,driver);
		highLighterMethod(element,driver);
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}
	
	public static void sendKeys(WebElement element, String Value,WebDriver driver) {
		highLighterMethod(element,driver);
		element.sendKeys(Value);
	}
	
	public static void click(WebElement element, String Value,WebDriver driver) {
		highLighterMethod(element,driver);
		element.click();
	}
	public static String getText(WebElement element, String Value,WebDriver driver) {
		highLighterMethod(element,driver);
		return element.getText();
	}
	
	public static void highLighterMethod( WebElement element,WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		}

	
}
