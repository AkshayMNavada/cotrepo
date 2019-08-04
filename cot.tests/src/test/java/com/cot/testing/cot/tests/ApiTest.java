package com.cot.testing.cot.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class ApiTest {

static String DeviceID="190859";//Raspberry pi
	
	static String pass="";
	static String baseurl="";
	static String uname="";
	static String Dpath="";
	static String ph="";
	static String uname2="";
	static String CreateAlarm="";
	static String GetAlarms="";
	
	/*@Test
	public void setAlarm() {
		obj.getProperties();
		obj.shouldAnswerWithPost();
	}*/
	
	public ApiTest() {
		
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
	        CreateAlarm=prop.getProperty("createalarm");
	        GetAlarms=prop.getProperty("getalarms");

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
	}
	
	public void setAlarm() {

		// Get Children
		ExtractableResponse<Response> getChildrenResponse = given().log().all()
				// .contentType(ContentType.ANY)
				
				// .header("Content-Type", "application/json;charset=ISO-8859-1")
				.proxy("10.24.0.53",8080)
				.contentType("application+json").accept("application+json").auth()
				.basic(uname, pass)
				//.body("{\"name\": \"testMeasurementDevice\",\"c8y_IsDevice\":{},\"c8y_SupportedMeasurements\":[\"c8y_TemperatureMeasurement\"]}").when()
				.body("{\r\n" + 
						"\"source\": {\r\n" + 
						"\"id\":\"190859\"},\r\n" + 
						"\"type\":\"Rpi_temp_alarm\",\r\n" + 
						"\"text\":\"New alarm\",\r\n" + 
						"\"severity\":\"MAJOR\",\r\n" + 
						"\"status\":\"ACTIVE\",\r\n" + 
						"\"time\":\"2019-07-19T05:52:00.000Z\"\r\n" + 
						"}").when()
				//.body(Payload()).when()
				.post(CreateAlarm).then().log().all()
				.statusCode(201).extract();

		System.out.println("!!!!!!!!!!!!!!" + getChildrenResponse.asString() + "!!!!!!!!!!!!!!!!");

	}
	
	
	public void getAlarms() {
		// Get Children
		ExtractableResponse<Response> getChildrenResponse = given().log().all()
				.proxy("10.24.0.53",8080)
				.auth()
				.basic(uname, pass).when().get(GetAlarms).then().statusCode(200)
				.body("self", Matchers.equalTo("https://indiatransition.test-ram.m2m.telekom.com/alarm/alarms?pageSize=5&currentPage=1"))
				.body("alarms.severity", Matchers.hasItem("MAJOR")).extract();
		System.out.println("!!!!!!!!!!!!!!" + getChildrenResponse.asString() + "!!!!!!!!!!!!!!!!");

	}
	
	

	/*private Map<String, Object> Payload() {
		Map<String, Object> CSRLoginInfo = new HashMap<String, Object>();
		CSRLoginInfo.put("name", "testMeasurementDevice");
		List<String> list = new ArrayList<String>();
		list.add("c8y_TemperatureMeasurement");
		CSRLoginInfo.put("c8y_SupportedMeasurements", list);
		return CSRLoginInfo;
	}*/
}