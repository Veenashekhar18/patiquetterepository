package com.scm.testscripts.patiquette;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.scm.genericutilities.Baseclass;
import com.scm.genericutilities.Excelutiliity;
import com.scm.genericutilities.FileUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginadminTest extends Baseclass {
	@Test(groups = "smoke")
	public void logintest() throws Throwable {
		FileUtility flib = new FileUtility();
		Excelutiliity elib=new Excelutiliity();

		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("6");
		String filepath = flib.getfilepathfromproeritiesfile("projectconfigdatafilepath");
		System.out.println("7");
		String url = flib.getdatafromproperties(filepath, "url");
		Reporter.log(url);
		driver.get(url);
		String usn = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx","Sheet1","TC_01","username");
		Reporter.log(usn);
		String pwd = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx","Sheet1","TC_01","password");
		String logintype=elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx", "Sheet1","TC_01","Logintype");
		Reporter.log(pwd);
		//made some changes
		//update changes
	}

}
