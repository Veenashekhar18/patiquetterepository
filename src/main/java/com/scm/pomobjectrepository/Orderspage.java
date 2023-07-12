package com.scm.pomobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.genericutilities.WebActionUtility;



public class Orderspage {
WebActionUtility wlib= new WebActionUtility();
	
	//declaration
	@FindBy(xpath="//a[.='Orders']")
	private WebElement orderslnk;
	
	@FindBy(id="cmbFilter")
	private WebElement searchbydrpdwn;
	
	@FindBy(xpath="//input[@id='datepicker']")
	private WebElement calselct;
	
	@FindBy(xpath="//input[@value='Search']")
	private WebElement searchbtn;
	
	//initialization
	public Orderspage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//utilization
	public WebElement getOrderslnk() {
		return orderslnk;
	}

	public WebElement getSearchbydrpdwn() {
		return searchbydrpdwn;
	}
	
	public WebElement getSearchbtn() {
		return searchbtn;
	}

	//business libraries
	public void ordersearchandconfirm()
	{
		orderslnk.click();
		 wlib.select(searchbydrpdwn, "Date");
		 
			searchbtn.click();
	}
}
