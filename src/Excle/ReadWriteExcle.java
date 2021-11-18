package Excle;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcle {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//location of my file
		File src = new File("C:\\Users\\PratiksMishra\\Desktop\\Eclips\\DemoProject\\TestData\\TESTDATAMine.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis); //.xlsx
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(0);
		XSSFCell col = row.getCell(0);
		String value = col.getStringCellValue();
		System.out.println(value);
		int Rowcount = sheet.getLastRowNum();
		
		for(int i=0; i<=Rowcount ;i++)
		{
			for(int j=0;j<row.getLastCellNum() ;j++)
			{
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + "\t");
				
			
			}
			System.out.println();
		}
		
		System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
		//Write in sheet
		sheet.getRow(0).createCell(2).setCellValue("Result");
		for(int i=1; i<Rowcount +1 ;i++)
		{
			if(i<4) {
			sheet.getRow(i).createCell(2).setCellValue("Pass");}
			else {
			sheet.getRow(i).createCell(2).setCellValue("Fail");
			}
		}
		FileOutputStream fos = new FileOutputStream(src);
		wb.write(fos);
		wb.close();
	}

}
