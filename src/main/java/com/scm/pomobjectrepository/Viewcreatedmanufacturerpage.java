package com.scm.pomobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Viewcreatedmanufacturerpage {
	//declaration
		@FindBy(xpath="//a[.='Manufacturers']")
		private WebElement manufacturerlnk;
		
		@FindBy(xpath="//input[@value='Log out']")
		private WebElement logoutbtn;
		
		//initialization
		public Viewcreatedmanufacturerpage(WebDriver driver)
		{
          PageFactory.initElements(driver,this);
		}
		
		//utilization
		public WebElement getManufacturerlnk() {
			return manufacturerlnk;
		}

		public WebElement getLogoutbtn() {
			logoutbtn.click();
			return logoutbtn;
		}
		
		//business libraries
		public void viewmanufrandlogout()
		{
			manufacturerlnk.click();
			
		}
}
