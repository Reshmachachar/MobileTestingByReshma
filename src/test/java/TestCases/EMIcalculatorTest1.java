package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseTest.BrowserBaseTest2;

import PageObject.EMICalculator1;
import Utils.ExtentListeners;
import Utils.XLUtility;

public class EMIcalculatorTest1 extends BrowserBaseTest2 {
	XLUtility testdata;
	ExtentListeners e=new ExtentListeners();
	//An_ExtentReport extentTest=new An_ExtentReport();
	public static EMICalculator1 homepage;

	@Test
	public void TC01_ExplorePoduct() throws Exception 
	{
		homepage=new EMICalculator1(driver);

		//click on loan
		Thread.sleep(2000);
		homepage.getLoan().click();
		Thread.sleep(2000);
		//click on Calculate EMI
		homepage.getCalculateEMI().click();

		//CLICK ON EMI calculator
		Thread.sleep(2000);
		homepage.getEmiCalculate().click();
		Assert.assertEquals(driver.getCurrentUrl(),homepage.EMIUrl);
		testdata = new XLUtility();
		double p=testdata.Principal;
		double r=testdata.rate;
		double y1=testdata.year;

		int principal = (int)Math.round(p);

		//fetch value in  to loan req
		homepage.getLoanreq().clear();
		homepage.getLoanreq().sendKeys(String.valueOf(p));
		Thread.sleep(2000);

		//insert value in to loan amount
		homepage.getLoanamt().clear();
		homepage.getLoanamt().sendKeys(String.valueOf(r));
		Thread.sleep(2000);

		//insert value in to years
		homepage.getYear().clear();
		homepage.getYear().sendKeys(String.valueOf(y1),Keys.ENTER);
		Thread.sleep(2000);

		String EMIAmt=homepage.getMonthEmi().getText();
		String emiAmt=EMIAmt.replaceAll(",","");
		int value1=Integer.parseInt(emiAmt);
Thread.sleep(2000);
		//Assertion on EMI amount
		double emiAmount=emi_calculator(principal,r,y1);
		int value2 = (int)Math.round(emiAmount);
		Assert.assertEquals(value1,value2,"Assertion on EMI amount not is successfull ");
		e.test.log(Status.INFO,"Assertion on EMI amount is successfull" );
		Thread.sleep(2000);
		//Principal amount assertion 
		String princ=homepage.getPrin().getText();
		String PrincAmt=princ.replaceAll(",","");
		Thread.sleep(2000);
		int PrincipalAmount=Integer.parseInt(PrincAmt);
		//int P_Amount=(int)Math.round(p);
		int P_Amount=(int)Math.round(p);
		Assert.assertEquals(PrincipalAmount,P_Amount,"Assertion on Principal amount is not successfull");
		e.test.log(Status.INFO,"Assertion on Principal amount is successfull" );
		Thread.sleep(2000);
		//for interest payable 
		String inter_pay=homepage.getInterest().getText();
		String inter_Amt=inter_pay.replaceAll(",","");
		int I_Amount=Integer.parseInt(inter_Amt);
		int totalamount=P_Amount+I_Amount;

		//for total amount 
		String total=homepage.getTotalPay().getText();
		String totalAmt=total.replaceAll(",","");
		Assert.assertEquals(Integer.parseInt(totalAmt),totalamount);
		e.test.log(Status.INFO,"assertion on total amount is successfull");


	}


	public	static double emi_calculator(double p,double r, double t)
	{
		double emi;

		r = r / (12 * 100); 
		t = t * 12; 
		emi = (p * r * (float)Math.pow(1 + r, t)) 
				/ (float)(Math.pow(1 + r, t) - 1);
		return emi;
	}

}
