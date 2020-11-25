package ct.utilities;

import java.util.Hashtable;
import org.testng.annotations.DataProvider;
import ct.Testcases.CTWriteExcel;
import ct.intit.Base;
import ct.intit.Baseinit;

public class DataProviderTest extends Base {


	@DataProvider(name = "Data")
	public static Object[][] dataRepository() throws Exception
	{
		CTWriteExcel.memberDemographicWriteTest(Readconfig.getQuery(),"MemberDemographics");
		Baseinit.setBrowserPath();
		ExcelUtility.setExcelFile(excelPath, "MemberDemographics");
		int rowcount = ExcelUtility.initialGetRowCount();
		int colcount = ExcelUtility.getCellCount(0);
		Object data[][] = new Object[rowcount][1];
		int count=0;
		for (int i = 1; i<=rowcount; i++) {
			Hashtable<String,String> table = new Hashtable<String, String>();
			for (int j = 0; j <= colcount - 1; j++) {

				String tableHeader =  ExcelUtility.getCellData(0, j);
				String tableValue = ExcelUtility.getCellData(i, j);
				table.put(tableHeader, tableValue);	
			}	
			data[count][0]=table;
			count++;
		}		

		return data;
	}


	@DataProvider(name = "SearchData" ,indices= {1})
	public static Object[][] SearchRepository() throws Exception
	{
		System.out.println("Alas search Data");
		CTWriteExcel.memberDemographicWriteTest(Readconfig.getQuery(),"MemberDemographics");
		Baseinit.setBrowserPath();
		ExcelUtility.setExcelFile(excelPath, "MemberDemographics");
		int rowcount = ExcelUtility.initialGetRowCount();
		int colcount = ExcelUtility.getCellCount(0);
		Object data[][] = new Object[rowcount][1];
		int count=0;
		for (int i = 1; i<=rowcount; i++) {
			Hashtable<String,String> table = new Hashtable<String, String>();
			for (int j = 0; j <= colcount - 1; j++) {

				String tableHeader =  ExcelUtility.getCellData(0, j);
				String tableValue = ExcelUtility.getCellData(i, j);
				table.put(tableHeader, tableValue);	
			}	
			data[count][0]=table;
			count++;
		}		


		System.out.println("Data provider completed");
		return data;
	}



}
