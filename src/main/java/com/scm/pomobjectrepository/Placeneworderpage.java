package com.scm.pomobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.genericutilities.WebActionUtility;



public class Placeneworderpage {
WebActionUtility wlib= new WebActionUtility();
	
	//declaration
	@FindBy(xpath="//a[.='New Order']")
	private WebElement orderslnk;
	
	@FindBy(xpath = "//table[@class='table_displayData']/tbody/tr/following-sibling::tr/td[.=' Cashew cookies ']/../td[5]/input[@id='30']")
	private WebElement enterqty;
		
	@FindBy(xpath="//input[@value='Post Order']")
	private WebElement placeorder;
	
	@FindBy(id="cmbFilter")
	private WebElement searchbydrpdwn;
	
	@FindBy(xpath="//input[@id='datepicker']")
	private WebElement calselct;
	
	@FindBy(xpath="//input[@value='Search']")
	private WebElement searchbtn;

	//initialization
		public Placeneworderpage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
//utilization
	public WebElement getOrderslnk() {
		return orderslnk;
	}

	public WebElement getEnterqty() {
		return enterqty;
	}

	public WebElement getPlaceorder() {
		return placeorder;
	}

	public WebElement getSearchbydrpdwn() {
		return searchbydrpdwn;
	}

	public WebElement getCalselct() {
		return calselct;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	//business libraries
		public void ordersearchandconfirm()
		{
			orderslnk.click();
			enterqty.click();
			placeorder.click();
			 wlib.select(searchbydrpdwn, "Date");
			 calselct.click();
				searchbtn.click();
		}

}
