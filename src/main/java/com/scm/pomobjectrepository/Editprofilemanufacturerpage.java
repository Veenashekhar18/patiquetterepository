package com.scm.pomobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Editprofilemanufacturerpage {
	//declaration
			@FindBy(id="manufacturer:name")
			private WebElement nametxt;
			
			@FindBy(id="manufacturer:email")
			private WebElement emailtxt;
			
			@FindBy(id="manufacturer:phone")
			private WebElement phonetxt;
			
			@FindBy(xpath="//input[@value='Change Password']")
			private WebElement changepwdbtn;

			@FindBy(xpath="//input[@value='Update Profile']")
			private WebElement updateprofilebtn;
			
			//initialization
			public Editprofilemanufacturerpage(WebDriver driver)
			{
				PageFactory.initElements(driver,this);
			}
			
			//utilization

			public WebElement getNametxt() {
				return nametxt;
			}

			public WebElement getEmailtxt() {
				return emailtxt;
			}

			public WebElement getPhonetxt() {
				return phonetxt;
			}

			public WebElement getChangepwdbtn() {
				return changepwdbtn;
			}

			public WebElement getUpdateprofilebtn() {
				return updateprofilebtn;
			}
			
			//business libraries
			public void editprofile(String name,String email,String phonenum)
			{
				nametxt.sendKeys(name);
				emailtxt.sendKeys(email);
				phonetxt.sendKeys(phonenum);
				changepwdbtn.click();
				updateprofilebtn.click();
			}
}
