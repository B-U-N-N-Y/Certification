package com.atmecsautomation.constants;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
/**
 * This class operate Grid Connection
 * @author arjun.santra
 *
 */
public class GridConnection {
	public URL url;
	String nodeurl;
	
	public static WebDriver driver;
	public void GridCon(String nodeurl,String browser) {

		nodeurl ="http://55.55.52.236:4444/wd/hub";

		DesiredCapabilities capability = new DesiredCapabilities();
		
		try {
			url = new URL(nodeurl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WIN10);
		driver = new RemoteWebDriver(url, capability);
	}
}
