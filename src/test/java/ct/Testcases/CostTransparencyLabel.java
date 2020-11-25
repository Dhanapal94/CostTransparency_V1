package ct.Testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;
import ct.Pages.MainCategoryPage;
import ct.Pages.MemberDemographicsPage;
import ct.Pages.PlanInfoPage;
import ct.Pages.PriorAuthInfoPage;
import ct.Pages.ProviderInformationPage;
import ct.intit.Base;
import ct.utilities.Readconfig;

public class CostTransparencyLabel extends Base {

	public static String medicareIdentifier;
	public static String actual,expected;
	public static int count =1;

	@BeforeMethod
	public void addingInitialDetails() throws Exception

	{
		if(!keepBrowserFlag)
		{
			Readconfig.saveMemberID(Readconfig.getMemberIDServiceExpected());
			driver.get(Readconfig.applicationURL());
			medicareIdentifier=Readconfig.getMemberIDServiceExpected();
			MemberDemographicsPage.clickAgree(driver);
			keepBrowserFlag=true;
			childTest="Yes";
			parentTest=extent.createTest("CT-LABELS TEST");
		}
	}	

	@AfterMethod
	public void removingDetails()
	{
		if(count==0)
		{
			childTest="No";
		}
	}

	//MemberDemographicsPage
	@Test(priority=1,enabled=true,groups="smoke")
	public static void verifyLabelMebDemoGraphic() {
		actual=MemberDemographicsPage.labelMebDemoGraphic(driver).getText();
		expected="Member Demographics";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=2,enabled=true,groups="smoke")
	public static void verifyLabelName() {
		actual=MemberDemographicsPage.labelName(driver).getText();
		expected="Name";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=3,enabled=true,groups="smoke")
	public static void verifyLabelPhoneNo() {
		actual=MemberDemographicsPage.labelPhoneNo(driver).getText();
		expected="Primary Phone";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=4,enabled=true,groups="smoke")
	public static void verifyLabelDOB() {
		actual=MemberDemographicsPage.labelDOB(driver).getText();
		expected="DOB";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=5,enabled=true,groups="smoke")
	public static void verifyLabelHICN() {
		actual=MemberDemographicsPage.labelHICN(driver).getText();
		expected="HICN";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=6,enabled=true,groups="smoke")
	public static void verifyLabelMBI() {
		actual=MemberDemographicsPage.labelMBI(driver).getText();
		expected="MBI";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=7,enabled=true,groups="smoke")
	public static void verifyLabelLanguage() {
		actual=MemberDemographicsPage.labelLanguage(driver).getText();
		expected="Primary Language";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=8,enabled=true,groups="smoke")
	public static void verifyLabelAddress() {
		actual=MemberDemographicsPage.labelAddress(driver).getText();
		expected="Address";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=9,enabled=true,groups="smoke")
	public static void verifyLabelCity() {
		actual=MemberDemographicsPage.labelCity(driver).getText();
		expected="City";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=10,enabled=true,groups="smoke")
	public static void verifyLabelState() {
		actual=MemberDemographicsPage.labelState(driver).getText();
		expected="State";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=11,enabled=true,groups="smoke")
	public static void verifyLabelPlanInfo() {
		actual=PlanInfoPage.labelPlanInfo(driver).getText();
		expected="Plan Information";
		Assert.assertEquals(actual, expected);
	}
	//PlanInfoPage
	@Test(priority=12,enabled=true,groups="smoke")
	public static void verifyLabelPlan() {
		actual=PlanInfoPage.labelPlan(driver).getText();
		expected="Plan";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=13,enabled=true,groups="smoke")
	public static void verifyLabelPlanName() {
		actual=PlanInfoPage.labelPlanName(driver).getText();
		expected="Plan Name";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=14,enabled=true,groups="smoke")
	public static void verifyLabelDeductibeSpendOutNetwork() {
		actual=PlanInfoPage.labelDeductibeSpendOutNetwork(driver).getText();
		expected="Deductibe Spent Out Network";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=15,enabled=true,groups="smoke")
	public static void verifyLabelDeductibeLimitOutNetwork() {
		actual=PlanInfoPage.labelDeductibeLimitOutNetwork(driver).getText();
		expected="Deductibe Limit Out Network";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=16,enabled=true,groups="smoke")
	public static void verifyLabelDeductibeSpendInNetwork() {
		actual=PlanInfoPage.labelDeductibeSpendInNetwork(driver).getText();
		expected="Deductibe Spent In Network";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=17,enabled=true,groups="smoke")
	public static void verifyLabelDeductibeLimitInNetwork() {
		actual=PlanInfoPage.labelDeductibeLimitInNetwork(driver).getText();
		expected="Deductibe Limit In Network";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=18,enabled=true,groups="smoke")
	public static void verifyLabelOOPSpendOutNetwork() {
		actual=PlanInfoPage.labelOOPSpendOutNetwork(driver).getText();
		expected="OOP Spent Out Network";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=19,enabled=true,groups="smoke")
	public static void verifyLabelOOPLimitOutNetwork() {
		actual=PlanInfoPage.labelOOPLimitOutNetwork(driver).getText();
		expected="OOP Limit Out Network";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=20,enabled=true,groups="smoke")
	public static void verifyLabelOOPSpendInNetwork() {
		actual=PlanInfoPage.labelOOPSpendInNetwork(driver).getText();
		expected="OOP Spent In Network";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=21,enabled=true,groups="smoke")
	public static void verifyLabelOOPLimitInNetwork() {
		actual=PlanInfoPage.labelOOPLimitInNetwork(driver).getText();
		expected="OOP Limit In Network";
		Assert.assertEquals(actual, expected);
	}
	//Prior Authorization Information
	@Test(priority=22,enabled=true,groups="smoke")
	public static void verifyLabelPriorAuthInfo() {
		actual=PriorAuthInfoPage.labelPriorAuthInfo(driver).getText();
		expected="Prior Authorization Information";
		Assert.assertEquals(actual, expected);
	}
	//Prior Authorization Information
	@Test(priority=23,enabled=true,groups="smoke")
	public static void verifyLabelHSCID() {
		actual=PriorAuthInfoPage.labelHSCID(driver).getText();
		expected="HSC ID";
		Assert.assertEquals(actual, expected);
	}
	//Prior Authorization Information
	@Test(priority=24,enabled=true,groups="smoke")
	public static void verifyLabelDateofProcedure() {
		actual=PriorAuthInfoPage.labelDateofProcedure(driver).getText();
		expected="Date of Procedure";
		Assert.assertEquals(actual, expected);
	}
	//Prior Authorization Information
	@Test(priority=25,enabled=true,groups="smoke")
	public static void verifyLabelProcedureCode() {
		actual=PriorAuthInfoPage.labelProcedureCode(driver).getText();
		expected="Procedure Code";
		Assert.assertEquals(actual, expected);
	}
	//Prior Authorization Information
	@Test(priority=26,enabled=true,groups="smoke")
	public static void verifyLabelFacility() {
		actual=PriorAuthInfoPage.labelFacility(driver).getText();
		expected="Facility";
		Assert.assertEquals(actual, expected);
	}
	//Prior Authorization Information
	@Test(priority=27,enabled=true,groups="smoke")
	public static void verifyLabelReferanceNo() {
		actual=PriorAuthInfoPage.labelReferanceNo(driver).getText();
		expected="Service Reference Number";
		Assert.assertEquals(actual, expected);
	}
	//Provider Information
	@Test(priority=28,enabled=true,groups="smoke")
	public static void verifyLabelProviderInfo() {
		actual=ProviderInformationPage.labelProviderInfo(driver).getText();
		expected="Provider Information";
		Assert.assertEquals(actual, expected);
	}
	//Provider Information
	@Test(priority=29,enabled=true,groups="smoke")
	public static void verifyLabelProviderName() {
		actual=ProviderInformationPage.labelProviderName(driver).getText();
		expected="Name";
		Assert.assertEquals(actual, expected);
	}
	//Provider Information
	@Test(priority=30,enabled=true,groups="smoke")
	public static void verifyLabelProviderAddress() {
		actual=ProviderInformationPage.labelProviderAddress(driver).getText();
		expected="Address";
		Assert.assertEquals(actual, expected);
	}
	//Provider Information
	@Test(priority=31,enabled=true,groups="smoke")
	public static void verifyLabelProviderState() {
		actual=ProviderInformationPage.labelProviderState(driver).getText();
		expected="State";
		Assert.assertEquals(actual, expected);
	}
	//Provider Information
	@Test(priority=32,enabled=true,groups="smoke")
	public static void verifyLabelProviderCity() {
		actual=ProviderInformationPage.labelProviderCity(driver).getText();
		expected="City";
		Assert.assertEquals(actual, expected);
	}
	//Provider Information
	@Test(priority=33,enabled=true,groups="smoke")
	public static void verifyLabelProviderZip() {
		actual=ProviderInformationPage.labelProviderZip(driver).getText();
		expected="Zip Code";
		Assert.assertEquals(actual, expected);
	}
	//Provider Information
	@Test(priority=34,enabled=true,groups="smoke")
	public static void verifyLabelProviderSpeciality() {
		actual=ProviderInformationPage.labelProviderSpeciality(driver).getText();
		expected="Speciality";
		Assert.assertEquals(actual, expected);
	}
	//Provider Information
	@Test(priority=35,enabled=true,groups="smoke")
	public static void verifyLabelProviderNetworkStatus() {
		actual=ProviderInformationPage.labelProviderNetworkStatus(driver).getText();
		expected="Network Status";
		Assert.assertEquals(actual, expected);
	}
	//MainCategoryPage
	@Test(priority=36,enabled=true,groups="smoke")
	public static void verifyLabelCCSCategory() {
		actual=MainCategoryPage.labelCCSCategory(driver).getText();
		expected="CCS Category";
		Assert.assertEquals(actual, expected);
	}
	//MainCategoryPage
	@Test(priority=37,enabled=true,groups="smoke")
	public static void verifyLabelDiagnosis() {
		actual=MainCategoryPage.labelDiagnosis(driver).getText();
		expected="Diagnosis";
		Assert.assertEquals(actual, expected);
	}
	//MainCategoryPage
	@Test(priority=38,enabled=true,groups="smoke")
	public static void verifyLabelSurgeryExpected() {
		actual=MainCategoryPage.labelSurgeryExpected(driver).getText();
		expected="Surgery Expected";
		Assert.assertEquals(actual, expected);
	}

	//MainCategoryPage
	@Test(priority=39,enabled=true,groups="smoke")
	public static void verifyLabelSurgeryNotExpected() {
		actual=MainCategoryPage.labelSurgeryNotExpected(driver).getText();
		expected="Surgery Not Expected";
		Assert.assertEquals(actual, expected);
	}
	//MainCategoryPage
	@Test(priority=40,enabled=true,groups="smoke")
	public static void verifyLabelbuttonReset() {
		actual=MainCategoryPage.buttonReset(driver).getText();
		expected="Reset";
		Assert.assertEquals(actual, expected);
	}
	//MainCategoryPage
	@Test(priority=41,enabled=true,groups="smoke")
	public static void verifyLabelbuttonSave() {
		actual=MainCategoryPage.buttonSave(driver).getText();
		expected="Save";
		Assert.assertEquals(actual, expected);
	}
	//MainCategoryPage
	@Test(priority=42,enabled=true,groups="smoke")
	public static void verifyLabelbuttonGoToSearch() {
		actual=MainCategoryPage.buttonGoToSearch(driver).getText();
		expected="Go to Search";
		Assert.assertEquals(actual, expected);
	}
	
	//MainCategoryPage
    @Test(priority=43,enabled=true,groups="smoke")
    public static void verifyPreTableHeaders() {
        String [] exp= {"Actions","Cost Type","In or Out of Network?","Quantity","In Network Cost","Out of Network Cost","Member Benefit for Item","Estimated Member OOP"};
        List<String> l2 = new ArrayList<String>();
        l2.addAll(Arrays.asList(exp));
        List<String> l1 = new ArrayList<String>();
        l1=MainCategoryPage.colTableHeaders(driver, "Pre");
        boolean actual = MainCategoryPage.checkListContains(l1,l2);
        Assert.assertTrue(actual);
    }

	//MainCategoryPage
	@Test(priority=44,enabled=true,groups="smoke")
	public static void verifyDuringTableHeaders() {
		String [] exp= {"Actions","Cost Type","In or Out of Network?","Quantity","In Network Cost","Out of Network Cost","Member Benefit for Item","Estimated Member OOP"};
		List<String> l2 = new ArrayList<String>(); 
		l2.addAll(Arrays.asList(exp));
		List<String> l1 = new ArrayList<String>(); 
		l1=MainCategoryPage.colTableHeaders(driver, "During");
		System.out.println(l1);
		boolean actual = MainCategoryPage.checkListContains(l1,l2);
		Assert.assertTrue(actual);
	}
	/* @nayna :: updated on 06-10-2020 , due to CR :Cost Transparency Pilot[Added new col] */
	//MainCategoryPage
	@Test(priority=45,enabled=true,groups="smoke")
	public static void verifyPostTableHeaders() {
		String [] exp= {"Actions","Cost Type","In or Out of Network?","Quantity","In Network Cost","Out of Network Cost","Member Benefit for Item","Estimated Member OOP"};
		List<String> l2 = new ArrayList<String>(); 
		l2.addAll(Arrays.asList(exp));
		List<String> l1 = new ArrayList<String>(); 
		l1=MainCategoryPage.colTableHeaders(driver, "Post");
		boolean actual = MainCategoryPage.checkListContains(l1,l2);
		Assert.assertTrue(actual);
	}


	/* @nayna :: updated on 06-10-2020 , due to CR :Cost Transparency Pilot[Added new col] */ 
	//MainCategoryPage
	@Test(priority=46,enabled=true,groups="smoke")
	public static void verifyLabelTotalIn() {
		actual=MainCategoryPage.labelTotalIn(driver).getText();
		expected="Total In-Network:";
		Assert.assertEquals(actual, expected);
	}

	//MainCategoryPage
	@Test(priority=47,enabled=true,groups="smoke")
	public static void verifyLabelTotalOut() {
		actual=MainCategoryPage.labelTotalOut(driver).getText();
		expected="Total Out-of-Network:";
		Assert.assertEquals(actual, expected);
	}
	//MainCategoryPage
	@Test(priority=48,enabled=true,groups="smoke")
	public static void verifyLabelTable() {

		count=0;
		actual=MainCategoryPage.labelTable(driver,"Pre").getText().split("\\n")[0].
				trim(); 
		expected="Pre Surgery"; 
		Assert.assertEquals(actual,
				expected,"Failed : Table Header as 'PreSurgery' mismatch");
		actual=MainCategoryPage.labelTable(driver,"During ").getText().split("\\n")[0].trim();
		expected="During Surgery";
		Assert.assertEquals(actual, expected,"Failed : Table Header as 'During Surgery' mismatch");
		actual=MainCategoryPage.labelTable(driver,"Post").getText().split("\\n")[0].trim();
		expected="Post Surgery";
		Assert.assertEquals(actual, expected,"Failed : Table Header As 'Post Surgery' mismatch");
	}
	//Pre Surgery Page

	/*@Test(priority=49,enabled=true,groups="smoke")
	public static void verifyLabelPreSurgery() {
		actual=PreSurgeryPage.labelPreSurgery(driver).getText().split("\\n")[0].trim();
		expected="Pre Surgery";
		System.out.println("actual"+actual);
		Assert.assertEquals(actual, expected);
	}*/

}
