package com.scm.testscripts.patiquette;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.scm.genericutilities.Baseclass;
import com.scm.genericutilities.Excelutiliity;
import com.scm.genericutilities.Javautility;
import com.scm.genericutilities.WebActionUtility;
import com.scm.pomobjectrepository.Addproductspage;
import com.scm.pomobjectrepository.Createmanufacturerpage;
import com.scm.pomobjectrepository.Loginpage;
import com.scm.pomobjectrepository.ViewRetailerspage;

@Listeners(com.scm.genericutilities.Listnersimpleclass.class)
public class Manufacturer_stcTest extends Baseclass {
	@Test(groups="system")
	public void manufacturerTest() throws Throwable {

		// create object for utility
		WebActionUtility wlib = new WebActionUtility();
		Javautility jlib = new Javautility();
		Excelutiliity elib = new Excelutiliity();
		
		//to create random num
		int num = jlib.getrandomnum();

		// for creating manufacurer

		String mname = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_04", "mname");
		wlib.waitforelement(driver);// wait for 20seconds
		String memail = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_04", "memail");
		String mphone = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_04", "mphonenum");
		Createmanufacturerpage createmanufacturer = new Createmanufacturerpage(driver);
		String musn = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_04",
				"musername")+num;
		String mpwd = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_04", "mpassword");
		// verifying manufacturer page is displayed
		String title = driver.getTitle();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals("Home", title);
		//if (title.contains("Add Manufacturer")) {
			Reporter.log("add manufactrer page is displayed");
		//}
		
		createmanufacturer.addmanufacturer(mname, memail, mphone, musn, mpwd);
		wlib.switchtoalertwindowandaccept(driver, "manufacturer added successfully");
		String mnfrname = musn;
		// check created manufacturer is present
		
		sa.assertEquals(mnfrname, musn);
//if (mnfrname.equals(musn)) {
			Reporter.log("manufacturer created successfully"); // print the created manufacturer
		//}

		// logout as addmin
		Loginpage loginpage = new Loginpage(driver);
		loginpage.getLogoutbtn();
		Reporter.log("logout as admin");
		Thread.sleep(4000);

		// login as manufacurer

		//String usn = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_04", "musername");
		String usn=musn;
		String pwd = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_04", "mpassword");
		String logintype = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_02",
				"Logintype");
		loginpage.Logintoappl(usn, pwd, logintype);
		Reporter.log("logged in as manufacturer");

		// create product
		Addproductspage addproduct = new Addproductspage(driver);
		String title1 = driver.getTitle();
		sa.assertEquals("View Products", title1);
		//if (title1.contains("View Products")) {
			Reporter.log("products page is displayed",true);
		//}
		//create product 
		String product = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_06",
				"productname");
		String productcreated = product;
		String price = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_06",
				"productprice");
	String unitType = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_07", "unittype");
		String category = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_07", "category");
	addproduct.addproducts(product, price, unitType, category);
		// check created product is present
		if (product.equals(productcreated)) {
			Reporter.log("product created successfully"); // print the created manufacturer
		}
		//handle alert popup
		wlib.switchtoalertwindowandaccept(driver, "product added successfully");
		//check retailer page is displayed
		ViewRetailerspage viewretailers = new ViewRetailerspage(driver);
		viewretailers.viewreatilers();
		//verify retailer page is displayed
		String title2 = driver.getTitle();
		sa.assertEquals("View Retailer", title2);
		//if (title2.contains("View Retailer")) {
			Reporter.log("retailers page is displayed");
		//}
		sa.assertAll();
	}

}
