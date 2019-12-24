package testCase001;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import basePage.BasePage;
import new_car_insurance_input.New_car_input_page;
import new_car_insurance_input.ProposalPage;
import new_car_insurance_input.QuotePage;
import testBase.TestBase;
import utility.Constant;
import utility.ExcelUtils;

@Listeners(utility.TestNgListners.class)
public class TestCase001 extends TestBase {
	//public WebDriver driver;
	public BasePage basepage;
	public Properties prop;
	public int iTestCaseRow = 1;
	public int iTestCaseRow1 = 2;
	public int iTestCaseRow3 = 3;
	public static ExtentReports extent;
	public static ExtentTest test;
	public Map<Integer, Map<Integer, List<String>>> abcmap;
	public String sName="Sheet1";
	
	@BeforeSuite
	public void beforeSuite() throws Exception {
		//extent = new ExtentReports("C:\\Users\\Vijay\\git\\New_Test\\New_Car_insurance\\New_Insurance\\test-output\\MyExtentReport.html",true);
		extent = new ExtentReports(Constant.Path_ExtentReport,true);
		//extent.loadConfig(new File("C:\\Users\\Vijay\\git\\New_Test\\New_Car_insurance\\New_Insurance\\src\\main\\resources\\configfile\\extent-config.xml"));
		extent.loadConfig(new File(Constant.Path_ExtentReport_Config));
		prop = getprop();
	}

	/*@BeforeTest
	public void beforeTest() throws Exception {
		openBrowser();
		prop = getprop();
		//EU = new ExcelUtils();
		//ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		//System.out.println("sssttttaaarrrttt");
		//Login lg = new Login(driver);
		//lg.checkLogin();
	}*/

	@BeforeMethod
	public void beforeMethod(Method method) throws Exception {
		//openBrowser(sName);
		prop = getprop();
		test = extent.startTest((this.getClass().getSimpleName() + " :: " + method.getName()),method.getName());
		test.assignAuthor("Vijay Chetgiri");
		test.assignCategory("SmokeReport--Prod");
	}

	@Test(description="With login")

	public void Test0001() throws Exception {
		test.log(LogStatus.INFO, "Test started with login");
		openBrowser(prop.getProperty("Sheet1"));
		New_car_input_page car = new New_car_input_page(driver);
		//Log.startLog(Class.forName(TestCase001));
		car.enterVehicleDetail(prop.getProperty("Sheet1"));
		test.log(LogStatus.INFO, "Vehicle details entered Successfully");
		car.enterPolicyDetail(prop.getProperty("Sheet1"));
		test.log(LogStatus.INFO, "Policy details entered Successfully");
		car.enterPsnlDetail(prop.getProperty("Sheet1"));
		test.log(LogStatus.INFO, "Psnl details entered Successfully");
		QuotePage quote = new QuotePage(driver);
		/*quote.getCrn();
		quote.getQuoteDetails();
		quote.getNoOfInsurers();
		quote.getIdv();
		quote.getPremium();*/
		//quote.getDataMap();
	    abcmap = quote.getDataMap();
		ExcelUtils.writeToExcel(abcmap, prop.getProperty("Sheet1"));
		test.log(LogStatus.INFO, "Data written successfully in Excel");
		Integer crno = quote.getCrn();
		test.log(LogStatus.INFO, "CrnNo is "+crno);
		//boolean vrcrn = quote.verifyCrn();
		//System.out.println("insurer given is present or not "+quote.ifInsurerPresent());
		String insName = ExcelUtils.getMapData("IsInsurerPresent", "Sheet1");
		quote.buyInsurer(sName);
		test.log(LogStatus.INFO, "Insurance selected is"+insName);
		ProposalPage pb = new ProposalPage(driver);
		pb.enterContact();
		test.log(LogStatus.INFO, "Contact details entered successfully on proposal page");
		pb.enterAddress(prop.getProperty("Sheet1"));
		test.log(LogStatus.INFO, "Address details entered successfully on proposal page");
		pb.enterVehicle();
		test.log(LogStatus.INFO, "Vehicle details entered successfully on proposal page");
		pb.enterNominee();
		test.log(LogStatus.INFO, "Nominee details entered successfully on proposal page");
		if(ExcelUtils.getMapData("Login", prop.getProperty("Sheet1")).equalsIgnoreCase("NO")) {
		pb.TermsandCondition();
		boolean status = false;
		if(pb.bldstrint==pb.mfloat) {
			status = true;
			assertTrue(status, "Test case for vehicle is successfull");
		}else {
			assertFalse(status, "This test for Vehicle is failed");
			
			
		}
		}else {
			pb.BtnPaymentLink.click();
			test.log(LogStatus.INFO, "Proposal page form submitted successfully");
		}
		
		
		//Assert.assertEquals(pb.bldstrint, pb.mfloat);
		
		//Assert.assertTrue(quote.verifyCrn());
		//Assert.assertTrue(false);
	}
	
	@Test(description="Without login")
	public void Test0002() throws Exception {
		test.log(LogStatus.INFO, "Test started without login");
		openBrowser(prop.getProperty("Sheet2"));
		New_car_input_page car = new New_car_input_page(driver);
		//Log.startLog(Class.forName(TestCase001));
		car.enterVehicleDetail(prop.getProperty("Sheet2"));
		test.log(LogStatus.INFO, "Vehicle details entered Successfully");
		car.enterPolicyDetail(prop.getProperty("Sheet2"));
		test.log(LogStatus.INFO, "Policy details entered Successfully");
		car.enterPsnlDetail(prop.getProperty("Sheet2"));
		test.log(LogStatus.INFO, "Psnl details entered Successfully");
		QuotePage quote = new QuotePage(driver);
		/*quote.getCrn();
		quote.getQuoteDetails();
		quote.getNoOfInsurers();
		quote.getIdv();
		quote.getPremium();*/
		//quote.getDataMap();
	    abcmap = quote.getDataMap();
		ExcelUtils.writeToExcel(abcmap, prop.getProperty("Sheet2"));
		test.log(LogStatus.INFO, "Data written successfully in Excel");
		Integer crno = quote.getCrn();
		test.log(LogStatus.INFO, "CrnNo is "+crno);
		//boolean vrcrn = quote.verifyCrn();
		//System.out.println("insurer given is present or not "+quote.ifInsurerPresent());
		String insName = ExcelUtils.getMapData("IsInsurerPresent", "Sheet1");
		quote.buyInsurer(sName);
		test.log(LogStatus.INFO, "Insurance selected is"+insName);
		quote.buyInsurer(sName);
		ProposalPage pb = new ProposalPage(driver);
		pb.enterContact();
		test.log(LogStatus.INFO, "Contact details entered successfully on proposal page");
		pb.enterAddress(prop.getProperty("Sheet2"));
		test.log(LogStatus.INFO, "Address details entered successfully on proposal page");
		pb.enterVehicle();
		test.log(LogStatus.INFO, "Vehicle details entered successfully on proposal page");
		pb.enterNominee();
		test.log(LogStatus.INFO, "Nominee details entered successfully on proposal page");
		if(ExcelUtils.getMapData("Login", prop.getProperty("Sheet2")).equalsIgnoreCase("NO")) {
		pb.TermsandCondition();
		boolean status = false;
		if(pb.bldstrint==pb.mfloat) {
			status = true;
			assertTrue(status, "Test case for vehicle is successfull");
		}else {
			assertFalse(status, "This test for Vehicle is failed");
			
			
		}
		}else {
			pb.BtnPaymentLink.click();
			test.log(LogStatus.INFO, "E-mail link sent successfully");
		}
		
		
		//Assert.assertEquals(pb.bldstrint, pb.mfloat);
		
		//Assert.assertTrue(quote.verifyCrn());
		//Assert.assertTrue(false);
	}
	
	/*@Test
	public void verifyTPText() throws Exception {
		New_car_input_page car1 = new New_car_input_page(driver);
		car1.selectRenewsec();
		Thread.sleep(5000);
		String verifyTPtext = car1.verifyTPText();
		System.out.println(verifyTPtext);
		Assert.assertEquals(verifyTPtext, "T.P. Only (1 Yr)");
		test.log(LogStatus.INFO, "TP Text Verified successfully");
	}
	
	@Test
	public void verifyODText() throws Exception {
		New_car_input_page car1 = new New_car_input_page(driver);
		car1.selectRenewsec();
		String verifyODtext = car1.verifyODText();
		System.out.println(verifyODtext);
		Assert.assertEquals(verifyODtext, "O.D. Oqnly (1 Yr)");
		test.log(LogStatus.INFO, "OD Text Verified successfully");
	}
	
	@Test
	public void verifyComprehensiveText() {
		New_car_input_page car1 = new New_car_input_page(driver);
		car1.selectRenewsec();
		String verifyComptext = car1.verifyCompText();
		System.out.println(verifyComptext);
		Assert.assertEquals(verifyComptext, "Comprehensive Plan (1 Yr)");
		test.log(LogStatus.INFO, "Comp Text Verified successfully");
	}
*/
	@AfterMethod //AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result){
		//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
		if(ITestResult.FAILURE==result.getStatus()){
			try{
				test.log(LogStatus.FAIL,"Test Case Failed is "+result.getName());
				test.log(LogStatus.FAIL,"Test Case Failed is "+result.getThrowable());
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				// Call method to capture screenshot
				File src=screenshot.getScreenshotAs(OutputType.FILE);
				//String failureImageFileName = result.getMethod().getMethodName()+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime())+ ".png";
				//File failureImageFile = new File(System.getProperty("user.dir")+"\\screenshots\\"+failureImageFileName);
				// Copy files to specific location 
				// result.getName() will return name of test case so that screenshot name will be same as test case name
				//FileUtils.copyFile(src, failureImageFile);
				System.out.println("Successfully captured a screenshot");
				//driver.close();
				String screenshotPath = getScreenshot(driver, result.getName());
				
				test.log(LogStatus.FAIL,test.addScreenCapture(screenshotPath));
				extent.endTest(test);
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
			extent.endTest(test);
			}else {
			//driver.close();
			extent.endTest(test);
		}
	}
	
	/*@AfterTest
	public void afterTest() {
		driver.close();
	}*/


	@AfterTest
	public void afterSuite() throws Exception {
		extent.flush();
		Thread.sleep(5000);		
		extent.close();
	}


}

