package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readdatafromexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\veena\\OneDrive\\Desktop\\Book1.xlsx");
		//open workbook in read mode
	Workbook book = WorkbookFactory.create(fis);
	Sheet sh = book.getSheet("sheet2");
	/*Row r = sh.getRow(1);
	Cell c = r.getCell(1);
	String data = c.getStringCellValue();
	System.out.println(data);*/
	
	/*//get the last used row count
	int count=sh.getLastRowNum();
	for (int i = 0; i < count; i++) {
		String expecteddata="Product ID";
		Row row=sh.getRow(i);
		String firstColData=row.getCell(1).getStringCellValue();
		String secondColData=row.getCell(2).getStringCellValue();
		System.out.println(firstColData+"\t"+secondColData);
		
	}*/
	

	book.close();
	
	
	
	
	
	
	}

}
