package Practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenlinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.get("http://rmgtestingserver/domain/Supply_Chain_Management");
     driver.findElement(By.id("login:username")).sendKeys("admin");
     driver.findElement(By.id("login:password")).sendKeys("admin123");
     driver.findElement(By.xpath("//select[@id='login:type']")).sendKeys("Admin");
     driver.findElement(By.xpath("//input[@value='Login']")).click();
	List<WebElement> links = driver.findElements(By.xpath("//a"));
	ArrayList<Object> brokenlinks = new ArrayList<Object>();
	for(int i=0; i<links.size(); i++)
	{
		String allLinks=links.get(i).getAttribute("href");
		URL url;
		int statuscode=0;
		try {
			url=new URL(allLinks);
			URLConnection connection = url.openConnection();
		HttpURLConnection httpurlconnection=(HttpURLConnection)connection;
		statuscode=httpurlconnection.getResponseCode();
		if(statuscode>=400)
		{
			brokenlinks.add(allLinks+" "+statuscode);
		}
		}
		catch(Exception e)
		{
			continue;
		}
	}
System.out.println(brokenlinks);
	}

}
