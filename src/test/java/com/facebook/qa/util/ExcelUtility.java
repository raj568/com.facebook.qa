package com.facebook.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public static String file_path="C:\\Users\\Nitu_Diku\\Downloads\\Testdata.xlsx";
	public static   Workbook book;
	public static  Sheet sheet;
 
	public static Object[][] get_Test_Data( String sheetName)
	{
		Object data[][]=null;
	try {
		FileInputStream fis=new FileInputStream(file_path);
		book=WorkbookFactory.create(fis);
		sheet=  book.getSheet(sheetName);
		data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j);
				
			}
		}
		
		
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (EncryptedDocumentException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return data;
	}

}
