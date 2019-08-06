package com.cot.testing.jenkins.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test5515 {

	static String DeviceID="190859";//Raspberry pi
	
	static String pass="";
	static String baseurl="";
	static String uname="";
	static String Dpath="";
	static String ph="";
	static String uname2="";
	
	//@Test
	public void TestMethod5515() throws InterruptedException {
		
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
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//span[contains(.,'Data explorer')]")));
	element.click();
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//button//translate[contains(text(),'Add data point')]")));
	element.click();
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[contains(@ng-model,'searchData.text')]")));
	element.sendKeys("CoTJavaAgent");
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//span//button[contains(@ng-click,'search(searchData.text)')]")));
	element.click();
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "(//button[@title='CoTJavaAgent'])[2]")));
	element.click();
	
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	//js.executeScript("window.scrollBy(0,1000)");
	
	//driver.findElement(By.xpath("(//div//label//input[@type='checkbox'])[1]")).click();
	Thread.sleep(5000);
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//label[@class='c8y-checkbox input-sm']")));
	element.click();
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "(//div//button[contains(@ng-click,'add()')])[1]")));
	element.click();
	Thread.sleep(5000);
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "(//div//button[@title='Expand'])[1]")));
	element.click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div//input[@name='min']")).clear();
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[@name='min']")));
	element.sendKeys("1");
	
	driver.findElement(By.xpath("//div//input[@name='max']")).clear();
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[@name='max']")));
	element.sendKeys("100");
	
	driver.findElement(By.xpath("//div//input[@name='target']")).clear();
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[@name='target']")));
	element.sendKeys("27");
	
	driver.findElement(By.xpath("//div//input[@name='yellowRangeMin']")).clear();
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[@name='yellowRangeMin']")));
	element.sendKeys("1");
	
	driver.findElement(By.xpath("//div//input[@name='yellowRangeMax']")).clear();
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[@name='yellowRangeMax']")));
	element.sendKeys("50");
	
	driver.findElement(By.xpath("//div//input[@name='redRangeMin']")).clear();
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[@name='redRangeMin']")));
	element.sendKeys("51");
	
	driver.findElement(By.xpath("//div//input[@name='redRangeMax']")).clear();
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//input[@name='redRangeMax']")));
	element.sendKeys("100");
	
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//select[@ng-model='dp.renderType']")));
	element.click();
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div//select[@ng-model='dp.renderType']//option[@label='Minimum and maximum']")));
	element.click();
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//span[contains(.,'More')]")));
	element.click();
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[contains(.,'Download as Excel')]")));
	element.click();
	Thread.sleep(2000);
	element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//a[contains(.,'Download')]")));
	element.click();
}
}
