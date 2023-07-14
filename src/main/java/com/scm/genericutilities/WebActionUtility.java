package com.scm.genericutilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;


public class WebActionUtility {
	FileUtility flib=new FileUtility();
	int Timeout=30;
	
	/**
	 * it's an implicitly wait  Always wait for Element in DOM document & release the control if element available
	 * @param driver
	 */
	public void waitforelement(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeout));
	}
	
	/**
	 * it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partialpageurl
	 */
	public void waitforpage(WebDriver driver,String partialpageurl)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(Timeout));
		wait.until(ExpectedConditions.urlContains(partialpageurl));
	}
	
	/**
	 * it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param element
	 */
	public void waitforelement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Timeout));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * it's an Explicitly wait Always wait until title visible
	 * @param driver
	 * @param title
	 */
	public void waitforelementtitle(WebDriver driver, String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Timeout));
		wait.until(ExpectedConditions.titleContains(title));
	}
	public void waitforelementClickable(WebDriver driver, WebElement title)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Timeout));
		wait.until(ExpectedConditions.elementToBeClickable(title));
	}
	public void fluentWaitElement(WebDriver driver, WebElement element)
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(50));
		wait.ignoring("Datta is great".getClass());
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitandclick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<Timeout)
		{
			try {
				element.click();
				break;
				}
			catch(Throwable e)
			{
				Thread.sleep(1000);
				count++;
				
			}
		}
	}
	
	/**
	 *  wait for the element and type the data
	 * @param element
	 * @param data
	 * @throws InterruptedException
	 */
	public void waitandtype(WebElement element,String data) throws InterruptedException
	{
		int count=0;
		while(count<20) {
			try {
				element.sendKeys(data);
				break;
				}
			catch(Throwable e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialwindowtitle
	 */
	public void switchtowindowbasedontitle(WebDriver driver,String partialwindowtitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext())
		{
			String wid=itr.next();
			driver.switchTo().window(wid);
			String currentwindowtitle=driver.getCurrentUrl();
			if(currentwindowtitle.contains(partialwindowtitle))
			{
				System.out.println(partialwindowtitle+"window successfully switched");
				break;
			}
		}
	}
	
	/**
	 * used to Switch to Any Window based on Window URL
	 * @param driver
	 * @param partialwindowurl
	 */
	public void switchtowindowbasedonurl(WebDriver driver,String partialwindowurl)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext())
		{
			String wid=itr.next();
			driver.switchTo().window(wid);
			String currentwindowtitle=driver.getCurrentUrl();
			if(currentwindowtitle.contains(partialwindowurl))
			{
				System.out.println(partialwindowurl+"window successfully switched");
				break;
			}
		}
	}
	
	/**
	 * used to switch to alert window and click on accept
	 * @param driver
	 * @param expectedmsg
	 */
			public void switchtoalertwindowandaccept(WebDriver driver,String expectedmsg)
			{
				Alert alert=driver.switchTo().alert();
				if(alert.getText().trim().equalsIgnoreCase(expectedmsg.trim()))
				{
					System.out.println("alert messege is verified");
				}
				else {
					System.out.println("alert messege is not verified");
				}
				alert.accept();
		}
			
			/**
			 * used to switch to alert window and click on dismiss 
			 * @param driver
			 * @param expectedmsg
			 */
		public void switchtoalertwindowdismiss(WebDriver driver,String expectedmsg)
		{
			Alert alert=driver.switchTo().alert();
			if(alert.getText().equals(expectedmsg))
			{
				System.out.println("alert messege is verified");
			}
			else {
				System.out.println("alert messege is not verified");
			}
			alert.dismiss();
			}
		
		/**
		 * used to switch frame based on id or name attribute
		 * @param driver
		 * @param idnameattribute
		 */
		public void switchfarme(WebDriver driver,String idnameattribute)
		{
			driver.switchTo().frame(idnameattribute);
		}
		
		/**
		 * used to select the value in dropdown based on index
		 * @param element
		 * @param index
		 */
		public void select(WebElement element,int index)
		{
			Select s=new Select(element);
			s.selectByIndex(index);
			
		}
		
		/**
		 * used to select the value in dropdown based on text
		 * @param element
		 * @param txt
		 */
		public void select(WebElement element,String txt)
		{
			Select s=new Select(element);
			s.selectByVisibleText(txt);			
		}
		
		/**
		 * used to mousehover on element
		 * @param driver
		 * @param element
		 */
		public void mouseoveronelement(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.moveToElement(element).perform();
		}
		
		/**
		 * used to rightclick on element
		 * @param driver
		 * @param element
		 */
		public void rightclickonelement(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.contextClick(element).perform();
		}
		
		/**
		 * 
		 * @param driver
		 * @param javascript
		 */
		public void executejavascript(WebDriver driver,String javascript)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript(javascript, null);
			
		}
		
		/**
		 * pass enter key 
		 * @param driver
		 */
		public void passenterkey(WebDriver driver)
		{
			Actions act=new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
		}
		
		/**
		 * this method is used to take screenshots
		 * @param driver
		 * @param screenshotname
		 * @return
		 */
		public static String takescreenshot(WebDriver driver,String screenshotname)
		{
						
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			LocalDateTime dt=LocalDateTime.now();
			String datetime=dt.toString().replace(" ","_").replace(":","_");
			File dst=new File("./Screenshots/"+screenshotname+".png");
			try {
				FileUtils.copyFile(src, dst);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			return screenshotname;
		}
		
}
