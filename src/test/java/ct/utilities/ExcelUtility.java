package ct.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

	public static int initialGetRowCount() throws Exception 
	{
		int rowcount;
		try {
			rowcount=ExcelWSheet.getLastRowNum();
		}catch(Exception e) {
			throw (e);
		}
		return rowcount;		
	}

	//This method get the row count of workSheet 
	public static int getRowCount() throws Exception 
	{
		int rowcount=1;
		try {
			rowcount=rowcount+ExcelWSheet.getLastRowNum();
		}catch(Exception e) {
			throw (e);
		}
		return rowcount;		
	}

	//This method get the cell count of respective row 
	public static int getCellCount(int RowNum) throws Exception
	{
		int cellcount = 0 ;

		try{
			Row  = ExcelWSheet.getRow(RowNum);
			cellcount=Row.getLastCellNum();
		} 

		catch(NullPointerException e) {
			Row=ExcelWSheet.createRow(RowNum);
			Row.createCell(0);	
		}

		return cellcount;
	}


	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path,String SheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e){

			throw (e);

		}

	}

	//This method is to write in the Excel cell, Row num and Col num are the parameters

	public static void setCellData(String Path,String Result,int RowNum, int ColNum) throws Exception {

		try{

			Row  = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}


			FileOutputStream fileOut = new FileOutputStream(Path);

			ExcelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		}catch(Exception e){

			throw (e);

		}

	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

	public static String getCellData(int RowNum, int ColNum) throws Exception{
		Object  CellData  ;

		try{

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			switch (Cell.getCellType()) {
			case STRING:
				CellData=Cell.getStringCellValue();
				break;

			case FORMULA :
			case NUMERIC:      
				DataFormatter formatter = new DataFormatter();
				CellData= formatter.formatCellValue(Cell);
				//CellData=Cell.getNumericCellValue();                 
				break;       

			case BOOLEAN :
				CellData=Cell.getBooleanCellValue();
				break;

			case BLANK:
				CellData ="EMPTY";

				// ERROR : 
				//CellData =Cell.getErrorCellValue();

			default :	
				CellData ="";
				break;       
			}
		}
		catch(NullPointerException e1) {
			CellData ="";
		}
		catch (Exception e){return e.toString();}
		return CellData.toString();

	}

	//This method is to delete the existing test data from the Excel cell before the automation starting

	public static void deleteRows(int rowNum,String Path) throws Exception
	{

		Row = ExcelWSheet.getRow(rowNum);

		ExcelWSheet.removeRow(Row);

		FileOutputStream fileOut = new FileOutputStream(Path);

		ExcelWBook.write(fileOut);

		fileOut.flush();

		fileOut.close();
	}


}


