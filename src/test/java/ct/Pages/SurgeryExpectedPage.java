package ct.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngularModel;

import ct.utilities.HelperSurgeryExpected;

public class SurgeryExpectedPage extends PageObject{

	private static WebElement switchToOriginalDataButton(WebDriver driver,String type)
	{
		return driver.findElement(ByAngularModel.xpath("(//div[text()='"+type+"']//following::a[text()='Switch to Original Data'])[1]"));
	}

	private static WebElement editCostTypeButton(WebDriver driver,String type,String costType) {

		return driver.findElement(ByAngularModel.xpath("(//div[text()='"+type+"']//following::div[@class='wdgt-body row'])[1]//table/tbody/tr/td[text()='"+costType+"']//preceding::td[1]/a[1]"));
	}

	private static WebElement removeCostTypeButton(WebDriver driver,String type,String costType) {

		return driver.findElement(ByAngularModel.xpath("(//div[text()='"+type+"']//following::div[@class='wdgt-body row'])[1]//table/tbody/tr/td[text()='"+costType+"']//preceding::td[1]/a[2]"));
	}

	public static WebElement costType(WebDriver driver,String type,String costType) {
		//Updated for IE  [contains(text(),'Post ')]
		return  driver.findElement(ByAngularModel.xpath(".//div[contains(text(),'"+type+"')]//following::div[@class='wdgt-body row']//tbody//td[contains(text(),'"+costType+"')]"));

		//return driver.findElement(ByAngularModel.xpath("(//div[text()='"+type+"']//following::div[@class='wdgt-body row'])[1]//table/tbody/tr/td[text()='"+costType+"']"));
	}

	public static WebElement inNetworkRadioButton(WebDriver driver,String type,String costType) {

		try {
			//  //Updated for IE ::Nayna
			return driver.findElement(ByAngularModel.xpath(".//div[contains(text(),'"+type+"')]//following::div[@class='wdgt-body row']//tbody//td[contains(text(),'"+costType+"')]//following::td[1]/input"));

			//	return driver.findElement(ByAngularModel.xpath("(//div[text()='"+type+"']//following::div[@class='wdgt-body row'])[1]//table/tbody/tr/td[text()='"+costType+"']//following::td[1]/input"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}

	}

	public static WebElement outNetworkRadioButton(WebDriver driver,String type,String costType) {
		//Updated for IE ::Nayna
		return driver.findElement(ByAngularModel.xpath(".//div[contains(text(),'"+type+"')]//following::div[@class='wdgt-body row']//tbody//td[contains(text(),'"+costType+"')]//following::td[2]/input"));

		//return driver.findElement(ByAngularModel.xpath("(//div[text()='"+type+"']//following::div[@class='wdgt-body row'])[1]//table/tbody/tr/td[text()='"+costType+"']//following::td[2]/input"));
	}

	public static WebElement quantity(WebDriver driver,String type,String costType) {
		//Updated for IE ::Nayna
		return driver.findElement(ByAngularModel.xpath(".//div[contains(text(),'"+type+"')]//following::div[@class='wdgt-body row']//tbody//td[contains(text(),'"+costType+"')]//following::td[3]"));

		//return driver.findElement(ByAngularModel.xpath("(//div[text()='"+type+"']//following::div[@class='wdgt-body row'])[1]//table/tbody/tr/td[text()='"+costType+"']//following::td[3]"));
	}

	private static WebElement totalAmountRange(WebDriver driver,String type,String costType) {
		//Updated for IE ::Nayna
		return driver.findElement(ByAngularModel.xpath(".//div[contains(text(),'"+type+"')]//following::div[@class='wdgt-body row']//tbody//td[contains(text(),'"+costType+"')]//following::td[4]"));
	}
	
	public static WebElement totalOutAmountRange(WebDriver driver,String type,String costType) {
		//Updated for IE ::Nayna
		return driver.findElement(ByAngularModel.xpath(".//div[contains(text(),'"+type+"')]//following::div[@class='wdgt-body row']//tbody//td[contains(text(),'"+costType+"')]//following::td[5]"));
	}

	private static WebElement memberBenfitForItem(WebDriver driver,String type,String costType) {
		//Updated for IE ::Nayna
		return driver.findElement(ByAngularModel.xpath(".//div[contains(text(),'"+type+"')]//following::div[@class='wdgt-body row']//tbody//td[contains(text(),'"+costType+"')]//following::td[6]"));

		//	return driver.findElement(ByAngularModel.xpath("(//div[text()='"+type+"']//following::div[@class='wdgt-body row'])[1]//table/tbody/tr/td[text()='"+costType+"']//following::td[5]"));
	}

	private static WebElement estimatedMemberOOP(WebDriver driver,String type,String costType) {

		return driver.findElement(ByAngularModel.xpath("(//div[text()='"+type+"']//following::div[@class='wdgt-body row'])[1]//table/tbody/tr/td[text()='"+costType+"']//following::td[7]"));
	}

	//Nayna code - Amount calculation

	public static WebElement radioNonSurgery(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath(".//*[contains(text(),'Surgery Not Expected')]//parent::div/input[1]"));

	}

	public static WebElement radioSurgery(WebDriver driver) {
		return driver.findElement(ByAngularModel.xpath(".//*[contains(text(),'Surgery Expected')]//parent::div/input[1]"));

	}

	//In -- Dhanapal 10/4/2020
	public static WebElement textTotalAmtsubTotal(WebDriver driver,String text) {
		return scrollIntoView(driver,driver.findElement(ByAngularModel.xpath(".//div[contains(text(),'"+text+"')]//parent::div[@class='wdgt-wrpr']//tfoot//td[1]/span[contains(text(),'Sub-Total:')][1]/parent::td[1]")));
	}
	
	//Out -- Dhanapal 10/4/2020
	public static WebElement textTotalAmtsubOutTotal(WebDriver driver,String text) {
		return scrollIntoView(driver,driver.findElement(ByAngularModel.xpath(".//div[contains(text(),'"+text+"')]//parent::div[@class='wdgt-wrpr']//tfoot//td[2]/span[contains(text(),'Sub-Total:')][1]/parent::td[1]")));
	}


	public static WebElement textEstimatedAmtsubTotal(WebDriver driver ,String text) {
		return scrollIntoView(driver,driver.findElement(ByAngularModel.xpath(".//div[contains(text(),'"+text+"')]//parent::div[@class='wdgt-wrpr']//tfoot//td[3]/span[contains(text(),'Sub-Total:')][1]/parent::td[1]")));
	}

	// Text : Diagnosis , Treatment [for non surgery]
	//Test: Post, Pre , During [for surgery]
	public static  List<WebElement> tablerows(WebDriver driver , String text){
		return driver.findElements(ByAngularModel.xpath(".//div[contains(text(),'"+text+"')]//parent::div[@class='wdgt-wrpr']//tbody/tr"));
	}

	//get Total Amount Range incol value as per given table row.
	public static List<WebElement> colTotalAmountRange(WebDriver driver, String text) {
		List<WebElement> colTotalAmountRange = new ArrayList<WebElement>();
		List<WebElement> tablerows = SurgeryExpectedPage.tablerows(driver,text);
		int size = tablerows.size();
		for(int count=1;count<=size;count++) {
			WebElement col = driver.findElement(ByAngularModel.xpath(".//div[contains(text(),'"+text+"')]//parent::div[@class='wdgt-wrpr']//tbody/tr["+count+"]//td[6]"));
			scrollIntoView(driver, col);
			colTotalAmountRange.add(col);  //gettext return $0.00-$86.56
		}
		return colTotalAmountRange;
	}
	
	//Out -- Dhanapal 10/4/2020
	public static List<WebElement> colTotalOutAmountRange(WebDriver driver, String text) {
		List<WebElement> colTotalAmountRange = new ArrayList<WebElement>();
		List<WebElement> tablerows = SurgeryExpectedPage.tablerows(driver,text);
		int size = tablerows.size();
		for(int count=1;count<=size;count++) {
			WebElement col = driver.findElement(ByAngularModel.xpath(".//div[contains(text(),'"+text+"')]//parent::div[@class='wdgt-wrpr']//tbody/tr["+count+"]//td[7]"));
			scrollIntoView(driver, col);
			colTotalAmountRange.add(col);  //gettext return $0.00-$86.56
		}
		return colTotalAmountRange;
	}
	
	//get Total Amount Range col value as per given table row.
	public static List<WebElement> colEstimatedMemberOOP(WebDriver driver, String text) {

		List<WebElement> colEstimatedMemberOOP = new ArrayList<WebElement>();
		List<WebElement> tablerows = SurgeryExpectedPage.tablerows(driver,text);
		int size = tablerows.size();
		for(int count=1;count<=size;count++) {
			WebElement col = driver.findElement(ByAngularModel.xpath("//div[contains(text(),'"+text+"')]//parent::div[@class='wdgt-wrpr']//tbody/tr["+count+"]//td[9]"));
			scrollIntoView(driver, col);
			colEstimatedMemberOOP.add(col);  //gettext return $0.00-$86.56
		}
		return colEstimatedMemberOOP;
	}
	
	//Total In Network value 
	public static WebElement txtTotalInNetwork(WebDriver driver) {
	return scrollIntoView(driver,driver.findElement(ByAngularModel.xpath(".//div[contains(@class,'total-value ng-star-inserted')]//b[contains(text(),' In-Network')]//parent::p/span")));
	}
	//Total Out Network value
	public static WebElement txtTotalOutNetwork(WebDriver driver) {
	return scrollIntoView(driver,driver.findElement(ByAngularModel.xpath(".//div[contains(@class,'total-value ng-star-inserted')]//b[contains(text(),' Out-of-Network')]//parent::p/span")));
	}
	
	//Total Estimated Member OOP
	public static WebElement txtTotalEstimatedMemberOOP(WebDriver driver) {
		return scrollIntoView(driver,driver.findElement(ByAngularModel.xpath(".//div[contains(@class,'total-value ng-star-inserted')]//b[contains(text(),'Estimated Member')]//parent::p/span")));
		}

	public static String getTotalInNetworkForSurgery(WebDriver driver){
	//Click on surgery :: for correct flow
	SurgeryExpectedPage.radioSurgery(driver).click();
	List<WebElement> colTotalAmountRangePre = SurgeryExpectedPage.colTotalAmountRange(driver,"Pre");
	List<WebElement> colTotalAmountRangeDuring = SurgeryExpectedPage.colTotalAmountRange(driver,"During");
	List<WebElement> colTotalAmountRangePost = SurgeryExpectedPage.colTotalAmountRange(driver,"Post");
	colTotalAmountRangePre.addAll(colTotalAmountRangePost);
	colTotalAmountRangePre.addAll(colTotalAmountRangeDuring);
	String subTotal = HelperSurgeryExpected.getSubTotal(colTotalAmountRangePre);
	String value=subTotal.split("-")[0]+" "+"-"+" "+subTotal.split("-")[1];
	System.out.println("subTotal for only surgery table as"+subTotal); 
	return value;
	}
	
	public static String getTotalInNetworkForNonSurgery(WebDriver driver) {
	//before checking non surgery need to click on the non -surgery.  // Text : Diagnosis , Treatment [for non surgery]
	SurgeryExpectedPage.radioNonSurgery(driver).click();
	List<WebElement> colTotalAmountRangeDiagnosis = SurgeryExpectedPage.colTotalAmountRange(driver,"Diagnosis");
	List<WebElement> colTotalAmountRangeTreatment = SurgeryExpectedPage.colTotalAmountRange(driver,"Treatment");
	colTotalAmountRangeDiagnosis.addAll(colTotalAmountRangeTreatment);
	String subTotal = HelperSurgeryExpected.getSubTotal(colTotalAmountRangeDiagnosis);
	System.out.println("subTotal for After adding non surgery table as"+subTotal); 
	String value=subTotal.split("-")[0]+" "+"-"+" "+subTotal.split("-")[1];
	System.out.println("subTotal for only surgery non surgery table as"+subTotal); 
	return value;
	}
	public static String getTotalOutNetworkForSurgery(WebDriver driver){
	//Click on surgery :: for correct flow
	SurgeryExpectedPage.radioSurgery(driver).click();
	List<WebElement> colTotalAmountRangePre = SurgeryExpectedPage.colTotalOutAmountRange(driver,"Pre");
	List<WebElement> colTotalAmountRangeDuring = SurgeryExpectedPage.colTotalOutAmountRange(driver,"During");
	List<WebElement> colTotalAmountRangePost = SurgeryExpectedPage.colTotalOutAmountRange(driver,"Post");
	colTotalAmountRangePre.addAll(colTotalAmountRangePost);
	colTotalAmountRangePre.addAll(colTotalAmountRangeDuring);
	String subTotal = HelperSurgeryExpected.getSubTotal(colTotalAmountRangePre);
	String value=subTotal.split("-")[0]+" "+"-"+" "+subTotal.split("-")[1];
	System.out.println("subTotal for only surgery table as"+subTotal); 
	return value;
	}
	public static String getTotalOutNetworkForNonSurgery(WebDriver driver) {
	//before checking non surgery need to click on the non -surgery.  // Text : Diagnosis , Treatment [for non surgery]
	SurgeryExpectedPage.radioNonSurgery(driver).click();
	List<WebElement> colTotalAmountRangeDiagnosis = SurgeryExpectedPage.colTotalOutAmountRange(driver,"Diagnosis");
	List<WebElement> colTotalAmountRangeTreatment = SurgeryExpectedPage.colTotalOutAmountRange(driver,"Treatment");
	colTotalAmountRangeDiagnosis.addAll(colTotalAmountRangeTreatment);
	String subTotal = HelperSurgeryExpected.getSubTotal(colTotalAmountRangeDiagnosis);
	System.out.println("subTotal for After adding non surgery table as"+subTotal); 
	String value=subTotal.split("-")[0]+" "+"-"+" "+subTotal.split("-")[1];
	System.out.println("subTotal for only surgery non surgery table as"+subTotal); 
	return value;
	}

	public static String getTotalEstimatedMemberOOPForSurgery(WebDriver driver){
	//Click on surgery :: for correct flow
	SurgeryExpectedPage.radioSurgery(driver).click();
	List<WebElement> colTotalAmountRangePre = SurgeryExpectedPage.colEstimatedMemberOOP(driver,"Pre");
	List<WebElement> colTotalAmountRangeDuring = SurgeryExpectedPage.colEstimatedMemberOOP(driver,"During");
	List<WebElement> colTotalAmountRangePost = SurgeryExpectedPage.colEstimatedMemberOOP(driver,"Post");
	colTotalAmountRangePre.addAll(colTotalAmountRangePost);
	colTotalAmountRangePre.addAll(colTotalAmountRangeDuring);
	String subTotal = HelperSurgeryExpected.getSubTotal(colTotalAmountRangePre);
	String value=subTotal.split("-")[0]+" "+"-"+" "+subTotal.split("-")[1];
	System.out.println("subTotal for only surgery table as"+subTotal); 
	return value;
	}
	
	public static String getTotalEstimatedMemberOOPForNonSurgery(WebDriver driver) {
	//before checking non surgery need to click on the non -surgery.  // Text : Diagnosis , Treatment [for non surgery]
	SurgeryExpectedPage.radioNonSurgery(driver).click();
	List<WebElement> colTotalAmountRangeDiagnosis = SurgeryExpectedPage.colEstimatedMemberOOP(driver,"Diagnosis");
	List<WebElement> colTotalAmountRangeTreatment = SurgeryExpectedPage.colEstimatedMemberOOP(driver,"Treatment");
	colTotalAmountRangeDiagnosis.addAll(colTotalAmountRangeTreatment);
	String subTotal = HelperSurgeryExpected.getSubTotal(colTotalAmountRangeDiagnosis);
	System.out.println("subTotal for After adding non surgery table as"+subTotal); 
	String value=subTotal.split("-")[0]+" "+"-"+" "+subTotal.split("-")[1];
	System.out.println("subTotal for only surgery non surgery table as"+subTotal); 
	return value;
	}



	public static void clickSwitchToOriginalData(WebDriver driver,String type) throws Exception
	{
		scrollElement(switchToOriginalDataButton(driver,type),driver);
		mouseClick(switchToOriginalDataButton(driver,type),driver);

	}


	public static void clickEditCostType(WebDriver driver,String type,String costType) throws Exception
	{	

		Thread.sleep(1000);
		scrollElement(editCostTypeButton(driver,type,costType),driver);
		mouseClick(editCostTypeButton(driver,type,costType),driver);
	}

	public static void clickRemoveCostType(WebDriver driver,String type,String costType) throws Exception
	{	

		scrollElement(removeCostTypeButton(driver,type,costType),driver);
		mouseClick(removeCostTypeButton(driver,type,costType),driver);
	}

	public static String costTypeText(WebDriver driver,String type,String costType) throws Exception
	{	
		try {

			scrollElement(costType(driver,type,costType),driver);
			return getText(costType(driver,type,costType));
		}

		catch(org.openqa.selenium.NoSuchElementException e)
		{
			return "Exception";
		}



	}

	public static String costTypeTextCheck(WebDriver driver,String type,String costType,String inNetworkStatus) throws Exception
	{	
		try {

			scrollElement(costType(driver,type,costType),driver);

			if(inNetworkStatus.equalsIgnoreCase("1"))
			{
				if(!inNetworkRadioButton(driver,type,costType).isSelected())
				{
					System.out.println("No In network selected");
					return "Exception";
				}
			}
			else
			{
				if(!outNetworkRadioButton(driver,type,costType).isSelected())
				{
					System.out.println("No out network selected");
					return "Exception";
				}

			}

			return "No Exception";

		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			return "Exception";
		}



	}

	public static String inNetworkRadioButtonStatus(WebDriver driver,String type,String costType) throws Exception
	{	
		scrollElement(inNetworkRadioButton(driver,type,costType),driver);
		boolean flag = radioButtonStatus(inNetworkRadioButton(driver,type,costType));
		if(flag==true)
		{
			return "1";
		}

		else
		{
			return "0";
		}

	}

	public static String outNetworkRadioButtonStatus(WebDriver driver,String type,String costType) throws Exception
	{	
		scrollElement(outNetworkRadioButton(driver,type,costType),driver);
		boolean flag = radioButtonStatus(outNetworkRadioButton(driver,type,costType));
		if(flag==true)
		{
			return "1";
		}

		else
		{
			return "0";
		}

	}

	public static String quantityText(WebDriver driver,String type,String costType) throws Exception
	{	
		scrollElement(quantity(driver,type,costType),driver);
		return getText(quantity(driver,type,costType));

	}

	public static String totalAmountRangeText(WebDriver driver,String type,String costType) throws Exception
	{	
		scrollElement(totalAmountRange(driver,type,costType),driver);
		return getText(totalAmountRange(driver,type,costType));

	}
	
	public static String totalOutAmountRangeText(WebDriver driver,String type,String costType) throws Exception
	{	
		scrollElement(totalOutAmountRange(driver,type,costType),driver);
		return getText(totalOutAmountRange(driver,type,costType));

	}

	public static String memberBenfitForItemText(WebDriver driver,String type,String costType) throws Exception
	{	
		scrollElement(memberBenfitForItem(driver,type,costType),driver);
		return getText(memberBenfitForItem(driver,type,costType));

	}

	public static String estimatedMemberOOPText(WebDriver driver,String type,String costType) throws Exception
	{	
		scrollElement(estimatedMemberOOP(driver,type,costType),driver);
		return getText(estimatedMemberOOP(driver,type,costType));

	}
}
