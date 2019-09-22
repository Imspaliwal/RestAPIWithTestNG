package com.swapi.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC03_GoogleMAP_GET {
	
	@Test(description = "", enabled = true)
	public void googleMAP_GET() {
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET, "");
		
		// Print and Assert Response Status Code
		int responseStatusCode = response.getStatusCode();
		System.out.println("Response Status Code is : "+responseStatusCode);
		Assert.assertEquals(responseStatusCode, 200);
		
		// Print and Assert Response Status Line
		String responseStatusLine = response.statusLine();
		System.out.println("Response Status Line is : "+responseStatusLine);
		Assert.assertEquals(responseStatusLine, "HTTP/1.1 200 OK");
		
		// Print and Assert Response Body
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);		
		
		
	}

}
