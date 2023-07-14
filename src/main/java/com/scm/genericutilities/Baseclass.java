package com.scm.genericutilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.scm.pomobjectrepository.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Baseclass {
	WebActionUtility wlib=new WebActionUtility();
	FileUtility flib=new FileUtility();
	Excelutiliity elib=new Excelutiliity();
	public static WebDriver driver;
	public static WebDriver sdriver;
	public String filepath;

	//@Parameters("browser")
	//@BeforeClass(groups= {"smoke","integration"})
	@BeforeClass
	public void openbrowser() throws IOException {
				
		filepath=flib.getfilepathfromproeritiesfile("projectconfigdatafilepath");
		String browser=flib.getdatafromproperties(filepath,"browser");
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		default:
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				
				
		}
		sdriver=driver;
		driver.manage().window().maximize();
		System.out.println("opening the browser");
			wlib.waitforelement(driver);//wait for 40seconds
			flib.getfilepathfromproeritiesfile("projectconfigdatafilepath");
			String url=flib.getdatafromproperties(filepath,"url");
			
			driver.get(url);
			System.out.println("entered url");
			String title=driver.getTitle();
			System.out.println(title);
			
	}
	@BeforeMethod
	public void logintoapp() throws Throwable {
		
		//login as admin
		wlib.waitforelement(driver);//wait for 20seconds
		String usn = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx","Sheet1","TC_01","username");
		String pwd = elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx","Sheet1","TC_01","password");
		String logintype=elib.getdatafromexcelbasedontestid("./configuration/pati.xlsx","Sheet1","TC_01","Logintype");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.Logintoappl(usn, pwd, logintype);
		System.out.println("logged in as admin");
	}
/*@AfterMethod
	public void logoutfrmapp() {
		Loginpage loginpage = new Loginpage(driver);
		loginpage.getLogoutbtn();
		System.out.println("logout");
	}
	*/
	  @AfterClass 
	  public void closebrowser() { 
		  driver.close();
	  System.out.println("Browser is closed"); }
	 
//@BeforeSuite to opendb
//@AfterSuite to closedbb
}
/*driver=new ChromeDriver();  //launch the browser
String browser=flib.getdatafromproperties(filepath,"browser");
if(browser.equals("firefox"))
{
	//System.setProperty("webdriver.gecko.driver","./software/geckodriver32.exe");
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}
else if(browser.equals("chrome"))
{
	//System.setProperty("webdriver.chrome.driver","./software/chromedriver32.exe");
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}
}*/
