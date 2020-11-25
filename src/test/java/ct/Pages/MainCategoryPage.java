package ct.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngularModel;

public class MainCategoryPage extends PageObject {


	//***********************************MainCategoryPage Labels***************************

	public static WebElement labelCCSCategory(WebDriver driver) 
	{
		return driver.findElement(ByAngularModel.xpath("//label[text()='CCS Category']"));
	}
	public static WebElement labelDiagnosis(WebDriver driver)
	{
		return driver.findElement(ByAngularModel.xpath("//label[text()='Diagnosis']"));
	}
	public static WebElement labelSurgeryExpected(WebDriver driver)
	{
		return driver.findElement(ByAngularModel.xpath("(//*[@class='form-group form-check row'])[1]//label"));
	}
	public static WebElement labelSurgeryNotExpected(WebDriver driver)
	{
		return driver.findElement(ByAngularModel.xpath("(//*[@class='form-group form-check row'])[2]//label"));
	}
	public static WebElement labelTotalIn(WebDriver driver) {
		return scrollIntoView(driver,driver.findElement(ByAngularModel.xpath("//*[@class='wdgt-hdr-trans'][1]/b")));
	}
	public static WebElement labelTotalOut(WebDriver driver) {
		return scrollIntoView(driver,driver.findElement(ByAngularModel.xpath("//*[@class='wdgt-hdr-trans'][2]/b")));
	}
	public static WebElement labelTable(WebDriver driver,String text) {
		return scrollIntoView(driver, driver.findElement(ByAngularModel.xpath("//*[@class='wdgt-hdr'][contains(text(),'"+text+"')]")));
	}

	//get Table Header text as per table name 
	public static List<String> colTableHeaders(WebDriver driver, String text) {
		List<String> colThTable = new ArrayList<String>();
		int size = 8;   //updated count 7 to 8 due to CR :Cost Transparency Pilot[Added new col]
		if(text.contains("Search")) {
			size=9;
		}
		for(int count=1;count<=size;count++) {
			WebElement col = driver.findElement(ByAngularModel.xpath("//div[contains(text(),'"+text+"')]//parent::div[@class='wdgt-wrpr']//thead//th["+count+"]"));
			scrollIntoView(driver, col);
			colThTable.add(col.getText());  //get text return $0.00-$86.56
		}
		return colThTable;
	}


	//************Label End****************

	private static WebElement selectCCSCategory(WebDriver driver)
	{
		return driver.findElement(ByAngularModel.xpath("//label[text()='CCS Category']//following::select[1]"));

	}

	public static WebElement selectDiagnosis(WebDriver driver)
	{
		return driver.findElement(ByAngularModel.xpath("//label[text()='Diagnosis']//following::select[1]"));

	}

	public static WebElement buttonReset(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//button[text()='Reset']"));
	}

	public static WebElement buttonSave(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//button[text()='Save']"));
	}

	public static WebElement buttonGoToSearch(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//button[text()='Go to Search']"));
	}

	private static WebElement textSaveMessage(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//div[text()='Save']//following::div[1]"));
	}

	private static WebElement textValidationMessage(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//div[text()='Validation']//following::div[1]"));
	}

	private static WebElement textResetMessage(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath("//div[text()='Reset']//following::div[1]"));
	}

	//Methods

	public static String ccsCategoryDefaultSelectedText(WebDriver driver) throws Exception
	{
		return getFirstSelectedText(selectCCSCategory(driver));
	}

	public static String diagnosisDefaultSelectedText(WebDriver driver) throws Exception
	{
		return getFirstSelectedText(selectDiagnosis(driver));
	}



	public static void clickMainSave(WebDriver driver) throws Exception
	{	
		mouseClick(buttonSave(driver),driver);
	}

	public static void clickMainReset(WebDriver driver) throws Exception
	{	
		mouseClick(buttonReset(driver),driver);
	}

	public static void clickMainGoToSearch(WebDriver driver) throws Exception
	{	
		mouseClick(buttonGoToSearch(driver),driver);
	}

	public static String saveMessage(WebDriver driver) throws Exception
	{	

		return getText(textSaveMessage(driver));
	}

	public static String validationMessage(WebDriver driver) throws Exception
	{	

		return getText(textValidationMessage(driver));
	}

	public static String resetMessage(WebDriver driver) throws Exception
	{	

		return getText(textResetMessage(driver));
	}

}
