package com.scm.genericutilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FBBasesclass {
	public WebDriver driver;
	@BeforeClass
	public void Login() {
		WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("veenaraichur58@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("182255141");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
}
