package com.scm.pomobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.genericutilities.WebActionUtility;



public class Manufacturerloginpage {
WebActionUtility wlib= new WebActionUtility();
	
	//Declaration
	@FindBy(xpath="//input[@name='txtUsername']") 
	private WebElement musernametxt;
	
	@FindBy(xpath="//input[@name='txtPassword']") 
	private WebElement mpasswordtxt;
	
	@FindBy(xpath="//select[@id='login:type']") 
	private WebElement mselectdrpdwn;

	@FindBy(xpath="//input[@value='Login']") 
	private WebElement loginbtn;
	
	@FindBy(xpath="//input[@value='Log out']")
	private WebElement logoutbtn;
	
	//initialization
	public Manufacturerloginpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//utilization

	public WebElement getUsernametxt() {
		return musernametxt;
	}

	public WebElement getPasswordtxt() {
		return mpasswordtxt;
	}

	public WebElement getSelectdrpdwn() {
		//wlib.select(selectdrpdwn, "Admin");
		return mselectdrpdwn;
	}

	public WebElement getLoginbtn() {
		
		return loginbtn;
	}
		
	
	public WebElement getLogoutbtn() {
		logoutbtn.click();
		return logoutbtn;
	}

	//business libraries
	public void Manufrlogin(String musername,String mpassword)
	{
		musernametxt.sendKeys(musername);
		mpasswordtxt.sendKeys(mpassword);
		 wlib.select(mselectdrpdwn, "Manufacturer");
	    loginbtn.click();
	}
}
