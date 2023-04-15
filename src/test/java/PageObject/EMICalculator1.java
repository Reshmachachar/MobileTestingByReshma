package PageObject;

import Utils.AndroidActions;
import Utils.Listeners;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EMICalculator1  {
	AndroidDriver ldriver;
	//	public EMICalculator(AndroidDriver driver) {
//		EMICalculator.driver=driver;
//		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//	}
	
	public EMICalculator1(AndroidDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	public static String personalLoanUrl="https://www.kotak.com/en/personal-banking/loans/personal-loan.html";

	public static String EMIUrl="https://www.kotak.com/en/personal-banking/loans/personal-loan/personal-loan-emi-calculator.html123";

	//click on loan 
	@FindBy(xpath="(//a[@data-title='Personal Loan at incredibly low rates'])[1]") WebElement loan;

	public WebElement getLoan() {
		return loan;
	}
	
	////click on Calculate EMI
	@FindBy(xpath="//a[@data-id='calculator1520598575344']") WebElement calculateEMI;

	public WebElement getCalculateEMI() {
		return calculateEMI;
	}
		//CLICK ON EMI calculator
		
	@FindBy(xpath="//a[text()='EMI Calculator']") WebElement emiCalculate;

	public WebElement getEmiCalculate() {
		return emiCalculate;
	}	
	//Click on loan requirment 
	@FindBy(xpath="//input[@id='amt']") WebElement loanreq;

	public WebElement getLoanreq() {
		return loanreq;
	}
	
	//click on loan amount 
	@FindBy(xpath="//input[@id='per']") WebElement loanamt;

	public WebElement getLoanamt() {
		return loanamt;
	}
	
	//click on years 
	@FindBy(xpath="//input[@id='yr']") WebElement year;

	public WebElement getYear() {
		return year;
	}
	//  //get monthly emi
	@FindBy(xpath="//p[@class='f48 emi_value']") WebElement monthEmi;

	public WebElement getMonthEmi() {
		return monthEmi;
	}
	
	//getPrincipalAmount /get Interest Payable   //GET total payment
	@FindBy(xpath="//p[@class='f24 total_principal']") WebElement prin;
	@FindBy(xpath="//p[@class='f24 total_interest']") WebElement interest;
	@FindBy(xpath="//p[@class='f24 total_payment']") WebElement totalPay;

	public WebElement getPrin() {
		return prin;
	}
	public WebElement getInterest() {
		return interest;
	}
	public WebElement getTotalPay() {
		return totalPay;
	}
	
}
