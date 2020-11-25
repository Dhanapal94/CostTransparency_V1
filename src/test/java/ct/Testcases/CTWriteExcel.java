package ct.Testcases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import ct.intit.Base;
import ct.utilities.ExcelUtility;
import ct.utilities.GetDBConnection;

public class CTWriteExcel extends Base {

	public static int initColc;
	public static int rowc,colc;
	public static int rowSno=1;

	@Test
	public static void memberDemographicWriteTest(String queryValue,String sheetName) throws  Exception
	{

		String query=queryValue;
		Connection conn = GetDBConnection.getConnection();
		Statement stmt = conn.createStatement();						
		ResultSet rs= stmt.executeQuery(query);
		ExcelUtility.setExcelFile(excelPath,sheetName);
		rowc=ExcelUtility.initialGetRowCount();		
		for(int i=1;i<=rowc;i++)
		{
			ExcelUtility.deleteRows(i,excelPath);
		}

		System.out.println("Delete Operation Completed");
		initColc = ExcelUtility.getCellCount(0);

		if(sheetName.equalsIgnoreCase("MemberDemographics"))
		{
			while (rs.next()){

				rowc=ExcelUtility.getRowCount();
				colc = ExcelUtility.getCellCount(rowc);
				ExcelUtility.setCellData(excelPath,Integer.toString(rowSno),rowSno, colc);
				for(int i=1;i<=initColc-2;i++)
				{
					colc = ExcelUtility.getCellCount(rowc);
					String result = rs.getString(i);				
					ExcelUtility.setCellData(excelPath, result, rowc, colc);
				}	

				rowSno++;

			}	

		}

		else
		{
			while (rs.next()){

				rowc=ExcelUtility.getRowCount();
				for(int i=1;i<=initColc;i++)
				{
					colc = ExcelUtility.getCellCount(rowc);
					String result = rs.getString(i);				
					ExcelUtility.setCellData(excelPath, result, rowc, colc);
				}	

			}
		}
		conn.close();	
		System.out.println("Writing of data into Excel --->Process Completed");
	}


}
