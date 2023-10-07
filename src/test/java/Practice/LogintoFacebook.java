package Practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import com.scm.genericutilities.FBBasesclass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogintoFacebook 
{
	public WebDriver driver;
	@Test
	public void Sendmsg() throws InterruptedException
	{
		EdgeOptions options=new EdgeOptions();
		options.addArguments("--disable-notifications");
		//options.setCapability("disable-infobars", true);
		//options.setCapability("--disable-notifications", true);
		WebDriverManager.edgedriver().setup();
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver(options); 
		driver=new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("veenaraichur58@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("182255141");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> links = driver.findElements(By.xpath("//span[.='Contacts']/ancestor::div[@class='x1n2onr6']/descendant::li"));
		int count=links.size();
		ArrayList<String> list=new ArrayList<>();
		
		for(WebElement l: links)
		{
			String s=l.getText();
			list.add(s);
			
		}
		System.out.println(list);
		driver.findElement(By.xpath("//span[.='Vidya Shekhar']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[@class='xat24cr xdj266r']")).sendKeys("hii");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[name()='svg' and @class='xsrhx6k']")).click();
		Thread.sleep(3000);
		System.out.println("msg sent");
		driver.findElement(By.xpath("//div[@aria-label='Close chat']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[name()='svg' and @aria-label='Your profile']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='xu06os2 x1ok221b' and .='Log out']")).click();
		
		
		
	}
}
