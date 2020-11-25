package ct.Testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import ct.Pages.MemberDemographicsPage;
import ct.Pages.PlanInfoPage;
import ct.Pages.PriorAuthInfoPage;
import ct.Pages.ProviderInformationPage;
import ct.intit.Base;
import ct.utilities.DataProviderTest;
import ct.utilities.Readconfig;

public class CostTransparencyFields extends Base {


	@Override
	public String toString() {
		return id;
	}


	@Factory(dataProvider="Data",dataProviderClass = DataProviderTest.class)
	public CostTransparencyFields(Hashtable<String,String> data) throws IOException {

		this.id = data.get("Sno");
		this.memberIdentifer = data.get("MBI");
		this.HICN=data.get("HICN");
		this.firstName=data.get("FirstName");
		this.lastName=data.get("LastName");
		this.dateOfBirth=data.get("DOB");	
		this.primaryPhone=data.get("Primary Phone");
		this.primaryLanguage=data.get("Primary Language");
		this.address=data.get("Address");
		this.city=data.get("City");
		this.state=data.get("State");
		this.zipCode=data.get("ZipCode");	    
		this.memberPlan=data.get("Plan");
		this.planName=data.get("Plan Name");
		this.deductibeSpentOutNetwork=data.get("Deductibe Spent Out Network");
		this.deductibeLimitOutNetwork=data.get("Deductibe Limit Out Network");
		this.deductibeSpentInNetwork=data.get("Deductibe Spent In Network");
		this.deductibeLimitInNetwork=data.get("Deductibe Limit In Network");
		this.oopSpentOutNetwork=data.get("OOP Spent Out Network");
		this.oopLimitOutNetwork=data.get("OOP Limit Out Network");
		this.oopSpentInNetwork=data.get("OOP Spent In Network");
		this.oopLimitInNetwork=data.get("OOP Limit In Network");
		this.serviceRefrenceNumber=data.get("Service Reference Number");
		this.hscID=data.get("HSC ID");
		this.dateOfProcedure=data.get("Date of Procedure");
		this.procedureCode=data.get("Procedure Code");
		this.facility=data.get("Facility");
		this.procedureCodeDescription=data.get("Procedure Code Description");
		this.providerFirstName=data.get("ProviderFirstName");
		this.providerLastName=data.get("ProviderLastName");
		this.providerAddress=data.get("ProviderAddress");
		this.providerState=data.get("ProviderState");
		this.providerCity=data.get("ProviderCity");
		this.providerZipcode=data.get("ProviderZipCode");
		this.providerSpeciality=data.get("Speciality");
		this.providerNetworkStatus=data.get("Network Status");
	}


	@BeforeMethod
	public void startBrowser() throws Exception
	{
		childTest="Yes";
		if(count==0&&keepBrowserFlag==false)
		{
			Readconfig.saveMemberID(memberIdentifer);
			driver.get(Readconfig.applicationURL());	
			System.out.println("Launching browser in Before method");
			parentTest=extent.createTest("CT DATA VALIDATION TEST Member-ID : "+Readconfig.getMemberID());
			count++;
		}	
		else if(count==0&&keepBrowserFlag==true)
		{

			parentTest=extent.createTest("CT Member-ID : "+Readconfig.getMemberID());
			System.out.println("Keeping browser session in Before method");
			count++;

		}

	}


	@Test(priority=1)
	public void memberIdentifierTest() throws Exception {

		if(!keepBrowserFlag)
		{
			MemberDemographicsPage.clickAgree(driver);
		}

		System.out.println("Test #1 with MemberIdentifier: "+id+". "+memberIdentifer);
		Assert.assertEquals(MemberDemographicsPage.memberIdentifierValidation(driver), memberIdentifer,"Member Identifier is Mismatched");
		passCount++;
	}
	@Test(priority=2)
	public void HICNTest() {

		System.out.println("Test #2 with HICN: "+id+". "+HICN);
		Assert.assertEquals(MemberDemographicsPage.hicnValidation(driver), HICN,"HICN is Mismatched");
		passCount++;
	}	
	@Test(priority=3)
	public void firstNameTest() {

		String name = firstName+" "+lastName;
		System.out.println("Test #3 with Name: "+id+". "+name);
		Assert.assertEquals(MemberDemographicsPage.nameValidation(driver),name,"Name is mismatched");
		passCount++;

	}
	@Test(priority=4)
	public void dateOfBirthTest() {

		String dobSplit[] =dateOfBirth.split("\\s");
		dateOfBirth=dobSplit[0];
		System.out.println("Test #4 with DOB: "+id+". "+dateOfBirth);
		Assert.assertEquals(MemberDemographicsPage.dobValidation(driver).trim(),dateOfBirth.trim(),"DOB is mismatched");
		passCount++;

	}

	@Test(priority=5)
	public void primaryPhoneTest() {

		System.out.println("Test #5 with primaryPhone: "+id+". "+primaryPhone);
		Assert.assertEquals(MemberDemographicsPage.primaryPhoneValidation(driver),primaryPhone,"primaryPhone is mismatched");
		passCount++;
	}

	@Test(priority=6)
	public void primaryLanguageTest() {

		System.out.println("Test #6 with primaryLanguage: "+id+". "+primaryLanguage);
		Assert.assertEquals(MemberDemographicsPage.primaryLanguageValidation(driver),primaryLanguage,"primaryLanguage is mismatched");
		passCount++;
	}

	@Test(priority=7)
	public void addressTest() {

		System.out.println("Test #7 with MemberAddress: "+id+". "+address);
		Assert.assertEquals(MemberDemographicsPage.addressValidation(driver),address,"address is mismatched");
		passCount++;
	}

	@Test(priority=8)
	public void cityTest() {

		System.out.println("Test #8 with MemberCity: "+id+". "+city);
		Assert.assertEquals(MemberDemographicsPage.cityValidation(driver),city,"city is mismatched");
		passCount++;
	}

	@Test(priority=9)
	public void stateTest() {

		System.out.println("Test #9 with MemberState: "+id+". "+state);
		Assert.assertEquals(MemberDemographicsPage.stateValidation(driver),state,"state is mismatched");
		passCount++;
	}

	@Test(priority=10)
	public void zipCodeTest() {

		System.out.println("Test #10 with MemberZip: "+id+". "+zipCode);
		Assert.assertEquals(MemberDemographicsPage.zipCodeValidation(driver),zipCode,"zipCode is mismatched");
		passCount++;
	}

	@Test(priority=11)
	public void planTest() {

		System.out.println("Test #11 with MemberPlan: "+id+". "+memberPlan);
		Assert.assertEquals(PlanInfoPage.planValidation(driver),memberPlan,"memberPlan is mismatched");
		passCount++;
	}

	@Test(priority=12)
	public void planNameTest() {

		System.out.println("Test #12 with MemberPlanName: "+id+". "+planName);
		Assert.assertEquals(PlanInfoPage.planNameValidation(driver),planName,"planName is mismatched");
		passCount++;
	}

	@Test(priority=13)
	public void deductibeSpentOutNetworkTest() {

		System.out.println("Test #13 with deductibeSpentOutNetwork: "+id+". "+deductibeSpentOutNetwork);
		Assert.assertEquals(PlanInfoPage.deductibeSpentOutNetworkValidation(driver),deductibeSpentOutNetwork,"deductibeSpentOutNetwork is mismatched");
		passCount++;
	}

	@Test(priority=14)
	public void deductibeLimitOutNetworkTest() {

		System.out.println("Test #14 with deductibeLimitOutNetwork: "+id+". "+deductibeLimitOutNetwork);
		Assert.assertEquals(PlanInfoPage.deductibeLimitOutNetworkValidation(driver),deductibeLimitOutNetwork,"deductibeLimitOutNetwork is mismatched");
		passCount++;
	}

	@Test(priority=15)
	public void deductibeSpentInNetworkTest() {

		System.out.println("Test #15 with deductibeSpentInNetwork: "+id+". "+deductibeSpentInNetwork);
		Assert.assertEquals(PlanInfoPage.deductibeSpentInNetworkValidation(driver),deductibeSpentInNetwork,"deductibeSpentInNetwork is mismatched");

	}

	@Test(priority=16)
	public void deductibeLimitInNetworkTest() {

		System.out.println("Test #16 with deductibeLimitInNetwork: "+id+". "+deductibeLimitInNetwork);
		Assert.assertEquals(PlanInfoPage.deductibeLimitInNetworkValidation(driver),deductibeLimitInNetwork,"deductibeLimitInNetwork is mismatched");
		passCount++;
	}

	@Test(priority=17)
	public void oopSpentOutNetworkTest() {

		System.out.println("Test #17 with oopSpentOutNetwork: "+id+". "+oopSpentOutNetwork);
		Assert.assertEquals(PlanInfoPage.oopSpentOutNetworkValidation(driver),oopSpentOutNetwork,"oopSpentOutNetwork is mismatched");
		passCount++;
	}

	@Test(priority=18)
	public void oopLimitOutNetworkTest() {

		System.out.println("Test #18 with oopLimitOutNetwork: "+id+". "+oopLimitOutNetwork);
		Assert.assertEquals(PlanInfoPage.oopLimitOutNetworkValidation(driver),oopLimitOutNetwork,"oopLimitOutNetwork is mismatched");
		passCount++;
	}

	@Test(priority=19)
	public void oopSpentInNetworkTest() {

		System.out.println("Test #19 with oopSpentInNetwork: "+id+". "+oopSpentInNetwork);
		Assert.assertEquals(PlanInfoPage.oopSpentInNetworkTestValidation(driver),oopSpentInNetwork,"oopSpentInNetwork is mismatched");
		passCount++;
	}

	@Test(priority=20)
	public void oopLimitInNetworkTest() {

		System.out.println("Test #20 with oopLimitInNetwork: "+id+". "+oopLimitInNetwork);
		Assert.assertEquals(PlanInfoPage.oopLimitInNetworkValidation(driver),oopLimitInNetwork,"oopLimitInNetwork is mismatched");
		passCount++;
	}

	@Test(priority=21)
	public void serviceRefrenceNumberTest() throws Exception {

		System.out.println("Flag in service number : "+keepBrowserFlag);
		if(keepBrowserFlag==false)
		{
			System.out.println("Came inside new browser loop");	
			System.out.println("Test #21 with serviceRefrenceNumber: "+id+"."+serviceRefrenceNumber);
			Assert.assertEquals(PriorAuthInfoPage.serviceRefrenceNumberValidation(driver),serviceRefrenceNumber,"serviceRefrenceNumber is mismatched");
			passCount++;
		}
		else if(keepBrowserFlag==true)
		{
			System.out.println("Came inside keep browser loop");
			System.out.println("Test #21 with serviceRefrenceNumber: "+id+"."+serviceRefrenceNumber);
			Assert.assertEquals(PriorAuthInfoPage.serviceRefrenceNumberSelectionValidation(driver,serviceRefrenceNumber),serviceRefrenceNumber,"serviceRefrenceNumber is mismatched");
			passCount++;
		}
	}

	@Test(priority=22)
	public void hscIdTest() {

		System.out.println("Test #22 with hscId: "+id+"."+hscID);
		Assert.assertEquals(PriorAuthInfoPage.hscIdValidation(driver),hscID,"hscId is mismatched");
		passCount++;
	}

	@Test(priority=23)
	public void dateOfProcedureTest() {

		System.out.println("Test #23 with dateOfProcedureValidation: "+id+"."+dateOfProcedure);
		Assert.assertEquals(PriorAuthInfoPage.dateOfProcedureValidation(driver),dateOfProcedure,"dateOfProcedureValidation is mismatched");
		passCount++;

	}

	@Test(priority=24)
	public void procedureCodeTest() {

		System.out.println("Test #24 with procedureCode: "+id+"."+procedureCode);
		Assert.assertEquals(PriorAuthInfoPage.procedureCodeValidation(driver),procedureCode,"procedureCode is mismatched");
		passCount++;
	}

	@Test(priority=25)
	public void facilityTest() {

		System.out.println("Test #25 with facility: "+id+"."+facility);
		Assert.assertEquals(PriorAuthInfoPage.facilityValidation(driver),facility,"facility is mismatched");
		passCount++;
	}

	/* @Test(priority=26)
	public void procedurecodeDescriptionTest() {

		System.out.println("Test #26 with procedurecodeDescription: "+id+"."+procedureCodeDescription);
		Assert.assertEquals(PriorAuthInfoPage.codeDescriptionValidation(driver),procedureCodeDescription,"procedureCodeDescription is mismatched");
		passCount++;
	}  

	 *****Procedure code Description is removed in GUI so commenting the Test*****
	 */

	@Test(priority=27)
	public void providerNameTest() {

		String providerName = providerFirstName+providerLastName;
		if(providerName.length()>0)
		{
			providerName = providerFirstName+" "+providerLastName;
		}
		else
		{
			System.out.println("Provider name is blank");
		}

		System.out.println("Test #27 with providerName: "+id+"."+providerName);
		Assert.assertEquals(ProviderInformationPage.nameValidation(driver),providerName,"providerName is mismatched");
		passCount++;
	}

	@Test(priority=28)
	public void providerAddressTest() {

		System.out.println("Test #28 with providerAddress: "+id+"."+providerAddress);
		Assert.assertEquals(ProviderInformationPage.addressValidation(driver),providerAddress,"providerAddress is mismatched");
		passCount++;
	}

	@Test(priority=29)
	public void providerStateTest() {

		System.out.println("Test #28 with providerState: "+id+"."+providerState);
		Assert.assertEquals(ProviderInformationPage.stateValidation(driver),providerState,"providerState is mismatched");
		passCount++;
	}

	@Test(priority=29)
	public void providerCityTest() {

		System.out.println("Test #29 with providerCity: "+id+"."+providerCity);
		Assert.assertEquals(ProviderInformationPage.cityValidation(driver),providerCity,"providerCity is mismatched");
		passCount++;
	}

	@Test(priority=30)
	public void providerZipcodeTest() {

		System.out.println("Test #30 with providerZipcode: "+id+"."+providerZipcode);
		Assert.assertEquals(ProviderInformationPage.zipValidation(driver),providerZipcode,"providerZipcode is mismatched");
		passCount++;
	}

	@Test(priority=31)
	public void providerSpecialityTest() {

		System.out.println("Test #31 with providerSpeciality: "+id+"."+providerSpeciality);
		Assert.assertEquals(ProviderInformationPage.specialityValidation(driver),providerSpeciality,"providerSpeciality is mismatched");
		passCount++;
	}

	@Test(priority=32)
	public void providerNetworkStatusTest() {

		count=0;
		System.out.println("Test #32 with providerNetworkStatus: "+id+"."+providerNetworkStatus);
		Assert.assertEquals(ProviderInformationPage.networkStatusValidation(driver),providerNetworkStatus,"providerNetworkStatus is mismatched");
		passCount++;
	}


}



