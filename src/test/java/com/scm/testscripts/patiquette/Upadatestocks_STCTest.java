package com.scm.testscripts.patiquette;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.scm.genericutilities.Baseclass;
import com.scm.genericutilities.Excelutiliity;
import com.scm.genericutilities.FileUtility;
import com.scm.genericutilities.Javautility;
import com.scm.genericutilities.WebActionUtility;
import com.scm.pomobjectrepository.Addproductspage;
import com.scm.pomobjectrepository.Editprofilemanufacturerpage;
import com.scm.pomobjectrepository.Loginpage;
import com.scm.pomobjectrepository.Managestockspage;
import com.scm.pomobjectrepository.Viewproductspage;

@Listeners(com.scm.genericutilities.Listnersimpleclass.class)
public class Upadatestocks_STCTest extends Baseclass {
	@Test(groups={"system","integration"})
	public void updatestocksTest() throws Throwable {
		{

			// create object for utility
			WebActionUtility wlib = new WebActionUtility();
			FileUtility flib = new FileUtility();
			Javautility jlib = new Javautility();
			Excelutiliity elib = new Excelutiliity();
			
			//to create random num
			int num = jlib.getrandomnum();

			//logout as admin
			Loginpage loginpage = new Loginpage(driver);
			loginpage.getLogoutbtn();
			//logged as admin
			String filepath = flib.getfilepathfromproeritiesfile("projectconfigdatafilepath");
			Thread.sleep(4000);
			
			//login as  manufacturer
			String usn = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_04","musername");
			String pwd = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_04","mpassword");
			String logintype = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_02","Logintype");
			loginpage.Logintoappl(usn, pwd, logintype);
			Reporter.log("logged in as manufacturer");
			
			
			//verify edit profile page is displayed
			Editprofilemanufacturerpage editmanufacurer = new Editprofilemanufacturerpage(driver);
			String title = driver.getTitle();
			if (title.contains("Profile")) {
				Reporter.log("edit profile page is dispalyed");
			}
			
			//create products
			String product = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_06","productname")+"num";
			String productcreated = product;
			
			String price = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_06","productprice");
			String unitType = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_07", "unittype");
			String category = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_07", "category");
			Addproductspage addproducts = new Addproductspage(driver);
			addproducts.addproducts(product, price, unitType, category);
			// check edit profile page is diplayed
			
			//handle alert popup
			wlib.switchtoalertwindowandaccept(driver, "product added successfully");
			
			//verify products page is viewed
			Viewproductspage viewproducts = new Viewproductspage(driver);
			viewproducts.verifyanddelete();
			String title1 = driver.getTitle();
			SoftAssert sa=new SoftAssert();
			sa.assertEquals("View Products", title1);
			//if (title1.contains("View Products")) {
				Reporter.log("products page is displayed");
			//}
			
			// update stock quantity
			String qty = flib.getdatafromproperties(filepath, "qty");
			Managestockspage managestocks = new Managestockspage(driver);
			String title2 = driver.getTitle();
			sa.assertEquals("Manage Stock", title2);
			//if (title2.contains("Manage Stock")) {
				Reporter.log("manage stocks page is displayed");
			//}
			managestocks.upadatestocks(qty); // give quantity to product
			wlib.switchtoalertwindowandaccept(driver, "stock quantity got updated successfully");
			Reporter.log("stock got upadted successfully");
			managestocks.getLogoutbtn();
			sa.assertAll();
		}

	}

}
