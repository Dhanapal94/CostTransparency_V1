package ct.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.ByAngularModel;

public class SearchPage extends PageObject {

	/////****************************SearchPage********************************
	static WebElement element ;

	public static WebElement textSearchResult (WebDriver driver){
		element=driver.findElement(ByAngularModel.xpath("//*[contains(text(),'Search Result')]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement labelName (WebDriver driver){
		element=driver.findElement(ByAngularModel.xpath("//label[contains(text(),'Name')]"));
		return element;
	}
	public static WebElement labelPhone (WebDriver driver){
		element=driver.findElement(ByAngularModel.xpath("//label[contains(text(),' Phone')]"));
		return element;
	}
	public static WebElement labelAddress (WebDriver driver){
		element= driver.findElement(ByAngularModel.xpath("//label[contains(text(),'Address Line 1')]"));
		return element;
	}
	public static WebElement labelMemberPlan (WebDriver driver){
		element= driver.findElement(ByAngularModel.xpath("//label[contains(text(),'Member Plan')]"));
		return element;
	}
	public static WebElement labelCCSCategory (WebDriver driver){
		element= driver.findElement(ByAngularModel.xpath("//label[contains(text(),'CCS Category')]"));
		return element;
	}


	@SuppressWarnings("deprecation")
	public static WebElement labelSearch(WebDriver driver) {
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.className("wdgt-hdr")));
		element= driver.findElement(ByAngularModel.className("wdgt-hdr"));	
		return element;
	}
	public static WebElement btnSearch (WebDriver driver){
		element=driver.findElement(ByAngularModel.xpath("//*[@type='button'][contains(text(),'Search')]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement btnCancel (WebDriver driver){
		element= driver.findElement(ByAngularModel.xpath("//*[@type='button'][contains(text(),'Cancel')]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement btnReset (WebDriver driver){
		element= driver.findElement(ByAngularModel.xpath("//*[@type='button'][contains(text(),'Reset')]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement inputName (WebDriver driver){
		element= driver.findElement(ByAngularModel.xpath("//label[contains(text(),'Name')]/following::input[1]"));
		highLighterMethod(element,driver);
			return element;
	}
	public static WebElement inputPhone (WebDriver driver){
		element= driver.findElement(ByAngularModel.xpath("//label[contains(text(),' Phone')]/following::input[1]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement inputAddress (WebDriver driver){
		element= driver.findElement(ByAngularModel.xpath("//label[contains(text(),'Address Line 1')]/following::input[1]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement selectMemberPlan (WebDriver driver){
		element= driver.findElement(ByAngularModel.xpath("//select[1]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement selectCCSCategory (WebDriver driver){
		element=driver.findElement(ByAngularModel.xpath("//label[contains(text(),'CCS Category')]/following-sibling::select"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement popConfiramtionLabel (WebDriver driver) {
		element=  driver.findElement(ByAngularModel.xpath("//span[contains(text(),'Confirmation')]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement popConfiramtionBtnYes (WebDriver driver) {
		element= scrollIntoView(driver,driver.findElement(ByAngularModel.xpath("//span[contains(text(),'Yes')]")));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement searchResult(WebDriver driver) {
		element=  driver.findElement(ByAngularModel.xpath("//tbody[@class='ui-table-tbody']//tr[1]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement EditIconOfsearchResult(WebDriver driver) {
		element=  searchResult(driver).findElement(ByAngularModel.xpath("//td[1]/a"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement colNameSearchResult(WebDriver driver) {
		element=  searchResult(driver).findElement(ByAngularModel.xpath("//td[2]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement colPhoneSearchResult(WebDriver driver) {
		element=  searchResult(driver).findElement(ByAngularModel.xpath("//td[3]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement colAddressSearchResult(WebDriver driver) {
		element=  searchResult(driver).findElement(ByAngularModel.xpath("//td[4]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement colCitySearchResult(WebDriver driver) {
		element=  searchResult(driver).findElement(ByAngularModel.xpath("//td[5]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement colStateSearchResult(WebDriver driver) {
		element=  searchResult(driver).findElement(ByAngularModel.xpath("//td[6]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement colZipSearchResult(WebDriver driver) {
		element=  searchResult(driver).findElement(ByAngularModel.xpath("//td[7]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement colCCSCategotySearchResult(WebDriver driver) {
		element=  searchResult(driver).findElement(ByAngularModel.xpath("//td[8]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement colPlanSearchResult(WebDriver driver) {
		element= searchResult(driver).findElement(ByAngularModel.xpath("//td[9]"));
		highLighterMethod(element,driver);
		return element;
	}
	public static WebElement ErrorText(WebDriver driver) {
		element=  driver.findElement(ByAngularModel.xpath("//div[contains(@class,'ui-toast-detail')][contains(text(),'Please enter at least one search parameter')]"));
		highLighterMethod(element,driver);
		return element;
	}
	
	
	public static void launch(WebDriver driver) {
		MainCategoryPage.buttonGoToSearch(driver).click();
		try {
			if(SearchPage.popConfiramtionLabel(driver).isEnabled());
			SearchPage.popConfiramtionBtnYes(driver).click();
			SearchPage.waitForPageLoad(driver);
			SearchPage.waitforVisibilityElement(driver, SearchPage.labelSearch(driver));
		}catch(Exception e) {
			System.out.println("No Pop up present.");
		}
	}

	
}
