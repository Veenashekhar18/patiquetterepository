package com.scm.testscripts.patiquette;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.genericutilities.Baseclass;
import com.scm.genericutilities.Excelutiliity;
import com.scm.genericutilities.Javautility;
import com.scm.genericutilities.WebActionUtility;
import com.scm.pomobjectrepository.CreateRetailerpage;
import com.scm.pomobjectrepository.Loginpage;
import com.scm.pomobjectrepository.ViewRetailerspage;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

//@Listeners(general_utilities.Lisimpclass.class)
public class CreateretailerTest extends Baseclass {

	@Test
	//(groups="integration")
	//(groups = {"integration","system"})
	public void createretailerTest() throws Throwable {
		// creating objects for utilities
		WebActionUtility wlib = new WebActionUtility();
		Excelutiliity elib = new Excelutiliity();
		Javautility jlib = new Javautility();
		
		//to create random num
				int num = jlib.getrandomnum();
				
		// fetching data from excel to create retailer

		String usn1 = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_05", "rusername")+""+num;
		String pwd1 = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_05", "rpassword");
		String email = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_05", "remail");
		String phone = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_05", "rphonenum");

		// creating object for retailer pom class
		CreateRetailerpage createretailerpage = new CreateRetailerpage(driver);
		// click on add retailer link
		createretailerpage.getAddretailerlnk();

		// creating retailer
		createretailerpage.addretailer(usn1, pwd1, phone, email);
		//handling alert popup
		wlib.switchtoalertwindowandaccept(driver, "retailer added successfully");
		//verifying retailer page is displayed
		String title = driver.getTitle();
	Assert.assertTrue(title.contains("Add Retailer"));
		//if (title.contains("Add Retailer")) {
			Reporter.log("add retailer page is displayed",true);
		//}

		// check view retailers page is displayed
		ViewRetailerspage viewRetailerspage = new ViewRetailerspage(driver);
		viewRetailerspage.viewreatilers();
		//verify retailer page is displayed
		String title1 = driver.getTitle();
		Assert.assertTrue(title1.contains("View Retailer"), title);
		Reporter.log("view retailer page is displayed");
		
        
		// logginng out as admin
		Loginpage loginpage = new Loginpage(driver);
		loginpage.getLogoutbtn();
		Reporter.log("logout as admin");
		Thread.sleep(4000);
		
		//login as retailer
		String logintype = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_03","Logintype");
		//pass created username and password of created retailer
		loginpage.Logintoappl(usn1, pwd1, logintype);
		Reporter.log("logged in as retailer");
		//verify retailer is logged in sucessfully
		String title2 = driver.getTitle();
		Assert.assertTrue(title.contains("Retailer"), title);
		//if (title2.contains("Retailer")) {
			Reporter.log("retailer logged in sucessfully");
		//}

	}

}
