package ct.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngularModel;

public class ProviderInformationPage extends PageObject {

	// ************** ProviderInformationPage  **************

	public static WebElement labelProviderName(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Name')])[3]"));
	}
	public static WebElement labelProviderAddress(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Address')])[2]"));
	}
	public static WebElement labelProviderState(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'State')])[2]"));
	}
	public static WebElement labelProviderCity(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'City')])[2]"));
	}
	public static WebElement labelProviderZip(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Zip')])[2]"));
	}
	public static WebElement labelProviderSpeciality(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Speciality')])[1]"));
	}
	public static WebElement labelProviderNetworkStatus(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Network Status')])[1]"));
	}

	// ************* Labels End **********
	public static WebElement labelProviderInfo(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//div[contains(text(),'Provider Information')]"));
	}
	public static WebElement inputName(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Name')])[3]//following-sibling::input"));
	}
	public static WebElement inputAddress(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Address')])[2]//following-sibling::input"));
	}
	public static WebElement inputState(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'State')])[2]//following-sibling::input"));
	}
	public static WebElement inputCity(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'City')])[2]//following-sibling::input"));
	}
	public static WebElement inputZip(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Zip')])[2]//following-sibling::input"));
	}
	public static WebElement inputSpeciality(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Speciality')])[1]//following-sibling::input"));
	}
	public static WebElement inputNetworkStatus(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Network Status')])[1]//following-sibling::input"));
	}

	public static String nameValidation(WebDriver driver)
	{	
		System.out.println("Provider Name in CostTransparency :"+getInputText(inputName(driver)));
		return getInputText(inputName(driver));		
	}

	public static String addressValidation(WebDriver driver)
	{	
		System.out.println("Provider Address in CostTransparency :"+getInputText(inputAddress(driver)));
		return getInputText(inputAddress(driver));		
	}

	public static String stateValidation(WebDriver driver)
	{	
		System.out.println("Provider State in CostTransparency :"+getInputText(inputState(driver)));
		return getInputText(inputState(driver));		
	}

	public static String cityValidation(WebDriver driver)
	{	
		System.out.println("Provider City in CostTransparency :"+getInputText(inputCity(driver)));
		return getInputText(inputCity(driver));		
	}

	public static String zipValidation(WebDriver driver)
	{	
		System.out.println("Provider Zipcode in CostTransparency :"+getInputText(inputZip(driver)));
		return getInputText(inputZip(driver));		
	}

	public static String specialityValidation(WebDriver driver)
	{	
		System.out.println("Provider Speciality in CostTransparency :"+getInputText(inputSpeciality(driver)));
		return getInputText(inputSpeciality(driver));		
	}

	public static String networkStatusValidation(WebDriver driver)
	{	
		System.out.println("Provider Network Status in CostTransparency :"+getInputText(inputNetworkStatus(driver)));
		return getInputText(inputNetworkStatus(driver));		
	}




}
