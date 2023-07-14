package com.scm.pomobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.genericutilities.WebActionUtility;


public class Addproductspage {
	WebActionUtility wlib=new WebActionUtility();
	//declaration
		@FindBy(linkText = "Add Products")
		private WebElement addproductslnk;
		
		@FindBy(id="product:name")
		private WebElement productnametxt;
		
		@FindBy(id="product:price")
		private WebElement pricetxt;
		
		@FindBy(xpath="//select[@id='product:unit']")
		private WebElement productunitdrpdwn;
		
		@FindBy(xpath="//select[@id='product:category']")
		private WebElement productcatydrpdwn;
		
		@FindBy(xpath="//input[@name='rdbStock' and @value='1']")
		private WebElement enradiobtn;
		
		@FindBy(xpath="//input[@name='rdbStock' and @value='2']")
		private WebElement disradiobtn;
		
		@FindBy(xpath="//input[@value='Add Product']")
		private WebElement addproductbtn;
		
		//initialization
				public Addproductspage(WebDriver driver)
				{
					PageFactory.initElements(driver,this);
				}
				
		//utilization
		public WebElement getAddproductslnk() {
			return addproductslnk;
		}

		public WebElement getProductnametxt() {
			return productnametxt;
		}

		public WebElement getPricetxt() {
			return pricetxt;
		}

		public WebElement getProductunitdrpdwn() {
			return productunitdrpdwn;
		}

		public WebElement getProductcatydrpdwn() {
			return productcatydrpdwn;
		}

		public WebElement getEnradiobtn() {
			return enradiobtn;
		}

		public WebElement getDisradiobtn() {
			return disradiobtn;
		}

		public WebElement getAddproductbtn() {
			return addproductbtn;
		}

		//business libraries
		public void addproducts(String productname,String productprice,String unittype,String category) throws InterruptedException
		{
			addproductslnk.click();
			Thread.sleep(2000);
			productnametxt.sendKeys(productname);
			Thread.sleep(2000);
			pricetxt.sendKeys(productprice);
			wlib.select(productunitdrpdwn,unittype);
			wlib.select(productcatydrpdwn,category);
			enradiobtn.click();
			addproductbtn.click();
		}	
}
