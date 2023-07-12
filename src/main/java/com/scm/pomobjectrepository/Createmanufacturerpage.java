package com.scm.pomobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createmanufacturerpage {
	//declaration
	@FindBy(linkText = "Add Manufacturer")
	private WebElement manufacturerlnk;
	
	@FindBy(id="manufacturer:name")
	private WebElement nametxt;
	
	@FindBy(id="manufacturer:password")
	private WebElement passwordtxt;
			
	@FindBy(id="manufacturer:phone")
	private WebElement phonetxt;
	
	@FindBy(id="manufacturer:email")
	private WebElement emailtxt;
	
	@FindBy(id="manufacturer:username")
	private WebElement usernametxt;
	
	@FindBy(xpath="//input[@value='Add Manufacturer']")
	private WebElement addmanufacturerbtn;
	
	@FindBy(xpath="//input[@value='Log out']")
	private WebElement logoutbtn;
	
	//initialization
	public Createmanufacturerpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public WebElement getManufacturerlnk() {
		return manufacturerlnk;
	}

	public WebElement getNametxt() {
		return nametxt;
	}

	public WebElement getPasswordtxt() {
		return passwordtxt;
	}

	public WebElement getPhonetxt() {
		return phonetxt;
	}

	public WebElement getEmailtxt() {
		return emailtxt;
	}

	public WebElement getUsernametxt() {
		return usernametxt;
	}

	public WebElement getAddmanufacturerbtn() {
		return addmanufacturerbtn;
	}
			
	public WebElement getLogoutbtn() {
		logoutbtn.click();
		return logoutbtn;
	}


			//business libraries
			public void addmanufacturer(String mname,String memail,String mphonenum,String musername,String mpassword)
			{
				manufacturerlnk.click();
				nametxt.sendKeys(mname);
				emailtxt.sendKeys(memail);
				phonetxt.sendKeys(mphonenum);
				usernametxt.sendKeys(musername);
				passwordtxt.sendKeys(mpassword);
				
				
				addmanufacturerbtn.click();
			}

}
