package com.scm.testscripts.patiquette;

import java.io.IOException;
import java.util.Random;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.scm.genericutilities.Baseclass;
import com.scm.genericutilities.Excelutiliity;
import com.scm.genericutilities.FileUtility;
import com.scm.genericutilities.Javautility;
import com.scm.genericutilities.WebActionUtility;
import com.scm.pomobjectrepository.Addproductspage;
import com.scm.pomobjectrepository.AdminHomepage;
import com.scm.pomobjectrepository.Loginpage;
import com.scm.pomobjectrepository.Managestockspage;

//@Listeners(general_utilities.Lisimpclass.class)
public class PlaceorderTest extends Baseclass {
	@Test
	public void placeorder() throws IOException, Throwable
	{
		
			// Step:01 creating the objects of the utility classes
		WebActionUtility wlib=new WebActionUtility();
		FileUtility flib=new FileUtility();
		Excelutiliity elib=new Excelutiliity();
		Javautility jlib=new Javautility();
			//  Step:02 creating objects of POM classes
	        Loginpage loginpage = new Loginpage(driver);
			AdminHomepage adminhomepage = new AdminHomepage(driver);
			//AddProductsPage addProd = new AddProductsPage(driver);
			//ProductsPage pp = new ProductsPage(driver);
			//ManufacturerHomePage manfHP = new ManufacturerHomePage(driver);
			//ManageStockPage mangStock = new ManageStockPage(driver);
			//RetailerHomePage retHp = new RetailerHomePage(driver);
			//NewOrderPage nwOrderHP = new NewOrderPage(driver);

			//  Step:03 clicking on add product
			adminhomepage.getAddproductlnk();

			// Step:04 Code for creating random number
			jlib.getrandomnum();
			Random ran = new Random();
			int randNum = ran.nextInt(1000);

			//  Step:05 entering the text fields and create new product
		String productname = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_07", "productname"+""+randNum);
			//prodName = productname + "" + randNum;
			String productprice = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_07", "productprice");
			String unitType = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_07", "unittype");
			String category = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_07", "category");
			Addproductspage addproducts = new Addproductspage(driver);
			addproducts.addproducts(productname, productprice);
			
			//handle alert popup
			wlib.switchtoalertwindowandaccept(driver, "product added successfully");
			
			// Step:09 clicking on products
			adminhomepage.getProductsmajortab();

			/*// Step:10 validating the product
			boolean res = pp.validateNewProduct(prodName, prodPrice, category);
			if (res) {
				System.out.println("product details are displaying properly");
			} else {
				System.out.println("product details are not displaying properly");
			}
*/
			// Step:11 logout as admin
			loginpage.getLogoutbtn();
			Reporter.log("logout as admin");

			//login as manufacturer
			String usn = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_04", "musername");
			String pwd = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_04", "mpassword");
			String logintype = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_02",
					"Logintype");
			loginpage.Logintoappl(usn, pwd, logintype);
			Reporter.log("logged in as manufacturer");
			
			// update stock quantity
			String qty = flib.getdatafromproperties(filepath, "qty");
			Managestockspage managestocks = new Managestockspage(driver);
						String title2 = driver.getTitle();
						if (title2.contains("Manage Stock")) {
							Reporter.log("manage stocks page is displayed");
						}
						managestocks.upadatestocks(qty); // give quantity to product
						wlib.switchtoalertwindowandaccept(driver, "stock quantity got updated successfully");
						Reporter.log("stock got upadted successfully");
						managestocks.getLogoutbtn();

			// Step:15 logout as manufacturer
			loginpage.getLogoutbtn();
			Reporter.log("logout as manufacturer");

			// Step:16 login as retailer
			String usn1 = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_05", "rusername");
			String pwd1 = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_05", "rpassword");
			String logintyp = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1", "TC_03","Logintype");
			//pass created username and password of created retailer
			loginpage.Logintoappl(usn1, pwd1, logintyp);
			System.out.println("logged in as retailer");
			//verify retailer is logged in sucessfully
			String title3 = driver.getTitle();
			if (title3.contains("Retailer")) {
				Reporter.log("retailer logged in sucessfully");
			}

			//click new order
			PlaceorderTest placeneworder = new PlaceorderTest();
			placeneworder.placeorder();
			String title4 = driver.getTitle();
			if (title4.contains("Order Items")) {
				Reporter.log("new order page is displayed sucessfully");
			}
			/*
			// Step:18 entering order quantity and place the order
			String Qty = ex.getExceldDataByTestIDAndColName(excelFilePath, "Retailer", "TC_01", "Order_Quantity");
			System.out.println(Qty);
			nwOrderHP.placeOrder(Qty);
			System.out.println("Order placed successfully");
			Order Items
			// Step:19 logout as retailer
			//adminHP.getLogoutBtn().click();
		}
		*/
			//order has been placed
	}
}
