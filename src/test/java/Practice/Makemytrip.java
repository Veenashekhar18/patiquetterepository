package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Makemytrip {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//section[@class='modalMain tcnFooter']")).click();
		driver.findElement(By.id("fromCity")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("//div[@class='react-autosuggest__section-container react-autosuggest__section-container--first']")).click();
		driver.findElement(By.id("toCity")).sendKeys("Mumbai");
		driver.findElement(By.xpath("//li[@data-suggestion-index='0']]")).click();
		driver.findElement(By.id("departure")).click();
		driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label='Tue Jul 18 2023']")).click();
		driver.findElement(By.id("departure")).click();
		driver.findElement(By.xpath("//a[.='Search']")).click();
	}

}

