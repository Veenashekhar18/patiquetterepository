package com.scm.genericutilities;

import org.testng.ITestListener;

public class Listnersimpleclass implements ITestListener {

	/*@Override
	public void onTestFailure(ITestResult result)
	{
		String methodname=result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot) Baseclass.sdriver;
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
		}
	}
*/
}
