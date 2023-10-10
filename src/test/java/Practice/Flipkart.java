package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[.='✕']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("phones");
		System.out.println("search for phones");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//span[.='Page 1 of 388']"));  
		System.out.println("scroll till next");//span[.='Next']
		Thread.sleep(2000);
		Point locn = ele.getLocation();
		int x=locn.getX();
		int y=locn.getY();
		System.out.println("value of x is : "+x);
		System.out.println("value of y is : "+y);
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
		System.out.println("scrolled till next element");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='ge-49M' and .='2']")).click();
		System.out.println("click on particular page number ");
	}

}
