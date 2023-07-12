package com.scm.pomobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.genericutilities.WebActionUtility;


public class Loginpage {
	WebActionUtility wlib= new WebActionUtility();
	
	//Declaration
	@FindBy(id="login:username") 
	private WebElement usernametxt;

	@FindBy(id="login:password") 
	private WebElement passwordtxt;

	@FindBy(xpath="//select[@id='login:type']") 
	private WebElement selectdrpdwn;

	@FindBy(xpath="//input[@value='Login']") 
	private WebElement loginbtn;

	@FindBy(xpath="//input[@value='Log out']")
	private WebElement logoutbtn;

	//initialization
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//utilization
	public WebElement getUsernametxt() {
		return usernametxt;
	}

	public WebElement getPasswordtxt() {
		return passwordtxt;
	}

	public WebElement getSelectdrpdwn() {
		return selectdrpdwn;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	//business libraries
	public void Logintoappl(String usn,String pwd,String logintype)
	{System.out.println("username is"+" "+usn);
		usernametxt.sendKeys(usn);
		passwordtxt.sendKeys(pwd);
		wlib.select(selectdrpdwn,logintype );
	    loginbtn.click();
	}
}
