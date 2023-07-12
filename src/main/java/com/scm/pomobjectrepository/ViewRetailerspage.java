package com.scm.pomobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewRetailerspage {
	//declaration
			@FindBy(linkText = "Retailers")
			private WebElement retailerslink;
			
			@FindBy(xpath="//input[@value='Log out']")
			private WebElement logoutbtn;
			
			//initialization
			public ViewRetailerspage(WebDriver driver)
			{
				PageFactory.initElements(driver,this);
			}

			//utilization
			public WebElement getRetailerslink() {
				return retailerslink;
					}
			
			public WebElement getLogoutbtn() {
				logoutbtn.click();
				return logoutbtn;
			}
			
			//business libraries
			public void viewreatilers()
			{
				retailerslink.click();
				
			}
}
