package com.scm.pomobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Managestockspage {
	//declaration
			@FindBy(linkText = "Manage Stock")
			private WebElement managestocklnk;
			
			
			@FindBy(xpath = "//input[@value='Update Stock']")
			private WebElement updatestockbtn;
			
			@FindBy(xpath = "//table[@class='table_displayData']/tbody/tr/td[.='cashewcookies']/following-sibling::td[2]/input[@name='txtQuantity[143]']")
			private WebElement updatestocksend;
			
			@FindBy(xpath="//input[@value='Log out']")
			private WebElement logoutbtn;
			
			//initialization
			public Managestockspage(WebDriver driver)
			{
				PageFactory.initElements(driver,this);
			}
			
		//utilization
			public WebElement getManagestocklnk() {
				return managestocklnk;
			}


			public WebElement getUpdatestockbtn() {
				return updatestockbtn;
			}
			
			public WebElement getUpdatestocksend() {
				
				return updatestocksend;
			}


			public WebElement getLogoutbtn() {
				logoutbtn.click();
				return logoutbtn;
			}
			
			//business libraries
			public void upadatestocks(String qty)
			{
				managestocklnk.click();
				updatestocksend.sendKeys(qty);
				updatestockbtn.click();
				
			}


}
