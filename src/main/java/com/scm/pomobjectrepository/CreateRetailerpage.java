package com.scm.pomobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.genericutilities.WebActionUtility;


public class CreateRetailerpage {
	WebActionUtility wlib=new WebActionUtility();
	//declaration
		@FindBy(linkText = "Add Retailers")
		private WebElement addretailerlnk;
		
		@FindBy(id="retailer:username")
		private WebElement usernametxt;
		
		@FindBy(id="retailer:password")
		private WebElement passwordtxt;
		
		@FindBy(xpath="//select[@id='retailer:areaCode']")
		private WebElement areacodedrpdwn;
		
		@FindBy(id="retailer:phone")
		private WebElement phonetxt;
		
		@FindBy(id="retailer:email")
		private WebElement emailtxt;
		
		@FindBy(id="retailer:address")
		private WebElement addresstxt;
		
		@FindBy(xpath="//input[@value='Add Retailer']")
		private WebElement addretailerbtn;
		
		//initialization
		public CreateRetailerpage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}

		//utilization
		public WebElement getAddretailerlnk() {
			addretailerlnk.click();
			return addretailerlnk;
		}

		public WebElement getUsernametxt() {
			return usernametxt;
		}

		public WebElement getPasswordtxt() {
			return passwordtxt;
		}

		public WebElement getAreacodedrpdwn() {
			return areacodedrpdwn;
		}

		public WebElement getPhonetxt() {
			return phonetxt;
		}

		public WebElement getEmailtxt() {
			return emailtxt;
		}

		public WebElement getAddresstxt() {
			return addresstxt;
		}

		public WebElement getAddretailerbtn() {
			return addretailerbtn;
		}
		
		//business libraries
		public void addretailer(String rusername,String rpassword,String rphonenum,String remail) throws InterruptedException
		{
			
			usernametxt.sendKeys(rusername);
			passwordtxt.sendKeys(rpassword);
			wlib.select(areacodedrpdwn, "VSTR (Vastrapur)");
			phonetxt.sendKeys(rphonenum);
			emailtxt.sendKeys(remail);
			addretailerbtn.click();
		}
}
