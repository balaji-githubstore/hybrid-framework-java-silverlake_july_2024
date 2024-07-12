package com.silverlake.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ZDemo2Excel {

	public static void main(String[] args) throws IOException {
		
		//location
		FileInputStream file=new FileInputStream("src/test/resources/open_emr_data.xlsx");
		
		//open
		XSSFWorkbook book=new XSSFWorkbook(file);
		XSSFSheet sheet=book.getSheet("validLoginTest");
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data=new Object[rowCount-1][cellCount];
		
		DataFormatter format=new DataFormatter();
		for(int r=1;r<rowCount;r++)
		{
			for(int c=0;c<cellCount;c++)
			{
				data[r-1][c]=format.formatCellValue(sheet.getRow(r).getCell(c));
			}
		}
		
		book.close();
		file.close();
		
		
	}

}
