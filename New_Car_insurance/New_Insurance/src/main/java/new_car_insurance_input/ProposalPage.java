package new_car_insurance_input;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePage.BasePage;

public class ProposalPage extends BasePage {
	
	public int bldstrint;
	public int mfloat;
	
	@FindBy(xpath = "//div[@class='popupScreen']/div[@class='popupclose']")
	WebElement btnCloseUp;

	@FindBy(xpath = "//a[@id='TabPersonalInfo']")
	WebElement TabPersonalInfo;
	
	@FindBy(xpath = "//select[@id='Salutation']")
	WebElement Salutation;
	
	@FindBy(xpath = "//input[@id='ContactLastName']")
	WebElement inputLastName;
	
	@FindBy(xpath = "//input[@id='DOBofOwner']")
	WebElement btnDobCal;
	
	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	WebElement selectYear;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	WebElement selectMonth;

	@FindBy(xpath = "//select[@id='MaritalStatus']")
	WebElement selectMarStatus;
	
	@FindBy(xpath = "//select[@id='ContactOccupationId']")
	WebElement selectOccupation;
	
	@FindBy(xpath = "//input[@id='ContactMobile']")
	WebElement inputMobile;
	
	@FindBy(xpath = "//input[@id='ContactEmail']")
	WebElement inputEmail;
	
	@FindBy(xpath = "//a[@id='TabAddInfo']")
	WebElement TabAddInfo;
	
	@FindBy(xpath = "//input[@id='RegisteredAddress']")
	WebElement InputRegisteredAddress;
	
	@FindBy(xpath = "//input[@id='RegisteredAddress2']")
	WebElement InputRegisteredAddress2;
	
	@FindBy(xpath = "//input[@id='RegisteredAddress3']")
	WebElement InputRegisteredAddress3;
	
	@FindBy(xpath = "//input[@id='RegisteredPinCode']")
	WebElement SelectRegisteredPinCode;
	
	@FindBy(xpath = "//select[@id='ddlRegisteredCityId']")
	WebElement SelectddlRegisteredCityId;
	
	@FindBy(xpath = "//a[@id='TabVehicleAddInfo']")
	WebElement TabVehicleAddInfo;
	
	@FindBy(xpath = "//input[@id='RegistrationNumberPart2']")
	WebElement InputRegistrationNumberPart2;
	
	@FindBy(xpath = "//input[@id='RegistrationNumberPart3']")
	WebElement InputRegistrationNumberPart3;
	
	@FindBy(xpath = "//input[@id='EngineNumber']")
	WebElement InputEngineNumber;
	
	@FindBy(xpath = "//input[@id='ChasisNumber']")
	WebElement InputChasisNumber;
	
	@FindBy(xpath = "//input[@id='PolicyNumber']")
	WebElement InputPolicyNumber;
	
	@FindBy(xpath = "//select[@id='VehicleColor']")
	WebElement SelectVehicleColor;
	
	@FindBy(xpath = "//a[@id='TabNomineeInfo']")
	WebElement TabTabNomineeInfo;
	
	@FindBy(xpath = "//select[@id='NomineeRelationID']")
	WebElement SelectNomineeRelationID;
	
	@FindBy(xpath = "//input[@id='NomineeName']")
	WebElement InputNomineeName;
	
	@FindBy(xpath = "//a[@id='TabTermsConditions']")
	WebElement TabTermsConditions;
	
	@FindBy(xpath = "//label[@id='lbliagree']")
	WebElement CheckBoxAgreeMessage;

	@FindBy(xpath = "//input[@id='NomineeDOB']")
	WebElement InputNomineeDOB;
	
	@FindBy(xpath = "//strong/span[@id='CustomerReference_ID']")
	WebElement TextCRN;
	
	@FindBy(xpath = "//span[@class='odometer-value']")
	List<WebElement> PremiumAMT;
	
	@FindBy(xpath = "//input[@id='PaymentLink']")
	public WebElement BtnPaymentLink;
	
	public ProposalPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public  void enterContact() throws Exception {
		enterContactDetails();
	}
	
	public  void enterAddress(String sName) throws Exception {
		enterAddressDetails(sName);
	}
	
	public  void enterVehicle() throws Exception {
		enterVehicleDetails();
	}
	

	public  void enterNominee() throws Exception {
		EnterNomineeDetails();
	}
	
	public  void TermsandCondition() throws Exception {
		TermsandConditionDetails();
	}
	
	private void enterContactDetails() throws Exception {
		//handleWait(btnCloseUp, driver, 20);
		//btnCloseUp.click();
		handleWait(TabPersonalInfo, driver, 3000);
		TabPersonalInfo.click();
		Thread.sleep(200);
		Salutation.click();
		handleDropDown(Salutation,"Mr");
		sendText(inputLastName, "Kumar");
		btnDobCal.click();
		handleDropDown(selectYear, "1982");
		handleDropDown(selectMonth, "Oct");
		selectDay("10");
		handleDropDown(selectMarStatus, "Married");
		handleDropDown(selectOccupation, "Others");
		inputMobile.sendKeys("9999999999");
		inputEmail.sendKeys("policybosstesting@gmail.com");
	}
	
	private void enterAddressDetails(String sName) throws Exception {
		Login lg = new Login(driver);
		boolean lgstatus = lg.islogin(sName);
		if(!lgstatus) {
		//handleWait(btnCloseUp, driver, 20);
		//btnCloseUp.click();
		TabAddInfo.click();
		Thread.sleep(200);
		InputRegisteredAddress.click();
		sendText(InputRegisteredAddress, "208 b wing,bharti deep chs");
		InputRegisteredAddress2.click();
		sendText(InputRegisteredAddress2, "saibaba nagar,navghar road");
		InputRegisteredAddress3.click();
		sendText(InputRegisteredAddress3, "bhyanadar east thana");
		//handleDropDown(SelectRegisteredPinCode, "400025");
		SelectRegisteredPinCode.click();
		SelectRegisteredPinCode.sendKeys("400025");
		SelectRegisteredPinCode.sendKeys(Keys.TAB);
		handleDropDown(SelectddlRegisteredCityId, "PRABHADEVI");
		
		}else {
			System.out.println("For login address is not required");
			
		}
		
		
	}
	
	private void enterVehicleDetails() throws Exception {
		Thread.sleep(200);
		TabVehicleAddInfo.click();
		Thread.sleep(200);
		InputRegistrationNumberPart2.click();
		sendText(InputRegistrationNumberPart2, "EQ");
		InputRegistrationNumberPart3.click();
		sendText(InputRegistrationNumberPart3, "5648");
		InputEngineNumber.click();
		sendText(InputEngineNumber, "EN56565656454645");
		InputChasisNumber.click();
		sendText(InputChasisNumber, "CH56456646464646");
		InputPolicyNumber.click();
		sendText(InputPolicyNumber, "PL543535353758568");
		//handleDropDown(SelectRegisteredPinCode, "400025");
		SelectVehicleColor.click();
		handleDropDown(SelectVehicleColor,"Black");
		TabTabNomineeInfo.click();
	}
	
	private void EnterNomineeDetails() throws Exception {
		SelectNomineeRelationID.click();
		handleDropDown(SelectNomineeRelationID, "Spouse");
		InputNomineeName.click();
		InputNomineeName.sendKeys("Test Spouse abckd");
		InputNomineeDOB.click();
		handleDropDown(selectYear, "1984");
		handleDropDown(selectMonth, "Oct");
		selectDay("1");
	}
	
	
	private void TermsandConditionDetails() throws Exception {
		jsExecute(TabTermsConditions);
		//TabTermsConditions.click();
		Thread.sleep(50);
		WebElement CheckforToggle4 = driver.findElement(By.xpath("//a[@aria-expanded='true']"));
		if(CheckforToggle4.getAttribute("aria-expanded").contains("false")) {
			WebElement ManField = driver.findElement(By.xpath("//div[@class='valerr']"));
			boolean manDis = ManField.isDisplayed();
			if(manDis==true) {
				System.out.println("Mandatory field's are not entered.");
			}
		}
		StringBuilder bld = new StringBuilder();
		int lpremamt = PremiumAMT.size();
		for(int i = 0;i<lpremamt;++i) {
		bld.append(PremiumAMT.get(i).getText());
		}
		String bldstr = bld.toString();
		bldstrint = Integer.parseInt(bldstr);
		System.out.println("bldstr value is "+ bldstr);
		//WebElement messageTextBox = driver.findElement(By.id("lbliagree"));
		
		Actions actions = new Actions(driver);
		actions.click(CheckBoxAgreeMessage).build().perform();
		WebElement PaymentLink = driver.findElement(By.id("PaymentLink"));
		PaymentLink.click();
		Thread.sleep(5000);
		WebElement amount = driver.findElement(By.xpath("//div[@class='panel-footer']/strong"));
		handleWait(amount, driver, 5000);
		String amtext = amount.getText();
		System.out.println("payment showing on payment gateway"+ amtext);
		String regamt = amtext.replaceAll("[^a-zA-Z0-9\\.0*$]", "");
		System.out.println("reg payment showing on payment gateway"+ amtext);
		String amt = removeZero(regamt);
		System.out.println("this is final amount "+amt);
		//int intamt = float.parsef.parseInt(amt);
		float flamt = Float.parseFloat(amt);
		mfloat=Math.round(flamt);
		System.out.println("int amount is "+mfloat);
		//if(intamt==)
		
		
	}
	
	
	
	
	private  void selectDay(String dayValue) {
		WebElement dayelem=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(.,'" + dayValue + "')]"));
		//WebElement dayelem=driver.findElement(By.xpath("//table[@class='table dtp-picker-days']/tbody/tr/td/a[contains(.,'" + dayValue + "')]"));
		
		WebElement GetFirstRegDay = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td/a"));
		int intcalday = Integer.parseInt(GetFirstRegDay.getText());
		//System.out.println(intcalday);
		for (int i = 0; i <= 31; i++) {
			if (intcalday == Integer.parseInt(dayValue)) {
				System.out.println(intcalday + " mon value is equal to " + dayValue);
				dayelem.click();
				break;
			} else if(intcalday <= Integer.parseInt(dayValue)){
				intcalday++;
				//GetFirstRegPrevYearBtn.click();
			}
			//System.out.println(intcalday);

		}
	}
	
	

	
}
