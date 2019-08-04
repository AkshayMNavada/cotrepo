package com.cot.testing.cot.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test4747 {

static String DeviceID="190859";//Raspberry pi
	
	static String pass="";
	static String baseurl="";
	static String uname="";
	static String Dpath="";
	static String ph="";
	static String uname2="";
	
	@Test
	public void TestMethod() throws InterruptedException {
		
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
		    
		System.setProperty("webdriver.chrome.driver", Dpath);
	 	WebDriver driver = new ChromeDriver();
	 	 driver.get(baseurl);
	 	 driver.manage().window().maximize();
	 	 
	 	WebDriverWait wait=new WebDriverWait(driver, 40);
	 	WebElement element;
	 	
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[contains(@placeholder,'Username (required)')]")));
		element.sendKeys(uname);
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[contains(@placeholder,'Password (required)')]")));
		element.sendKeys(pass);
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[contains(@ng-disabled,'ctrl.disabledForm(form_login)') ]")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//span[contains(.,'Global Smart Rules')]")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@ng-click='add()']")));
		element.click();
		
		//Rule1
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//small[contains(.,'When alarm is received then e-mail is sent')]")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[contains(@placeholder,'Alarm type (required)')]")));
		element.sendKeys("Rpi_temp_alarm");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[@placeholder='Send to (required)']")));
		element.sendKeys(uname2);
		
		js.executeScript("window.scrollBy(0,1000)");
		
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//input[@ng-model='searchData.text']")));
		element.sendKeys(DeviceID);
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@ng-click='search(searchData.text)']")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@title='CoTJavaAgent']")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@ng-click='save()']")));
		element.click();
		
		ApiTest obj=new ApiTest();
		obj.setAlarm();
	
		//Rule2
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//span//button[@ng-click='add()']")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//span[contains(.,'send SMS')]")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[contains(@placeholder,'Alarm type (required)')]")));
		element.sendKeys("Rpi_temp_alarm");
		
		js.executeScript("window.scrollBy(0,1000)");
		
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[@ng-model='rule.config[param.property]']")));
		element.sendKeys(ph);
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//input[@ng-model='searchData.text']")));
		element.sendKeys(DeviceID);
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@ng-click='search(searchData.text)']")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@title='CoTJavaAgent']")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@ng-click='save()']")));
		element.click();
		
		obj.setAlarm();
		
		//Rule3
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//span//button[@ng-click='add()']")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//span[contains(.,'increase severity')]")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[contains(@placeholder,'Alarm type (required)')]")));
		element.sendKeys("Rpi_temp_alarm");
				
		js.executeScript("window.scrollBy(0,1000)");
				
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//input[@ng-model='searchData.text']")));
		element.sendKeys(DeviceID);
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@ng-click='search(searchData.text)']")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@title='CoTJavaAgent']")));
		element.click();
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@ng-click='save()']")));
		element.click();	
		
		//Rule4
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//span//button[@ng-click='add()']")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//span[contains(.,'execute operation')]")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[contains(@placeholder,'Alarm type (required)')]")));
				element.sendKeys("Rpi_temp_alarm");
						
				js.executeScript("window.scrollBy(0,1000)");
						
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//select[@ng-model='operation.example']")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//select[@ng-model='operation.example']//option[contains(.,'Update relay status to OPEN')]")));
				element.click();
						
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//input[@ng-model='searchData.text']")));
				element.sendKeys(DeviceID);
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@ng-click='search(searchData.text)']")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@title='CoTJavaAgent']")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@ng-click='save()']")));
				element.click();
				
				obj.setAlarm();
		//Rule5
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//span//button[@ng-click='add()']")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//span[contains(.,'On missing measurements')]")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "(//div//input[@placeholder='Type (required)'])[1]")));
				element.sendKeys("Temperature");
						
				js.executeScript("window.scrollBy(0,1000)");
						
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//input[@ng-model='searchData.text']")));
				element.sendKeys(DeviceID);
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@ng-click='search(searchData.text)']")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@title='CoTJavaAgent']")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@ng-click='save()']")));
				element.click();
				
				
		//Rule6
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//span//button[@ng-click='add()']")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//span[contains(.,'On measurement explicit threshold')]")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//select[@ng-model='kpiId']")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//select//option[contains(.,'c8y_Temperature => sensorValue - sensorValue')]")));
				element.click();	
				js.executeScript("window.scrollBy(0,1000)");
						
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//input[@ng-model='searchData.text']")));
				element.sendKeys(DeviceID);
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@ng-click='search(searchData.text)']")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@title='CoTJavaAgent']")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@ng-click='save()']")));
				element.click();
		//Rule7
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//span//button[@ng-click='add()']")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "(//div//span[@class='caption caption-output ng-binding' and contains(.,'create alarm')])[4]")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//select[@ng-model='kpiId']")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//select[@ng-model='kpiId']//option[contains(.,'c8y_Temperature => sensorValue - sensorValue')]")));
				element.click();	
				js.executeScript("window.scrollBy(0,1000)");
						
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//input[@ng-model='searchData.text']")));
				element.sendKeys(DeviceID);
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@ng-click='search(searchData.text)']")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@title='CoTJavaAgent']")));
				element.click();
				element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@ng-click='save()']")));
				element.click();
	}
}
