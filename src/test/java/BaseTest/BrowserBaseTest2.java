package BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;


import Utils.XLUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest2 {
	public static AndroidDriver driver;
	public AppiumDriverLocalService service;
	public static Properties prop;
	XLUtility testdata;
	@BeforeClass
	public void AppiumTest() throws IOException, Exception
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("F:\\Workspace3\\kotakMobileTestingByReshma\\src\\test\\java\\Resource\\config.properies");
		prop.load(fis);
		//code to start server
		
//		 service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\RESHMA\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();
		
		//appium code->appium server->mobile
		UiAutomator2Options cap=new UiAutomator2Options();
        cap.setChromedriverExecutable("F:\\Workspace3\\MobileDemoProject\\Driver\\chromedriver.exe");
		cap.setCapability("deviceName","SM M015G");
		cap.setCapability("browserName","Chrome");
		
//		cap.setCapability("udid","R9ZN809M3WZ");
//		cap.setCapability("platformName","Android");
//		cap.setCapability("platformVersion","11");
//		cap.setCapability("appPackage","com.androidsample.generalstore");
//		cap.setCapability("appActivity","com.androidsample.generalstore.SplashActivity");
//		
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get(prop.getProperty("base_url"));
		 
		 
		 
		 
		 //---------------------------------------------------------------------------
//		 //click on Loan
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("(//a[@data-title='Personal Loan at incredibly low rates'])[1]")).click();
//		 
//		 
//		 //click on Calculate EMI
//		 driver.findElement(By.xpath("//a[@data-id='calculator1520598575344']")).click();
//		 System.out.println("click on calculate EMI");
//		 
//		 //CLICK ON EMI calculator
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//a[text()='EMI Calculator']")).click();
//		 
//		 testdata = new XLUtility();
//			double p=testdata.Principal;
//			double r=testdata.rate;
//			double y1=testdata.year;
//System.out.println(p);
//System.out.println(r);
//System.out.println(y1);
//		    int principal = (int)Math.round(p);
//		    
//		 //click on my loan requirment is    
//		   driver.findElement(By.xpath("//input[@id='amt']")).clear();
//		   driver.findElement(By.xpath("//input[@id='amt']")).sendKeys(String.valueOf(p));
//		   Thread.sleep(2000);
//		  //click on loan amount 
//		   driver.findElement(By.xpath("//input[@id='per']")).clear();
//		   driver.findElement(By.xpath("//input[@id='per']")).sendKeys(String.valueOf(r));
//		   Thread.sleep(2000);
//		   //click on years
//		   driver.findElement(By.xpath("//input[@id='yr']")).clear();
//		   driver.findElement(By.xpath("//input[@id='yr']")).sendKeys(String.valueOf(y1));
//		   
//		 
//		   Thread.sleep(2000);
//		   //get monthly emi
//		   driver.findElement(By.xpath("//p[@class='f48 emi_value']")).getText();
//			
//		   
//		   //getPrincipal amount
//		   driver.findElement(By.xpath("//p[@class='f24 total_principal']")).getText();
//		   
//		   //get Interest Payable
//		   
//		   driver.findElement(By.xpath("//p[@class='f24 total_interest']")).getText();
//		   
//		   //GET total payment
//		   driver.findElement(By.xpath("//p[@class='f24 total_payment']")).getText();
//		   
//		   
//	}
////	public void longPressAction(WebElement ele)
////	{
////		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
////			    "elementId", ((RemoteWebElement) ele).getId(),"duration",2000));
////	}
////	
////	
//	
//	
//	public	static double emi_calculator(double p,double r, double t)
//	{
//		double emi;
//
//		r = r / (12 * 100); 
//		t = t * 12; 
//		emi = (p * r * (float)Math.pow(1 + r, t)) 
//				/ (float)(Math.pow(1 + r, t) - 1);
//		return emi;
//	}
//	
//	public double getFormatedAmount(String amount)
//	{
//		double actualPrize = Double.parseDouble(amount.substring(1));
//		return actualPrize;
//	}
	}

}
