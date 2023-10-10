package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider1 {
@Test
public void getusnpwd(String username,String password,String logintype) {
	System.out.println(username+" "+password+"logged in as"+" "+logintype);
}
@DataProvider
public Object[][] getusnpwd()
{
	Object[][] obj=new Object[3][3];
	obj[0][0]="admin";
	obj[0][1]="admin123";
	obj[0][2]="Admin";
	obj[1][0]="admin12";
	obj[1][1]="admin123";
	obj[1][2]="Manufacturer";
	obj[2][0]="admin13";
	obj[2][1]="admin123";
	obj[2][2]="Retailer";
	return obj;
	
}
}
