package ct.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngularModel;

public class PlanInfoPage extends PageObject {

	// ********************* PlanInfoPage ********************

	public static WebElement labelPlan(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Plan')])[1]"));
	}
	public static WebElement labelPlanName(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Plan Name')])[1]"));
	}
	public static WebElement labelDeductibeSpendOutNetwork(WebDriver driver) {
		return scrollIntoView(driver,driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Spent Out Network')])[1]")));
	}
	public static WebElement labelDeductibeLimitOutNetwork(WebDriver driver) {
		return scrollIntoView(driver, driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Deductibe Limit Out Network')])[1]")));
	}
	public static WebElement labelDeductibeSpendInNetwork(WebDriver driver) {
		return scrollIntoView(driver, driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Spent In Network')])[1]")));
	}
	public static WebElement labelDeductibeLimitInNetwork(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Limit In Network')])[1]"));
	}
	public static WebElement labelOOPSpendOutNetwork(WebDriver driver) {
		return scrollIntoView(driver, driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'OOP Spent Out Network')])[1]")));
	}
	public static WebElement labelOOPLimitOutNetwork(WebDriver driver) {
		return scrollIntoView(driver,driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'OOP Limit Out Network')])[1]")));
	}
	public static WebElement labelOOPSpendInNetwork(WebDriver driver) {
		return scrollIntoView(driver,driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'OOP Spent In Network')])[1]")));
	}
	public static WebElement labelOOPLimitInNetwork(WebDriver driver) {
		return  scrollIntoView(driver,driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'OOP Limit In Network')])[1]")));
	}

	// *********** Labels End  ****************

	public static WebElement labelPlanInfo(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//div[contains(text(),'Plan Information')]"));
	}
	public static WebElement inputPlan(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Plan')])[1]//following-sibling::input"));
	}
	public static WebElement inputPlanName(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Plan Name')])[1]//following-sibling::input"));
	}
	public static WebElement inputDeductibeSpendOutNetwork(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Spent Out Network')])[1]//following-sibling::input"));
	}
	public static WebElement inputDeductibeLimitOutNetwork(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Limit Out Network')])[1]//following-sibling::input"));
	}
	public static WebElement inputDeductibeSpendInNetwork(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Spent In Network')])[1]//following-sibling::input"));
	}
	public static WebElement inputDeductibeLimitInNetwork(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'Limit In Network')])[1]//following-sibling::input"));
	}
	public static WebElement inputOOPSpendOutNetwork(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'OOP Spent Out Network')])[1]//following-sibling::input"));
	}
	public static WebElement inputOOPLimitOutNetwork(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'OOP Limit Out Network')])[1]//following-sibling::input"));
	}
	public static WebElement inputOOPSpendInNetwork(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'OOP Spent In Network')])[1]//following-sibling::input"));
	}
	public static WebElement inputOOPLimitInNetwork(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//label[contains(text(),'OOP Limit In Network')])[1]//following-sibling::input"));
	}

	public static String planValidation(WebDriver driver)
	{	
		System.out.println("MemberPlan in CostTransparency :"+getInputText(inputPlan(driver)));
		return getInputText(inputPlan(driver));		
	}

	public static String planNameValidation(WebDriver driver)
	{	
		System.out.println("MemberPlanName in CostTransparency :"+getInputText(inputPlanName(driver)));
		return getInputText(inputPlanName(driver));		
	}

	public static String deductibeSpentOutNetworkValidation(WebDriver driver)
	{	
		System.out.println("DeductibeSpentOutNetwork in CostTransparency :"+getInputText(inputDeductibeSpendOutNetwork(driver)));
		return getInputText(inputDeductibeSpendOutNetwork(driver));		
	}

	public static String deductibeLimitOutNetworkValidation(WebDriver driver)
	{	
		System.out.println("DeductibeLimitOutNetwork in CostTransparency :"+getInputText(inputDeductibeLimitOutNetwork(driver)));
		return getInputText(inputDeductibeLimitOutNetwork(driver));		
	}

	public static String deductibeSpentInNetworkValidation(WebDriver driver)
	{	
		System.out.println("DeductibeSpentInNetwork in CostTransparency :"+getInputText(inputDeductibeSpendInNetwork(driver)));
		return getInputText(inputDeductibeSpendInNetwork(driver));		
	}

	public static String deductibeLimitInNetworkValidation(WebDriver driver)
	{	
		System.out.println("DeductibeLimitInNetwork in CostTransparency :"+getInputText(inputDeductibeLimitInNetwork(driver)));
		return getInputText(inputDeductibeLimitInNetwork(driver));		
	}

	public static String oopSpentOutNetworkValidation(WebDriver driver)
	{	
		System.out.println("OOPSpendOutNetwork in CostTransparency :"+getInputText(inputOOPSpendOutNetwork(driver)));
		return getInputText(inputOOPSpendOutNetwork(driver));		
	}

	public static String oopLimitOutNetworkValidation(WebDriver driver)
	{	
		System.out.println("OOPLimitOutNetwork in CostTransparency :"+getInputText(inputOOPLimitOutNetwork(driver)));
		return getInputText(inputOOPLimitOutNetwork(driver));		
	}

	public static String oopSpentInNetworkTestValidation(WebDriver driver)
	{	
		System.out.println("OOPSpendInNetwork in CostTransparency :"+getInputText(inputOOPSpendInNetwork(driver)));
		return getInputText(inputOOPSpendInNetwork(driver));		
	}

	public static String oopLimitInNetworkValidation(WebDriver driver)
	{	
		System.out.println("OOPLimitInNetwork in CostTransparency :"+getInputText(inputOOPLimitInNetwork(driver)));
		return getInputText(inputOOPLimitInNetwork(driver));		
	}

}
