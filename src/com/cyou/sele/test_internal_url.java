package com.cyou.sele;


import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class test_internal_url {
	  public static final String USERNAME = "bsUser4359";
	  public static final String AUTOMATE_KEY = "aZPkqcsnW2CyPXpMLWD8";
	  public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	  public DesiredCapabilities caps = new DesiredCapabilities();
	  public WebDriver driver;
	  
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void IE6() throws Exception{    //Windows XP IE6
		
		//定义使用的OS和browser版本
		caps.setCapability("browser", "IE");
		caps.setCapability("browser_version", "6");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "XP");
		caps.setCapability("browserstack.debug", "true");
		caps.setCapability("browserstack.tunnel", "true");
		
		driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("http://10.6.219.71/");
		String titl=driver.getTitle();
	    assertEquals(titl,"Web Site List");
	}
	
	@Test
	public void IE7() throws Exception{    //Windows XP IE7
		
		//定义使用的OS和browser版本
		caps.setCapability("browser", "IE");
		caps.setCapability("browser_version", "7");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "XP");
		caps.setCapability("browserstack.debug", "true");
		caps.setCapability("browserstack.tunnel", "true");
		
		driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("http://10.6.219.71/");
		String titl=driver.getTitle();
	    assertEquals(titl,"Web Site List");
	}
	
	@Test
	public void IE8() throws Exception{    //Windows XP IE8
		
		//定义使用的OS和browser版本
		caps.setCapability("browser", "IE");
		caps.setCapability("browser_version", "8");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "7");
		caps.setCapability("browserstack.debug", "true");
		caps.setCapability("browserstack.tunnel", "true");
		
		driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("http://10.6.219.71/");
		String titl=driver.getTitle();
	    assertEquals(titl,"Web Site List");
	}
	
	@Test
	public void iphone() throws Exception{    //iPhone5
		
		//定义使用的OS和browser版本
		caps.setCapability("browserName", "iPhone");
		caps.setPlatform(Platform.MAC);
		caps.setCapability("device", "iPhone 5");
		caps.setCapability("browserstack.debug", "true");
		caps.setCapability("browserstack.tunnel", "true");
		
		driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("http://10.6.219.71/");
		String titl=driver.getTitle();
	    assertEquals(titl,"Web Site List");
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
