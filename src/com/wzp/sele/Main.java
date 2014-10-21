package com.wzp.sele;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.firefox.*;



public class Main {

	public static void main(String[] args) {
		try{
			//初始化浏览器
			String url = "http://10.1.11.68"; 
			WebDriver FFdr = new FirefoxDriver();
			Navigation FFna = FFdr.navigate();
			FFna.to(url);	//会等待页面加载完毕再执行下一句
			FFdr.manage().timeouts().pageLoadTimeout(8, java.util.concurrent.TimeUnit.SECONDS);
			
			//登陆平台
			WebElement userInput = FFdr.findElement(By.id("email"));
			WebElement pass = FFdr.findElement(By.name("password"));
			WebElement loginButton = FFdr.findElement(By.id("login"));
			userInput.sendKeys("wangzhipeng@cyou-inc.com");
//			userInput.submit();		//登陆时候用click()还是用submit()呢？
			pass.sendKeys("1qazxsw23edc");
			loginButton.submit();
			
			//获取页面信息
			String title = FFdr.getTitle();
			String homeUrl = FFdr.getCurrentUrl();
			String loginUser = FFdr.findElement(By.className("dropdown-toggle")).getText();
			String tagName = FFdr.findElement(By.className("dropdown-toggle")).getTagName();
			String hrefValue = FFdr.findElement(By.className("dropdown-toggle")).getAttribute("href");
//			Thread.sleep(5000);
			System.out.println(title + " | 登陆用户:" +loginUser + " | 标签类型:" + tagName + " | href地址:" + hrefValue + " | 页面地址:" + homeUrl);
			
			//跳转到二维码,并获取两个页面的handle,关闭一个页面
			FFdr.findElement(By.linkText("扫一扫")).click();
			String[] handles = new String[FFdr.getWindowHandles().size()];
			FFdr.getWindowHandles().toArray(handles);
			FFdr.switchTo().window(handles[1]);
			FFdr.close();
			FFdr.switchTo().window(handles[0]);
			System.out.println(FFdr.getTitle());
			
			//管理cookies
			java.util.Set<Cookie> cookie = FFdr.manage().getCookies();
			Cookie[] cookies = new Cookie[cookie.size()];
			cookie.toArray(cookies);
			System.out.println("当前cookies的数量:" + cookies.length);
			for(int i=0;i<cookies.length;i++){
				print("第"+(i+1)+"个cookies信息:");
				print("名称:" + cookies[i].getName());
				print("值　:" + cookies[i].getValue());
				print("域　:" + cookies[i].getDomain());
				print("路径:" + cookies[i].getPath());
				print("过期:" + cookies[i].getExpiry());
				print("");
			};
			
			//窗口的相关操作
			Window wind=  FFdr.manage().window();
			wind.maximize();
			print("浏览器尺寸为:" + wind.getSize().getWidth()+","+wind.getSize().getHeight());
			System.out.println(wind.equals(wind));
			
			
			FFdr.close();
			FFdr.quit();
		}catch(Exception e){
			System.out.print("faild");
		}
	}
	public static void print(String info){
		System.out.println(info);
	}
}
