package ct.Testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ct.Pages.MainCategoryPage;
import ct.Pages.MemberDemographicsPage;
import ct.Pages.SearchPage;
import ct.intit.Base;
import ct.utilities.ExcelUtility;
import ct.utilities.Readconfig;

public class SearchTest extends Base {

	public SearchTest() throws Exception {
		ExcelUtility.setExcelFile(excelPath, "MemberDemographics");
		this.memberIdentifer =ExcelUtility.getCellData(1, 6);
		this.firstName=ExcelUtility.getCellData(1, 1);
		this.primaryPhone=ExcelUtility.getCellData(1, 3);
		this.address=ExcelUtility.getCellData(1, 8);
		this.city=ExcelUtility.getCellData(1, 9);
		this.state=ExcelUtility.getCellData(1, 10);;
		this.zipCode=ExcelUtility.getCellData(1, 11);    
		this.memberPlan=ExcelUtility.getCellData(1, 12);
		this.ccsCategory=ExcelUtility.getCellData(1, 36);
	}


	@BeforeMethod
	public void addingInitialDetails() throws Exception
	{	
		if(!keepBrowserFlag)
		{
			Readconfig.saveMemberID(memberIdentifer);
			driver.get(Readconfig.applicationURL());	
			MemberDemographicsPage.clickAgree(driver);
			keepBrowserFlag=true;
			childTest="No";
			SearchPage.launch(driver); 
		}
	}

	@Test(priority=1)
	public void verifyNameSearch() throws Exception {
		System.out.println("verifyNameSearch");
		//SearchPage.highLighterMethod(SearchPage.inputName(driver), driver);
		SearchPage.inputName(driver).sendKeys(firstName);
		SearchPage.btnSearch(driver).click();
		Assert.assertEquals(SearchPage.searchResult(driver).isEnabled(),true,"Failed :not able to search with name ");
	}

	@Test(priority=2 )
	public void verifyPrimaryPhoneSearch() throws Exception {
		System.out.println("verifyPrimaryPhoneSearch");
		SearchPage.btnReset(driver).click();
		SearchPage.inputPhone(driver).sendKeys(primaryPhone);
		SearchPage.btnSearch(driver).click();
		Assert.assertEquals(SearchPage.searchResult(driver).isEnabled(),true,"Failed :not able to search with Primary Phone ");
	}

	@Test(priority=3) 
	public void verifyPrimaryAddressSearch() throws Exception {
		SearchPage.btnReset(driver).click();
		SearchPage.inputAddress(driver).sendKeys(address);
		SearchPage.btnSearch(driver).click();
		Assert.assertEquals(SearchPage.searchResult(driver).isEnabled(),
				true,"Failed :not able to search with Primary address "); }

	@Test(priority=4)
	public void verifyMemberPlanSearch() throws Exception {
		SearchPage.btnReset(driver).click();
		SearchPage.selectText(SearchPage.selectMemberPlan(driver),memberPlan,driver);
		SearchPage.btnSearch(driver).click();
		Assert.assertEquals(SearchPage.searchResult(driver).isEnabled(),
				true,"Failed :not able to search with memberPlan "); }

	@Test(priority=5)
	public void verifyccsCategorySearch() throws Exception {
		SearchPage.btnReset(driver).click();
		SearchPage.selectText(SearchPage.selectCCSCategory(driver),ccsCategory,driver);
		SearchPage.btnSearch(driver).click();
		Assert.assertEquals(SearchPage.searchResult(driver).isEnabled(),true,"Failed :not able to search with ccsCategory ");
	}
	@Test(priority=6)
	public void verifyAllFieldSearch() throws Exception {
		System.out.println("ALl:"+ccsCategory);
		SearchPage.btnReset(driver).click();
		SearchPage.inputName(driver).sendKeys(firstName);
		SearchPage.inputPhone(driver).sendKeys(primaryPhone);
		SearchPage.inputAddress(driver).sendKeys(address);
		SearchPage.selectText(SearchPage.selectMemberPlan(driver),memberPlan,driver);
		SearchPage.selectText(SearchPage.selectCCSCategory(driver),ccsCategory,driver);
		SearchPage.btnSearch(driver).click();
		Assert.assertEquals(SearchPage.searchResult(driver).isEnabled(),true,"Failed :not able to search with all fields ");
	}
	@Test(priority=7)
	public void verifyResetOnSearch() throws Exception {
		SearchPage.btnReset(driver).click();
		SearchPage.inputName(driver).sendKeys(firstName);
		SearchPage.btnReset(driver).click();
		Assert.assertEquals(SearchPage.getInputText(SearchPage.inputName(driver)).contains(""),true,"Failed :Name input not reset");
		SearchPage.inputPhone(driver).sendKeys(primaryPhone);
		SearchPage.btnReset(driver).click();
		Assert.assertEquals(SearchPage.getInputText(SearchPage.inputPhone(driver)).contains(""),true,"Failed :Phone input not reset");
		SearchPage.inputAddress(driver).sendKeys(address);
		SearchPage.btnReset(driver).click();
		SearchPage.waitForPageLoad(driver);
		Assert.assertEquals(SearchPage.getInputText(SearchPage.inputAddress(driver)).contains(""),true,"Failed :Adddress input not reset");
		SearchPage.selectText(SearchPage.selectMemberPlan(driver),memberPlan,driver);
		SearchPage.btnReset(driver).click();
		SearchPage.waitForPageLoad(driver);
		Assert.assertEquals(SearchPage.searchgetFirstSelectedText(SearchPage.selectMemberPlan(driver)),("--select--"),"Failed :Plan select not reset");
		SearchPage.selectText(SearchPage.selectCCSCategory(driver),ccsCategory,driver); 
		SearchPage.btnReset(driver).click();
		SearchPage.waitForPageLoad(driver);
		Assert.assertEquals(SearchPage.searchgetFirstSelectedText(SearchPage.selectCCSCategory(driver)).contains("--select--"),true,"Failed :CCS Category select not reset");
	}
	@Test(priority=8)
	public void verifyWorningText() throws Exception {
		SearchPage.btnReset(driver).click();
		SearchPage.btnSearch(driver).click();
		Assert.assertEquals(SearchPage.ErrorText(driver).isEnabled(),true,"Failed :Error text not displayed");
	}
	@Test(priority=9)
	public void verifySearchResultOnSearch() throws Exception {
		SoftAssert softAssert=new SoftAssert();
		SearchPage.btnReset(driver).click();
		SearchPage.inputName(driver).sendKeys(firstName);
		SearchPage.inputPhone(driver).sendKeys(primaryPhone);
		SearchPage.inputAddress(driver).sendKeys(address);
		SearchPage.selectText(SearchPage.selectMemberPlan(driver),memberPlan,driver);
		SearchPage.selectText(SearchPage.selectCCSCategory(driver), ccsCategory, driver);
		SearchPage.btnSearch(driver).click();
		SearchPage.waitforVisibilityElement(driver, SearchPage.searchResult(driver));
		softAssert.assertEquals(SearchPage.EditIconOfsearchResult(driver).isEnabled(), true,"Failed: Edit icon not display in search result");
		softAssert.assertEquals(SearchPage.colNameSearchResult(driver).getText().contains(firstName),true,"Failed: First name mismatch on search result");
		softAssert.assertEquals(SearchPage.colPhoneSearchResult(driver).getText(),primaryPhone ,"Failed: Primary Phone mismatch on search result");
		softAssert.assertEquals(SearchPage.colAddressSearchResult(driver).getText(), address,"Failed: First name mismatch on search result");
		softAssert.assertEquals(SearchPage.colCitySearchResult(driver).getText(), city,"Failed: City mismatch on search result");
		softAssert.assertEquals(SearchPage.colStateSearchResult(driver).getText(), state,"Failed: state mismatch on search result");
		softAssert.assertEquals(SearchPage.colZipSearchResult(driver).getText(), zipCode,"Failed: zipCode mismatch on search result");
		softAssert.assertEquals(SearchPage.colCCSCategotySearchResult(driver).getText(), ccsCategory,"Failed: CCS Category mismatch on search result");
		softAssert.assertEquals(SearchPage.colPlanSearchResult(driver).getText(), memberPlan,"Failed: Plan mismatch on search result");
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			AssertionError err = e;
			System.out.println(err.toString());
			throw err;
		}
	}
	@Test(priority=10)
	public void verifylabelsOnSearchPage() throws Exception {
		String [] exp= {"Actions","Name","Primary Phone","Address","City","State","Zip Code","CCS Category","Plan"};
		List<String> l2 = new ArrayList<String>(); 
		List<String> l1 = new ArrayList<String>(); 

		System.out.println("verifylabelsOnSearchPage");
		SoftAssert softAssert=new SoftAssert();
		//SearchPage.launch(driver); 
		softAssert.assertEquals(SearchPage.labelSearch(driver).getText(),"Search","Fail : Search label mismatch on Search Page");
		softAssert.assertEquals(SearchPage.labelName(driver).getText(),"Name","Fail : Name label mismatch on Search Page");
		softAssert.assertEquals(SearchPage.labelPhone(driver).getText(),"Primary Phone","Fail : Primary Phone label mismatch on Search Page");
		softAssert.assertEquals(SearchPage.labelAddress(driver).getText(),"Address Line 1","Fail : Address Line 1 label mismatch on Search Page");
		softAssert.assertEquals(SearchPage.labelMemberPlan(driver).getText(),"Member Plan","Fail : Member Plan label mismatch on Search Page");
		softAssert.assertEquals(SearchPage.labelCCSCategory(driver).getText(),"CCS Category","Fail : CCS Category label mismatch on Search Page");
		softAssert.assertEquals(SearchPage.btnSearch(driver).getText(),"Search","Fail : Btn Search label mismatch on Search Page");
		softAssert.assertEquals(SearchPage.btnCancel(driver).getText(),"Cancel","Fail : Btn Cancel label mismatch on Search Page");
		softAssert.assertEquals(SearchPage.btnReset(driver).getText(),"Reset","Fail : Btn Reset label mismatch on Search Page");
		softAssert.assertEquals(SearchPage.textSearchResult(driver).getText(),"Search Result" ,"Fail : Btn Reset label mismatch on Search Page");
		l2.addAll(Arrays.asList(exp));
		l1=MainCategoryPage.colTableHeaders(driver, "Search");
		boolean actual = MainCategoryPage.checkListContains(l1,l2);
		softAssert.assertTrue(actual,"Fail : Search Result table header mismatch");
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			AssertionError err = e;
			System.out.println(err.toString());
			throw err;
		}
	}
	@Test(priority=11)
	public void verifyCancelOnSearch() throws Exception {
		SearchPage.btnCancel(driver).click();
		SearchPage.waitForPageLoad(driver);
		MemberDemographicsPage.waitforVisibilityElement(driver, MemberDemographicsPage.agreeButton(driver));
		MemberDemographicsPage.agreeButton(driver).click();
		MemberDemographicsPage.waitForPageLoad(driver);
		Assert.assertEquals(driver.getTitle(), "Cost Transparency");
		//keepBrowserFlag=false;
	}
	@Test(priority=12,dependsOnMethods={"SearchTest.verifyCancelOnSearch"})
	public void verifyResutOnDemographic() throws Exception {
		System.out.println("verifyResutOnDemographic");
		SoftAssert softAssert=new SoftAssert();
		SearchPage.launch(driver); 
		SearchPage.btnReset(driver).click();
		SearchPage.inputName(driver).sendKeys(firstName);
		SearchPage.inputPhone(driver).sendKeys(primaryPhone);
		SearchPage.inputAddress(driver).sendKeys(address);
		SearchPage.selectText(SearchPage.selectMemberPlan(driver),memberPlan,driver);
		SearchPage.selectText(SearchPage.selectCCSCategory(driver),ccsCategory,driver);
		SearchPage.btnSearch(driver).click();
		SearchPage.waitforVisibilityElement(driver, SearchPage.searchResult(driver));
		SearchPage.EditIconOfsearchResult(driver).click();
		System.out.println("verifyResutOnDemographic");
		MemberDemographicsPage.waitForPageLoad(driver);
		MemberDemographicsPage.waitforVisibilityElement(driver, MemberDemographicsPage.agreeButton(driver));
		MemberDemographicsPage.agreeButton(driver).click();
		Assert.assertEquals(driver.getTitle(), "Cost Transparency");
		softAssert.assertEquals(MemberDemographicsPage.getInputText(MemberDemographicsPage.inputZip(driver)),zipCode,"Fail : zipCode is mismatched");
		softAssert.assertEquals(MemberDemographicsPage.getInputText(MemberDemographicsPage.inputState(driver)),state,"Fail : state is mismatched");
		softAssert.assertEquals(MemberDemographicsPage.getInputText(MemberDemographicsPage.inputCity(driver)),city,"Fail :city is mismatched");
		softAssert.assertEquals(MemberDemographicsPage.getInputText(MemberDemographicsPage.inputAddress(driver)),address,"Fail : address is mismatched");
		softAssert.assertEquals(MemberDemographicsPage.getInputText(MemberDemographicsPage.inputPhoneNo(driver)),primaryPhone,"Fail : primaryPhone is mismatched");
		softAssert.assertEquals(MemberDemographicsPage.getInputText(MemberDemographicsPage.inputName(driver)).contains(firstName),true,"Fail :Name is mismatched");
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			AssertionError err = e;
			System.out.println(err.toString());
			throw err;
		}
	}

}
