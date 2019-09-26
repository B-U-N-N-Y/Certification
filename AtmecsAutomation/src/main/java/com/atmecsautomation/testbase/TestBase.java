package com.atmecsautomation.testbase;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.atmecsautomation.constants.FilePath;
import com.atmecsautomation.constants.LoadPropertyFile;
import com.atmecsautomation.extentreports.ExtentReport;
import com.atmecsautomation.utils.ReadPropertiesFile;

/**
 * This class operate to choose the driver
 * 
 * @author arjun.santra
 *
 */
public class TestBase extends ExtentReport {

	Properties baseClass;
	String url;
	public static String browser;
	int downloadFile;
	LoadPropertyFile property=new LoadPropertyFile();

	@BeforeTest
	public void intitailizeBrowser() throws IOException {

		baseClass = ReadPropertiesFile.loadProperty(FilePath.CONFIG_FILE);
		url = baseClass.getProperty("url");
		browser = baseClass.getProperty("browser");

		System.out.println("browser is " + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", FilePath.CHROME_PATH);

			driver = new ChromeDriver();
			driver.get(url);

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", FilePath.FIREFOX_PATH);
			driver = new FirefoxDriver();
			driver.get(url);
		}
		 else if (browser.equalsIgnoreCase("ie")) {
			 System.setProperty("webdriver.edge.driver", FilePath.IE_PATH);
				DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
				ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, url);
				driver = new InternetExplorerDriver(ieCaps);
			}

		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

}
