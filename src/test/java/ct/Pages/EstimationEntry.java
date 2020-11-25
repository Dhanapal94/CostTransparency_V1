package ct.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngularModel;

public class EstimationEntry extends PageObject{

	private static WebElement estimationEntryTitle(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//span[contains(@id,'ui-dialog')]"));
	}

	private static WebElement selectCostType(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//select[@class='form-control ng-untouched ng-pristine']"));
	}

	public static WebElement inRadioButton(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//label[text()='In or Out of Network?']//following::input[1]"));
	}

	public static WebElement outRadioButton(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//label[text()='In or Out of Network?']//following::input[2]"));
	}



	public static WebElement inputQuantity(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//label[text()='Quantity']//following::input[1]"));
	}

	private static WebElement inputTotalAmountRange(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//label[text()='Total Amount Range']//following::input[1]"));
	}

	public static WebElement inputMemberBenefitforItem(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//label[text()='Member Benefit for Item']//following::input[1]"));
	}

	public static WebElement inputEstimatedMemberOOP(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//label[text()='Estimated Member OOP']//following::input[1]"));
	}

	private static WebElement buttonSave(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("(//button[text()='Save'])[2]"));
	}

	private static WebElement buttonClose(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//button[text()='Close']"));
	}

	private static WebElement buttonCloseIcon(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//a[@tabindex='0']/span"));
	}


	//Methods

	public static boolean estimationentryTitle(WebDriver driver)
	{
		return elementStatus(estimationEntryTitle(driver));

	}


	public static String costTypeDefaultSelect(WebDriver driver)
	{	
		System.out.println("Select Default Costtype in CostTransparency :"+getFirstSelectedText(selectCostType(driver)));
		return getFirstSelectedText(selectCostType(driver));		
	}


	public static void enterQuantity(WebDriver driver,String input)
	{	
		highLighterMethod(inputQuantity(driver),driver);
		textBoxClear(inputQuantity(driver));
		enterText(inputQuantity(driver),input);
	}

	public static String selectCostType(WebDriver driver,String input)
	{
		try
		{
			selectText(selectCostType(driver),input,driver);
			return "NoException";
		}
		catch(Exception e)
		{
			return "Exception";
		}
	}
	
	public static String clickInorOutNetwork(WebDriver driver)
	{
		try
		{
			boolean selectedFlag = radioButtonStatus(inRadioButton(driver));
			
			if(!selectedFlag)
				
			{
				System.out.println("In radio not selected");
				click(inRadioButton(driver));
				return "No Exception";
			}
			else
			{
				System.out.println("In radio selected");
				click(outRadioButton(driver));
				System.out.println("Selected");
				return "No Exception";
			}
		}
		catch(Exception e)
		{
			return "Exception";
		}
	}


	public static String enterTotalAmountRange(WebDriver driver,String input)
	{
		try
		{

			textBoxClear(inputTotalAmountRange(driver));
			enterText(inputTotalAmountRange(driver),input);
			return "No Exception";
		}
		catch(Exception e)
		{
			return "Exception";

		}

	}

	public static String enterMemberBenefitforItem(WebDriver driver,String input)
	{
		try
		{

			textBoxClear(inputMemberBenefitforItem(driver));
			enterText(inputMemberBenefitforItem(driver),input);
			return "No Exception";
		}
		catch(Exception e)
		{
			return "Exception";

		}

	}

	public static String enterEstimatedMemberOOP(WebDriver driver,String input)
	{
		try
		{

			textBoxClear(inputEstimatedMemberOOP(driver));
			enterText(inputEstimatedMemberOOP(driver),input);
			return "No Exception";
		}
		catch(Exception e)
		{
			return "Exception";

		}

	}
	public static void clickSave(WebDriver driver) throws InterruptedException
	{	
		mouseClick(buttonSave(driver),driver);
	}

	public static void clickClose(WebDriver driver) throws InterruptedException
	{	
		//mouseClick(buttonClose(driver),driver);
		jsClick(buttonClose(driver),driver);
	}

	public static void clickCloseIcon(WebDriver driver) throws InterruptedException
	{	
		mouseClick(buttonCloseIcon(driver),driver);
	}



}
