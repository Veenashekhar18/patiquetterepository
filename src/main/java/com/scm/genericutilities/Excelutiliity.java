package com.scm.genericutilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * used to perfrom Workbook releated operations like read , write , getcount etc
 * @author veena
 *
 */
public class Excelutiliity {
	public String getdatafromexcel(String filepath, String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		String data=row.getCell(cellnum).toString();
		return data;
		
	}

	/**
	 * read the date based on testId and Required Column name
	 * @param filepath
	 * @param sheetname
	 * @param testid
	 * @param colcumnheaderm
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getdatafromexcelbasedontestid(String filepath, String sheetname,String testid,String colcumnheaderm) throws Throwable, IOException
	{
		FileInputStream fis1=new FileInputStream(filepath);
		Workbook book=WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		int testrownum=0;
		String acttestid="";
		String actcolumnheadername="";
		String data="";
		for(int i=0; i<rowcount; i++)
		{
			try {
				acttestid=sheet.getRow(i).getCell(0).toString();
			}
			catch(Exception e)
			{}
			if(acttestid.equalsIgnoreCase(testid))
			{
				break;
			}
			testrownum++;
		}
		int testcolumnum=0;
		int cellcountfortest=sheet.getRow(testrownum-1).getLastCellNum();
		for(int j=0; j<cellcountfortest; j++)
		{
			try {
				actcolumnheadername=sheet.getRow(testrownum-1).getCell(j).toString();
			}
			catch(Exception e){
				
			}
			if(actcolumnheadername.equalsIgnoreCase(colcumnheaderm))
			{
				break;
		     }
			testcolumnum++;
			}
		try {
			data=sheet.getRow(testrownum).getCell(testcolumnum).toString();
		}
		catch(Exception e)
		{	}
		return data;
		}

	/**
	 * used to get the maximum used row count in required Sheet
	 * @param filePath
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int  getRowCount(String filePath, String sheetName) throws Throwable {
		System.out.println(filePath);
		FileInputStream fis1 = new FileInputStream(filePath);
		Workbook wb =  WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		return rowCount;
	}

	public int getcolumncount(String filePath, String sheetName,int i) throws Throwable {
		FileInputStream fis1 = new FileInputStream(filePath);
		Workbook wb =  WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet(sheetName);
		int columncount = sheet.getRow(i).getLastCellNum();
		return columncount;
	}
	/**
	 * 
	 * @param filePath
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataExcel(String filePath, String sheetName , int rowNum, int cellNum ,String data) throws Throwable {
		FileInputStream fis  = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		org.apache.poi.ss.usermodel.Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		wb.close();
		
	}
}
