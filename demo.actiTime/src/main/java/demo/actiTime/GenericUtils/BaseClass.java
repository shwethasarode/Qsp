package demo.actiTime.GenericUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import demo.actiTime.POM.HomePage;
import demo.actiTime.POM.LoginPage;

public class BaseClass {
	WebDriver driver= null;
	PropertyUtils pUtils= new PropertyUtils();
	@BeforeSuite
	public void configBS() {
		//database connection
	}
	
	@BeforeTest
	public void configBT() {
		//parallel Testing codes
	}
	
	@BeforeClass
	public void configBC() {
		//open the browser
		
		String browserName=pUtils.getPropertyData(IPathConstant.PROPFILE_PATH,"browser");
		String url=pUtils.getPropertyData(IPathConstant.PROPFILE_PATH, "url");
		if(browserName.equals("chrome")) {
			System.setProperty(IPathConstant.CHROME_KEY, IPathConstant.CHROME_PATH);
			driver = new ChromeDriver();
		} 
		else if(browserName.equals("firefox")) {
			System.setProperty(IPathConstant.FIREFOX_KEY, IPathConstant.FIREFOX_PATH);
			driver = new FirefoxDriver();
		}
		else {
			throw new SessionNotCreatedException("browser is not supported");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(IPathConstant.IMPLICIT_TIME, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@BeforeMethod
	public void configBM() {
		//login to the application
		String username = pUtils.getPropertyData(IPathConstant.PROPFILE_PATH, IPathConstant.UN_KEY);
		String password = pUtils.getPropertyData(IPathConstant.PROPFILE_PATH, IPathConstant.PWD_KEY);
		LoginPage loginPage= new LoginPage(driver);
		loginPage.login(username, password);
	}
	@AfterMethod
	public void configAM() throws Throwable {
		HomePage homePage= new HomePage(driver);
		Thread.sleep(5000);
		//WebDriverWait wait= new WebDriverWait(driver,20);
		//wait.until(ElementIsVisible);
		homePage.getLogoutLink().click();
	}
	
	@AfterClass
	public void configAC() {
		driver.quit();
	}
	@AfterTest
	public void configAT() {
		
	}
	@AfterSuite
	public void configAS() {
		
	}
}
