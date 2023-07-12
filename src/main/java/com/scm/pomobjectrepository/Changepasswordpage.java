package com.scm.pomobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Changepasswordpage {
	//declaration
			@FindBy(id="oldPassword")
			private WebElement oldpwdtxt;
			
			@FindBy(id="newPassword")
			private WebElement newpwdtxt;
			
			@FindBy(id="confirmPassword")
			private WebElement cnfmpwdtxt;
			
			@FindBy(id="//input[@value='Change Password'")
			private WebElement chngpwdbtn;
			
			//initialization
			public Changepasswordpage(WebDriver driver)
			{
				PageFactory.initElements(driver,this);
			}
			
			//utilization
			
			public WebElement getOldpwdtxt() {
				return oldpwdtxt;
			}

			public WebElement getNewpwdtxt() {
				return newpwdtxt;
			}

			public WebElement getCnfmpwdtxt() {
				return cnfmpwdtxt;
			}

			public WebElement getChngpwdbtn() {
				return chngpwdbtn;
			}
			
			//business libraries
			public void changepwd(String oldpwd,String newpwd,String cnfmpwd)
			{
				oldpwdtxt.sendKeys(oldpwd);
				newpwdtxt.sendKeys(newpwd);
				cnfmpwdtxt.sendKeys(cnfmpwd);
				chngpwdbtn.click();
			}
}
