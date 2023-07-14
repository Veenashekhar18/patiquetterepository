package com.scm.testscripts.patiquette;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.genericutilities.Baseclass;
import com.scm.genericutilities.Excelutiliity;
import com.scm.genericutilities.FileUtility;
import com.scm.genericutilities.Javautility;
import com.scm.genericutilities.WebActionUtility;
import com.scm.pomobjectrepository.Loginpage;
import com.scm.pomobjectrepository.Orderspage;

@Listeners(com.scm.genericutilities.Listnersimpleclass.class)
public class SearchorderbydateTest extends Baseclass {

	@Test(groups="integration")
	public void searchorder() throws Throwable {

		// create object for utility
		WebActionUtility wlib = new WebActionUtility();
		FileUtility flib = new FileUtility();
		Javautility jlib = new Javautility();
		Excelutiliity elib = new Excelutiliity();

		// login as manufacurer
		Loginpage loginpage = new Loginpage(driver);
		loginpage.getLogoutbtn();
		Thread.sleep(4000);
		String usn = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_04", "musername");
		String pwd = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_04", "mpassword");
		String logintype = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_02",
				"Logintype");
		loginpage.Logintoappl(usn, pwd, logintype);
		Reporter.log("logged in as manufacturer");
		// click on orders major tab
		Orderspage orders = new Orderspage(driver);
		Reporter.log("orders page is displayed");
		orders.ordersearchandconfirm();
		Reporter.log("searched based on date");
		// driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[*]/td[.='15']")).click();
		loginpage.getLogoutbtn();

	}

}
