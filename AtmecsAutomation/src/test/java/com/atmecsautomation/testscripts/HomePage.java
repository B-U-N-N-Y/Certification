package com.atmecsautomation.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.atmecsautomation.constants.LoadPropertyFile;
import com.atmecsautomation.dataProvider.TestDataProvider;
import com.atmecsautomation.helpers.CommonUtility;
import com.atmecsautomation.pages.HomePageValidation;
import com.atmecsautomation.testbase.TestBase;

public class HomePage extends TestBase {
	public static int counter = 0;
	
	@Test(priority=0,dataProvider = "HomePageTitle", dataProviderClass = TestDataProvider.class)
	public void isRedirectionPage(String title) {
		HomePageValidation.directionPage(driver,title);
	}
	

	@Test(priority = 1, dataProvider = "footerdata", dataProviderClass = TestDataProvider.class)
	public void homePageFooter(String[] validatedata) {
		counter++;
		HomePageValidation.footer(validatedata, counter);
		if (counter == 4) {
			counter = 0;
		}
	}

	@Test(priority = 2, dataProvider = "footerdata", dataProviderClass = TestDataProvider.class)
	public void aboutUsFooter(String[] validatedata) {
		if(counter==0) {
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.aboutus.btn"));
		}
		counter++;
		HomePageValidation.footer(validatedata, counter);
		if (counter == 4) {
			counter = 0;
		}
	}

	@Test(priority = 3, dataProvider = "footerdata", dataProviderClass = TestDataProvider.class)
	public void servicesFooter(String[] validatedata) {
		if(counter==0) {
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.services.btn"));
		}
		counter++;
		HomePageValidation.footer(validatedata, counter);
		if (counter == 4) {
			counter = 0;
		}
	}

	@Test(priority = 4, dataProvider = "footerdata", dataProviderClass = TestDataProvider.class)
	public void partnersFooter(String[] validatedata) {
		if(counter==0) {
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.partners.btn"));
		}
		counter++;
		HomePageValidation.footer(validatedata, counter);
		if (counter == 4) {
			counter = 0;
		}
	}

	@Test(priority = 5, dataProvider = "footerdata", dataProviderClass = TestDataProvider.class)
	public void mediaFooter(String[] validatedata) {
		if(counter==0) {
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.media.btn"));
		}counter++;
		HomePageValidation.footer(validatedata, counter);
		if (counter == 4) {
			counter = 0;
		}
	}

	@Test(priority = 6, dataProvider = "footerdata", dataProviderClass = TestDataProvider.class)
	public void insightsFooter(String[] validatedata) {
		if(counter==0) {
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.insights.btn"));
		}counter++;
		HomePageValidation.footer(validatedata, counter);
		if (counter == 4) {
			counter = 0;
		}
	}

	@Test(priority = 7, dataProvider = "footerdata", dataProviderClass = TestDataProvider.class)
	public void careersFooter(String[] validatedata) {
		if(counter==0) {
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.careers.btn"));
		}counter++;
		HomePageValidation.footer(validatedata, counter);
		if (counter == 4) {
			counter = 0;
		}
	}

	@Test(priority = 8, dataProvider = "footerdata", dataProviderClass = TestDataProvider.class)
	public void contactUsFooter(String[] validatedata) {
		if(counter==0){
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.contactus.btn"));
		}counter++;
		HomePageValidation.footer(validatedata, counter);
		if (counter == 4) {
			counter = 0;
		}
	}
	
	

}
