package com.orangeHRM.qa.testdata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader {
	@DataProvider(name="paramdata")
	public String[][] readdata() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/java/com/orangeHRM/qa/testdata/TestData.xlsx");
		String[][] dataarray;
		XSSFWorkbook  wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int row=sheet.getPhysicalNumberOfRows();
		System.out.println("number of rows:"+row);
		XSSFRow rows=sheet.getRow(0);
		int cellcount=rows.getPhysicalNumberOfCells();
		dataarray= new String[row][cellcount];
		
		for(int r=0;r<row;r++)
		{
			 rows=sheet.getRow(r);
			//System.out.println("row data"+row );
			int cells=rows.getPhysicalNumberOfCells();
			System.out.println("Here are the number of columns in the given excel: "+cells);
			for(int c=0;c<cells;c++)
			{
				XSSFCell cell=rows.getCell(c);
				System.out.print(cell.toString()+"\t\t");
				dataarray[r][c]=cell.toString();
				
			}
			System.out.println();
		}
		wb.close();
		fis.close();
		return dataarray;
	}
}
	
