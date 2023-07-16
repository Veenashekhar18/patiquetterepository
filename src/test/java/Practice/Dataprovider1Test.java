package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scm.genericutilities.Excelutiliity;
import com.scm.genericutilities.FileUtility;




public class Dataprovider1Test {

@Test(dataProvider = "getusnpwd")
public void dataprovide(String username,String password,String logintype) {
	System.out.println(username+" "+password+" logged in as "+logintype);
//	obj[0][0]="admin";
//	obj[0][1]="admin123";
//	obj[0][2]="Admin";
//   obj[1][0]="admin12";
//	obj[1][1]="admin123";
//	obj[1][2]="Manufacturer";
//	obj[2][0]="admin13";
//	obj[2][1]="admin123";
//	obj[2][2]="Retailer";
}
@DataProvider
public Object[][] getusnpwd() throws Throwable 
{
	FileUtility f=new FileUtility();
	Excelutiliity e=new Excelutiliity();
	String filepath=f.getfilepathfromproeritiesfile("excelconfigfilepath");
	int i=e.getRowCount(filepath,"dataprovider");
	int j=e.getcolumncount(filepath,"dataprovider",i);
	i=i+1;
	Object[][] obj=new Object[i][j];
	for(int k=0; k<i; k++)
	{
		for(int l=0; l<j; l++)
		{
			obj[k][l]=e.getdatafromexcel(filepath, "dataprovider", k, l);
		}
	}
	return obj;
}
}
	

	
	



