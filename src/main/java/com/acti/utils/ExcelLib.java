package com.acti.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib {
	
	 public XSSFWorkbook wb;
		
		public ExcelLib() 
		{
			try
			{
				File src = new File("./src/test/resources/Testdata/actidata.xlsx");
				FileInputStream fis = new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
			}
			catch(Exception e)
			{
				System.out.println("Unable to load excel file"+e.getMessage());
			}
		}
		
		public int getRowCount(int sheetnum)
		{
			/*int count = wb.getSheetAt(sheetnum).getLastRowNum()+1;
			return count;*/
			return wb.getSheetAt(sheetnum).getLastRowNum()+1;
		}
		public String getcelldata(int sheetnum, int row, int cell)
		{
			/*String data = wb.getSheetAt(sheetnum).getRow(row).getCell(cell).toString();
			return data;*/
			return wb.getSheetAt(sheetnum).getRow(row).getCell(cell).toString();
		}

	}


