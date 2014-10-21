package com.cyou.sele;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStack_eg {

  public static final String USERNAME = "bsUser4359";
  public static final String AUTOMATE_KEY = "aZPkqcsnW2CyPXpMLWD8";
  public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
  public DesiredCapabilities caps = new DesiredCapabilities();
  public WebDriver driver;
  
  public void OpBrowser()throws Exception{
	//操作浏览器
	driver = new RemoteWebDriver(new URL(URL), caps);
	driver.get("http://www.google.com/ncr");
	WebElement element = driver.findElement(By.name("q"));
	element.sendKeys("BrowserStack");
	element.submit();
	
  }
  
  @Before
  public void setup(){
	  
  }
  
  @Test //test Windows8 Firefox26.0
  public void Windows8_Firefox26() throws Exception {
	
	//定义使用的OS和browser版本
	caps.setCapability("browser", "Firefox");
	caps.setCapability("browser_version", "26.0");
	caps.setCapability("os", "Windows");
	caps.setCapability("os_version", "8.1");
	caps.setCapability("browserstack.debug", "true");
	
	this.OpBrowser();
    //case
    String titl=driver.getTitle();
    assertEquals(titl,"BrowserStack - Google Search");
  }
  
  @Test //test Windows7 IE9
  public void Windows7_IE9() throws Exception {
	
	//定义使用的OS和browser版本
	caps.setCapability("browser", "IE");
	caps.setCapability("browser_version", "9");
	caps.setCapability("os", "Windows");
	caps.setCapability("os_version", "7");
	caps.setCapability("browserstack.debug", "true");
	
	this.OpBrowser();
    //case
    int titl=driver.getPageSource().indexOf("Go to Google Home");
    assertNotEquals(titl,-1);
    
  }
  
  @After
  public void testdown(){
	  driver.quit();
  }
    
}



//package com.cyou.sele;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import java.net.URL;
//
//public class BrowserStack_eg {
//
//  public static final String USERNAME = "bsUser4359";
//  public static final String AUTOMATE_KEY = "aZPkqcsnW2CyPXpMLWD8";
//  public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
//  
//  public static void main(String[] args) throws Exception {
//
//    DesiredCapabilities caps = new DesiredCapabilities();
//    caps.setCapability("browser", "IE");
//    caps.setCapability("browser_version", "7.0");
//    caps.setCapability("os", "Windows");
//    caps.setCapability("os_version", "XP");
//    caps.setCapability("browserstack.debug", "true");
//    
//    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
//    driver.get("http://www.google.com/ncr");
//    WebElement element = driver.findElement(By.name("q"));
//    
//    element.sendKeys("BrowserStack");
//    element.submit();
//
//    System.out.println(driver.getTitle());
//    driver.quit();   //Warning: The driver.quit statement is required, otherwise the test continues to execute, leading to a timeout
//
//  }
//}