package com.scm.pomobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Viewproductspage {
	//declaration
	@FindBy(linkText ="Products")
	private WebElement productslink;
	
	@FindBy(xpath="//input[@value='Delete'")
	private WebElement deletebtn;
	
	@FindBy(xpath="//img[@alt='edit']")
	private WebElement editbtn;
	
	@FindBy(xpath="//input[@value='Log out']")
	private WebElement logoutbtn;
	
	//initialization
	public Viewproductspage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//utilization
	public WebElement getProductslink() {
		return productslink;
	}

	public WebElement getDeletebtn() {
		return deletebtn;
	}

	public WebElement getEditbtn() {
		return editbtn;
	}
	
	public WebElement getLogoutbtn() {
		logoutbtn.click();
		return logoutbtn;
	}

	//business libraries
	public void verifyanddelete()
	{
		productslink.click();
		//deletebtn.click();
		editbtn.click();
		
	}
}
