package com.scm.pomobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomepage {
	//declaration
			@FindBy(xpath="//a[.='Add Products']")
			private WebElement addproductlnk;
			
			@FindBy(xpath="//a[.='Add Retailers']")
			private WebElement addretailerlnk;
			
			@FindBy(xpath="//a[.='Add Manufacturer']")
			private WebElement addmanufacturerlnk;
			
			@FindBy(xpath="//a[.='Add Distributor']")
			private WebElement adddistributorlnk;
			
			@FindBy(xpath="//a[.='Manage Unit']")
			private WebElement manageunitlnk;
			
			@FindBy(xpath="//a[.='Manage Category']")
			private WebElement managecategorylnk;
			
			@FindBy(xpath="//a[.='Retailers']")
			private WebElement retailermajrtab;
			
			@FindBy(xpath="//a[.='Manufacturers']")
			private WebElement manufacturermajortab;
			
			@FindBy(xpath="//a[.='Distributors']")
			private WebElement distributorsmajortab;
			
			@FindBy(xpath="//a[.='Products']")
			private WebElement productsmajortab;
			
			@FindBy(xpath="//a[.='Orders']")
			private WebElement ordersmajortab;
			
			@FindBy(xpath="//a[.='Invoice']")
			private WebElement invoicemajortab;
			
			//initialization
			public AdminHomepage(WebDriver driver)
			{
				PageFactory.initElements(driver,this);
			}

			//utilization
			public WebElement getAddproductlnk() {
				return addproductlnk;
			}

			public WebElement getAddretailerlnk() {
				return addretailerlnk;
			}

			public WebElement getAddmanufacturerlnk() {
				return addmanufacturerlnk;
			}

			public WebElement getAdddistributorlnk() {
				return adddistributorlnk;
			}

			public WebElement getManageunitlnk() {
				return manageunitlnk;
			}

			public WebElement getManagecategorylnk() {
				return managecategorylnk;
			}

			public WebElement getRetailermajrtab() {
				return retailermajrtab;
			}

			public WebElement getManufacturermajortab() {
				return manufacturermajortab;
			}

			public WebElement getDistributorsmajortab() {
				return distributorsmajortab;
			}

			public WebElement getProductsmajortab() {
				return productsmajortab;
			}

			public WebElement getOrdersmajortab() {
				return ordersmajortab;
			}

			public WebElement getInvoicemajortab() {
				return invoicemajortab;
			} 
				
			//business libraries
			public void adminhomepage()
			{
				addproductlnk.click();
				addretailerlnk.click();
				addmanufacturerlnk.click();
				adddistributorlnk.click();
				manageunitlnk.click();
				managecategorylnk.click();
				retailermajrtab.click();
				manufacturermajortab.click();
				distributorsmajortab.click();
				productsmajortab.click();
				ordersmajortab.click();
				invoicemajortab.click();
			}
}
