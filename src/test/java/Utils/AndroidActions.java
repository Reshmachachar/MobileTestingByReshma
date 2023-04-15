package Utils;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidActions extends AppiumUtils{
public static AndroidDriver driver;

	
	public AndroidActions(AndroidDriver driver)
	{
	
		this.driver = driver;
	}
	
	public void scroll(double start_xd,double start_yd,double end_xd,double end_yd) {
		  
		  Dimension dim= driver.manage().window().getSize();
			int start_x=(int) (dim.width * start_xd);
			int start_y=(int) (dim.height * start_yd);
			
			int end_x=(int) (dim.width * end_xd);
			int end_y=(int) (dim.height * end_yd);
				
			TouchAction touch=new TouchAction(driver);
			touch.press(PointOption.point(start_x,start_y))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(end_x, end_y))
			.release()
			.perform();
	  }
	  	
		public boolean scroll_to_text_down(By by, String attribute, String text)
		{
			int a=0;
			boolean flag= false;
			do {
				List<WebElement> list = driver.findElements(by);
				for (WebElement e : list) {
					//System.out.println(e.getAttribute(attribute));
					if(e.getAttribute(attribute).equalsIgnoreCase(text))
					{
						flag=true;
						System.out.println("--------------- got the value");
						break;
					}
				}
				if(!flag)
				scroll(0.5, 0.8, 0.5, 0.2);
				a++;
			}
			while(!flag || a==14);
			return flag;	
		}
	
		/*
		 * public void setTimeOut(long time,TimeUnit unit) {
		 * driver.manage().timeouts().implicitlyWait(time,unit); }
		 */
		
}
