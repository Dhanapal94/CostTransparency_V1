package ct.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngularModel;

public class MemberDemographicsPage extends PageObject {

	// ******************MemberDemographicspage ******************

	public static WebElement labelName(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Name')])[1]"));
	}
	public static WebElement labelPhoneNo(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Phone')])[1]"));
	}
	public static WebElement labelDOB(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'DOB')])[1]"));
	}
	public static WebElement labelHICN(WebDriver driver) {
		return scrollIntoView(driver, driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'HICN')])[1]")));
	}
	public static WebElement labelMBI(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'MBI')])[1]"));
	}
	public static WebElement labelLanguage(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Language')])[1]"));
	}
	public static WebElement labelAddress(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Address')])[1]"));
	}
	public static WebElement labelCity(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'City')])[1]"));
	}
	public static WebElement labelState(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'State')])[1]"));
	}
	public static WebElement labelZip(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Zip')])[1]"));
	}

	//****** Labels End *********

	public static WebElement labelMebDemoGraphic(WebDriver driver) {
		return driver.findElement(ByAngularModel.className("wdgt-hdr"));		
	}
	public static WebElement inputName(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Name')])[1]//following-sibling::input"));
	}
	public static WebElement inputPhoneNo(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Phone')])[1]//following-sibling::input"));
	}
	public static WebElement inputDOB(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'DOB')])[1]//following-sibling::input"));
	}
	public static WebElement inputHICN(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'HICN')])[1]//following-sibling::input"));
	}
	public static WebElement inputMBI(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'MBI')])[1]//following-sibling::input"));
	}
	public static WebElement inputLanguage(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Language')])[1]//following-sibling::input"));
	}
	public static WebElement inputAddress(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Address')])[1]//following-sibling::input"));
	}
	public static WebElement inputCity(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'City')])[1]//following-sibling::input"));
	}
	public static WebElement inputState(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'State')])[1]//following-sibling::input"));
	}
	public static WebElement inputZip(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Zip')])[1]//following-sibling::input"));
	}

	public static WebElement agreeButton(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//button[text()='Agree']"));
	}

	public static void clickAgree(WebDriver driver) throws Exception
	{	
		click(agreeButton(driver));

	}


	public static String memberIdentifierValidation(WebDriver driver)
	{	
		System.out.println("MemberPlan in CostTransparency :"+getInputText(inputMBI(driver)));
		return getInputText(inputMBI(driver));		
	}


	public static String nameValidation(WebDriver driver)
	{
		System.out.println("Name in CostTransparency :"+getInputText(inputName(driver)));
		return getInputText(inputName(driver));

	}

	public static String hicnValidation(WebDriver driver)
	{	
		System.out.println("HICN number in CostTransparency :"+getInputText(inputHICN(driver)));
		return getInputText(inputHICN(driver));
	}

	public static String dobValidation(WebDriver driver)
	{
		System.out.println("DOB in CostTransparency :"+getInputText(inputDOB(driver)));
		return getInputText(inputDOB(driver));	
	}

	public static String primaryPhoneValidation(WebDriver driver) {

		System.out.println("PrimaryPhone in CostTransparency :"+getInputText(inputPhoneNo(driver)));
		return getInputText(inputPhoneNo(driver));	

	}

	public static String primaryLanguageValidation(WebDriver driver) {

		System.out.println("PrimaryLanguage in CostTransparency :"+getInputText(inputLanguage(driver)));
		return getInputText(inputLanguage(driver));	
	}


	public static String addressValidation(WebDriver driver) {

		System.out.println("MemberAddress in CostTransparency :"+getInputText(inputAddress(driver)));
		return getInputText(inputAddress(driver));

	}

	public static String cityValidation(WebDriver driver) {

		System.out.println("MemberCity in CostTransparency :"+getInputText(inputCity(driver)));
		return getInputText(inputCity(driver));
	}

	public static String  stateValidation(WebDriver driver) {

		System.out.println("MemberState in CostTransparency :"+getInputText(inputState(driver)));
		return getInputText(inputState(driver));
	}

	public static String zipCodeValidation(WebDriver driver) {

		System.out.println("MemberZipCode in CostTransparency :"+getInputText(inputZip(driver)));
		return getInputText(inputZip(driver));
	}


}
