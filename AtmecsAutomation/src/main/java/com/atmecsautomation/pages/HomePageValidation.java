package com.atmecsautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.atmecsautomation.constants.LoadPropertyFile;
import com.atmecsautomation.helpers.CommonUtility;

public class HomePageValidation {

	public static void footer(String[] validatedata, int counter) {

		switch (counter) {
		case 1:
			WebElement element = CommonUtility
					.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.footer.sitemap.txt"));
			footerValidation(validatedata, element);
			break;
		case 2:
			WebElement element1 = CommonUtility
					.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.footer.services.txt"));
			footerValidation(validatedata, element1);
			break;
		case 3:
			WebElement element2 = CommonUtility
					.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.footer.careers.txt"));
			footerValidation(validatedata, element2);
			break;
		case 4:
			WebElement element3 = CommonUtility
					.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.footer.contactus.txt"));
			footerValidation(validatedata, element3);
			break;
		}
	}

	private static void footerValidation(String[] validatedata, WebElement element) {
		String[] val = element.getText().split("\n");
		int datasize = val.length;
		for (int intial = 0; intial < datasize; intial++) {
			Assert.assertEquals(validatedata[intial], val[intial], "Footer data not matched");
			System.out.println("Footer data match:"+val[intial]+", "+validatedata[intial]);
		}

	}
	public static void directionPage(WebDriver driver,String title) {
		
		Assert.assertEquals(driver.getTitle(),title,"Direction Page is Not Landing");
		System.out.println("Page Landing properly");
	}
	
	public static void digitallifeMenuValidation(WebDriver driver,String[] validatedata) {
		Actions action = new Actions(driver);
		WebElement wb = CommonUtility.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.services.btn"));
		action.click(wb).build().perform();
		WebElement wb1 = CommonUtility.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.services.digitallife.btn"));
		action.click(wb1).build().perform();
		WebElement element = CommonUtility.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.services.digitallife.option.txt"));
		String [] val=element.getText().split("\n");
		int datasize = validatedata.length;
		for (int intial = 0; intial < datasize; intial++) {
			System.out.println(val[intial]);
			System.out.println(validatedata[intial]);
			Assert.assertEquals(validatedata[intial], val[intial+1], "Footer data not matched");
			System.out.println("Footer data match:"+val[intial+1]+", "+validatedata[intial]);
		}
	}
	
}
