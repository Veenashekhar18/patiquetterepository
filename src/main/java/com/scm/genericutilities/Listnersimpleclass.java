package com.scm.genericutilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listnersimpleclass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result)
	{
		test=report.createTest(result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS,result.getMethod().getMethodName());
		test.log(Status.PASS,result.getThrowable());
	
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL,result.getThrowable());
		
		String screenshot=WebActionUtility.takescreenshot(Baseclass.sdriver, result.getName());
		test.addScreenCaptureFromPath(screenshot);
		
				
		/*String methodname=result.getMethod().getMethodName();
		
		TakesScreenshot ts=(TakesScreenshot)Baseclass.sdriver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		LocalDateTime dt=LocalDateTime.now();
		String datetime=dt.toString().replace(" ","_").replace(":","_");
		File dst=new File("./Screenshots/"+methodname+"_"+datetime+".png");
		try {
			FileUtils.copyFile(src, dst);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}*/
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}
		
	@Override
	public void onStart(ITestContext context)
	{
		Random r=new Random();
		int num=r.nextInt();
		
		ExtentSparkReporter spark=new ExtentSparkReporter("ExtentReport/Report.html"+num);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("ExtentReport");
		spark.config().setReportName("veena");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("platform", "windows10");
		report.setSystemInfo("Executed by", "veena");
		report.setSystemInfo("reviewed by", "Deepak");
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		report.flush();
	}

	
	
	
	
}
