package Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class HandleCaptcha {

	public static void main(String[] args) throws IOException, InterruptedException, TesseractException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//a[.= ' LOGIN ']")).click();
		
		
		WebElement captcha = driver.findElement(By.xpath("//img[@class='captcha-img']"));
		 File src = captcha.getScreenshotAs(OutputType.FILE);
		 String path="C:\\Users\\veena\\eclipse-workspace\\com.supplychainmgmt.patiquette\\Screenshots\\img.png";
		org.openqa.selenium.io.FileHandler.copy(src, new File(path));
		Thread.sleep(2000);
		//https://sourceforge.net/projects/tess4j/
		ITesseract tess=new Tesseract();
		tess.setDatapath("C:\\Users\\veena\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
		String text=tess.doOCR(new File(path));
		System.out.println(text);
		driver.findElement(By.xpath("//input[@id='captcha']")).sendKeys(text);
		
	}

}
