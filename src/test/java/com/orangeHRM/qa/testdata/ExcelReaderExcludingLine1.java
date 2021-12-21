package com.orangeHRM.qa.testdata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReaderExcludingLine1 {//modified
	@DataProvider(name="paramdata")
	public String[][] readdata() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/java/com/orangeHRM/qa/testdata/TestData.xlsx");
		String[][] dataarray;
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int row=sheet.getPhysicalNumberOfRows();
		row = row-1; // added this to remove header row and also reduce array size
		System.out.println("number of rows:"+row);
		XSSFRow rows=sheet.getRow(0);
		int cellcount=rows.getPhysicalNumberOfCells();
		System.out.println("Number of columns: "+cellcount);
		dataarray = new String[row][cellcount];		

		//for(int r=1;r<=row;r++) //starting from row 1 rather than row 0
		for(int r=0;r<row;r++) //Another way of doing it
		{
			//rows=sheet.getRow(r);
			rows=sheet.getRow(r+1);
			//System.out.println("row data"+row );
			int cells=rows.getPhysicalNumberOfCells();
			System.out.println("Here are the number of columns in the given excel: "+cells);
			for(int c=0;c<cells;c++)
			{
				XSSFCell cell=rows.getCell(c);
				System.out.println("Row Number: "+r+","+"Column Number: "+c);
				System.out.println(cell.toString()+"\t\t");
				//dataarray[r-1][c]=cell.toString(); // added r-1 to store the data in an array as index starts from 0
				dataarray[r][c]=cell.toString(); // Another way of doing it
			}
			System.out.println();
		}
		wb.close();
		fis.close();
		return dataarray;
	}
}
	
