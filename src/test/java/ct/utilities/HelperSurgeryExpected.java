package ct.utilities;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ct.Pages.EstimationEntry;
import ct.Pages.MainCategoryPage;
import ct.Pages.MemberDemographicsPage;
import ct.Pages.PageObject;
import ct.Pages.PriorAuthInfoPage;
import ct.Pages.SurgeryExpectedPage;
import ct.Testcases.CTWriteExcel;
import ct.intit.Base;
import ct.intit.Baseinit;

public class HelperSurgeryExpected extends Base {

	public static HashMap<String, String> originalList = new HashMap<String, String>();
	public static HashMap<String, String> currentList = new HashMap<String, String>();
	public static HashMap<String, String> dbActualList = new HashMap<String, String>();
	public static HashMap<String, String> dbExpectedList = new HashMap<String, String>();
	public static String minAmountRange, maxAmountRange, minEstimatedMemberOOP, maxEstimatedMemberOOP,inOrOutNetwork;
	public static int tempCount;


	// ***** Adding original information in Screen **** //

	public static void storeOriginalInformation(WebDriver driver, String type, String costType) throws Exception {
		originalList.clear();
		if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("0") &&  SurgeryExpectedPage.inNetworkRadioButtonStatus(driver, Readconfig.getType(),Readconfig.getCostType()).equalsIgnoreCase("1")) {

			SurgeryExpectedPage.outNetworkRadioButton(driver, Readconfig.getType(), Readconfig.getCostType()).click();

		}
		PageObject.scrollElement(SurgeryExpectedPage.costType(driver, type, costType), driver);
		originalList.put("CostType", SurgeryExpectedPage.costTypeText(driver, type, costType));
		originalList.put("InOrOutNetwork", Readconfig.getInOrOutNetwork());

		if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("1") || inOrOutNetwork.equalsIgnoreCase("0"))
		{
			originalList.put("Quantity", SurgeryExpectedPage.quantityText(driver, type, costType));
			if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("1") )
			{
				originalList.put("TotalAmountRange", SurgeryExpectedPage.totalAmountRangeText(driver, type, costType));

			}

			if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("0"))
			{
				originalList.put("TotalAmountRange", SurgeryExpectedPage.totalOutAmountRangeText(driver, type, costType));
			}
		}

		else
		{
			SurgeryExpectedPage.clickEditCostType(driver, type, costType);
			System.out.println(EstimationEntry.inputQuantity(driver).getAttribute("value"));
			PageObject.highLighterMethod(EstimationEntry.inputQuantity(driver), driver);
			originalList.put("Quantity", EstimationEntry.inputQuantity(driver).getAttribute("value"));
			EstimationEntry.clickClose(driver);
			originalList.put("TotalAmountRange", SurgeryExpectedPage.totalOutAmountRangeText(driver, type, costType));
		}

		originalList.put("MemberBeneiftforItem", SurgeryExpectedPage.memberBenfitForItemText(driver, type, costType));
		originalList.put("EstimatedMemberOOP", SurgeryExpectedPage.estimatedMemberOOPText(driver, type, costType));

	}

	// ***** Adding changes on current information in Screen **** //

	public static void currentInformation(WebDriver driver, String type, String costType) throws Exception {
		currentList.clear();
		if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("0") &&  SurgeryExpectedPage.inNetworkRadioButtonStatus(driver, Readconfig.getType(),  Readconfig.getCostType()).equalsIgnoreCase("1")) {

			SurgeryExpectedPage.outNetworkRadioButton(driver, Readconfig.getType(), Readconfig.getCostType()).click();

		}
		PageObject.scrollElement(SurgeryExpectedPage.costType(driver, type, costType), driver);
		currentList.put("CostType", SurgeryExpectedPage.costTypeText(driver, type, costType));
		currentList.put("InOrOutNetwork", Readconfig.getInOrOutNetwork());

		if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("1") || inOrOutNetwork.equals("0"))
		{
			currentList.put("Quantity", SurgeryExpectedPage.quantityText(driver, type, costType));
			if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("1") )
			{
				currentList.put("TotalAmountRange", SurgeryExpectedPage.totalAmountRangeText(driver, type, costType));
			}
			if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("0"))
			{
				currentList.put("TotalAmountRange", SurgeryExpectedPage.totalOutAmountRangeText(driver, type, costType));
			}
		}

		else
		{
			SurgeryExpectedPage.clickEditCostType(driver, type, costType);
			PageObject.highLighterMethod(EstimationEntry.inputQuantity(driver), driver);
			currentList.put("Quantity", EstimationEntry.inputQuantity(driver).getAttribute("value"));
			EstimationEntry.clickClose(driver);
			currentList.put("TotalAmountRange", SurgeryExpectedPage.totalOutAmountRangeText(driver, type, costType));
		}

		currentList.put("MemberBeneiftforItem", SurgeryExpectedPage.memberBenfitForItemText(driver, type, costType));
		currentList.put("EstimatedMemberOOP", SurgeryExpectedPage.estimatedMemberOOPText(driver, type, costType));

	}

	public static void actualInformationDB(WebDriver driver,String type,String costType) throws Exception
	{
		dbActualList.clear();
		if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("0") &&  SurgeryExpectedPage.inNetworkRadioButtonStatus(driver, Readconfig.getType(),Readconfig.getCostType()).equalsIgnoreCase("1")) {

			SurgeryExpectedPage.outNetworkRadioButton(driver, Readconfig.getType(), Readconfig.getCostType()).click();

		}
		PageObject.scrollElement(SurgeryExpectedPage.costType(driver, type, costType),driver);
		dbActualList.put("CostType",SurgeryExpectedPage.costTypeText(driver,type,costType));
		dbActualList.put("InOrOutNetwork", Readconfig.getInOrOutNetwork());

		if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("1") || inOrOutNetwork.equals("0"))
		{
			dbActualList.put("Quantity", SurgeryExpectedPage.quantityText(driver, type, costType));
			dbActualList.put("MemberBeneiftforItem",SurgeryExpectedPage.memberBenfitForItemText(driver,type,costType));
		}

		else
		{
			SurgeryExpectedPage.clickEditCostType(driver, type, costType);
			PageObject.highLighterMethod(EstimationEntry.inputQuantity(driver), driver);
			dbActualList.put("Quantity", EstimationEntry.inputQuantity(driver).getAttribute("value"));
			PageObject.highLighterMethod(EstimationEntry.inputMemberBenefitforItem(driver), driver);
			dbActualList.put("MemberBeneiftforItem", EstimationEntry.inputMemberBenefitforItem(driver).getAttribute("value"));
			EstimationEntry.clickClose(driver);		
		}

		//dbActualList.put("MinAmountRange", minAmountRange);//going as null
		//dbActualList.put("MaxAmountRange", maxAmountRange);//going as null
		dbActualList.put("MinEstimatedMemberOOP", minEstimatedMemberOOP);//going as null
		dbActualList.put("MaxEstimatedMemberOOP", maxEstimatedMemberOOP); //going as null


	}

	public static void expectedInformationDB(String sheetName) throws Exception
	{
		dbExpectedList.clear();
		ExcelUtility.setExcelFile(excelPath,sheetName);
		dbExpectedList.put("CostType",ExcelUtility.getCellData(1,2));
		dbExpectedList.put("InOrOutNetwork",ExcelUtility.getCellData(1,3));
		dbExpectedList.put("Quantity",ExcelUtility.getCellData(1,4));
		//dbExpectedList.put("MinAmountRange",replaceLastCharacter(ExcelUtility.getCellData(1,5)));
		//dbExpectedList.put("MaxAmountRange",replaceLastCharacter(ExcelUtility.getCellData(1,6)));
		dbExpectedList.put("MemberBeneiftforItem",ExcelUtility.getCellData(1,7));
		dbExpectedList.put("MinEstimatedMemberOOP", replaceLastCharacter(ExcelUtility.getCellData(1,8)));
		dbExpectedList.put("MaxEstimatedMemberOOP", replaceLastCharacter(ExcelUtility.getCellData(1,9)));

	}

	// ***** Verifying the changes in DB and Application after save by comparing 2
	// HashMaps ***** //

	public static boolean checkInformationDBValid(WebDriver driver, String type, String costType, String sheetName)
			throws Exception {
		actualInformationDB(driver, type, costType);
		expectedInformationDB(sheetName);
		System.out.println("DBActualList ::"+dbActualList);
		System.out.println("DBExpectedList ::"+dbExpectedList);
		boolean flag = dbActualList.equals(dbExpectedList);
		System.out.println("Both the DB maps are equal? :" + flag);
		return flag;
	}

	// ***** Verifying the changes in GUI dynamically by comparing 2 HashMaps *****

	public static boolean checkInformationGUIValid() {
		System.out.println("originalList ::"+originalList);
		System.out.println("currentList ::"+currentList);
		boolean flag = originalList.equals(currentList);
		System.out.println("Both the GUI maps are equal? :" + flag);
		return flag;
	}

	// ***** Current Quantity Plus or Minus One for dynamic edit quantity *****//

	public static String currentQuantityPlusOrMinusOne() {
		int quantityInteger = Integer.parseInt(originalList.get("Quantity"));
		if (quantityInteger < 100) {
			quantityInteger++;
		} else {
			quantityInteger--;
		}
		String quantity = Integer.toString(quantityInteger);
		return quantity;

	}

	// ***** UPDATING AMOUNTS ***** //

	public static void amountUpdationCostType(WebDriver driver, String type, String costType) throws Exception {
		PageObject.scrollElement(SurgeryExpectedPage.costType(driver, type, costType), driver);
		String tmr, emoop;

		if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("0")) {

			SurgeryExpectedPage.outNetworkRadioButton(driver, Readconfig.getType(), Readconfig.getCostType()).click();

		}

		if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("1") || inOrOutNetwork.equalsIgnoreCase("0"))
		{
			if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("1") )
			{
				tmr=SurgeryExpectedPage.totalAmountRangeText(driver, type, costType);

			}

			else
			{
				tmr=SurgeryExpectedPage.totalOutAmountRangeText(driver, type, costType);
			}

			emoop = SurgeryExpectedPage.estimatedMemberOOPText(driver, type, costType);

		}

		else
		{
			tmr=SurgeryExpectedPage.totalOutAmountRangeText(driver, type, costType);
			SurgeryExpectedPage.clickEditCostType(driver, type, costType);
			PageObject.highLighterMethod(EstimationEntry.inputEstimatedMemberOOP(driver), driver);
			emoop=EstimationEntry.inputEstimatedMemberOOP(driver).getAttribute("value");
			System.out.println(emoop);
			EstimationEntry.clickClose(driver);
		}
		
		String split[] = tmr.split("-");
		minAmountRange = split[0].replaceAll("[$,]", "");
		maxAmountRange = split[1].replaceAll("[$,]", "");
		String split1[] = emoop.split("-");
		minEstimatedMemberOOP = split1[0].replaceAll("[$,]", "");
		maxEstimatedMemberOOP = split1[1].replaceAll("[$,]", "");
		System.out.println(minEstimatedMemberOOP);
		System.out.println(maxEstimatedMemberOOP);

	}

	// ***** REFRESH THE BROWSER *****//

	public static void basicRefresh(WebDriver driver) throws Exception {
		driver.navigate().refresh();
		MemberDemographicsPage.clickAgree(driver);
		MainCategoryPage.selectByVisibleText(MainCategoryPage.selectDiagnosis(driver), Readconfig.getDiagnosis(),
				driver);
		Baseinit.waitForAngularRequestNGDriver(driver);

	}


	public static void refresh(WebDriver driver) throws Exception {
		driver.navigate().refresh();
		MemberDemographicsPage.clickAgree(driver);
		MainCategoryPage.selectByVisibleText(MainCategoryPage.selectDiagnosis(driver), Readconfig.getDiagnosis(),
				driver);
		Baseinit.waitForAngularRequestNGDriver(driver);

		if (Readconfig.getType().contains("Treatment") || Readconfig.getType().contains("Diagnosis")) {
			SurgeryExpectedPage.radioNonSurgery(driver).click();
		}

		if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("0") &&  SurgeryExpectedPage.inNetworkRadioButtonStatus(driver, Readconfig.getType(),  Readconfig.getCostType()).equalsIgnoreCase("1")) {

			if(tempCount==0)
			{
				inOrOutNetwork="1";
				System.out.println("Out Network selected");
				tempCount++;
			}
			SurgeryExpectedPage.outNetworkRadioButton(driver, Readconfig.getType(), Readconfig.getCostType()).click();

		}

		if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("0") &&  SurgeryExpectedPage.inNetworkRadioButtonStatus(driver, Readconfig.getType(),  Readconfig.getCostType()).equalsIgnoreCase("0"))
		{
			if(tempCount==0)
			{
				inOrOutNetwork="0";
				System.out.println("Out Network already selected");
				tempCount++;
			}

		}

	}

	public static void checkInOrOutNetworkAfterOriginalSwitch() throws IOException, Exception
	{
		if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("0") &&  SurgeryExpectedPage.inNetworkRadioButtonStatus(driver, Readconfig.getType(),  Readconfig.getCostType()).equalsIgnoreCase("1")) {

			inOrOutNetwork="1";

		}

		if(Readconfig.getInOrOutNetwork().equalsIgnoreCase("0") &&  SurgeryExpectedPage.inNetworkRadioButtonStatus(driver, Readconfig.getType(),  Readconfig.getCostType()).equalsIgnoreCase("0"))
		{

			inOrOutNetwork="0";
		}

	}

	// ***** Replace Last Character Excel sheet for 3 decimal point ***** //

	public static String replaceLastCharacter(String excelValue) {

		char lastCharacter = excelValue.charAt(excelValue.length() - 1);
		String reverse = StringUtils.reverse(excelValue);
		String value = reverse.replaceFirst("[" + lastCharacter + "]", "");
		value = StringUtils.reverse(value);
		return value;

	}

	public static String quote(String s) {
		return new StringBuilder().append('\'').append(s).append('\'').toString();
	}

	// ***** Actual Estimation Query *****//

	public static void actualEstimationQuery(String medicareValue, String typeValue, String costTypeValue)
			throws Exception {
		setActualEstimationQueryValue(medicareValue, typeValue, costTypeValue);
		CTWriteExcel.memberDemographicWriteTest(Readconfig.getActualEstimationQuery(), "AppActualEstimation");

	}

	public static void setActualEstimationQueryValue(String medicareValue, String typeValue, String costTypeValue)
			throws Exception {
		String medicareIdentifier = medicareValue.trim();
		String type = typeValue.trim();
		String costType = costTypeValue.trim();
		// PageObject.selectFirstTextByIndex(MainCategoryPage.selectDiagnosis(driver),
		// driver);
		String query = "select AppActualEstimationId,Type,CostType,InOrOutNetwork,Quantity,MinAmountRange,MaxAmountRange,MemberBenefitForItem,MinEstimatedMemberOOP,MaxEstimatedMemberOOP,MedicareIdentifier from AppActualEstimation where MedicareIdentifier="
				+ quote(medicareIdentifier) + " and Type=" + quote(type) + " and CostType=" + quote(costType)
				+ " and InOrOutNetwork="
				+ quote(Readconfig.getInOrOutNetwork())
				+ " and DiagnosisCode=" + quote(MainCategoryPage.diagnosisDefaultSelectedText(driver));
		System.out.println(query);
		Readconfig.setActualEstimationQuery(query);
	}

	// ***** Original Estimation Query *****//

	public static void originalEstimationQuery(String medicareValue, String typeValue, String costTypeValue,
			WebDriver driver) throws Exception {
		setOriginalEstimationQueryValue(medicareValue, typeValue, costTypeValue, driver);
		CTWriteExcel.memberDemographicWriteTest(Readconfig.getOriginalEstimationQuery(), "AppOrginalEstimation");

	}

	public static void setOriginalEstimationQueryValue(String medicareValue, String typeValue, String costTypeValue,
			WebDriver driver) throws Exception {
		String medicareIdentifier = medicareValue.trim();
		String type = typeValue.trim();
		String costType = costTypeValue.trim();
		// PageObject.selectFirstTextByIndex(MainCategoryPage.selectDiagnosis(driver),
		// driver);

		String query = " select aoe.AppOrginalEstimationId,Type,CostType,InOrOutNetwork,Quantity,MinAmountRange,MaxAmountRange,MemberBenefitForItem,MinEstimatedMemberOOP,MaxEstimatedMemberOOP,a.MedicareIdentifier,a.servicereferenceno,a.ccscategory,a.DiagnosisDescription from [AppOrginalEstimation] aoe\r\n"
				+ " Inner join [AppPreAuthAndProvider] a on a.MemberPlan = aoe.MemberPlan and a.[State] = aoe.[State] and a.CCSCategory = aoe.CCSCategory and a.DiagnosisCode = aoe.DiagnosisCode\r\n"
				+ " where a.MedicareIdentifier=" + quote(medicareIdentifier) + " and Type=" + quote(type)
				+ " and CostType=" + quote(costType) + " and a.ccscategory="
				+ quote(MainCategoryPage.ccsCategoryDefaultSelectedText(driver)) + " and a.DiagnosisCode="
				+ quote(MainCategoryPage.diagnosisDefaultSelectedText(driver)) + " and a.ServiceReferenceNo="
				+ quote(PriorAuthInfoPage.serviceRefrenceNumberValidation(driver))
				+ " and InOrOutNetwork=" + quote(Readconfig.getInOrOutNetwork())
				+ " order by aoe.MemberBenefitForItem";

		System.out.println(query);
		Readconfig.setOriginalEstimationQuery(query);
	}

	// Update 120 Days Past Query

	public static void update120DaysPlusActualEstimationQuery(String medicareValue) throws Exception {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -121); // 120 days past date
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String one20PastDate = s.format(new Date(cal.getTimeInMillis()));
		System.out.println(one20PastDate);
		String medicareIdentifier = medicareValue.trim();
		// PageObject.selectFirstTextByIndex(MainCategoryPage.selectDiagnosis(driver),
		// driver);
		String query = "UPDATE AppActualEstimation SET CreatedOn=" + quote(one20PastDate) + " where MedicareIdentifier="
				+ quote(medicareIdentifier) + "and DiagnosisCode="
				+ quote(MainCategoryPage.diagnosisDefaultSelectedText(driver));
		System.out.println(query);
		GetDBUpdate.dbUpdate(query);

	}

	// Getting calculated subTotal from any table as per parameter
	public static String getSubTotal(List<WebElement> col) {
		String total = "";
		if (col == null) {
			return "$0.00-$0.00";
		}
		BigDecimal bigDecimalCurrencyL = new BigDecimal("0.0");
		BigDecimal bigDecimalCurrencyR = new BigDecimal("0.0");
		ArrayList<String> listcolText = new ArrayList<String>();
		for (WebElement textcol : col) {
			System.out.println("text from col" + textcol.getAttribute("innerHTML").replaceAll("[//,//$]", "").trim());
			listcolText.add(textcol.getAttribute("innerHTML").replaceAll("[//,//$]", "").trim());
		}
		for (String s : listcolText) {
			bigDecimalCurrencyL = bigDecimalCurrencyL.add(new BigDecimal(s.split("-")[0]));
			bigDecimalCurrencyR = bigDecimalCurrencyR.add(new BigDecimal(s.split("-")[1]));
		}
		System.out.println(
				"bigDecimalCurrency" + NumberFormat.getCurrencyInstance(Locale.US).format(bigDecimalCurrencyL));
		System.out.println(
				"bigDecimalCurrency" + NumberFormat.getCurrencyInstance(Locale.US).format(bigDecimalCurrencyR));
		total = NumberFormat.getCurrencyInstance(Locale.US).format(bigDecimalCurrencyL) + "-"
				+ NumberFormat.getCurrencyInstance(Locale.US).format(bigDecimalCurrencyR);
		System.out.println("Total" + total);
		return total;

	}

}
