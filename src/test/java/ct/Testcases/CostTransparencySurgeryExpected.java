package ct.Testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ct.Pages.ConfirmationPage;
import ct.Pages.EstimationEntry;
import ct.Pages.MainCategoryPage;
import ct.Pages.MemberDemographicsPage;
import ct.Pages.SurgeryExpectedPage;
import ct.intit.Base;
import ct.intit.Baseinit;
import ct.utilities.HelperSurgeryExpected;
import ct.utilities.Readconfig;

public class CostTransparencySurgeryExpected  extends Base{

	public static String medicareIdentifier;
	public static String type;
	public static String costType;


	@BeforeMethod
	public void addingInitialDetails() throws Exception

	{
		if(!keepBrowserFlag)
		{
			Readconfig.saveMemberID(Readconfig.getMemberIDServiceExpected());
			driver.get(Readconfig.applicationURL());
			medicareIdentifier=Readconfig.getMemberIDServiceExpected();
			type=Readconfig.getType();
			costType=Readconfig.getCostType();		
			MemberDemographicsPage.clickAgree(driver);
			keepBrowserFlag=true;
			childTest="No";
		}
	}	

	@Test(priority=1,enabled=true,groups="smoke") 
	public void getTotalInNetworkAmtForSurgeryTest() {
		String expected =SurgeryExpectedPage.getTotalInNetworkForSurgery(driver);
		System.out.println(expected);
		String actual =SurgeryExpectedPage.txtTotalInNetwork(driver).getText();
		System.out.println(actual);
		Assert.assertEquals(expected,actual);
	}
	
	@Test(priority=2,enabled=true,groups="smoke")
	public void getTotalOutNetworkAmtForSurgeryTest() {
		String expected =SurgeryExpectedPage.getTotalOutNetworkForSurgery(driver);
		String actual =SurgeryExpectedPage.txtTotalOutNetwork(driver).getText();
		Assert.assertEquals(expected,actual);
	}
	
	@Test(priority=3,enabled=false,groups="smoke")
	public void getTotalInNetworkAmtForNonSurgeryTest() {
		String expected =SurgeryExpectedPage.getTotalInNetworkForNonSurgery(driver);
		String actual =SurgeryExpectedPage.txtTotalInNetwork(driver).getText();
		Assert.assertEquals(expected,actual);
	}

	
	@Test(priority=4,enabled=false,groups="smoke")
	public void getTotalOutNetworkAmtForNonSurgeryTest() {
		String expected =SurgeryExpectedPage.getTotalOutNetworkForNonSurgery(driver);
		String actual =SurgeryExpectedPage.txtTotalOutNetwork(driver).getText();
		Assert.assertEquals(expected,actual);
	}

	@Test(priority=5,enabled=false,groups="smoke")
	public void getTotalEstimatedMemberOOPAmtForSurgeryTest() throws Exception {
		HelperSurgeryExpected.basicRefresh(driver);
		String expected =SurgeryExpectedPage.getTotalEstimatedMemberOOPForSurgery(driver);
		String actual =SurgeryExpectedPage.txtTotalEstimatedMemberOOP(driver).getText();
		Assert.assertEquals(expected,actual);
	}
	
	@Test(priority=6,enabled=false,groups="smoke")
	public void getTotalEstimatedMemberOOPAmtForNonSurgeryTest() {
		String expected =SurgeryExpectedPage.getTotalEstimatedMemberOOPForNonSurgery(driver);
		String actual =SurgeryExpectedPage.txtTotalEstimatedMemberOOP(driver).getText();
		Assert.assertEquals(expected,actual);
	}


	@Test(priority=7,enabled=false,groups="smoke")
	public void getSubTotalEstimatedMemberOOPForSurgeryTest() throws Exception {

		HelperSurgeryExpected.basicRefresh(driver);
		SurgeryExpectedPage.radioSurgery(driver).click();

		//for Pre Surgery  
		String expected=HelperSurgeryExpected.getSubTotal(SurgeryExpectedPage.colEstimatedMemberOOP(driver,"Pre"));
		String actual=SurgeryExpectedPage.textEstimatedAmtsubTotal(driver,"Pre").getText().replaceAll("Sub-Total:", "");
		System.out.println("App value:"+actual);
		Assert.assertEquals(actual, expected);

		//for During Surgery 
		expected=HelperSurgeryExpected.getSubTotal(SurgeryExpectedPage.colEstimatedMemberOOP(driver,"During"));
		actual=SurgeryExpectedPage.textEstimatedAmtsubTotal(driver,"During").getText().replaceAll("Sub-Total:", "");
		System.out.println("App value:"+actual);
		Assert.assertEquals(actual, expected);

		//for Post Surgery
		expected=HelperSurgeryExpected.getSubTotal(SurgeryExpectedPage.colEstimatedMemberOOP(driver,"Post"));
		actual=SurgeryExpectedPage.textEstimatedAmtsubTotal(driver,"Post").getText().replaceAll("Sub-Total:", "");
		System.out.println("App value:"+actual);
		Assert.assertEquals(actual, expected);

		//before checking non surgery need to click on the non -surgery.
	}

	@Test(priority=8,enabled=false,groups="smoke")
	public void getSubTotalEstimatedMemberOOPForNonSurgeryTest() {

		String expected,actual;
		SurgeryExpectedPage.radioNonSurgery(driver).click();

		//for Diagnosis
		expected=HelperSurgeryExpected.getSubTotal(SurgeryExpectedPage.colEstimatedMemberOOP(driver,"Diagnosis"));
		actual=SurgeryExpectedPage.textEstimatedAmtsubTotal(driver,"Diagnosis").getText().replaceAll("Sub-Total:", "");
		System.out.println("App value:"+actual);
		Assert.assertEquals(actual, expected);

		//for Treatment
		expected=HelperSurgeryExpected.getSubTotal(SurgeryExpectedPage.colEstimatedMemberOOP(driver,"Treatment"));
		actual=SurgeryExpectedPage.textEstimatedAmtsubTotal(driver,"Treatment").getText().replaceAll("Sub-Total:", "");
		System.out.println("App value:"+actual+"\n");
		Assert.assertEquals(actual, expected);

	}

	@Test(priority=9,enabled=false,groups="smoke")
	public void getSubTotalAmountInRangeForSurgeryTest() throws Exception {

		HelperSurgeryExpected.basicRefresh(driver);
		System.out.println("GetTotalAmountInRange");
		//Click on surgery :: for correct flow 
		SurgeryExpectedPage.radioSurgery(driver).click();

		//for Pre Surgery  
		String expected=HelperSurgeryExpected.getSubTotal(SurgeryExpectedPage.colTotalAmountRange(driver,"Pre"));
		String actual=SurgeryExpectedPage.textTotalAmtsubTotal(driver,"Pre").getText().replaceAll("Sub-Total:", "");
		System.out.println("App value:"+actual);
		Assert.assertEquals(actual, expected);

		//for During Surgery 
		expected=HelperSurgeryExpected.getSubTotal(SurgeryExpectedPage.colTotalAmountRange(driver,"During"));
		actual=SurgeryExpectedPage.textTotalAmtsubTotal(driver,"During").getText().replaceAll("Sub-Total:", "");
		System.out.println("App value:"+actual);
		Assert.assertEquals(actual, expected);

		//for post surgery
		expected=HelperSurgeryExpected.getSubTotal(SurgeryExpectedPage.colTotalAmountRange(driver,"Post"));
		actual=SurgeryExpectedPage.textTotalAmtsubTotal(driver,"Post").getText().replaceAll("Sub-Total:", "");
		System.out.println("App value:"+actual);
		Assert.assertEquals(actual, expected);

	}

	@Test(priority=10,enabled=false,groups="smoke")
	public void getSubTotalAmountInRangeForNonSurgeryTest() throws Exception {
		
		String expected,actual;

		SurgeryExpectedPage.radioNonSurgery(driver).click();

		//for Diagnosis 
		expected=HelperSurgeryExpected.getSubTotal(SurgeryExpectedPage.colTotalAmountRange(driver,"Diagnosis"));
		actual=SurgeryExpectedPage.textTotalAmtsubTotal(driver,"Diagnosis").getText().replaceAll("Sub-Total:", "");
		System.out.println("App value:"+actual);
		Assert.assertEquals(actual, expected);

		//for Treatment 
		expected=HelperSurgeryExpected.getSubTotal(SurgeryExpectedPage.colTotalAmountRange(driver,"Treatment"));
		actual=SurgeryExpectedPage.textTotalAmtsubTotal(driver,"Treatment").getText().replaceAll("Sub-Total:", "");
		System.out.println("App value:"+actual);
		Assert.assertEquals(actual, expected);
	}

	
	@Test(priority=11,enabled=false,groups="smoke")
	public void getSubTotalAmountOutRangeForSurgeryTest() throws Exception {

		
		HelperSurgeryExpected.basicRefresh(driver);
		System.out.println("GetTotalAmountOutRange");
		//Click on surgery :: for correct flow 
		SurgeryExpectedPage.radioSurgery(driver).click();

		//for Pre Surgery  
		String expected=HelperSurgeryExpected.getSubTotal(SurgeryExpectedPage.colTotalOutAmountRange(driver,"Pre"));
		String actual=SurgeryExpectedPage.textTotalAmtsubOutTotal(driver,"Pre").getText().replaceAll("Sub-Total:", "");
		System.out.println("App value:"+actual);
		Assert.assertEquals(actual, expected);

		//for During Surgery 
		expected=HelperSurgeryExpected.getSubTotal(SurgeryExpectedPage.colTotalOutAmountRange(driver,"During"));
		actual=SurgeryExpectedPage.textTotalAmtsubOutTotal(driver,"During").getText().replaceAll("Sub-Total:", "");
		System.out.println("App value:"+actual);
		Assert.assertEquals(actual, expected);

		//for post surgery
		expected=HelperSurgeryExpected.getSubTotal(SurgeryExpectedPage.colTotalOutAmountRange(driver,"Post"));
		actual=SurgeryExpectedPage.textTotalAmtsubOutTotal(driver,"Post").getText().replaceAll("Sub-Total:", "");
		System.out.println("App value:"+actual);
		Assert.assertEquals(actual, expected);

	}

	
	@Test(priority=12,enabled=false,groups="smoke")
	public void getSubTotalAmountOutRangeForNonSurgeryTest() throws Exception {
		
		String expected,actual;

		SurgeryExpectedPage.radioNonSurgery(driver).click();

		//for Diagnosis 
		expected=HelperSurgeryExpected.getSubTotal(SurgeryExpectedPage.colTotalOutAmountRange(driver,"Diagnosis"));
		actual=SurgeryExpectedPage.textTotalAmtsubOutTotal(driver,"Diagnosis").getText().replaceAll("Sub-Total:", "");
		System.out.println("App value:"+actual);
		Assert.assertEquals(actual, expected);

		//for Treatment 
		expected=HelperSurgeryExpected.getSubTotal(SurgeryExpectedPage.colTotalOutAmountRange(driver,"Treatment"));
		actual=SurgeryExpectedPage.textTotalAmtsubOutTotal(driver,"Treatment").getText().replaceAll("Sub-Total:", "");
		System.out.println("App value:"+actual);
		Assert.assertEquals(actual, expected);
	}

	@Test(priority=13,enabled=true,groups="smoke")
	public void saveCostTypeGUITest() throws Exception
	{

		HelperSurgeryExpected.refresh(driver);
		HelperSurgeryExpected.storeOriginalInformation(driver,type,costType);
		SurgeryExpectedPage.clickEditCostType(driver,type,costType);
		EstimationEntry.enterQuantity(driver,HelperSurgeryExpected.currentQuantityPlusOrMinusOne());
		EstimationEntry.clickSave(driver);
		HelperSurgeryExpected.currentInformation(driver,type,costType);
		Assert.assertTrue(!HelperSurgeryExpected.checkInformationGUIValid()); 
		System.out.println("saveguitest completed");

	}

	@Test(priority=14,enabled=true,groups="smoke")
	public void saveMainCostTypeTest() throws Exception
	{

		MainCategoryPage.clickMainSave(driver);
		ConfirmationPage.clickYes(driver);

	}

	@Test(priority=15,enabled=true,groups="smoke")
	public void saveMessageTest() throws Exception
	{
		System.out.println(MainCategoryPage.saveMessage(driver));
		Assert.assertEquals(MainCategoryPage.saveMessage(driver),SUCCESSMESSAGE,"SAVE Message is wrong");
	}

	@Test(priority=16,enabled=true,groups="smoke")
	public void appActualEstimationDBTest() throws Exception
	{
		HelperSurgeryExpected.actualEstimationQuery(medicareIdentifier,type,costType);
		HelperSurgeryExpected.amountUpdationCostType(driver, type, costType);
		HelperSurgeryExpected.storeOriginalInformation(driver,type,costType);//For upcoming Tests
		Assert.assertTrue(HelperSurgeryExpected.checkInformationDBValid(driver, type, costType,"AppActualEstimation"));
	}


	@Test(priority=17,enabled=true,groups="smoke")
	public void resetStatusMessageTest() throws Exception
	{
		HelperSurgeryExpected.refresh(driver);
		SurgeryExpectedPage.clickEditCostType(driver,type,costType);
		System.out.println("Rest : "+HelperSurgeryExpected.currentQuantityPlusOrMinusOne());
		EstimationEntry.enterQuantity(driver,HelperSurgeryExpected.currentQuantityPlusOrMinusOne());
		EstimationEntry.clickSave(driver);
		MainCategoryPage.clickMainReset(driver);
		ConfirmationPage.clickYes(driver);
		System.out.println(MainCategoryPage.resetMessage(driver));
		Assert.assertEquals(MainCategoryPage.resetMessage(driver),RESETSUCCESSMESSAGE,"Reset Message is wrong");	

	}

	@Test(priority=18,enabled=true,groups="smoke")
	public void resetGUITest() throws  Exception
	{
		HelperSurgeryExpected.currentInformation(driver,type,costType);	
		Assert.assertTrue(HelperSurgeryExpected.checkInformationGUIValid()); 

	}

	@Test(priority=19,enabled=true,groups="smoke")
	public void resetDBTest() throws  Exception
	{
		Assert.assertTrue(HelperSurgeryExpected.checkInformationDBValid(driver, type, costType,"AppActualEstimation"));
	}


	@Test(priority=20,enabled=true)
	public void closeEstimationEntryTest() throws Exception
	{
		HelperSurgeryExpected.refresh(driver);
		SurgeryExpectedPage.clickEditCostType(driver,type,costType);
		EstimationEntry.enterQuantity(driver,HelperSurgeryExpected.currentQuantityPlusOrMinusOne());
		EstimationEntry.clickClose(driver);
		HelperSurgeryExpected.currentInformation(driver,type,costType);
		Assert.assertTrue(HelperSurgeryExpected.checkInformationGUIValid()); 

	}

	@Test(priority=21,enabled=true)
	public void closeIconEstimationEntryTest() throws Exception
	{
		HelperSurgeryExpected.refresh(driver);
		SurgeryExpectedPage.clickEditCostType(driver,type,costType);
		EstimationEntry.enterQuantity(driver,HelperSurgeryExpected.currentQuantityPlusOrMinusOne());
		EstimationEntry.clickCloseIcon(driver);
		HelperSurgeryExpected.currentInformation(driver,type,costType);
		Assert.assertTrue(HelperSurgeryExpected.checkInformationGUIValid()); 

	}

	@Test(priority=22,enabled=true)
	public void mininvalidQuantityTest() throws  Exception
	{

		HelperSurgeryExpected.refresh(driver);
		SurgeryExpectedPage.clickEditCostType(driver,type,costType);
		EstimationEntry.enterQuantity(driver,"0");
		EstimationEntry.clickSave(driver);
		Assert.assertEquals(MainCategoryPage.validationMessage(driver),VALIDATIONINVALIDMESSAGE,"Validation invalid Message is wrong");	

	}

	@Test(priority=23,enabled=true)
	public void maxinvalidQuantityTest() throws  Exception
	{

		HelperSurgeryExpected.refresh(driver);
		SurgeryExpectedPage.clickEditCostType(driver,type,costType);
		EstimationEntry.enterQuantity(driver,"101");
		EstimationEntry.clickSave(driver);
		Assert.assertEquals(MainCategoryPage.validationMessage(driver),VALIDATIONINVALIDMESSAGE,"Validation invalid Message is wrong");	

	}

	@Test(priority=24,enabled=true)
	public void noChangesDetectedMainSaveTest() throws Exception
	{

		HelperSurgeryExpected.refresh(driver);
		MainCategoryPage.clickMainSave(driver);
		Assert.assertEquals(MainCategoryPage.saveMessage(driver),NOCHANGESMESSAGE,"No Changes detected Message is wrong");

	}

	@Test(priority=25,enabled=true)
	public void noChangesDetectedEstimationEntrySaveTest() throws Exception
	{

		HelperSurgeryExpected.refresh(driver);
		SurgeryExpectedPage.clickEditCostType(driver,type,costType);
		EstimationEntry.enterQuantity(driver,HelperSurgeryExpected.originalList.get("Quantity"));
		EstimationEntry.clickSave(driver);
		Assert.assertEquals(MainCategoryPage.validationMessage(driver),NOCHANGESMESSAGE,"No Changes detected Message is wrong");

	}

	@Test(priority=26,enabled=true)
	public void noChangesDetectedResetTest() throws Exception
	{

		HelperSurgeryExpected.refresh(driver);
		MainCategoryPage.clickMainReset(driver);
		Assert.assertEquals(MainCategoryPage.resetMessage(driver),NOCHANGESMESSAGE,"No Changes detected Message is wrong");

	}

	@Test(priority=27,enabled=true,groups="smoke")
	public void deleteCostTypeTest() throws Exception
	{

		HelperSurgeryExpected.refresh(driver);
		String inNetworkStatus = SurgeryExpectedPage.inNetworkRadioButtonStatus(driver, type, costType);
		SurgeryExpectedPage.clickRemoveCostType(driver, type, costType);
		ConfirmationPage.clickYes(driver);
		//MainCategoryPage.clickMainSave(driver);
		//ConfirmationPage.clickYes(driver);
		//Baseinit.waitForAngularRequestNGDriver(driver);
		Assert.assertEquals(SurgeryExpectedPage.costTypeTextCheck(driver, type, costType,inNetworkStatus),"Exception","Costtype is not deleted successfully");

	}

	@Test(priority=28,enabled=true,groups="smoke")
	public void switchToOriginalDataTest() throws Exception
	{
		HelperSurgeryExpected.refresh(driver);
		SurgeryExpectedPage.clickSwitchToOriginalData(driver,type);
		Baseinit.waitForAngularRequestNGDriver(driver);
		MainCategoryPage.clickMainSave(driver);
		ConfirmationPage.clickYes(driver);

	}

	@Test(priority=29,enabled=true,groups="smoke")
	public void switchToOriginalDataDBTest() throws Exception
	{

		Baseinit.waitForAngularRequestNGDriver(driver);
		HelperSurgeryExpected.checkInOrOutNetworkAfterOriginalSwitch();
		HelperSurgeryExpected.originalEstimationQuery(medicareIdentifier, type, costType, driver);
		HelperSurgeryExpected.amountUpdationCostType(driver, type, costType);
		Assert.assertTrue(HelperSurgeryExpected.checkInformationDBValid(driver, type, costType,"AppOrginalEstimation"));

	}

	@Test(priority=30,groups="smoke")
	public void oneTwentyDaysPastSwitchToOriginalDataDBTest() throws Exception
	{

		HelperSurgeryExpected.refresh(driver);
		SurgeryExpectedPage.clickEditCostType(driver,type,costType);
		EstimationEntry.enterQuantity(driver,HelperSurgeryExpected.currentQuantityPlusOrMinusOne());
		EstimationEntry.clickSave(driver);
		MainCategoryPage.clickMainSave(driver);
		ConfirmationPage.clickYes(driver);
		HelperSurgeryExpected.update120DaysPlusActualEstimationQuery(medicareIdentifier);
		HelperSurgeryExpected.refresh(driver);
		HelperSurgeryExpected.amountUpdationCostType(driver, type, costType);
		Assert.assertTrue(HelperSurgeryExpected.checkInformationDBValid(driver, type, costType,"AppOrginalEstimation"));	

	}

	@Test(priority=31,groups="smoke")
	public void estimatedMemberOOPVsNetworkCostTest() throws Exception
	{
		HelperSurgeryExpected.refresh(driver);
		if(Readconfig.getInOrOutNetwork().equals("0"))
		{
			SurgeryExpectedPage.outNetworkRadioButton(driver, Readconfig.getType(), Readconfig.getCostType()).click();
			Assert.assertEquals(SurgeryExpectedPage.totalOutAmountRangeText(driver, type, costType), SurgeryExpectedPage.estimatedMemberOOPText(driver, type, costType),"EstimatedMemberOOP and Network cost Not matched");
		}
		else
		{
			SurgeryExpectedPage.inNetworkRadioButton(driver, Readconfig.getType(), Readconfig.getCostType()).click();
			Assert.assertEquals(SurgeryExpectedPage.totalAmountRangeText(driver, type, costType), SurgeryExpectedPage.estimatedMemberOOPText(driver, type, costType),"EstimatedMemberOOP and Network cost Not matched");
		}
		
	}
	
	@Test(priority=32,enabled=true,groups="smoke")
	public void editOnlyQuantityTest() throws Exception
	{

		HelperSurgeryExpected.refresh(driver);
		SurgeryExpectedPage.clickEditCostType(driver,type,costType);
		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(EstimationEntry.selectCostType(driver, "Pathology and Laboratory"),"Exception" ,"User able to select read only cost type - Invalid");
		//assertion.assertEquals(EstimationEntry.clickInorOutNetwork(driver),"Exception","User able to modify read only In or out Network - Invalid");
		EstimationEntry.enterQuantity(driver,HelperSurgeryExpected.currentQuantityPlusOrMinusOne());
		assertion.assertEquals(EstimationEntry.enterTotalAmountRange(driver,"$100.00-$200.00"),"Exception","User able to modify read only Total amount range - Invalid");
		assertion.assertEquals(EstimationEntry.enterMemberBenefitforItem(driver,"40%"),"Exception","User able to modify read only Member Benefit for Item - Invalid");
		assertion.assertEquals(EstimationEntry.enterEstimatedMemberOOP(driver,"$10.00-$25.00"),"Exception","User able to modify read only Estimated Member OOP - Invalid");
		assertion.assertAll();

	}

	//************** Functionality removed in GUI ***************
	/*
	@Test(priority=10,enabled=false)
	public void noConfirmationPopupTest() throws Exception
	{
		HelperSurgeryExpected.refresh(driver);
		SurgeryExpectedPage.clickEditCostType(driver,type,costType);
		EstimationEntry.enterQuantity(driver,HelperSurgeryExpected.currentQuantityPlusOrMinusOne());
		EstimationEntry.clickSave(driver);
		ConfirmationPage.clickNo(driver);
		Assert.assertTrue(EstimationEntry.estimationentryTitle(driver)); 
	}

	@Test(priority=11,enabled=false)
	public void closeIconConfirmationPopupTest() throws Exception
	{
		HelperSurgeryExpected.refresh(driver);
		SurgeryExpectedPage.clickEditCostType(driver,type,costType);
		EstimationEntry.enterQuantity(driver,HelperSurgeryExpected.currentQuantityPlusOrMinusOne());
		EstimationEntry.clickSave(driver);
		ConfirmationPage.clickCloseIconButton(driver);
		Assert.assertTrue(EstimationEntry.estimationentryTitle(driver)); 
	}
	 */

}
