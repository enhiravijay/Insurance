package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import basePage.BasePage;
import new_car_insurance_input.Login;
import utility.Config;

public class TestBase {
	public WebDriver driver;
	Properties prop;
	BasePage basepage;
	Login login;

	public WebDriver openBrowser(String sName) throws Exception {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login=new Login(driver);
		login.checkLogin(sName);
		return driver;
	}
	
	

	public Properties getprop() throws Exception {
		Config con = new Config();
		prop = Config.loadPropertyFile();
		return prop;

	}

	public void softverification(String Actual, String Expected, int iTestCaseRow) throws Exception {
		boolean bResult;
		if (Expected.equalsIgnoreCase(Actual)) {
			bResult = true;
			System.out.println("value are matching");
			System.out.println("act and expe match" + bResult);
			//ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);

		} else {
			SoftAssert softassert = new SoftAssert();
			softassert.assertTrue(Expected.equals(Actual));
			System.out.println("this is actual" + " " + Actual);
			System.out.println("this is Expected" + Expected);
			System.out.println("first test");
			bResult = false;
			System.out.println(bResult);
			if (bResult == false) {
				System.out.println(bResult);
				//ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
			}

			softassert.assertAll();

		}

	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		// below line is just to append the date format with the screenshot name to
		// avoid duplicate names
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		//String failureImageFileName = result.getMethod().getMethodName()+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime())+ ".png";
		//File failureImageFile = new File(System.getProperty("user.dir")+"\\screenshots\\"+failureImageFileName);
		String destination = System.getProperty("user.dir") + "\\FailedTestsScreenshots\\" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		// Returns the captured file path
		return destination;
	}

	/*public static String checkRunMode(int itestCaseRow) {
		return //ExcelUtils.getCellData(itestCaseRow, Constant.Col_RunMode);

	}*/
}
