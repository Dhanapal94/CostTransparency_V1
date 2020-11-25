package ct.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngularModel;

public class PriorAuthInfoPage extends PageObject{

	// ********************************PriorAuthInfoPage

	public static WebElement labelPriorAuthInfo(WebDriver driver) { 
		return scrollIntoView(driver, driver.findElement(ByAngularModel.xpath("//*[@class='wdgt-hdr'][contains(text(),'Prior')]")));
	}
	public static WebElement labelReferanceNo(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//*[@id='servicerefdd']//parent::div/label[1]"));
	}
	public static WebElement labelHSCID(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'HSC ID')])[1]"));
	}
	public static WebElement labelDateofProcedure(WebDriver driver) {
		return scrollIntoView(driver, driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Date of ')])[1]")));
	}
	public static WebElement labelProcedureCode(WebDriver driver) {
		return scrollIntoView(driver, driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Procedure Code')])[1]")));
	}
	public static WebElement labelFacility(WebDriver driver) {
		return scrollIntoView(driver, driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Facility')])[1]")));
	}

	// ********* Labels End ***********

	public static WebElement labelPlanInfo(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//div[contains(text(),'Prior Auth Information')]"));
	}
	public static WebElement selectReferanceNo(WebDriver driver) {
		return driver.findElement(ByAngularModel.id("servicerefdd"));
	}
	public static WebElement inputHSCID(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'HSC ID')])[1]//following-sibling::input"));
	}
	public static WebElement inputDateofProcedure(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Date of ')])[1]//following-sibling::input"));
	}
	public static WebElement inputProcedureCode(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Procedure Code')])[1]//following-sibling::input"));
	}
	public static WebElement inputFacility(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Facility')])[1]//following-sibling::input"));
	}
	public static WebElement inputCodeDescription(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Procedure Code Description')])[1]//following-sibling::input"));
	}

	public static String serviceRefrenceNumberValidation(WebDriver driver) throws Exception
	{	
		scrollElement(selectReferanceNo(driver), driver);
		System.out.println("Service Refrence Number in CostTransparency :"+getFirstSelectedText(selectReferanceNo(driver)));
		return getFirstSelectedText(selectReferanceNo(driver));		
	}


	public static String serviceRefrenceNumberSelectionValidation(WebDriver driver,String selText) throws Exception
	{	
		String value = selectText(selectReferanceNo(driver),selText,driver);
		System.out.println("Service Refrence Number in CostTransparency :"+value);
		return value;	
	}


	public static String hscIdValidation(WebDriver driver)
	{	
		System.out.println("HSC ID in CostTransparency :"+getInputText(inputHSCID(driver)));
		return getInputText(inputHSCID(driver));		
	}

	public static String dateOfProcedureValidation(WebDriver driver)
	{	
		System.out.println("Date of Procedure in CostTransparency :"+getInputText(inputDateofProcedure(driver)));
		return getInputText(inputDateofProcedure(driver));		
	}


	public static String procedureCodeValidation(WebDriver driver)
	{	
		System.out.println("Procedure Code in CostTransparency :"+getInputText(inputProcedureCode(driver)));
		return getInputText(inputProcedureCode(driver));		
	}

	public static String facilityValidation(WebDriver driver)
	{	
		System.out.println("Facility in CostTransparency :"+getInputText(inputFacility(driver)));
		return getInputText(inputFacility(driver));		
	}

	public static String codeDescriptionValidation(WebDriver driver)
	{	
		System.out.println("Procedure Code Descrition in CostTransparency :"+getInputText(inputCodeDescription(driver)));
		return getInputText(inputCodeDescription(driver));		
	}



}
