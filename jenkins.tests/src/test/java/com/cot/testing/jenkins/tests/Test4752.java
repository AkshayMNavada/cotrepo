package com.cot.testing.jenkins.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test4752 {

	static String DeviceID="190859";//Raspberry pi
	
	static String pass="";
	static String baseurl="";
	static String uname="";
	static String Dpath="";
	static String ph="";
	static String uname2="";
	
	@Test
	public void TestMethod4752() throws InterruptedException, MalformedURLException {
		
		 Properties prop = new Properties();
		    InputStream input = null;

		    try {

		        input = new FileInputStream("src/main/resources/configuarations.properties");

		        // load a properties file
		        prop.load(input);

		        baseurl=prop.getProperty("url");
		        uname=prop.getProperty("username");
		        uname2=prop.getProperty("username2");
		        pass=prop.getProperty("password");
		        Dpath=prop.getProperty("DriverPathc");
		        ph=prop.getProperty("ph1");
		        
		    } catch (IOException ex) {
		        ex.printStackTrace();
		    } finally {
		        if (input != null) {
		            try {
		                input.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		    
		    
		    DesiredCapabilities capability = DesiredCapabilities.chrome();
		    WebDriver driver = new RemoteWebDriver(new URL("http://Jenkins.ip.here:4444/wd/hub"), capability);
		    driver.get(baseurl);
		    String page = driver.getPageSource();
	 	
		    WebDriverWait wait=new WebDriverWait(driver, 40);
	 	WebElement element;
	 	
	 	ApiTest obj=new ApiTest();
	 	
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[contains(@placeholder,'Username (required)')]")));
		element.sendKeys(uname);
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[contains(@placeholder,'Password (required)')]")));
		element.sendKeys(pass);
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[contains(@ng-disabled,'ctrl.disabledForm(form_login)') ]")));
		element.click();
	
		Thread.sleep(5000);
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button//i[@class='fa-2x fa fw fa-th']")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div[@class='app-switcher']//a[@title='Device management']")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//a[@title='Devices']")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//a//span[contains(text(),'All devices')]")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//td[@class='ng-scope']//div//a[contains(@ng-href,'#/device/190859')]")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//ul//li//a//span[contains(text(),'Alarms')]")));
		element.click();
		
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@title='Toggle realtime']")));
		element.click();
		
		obj.setAlarmTest4752();
		  
		Thread.sleep(5000);
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@title='Toggle realtime']")));
		element.click();
		
		obj.setAlarmTest4752();
		
	}
}
