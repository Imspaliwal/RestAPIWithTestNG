package com.swapi.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_SWAPI_GET {
	
	@Test(description = "GET Request to get Star War API and Verify Status Code, Status Line", enabled = true)
	public void starWarAPI_GET() {
		
		// Base URI
		RestAssured.baseURI = "https://swapi.co/api/people";
		
		// Specify Request Object to Send Request
		RequestSpecification httpRequest = RestAssured.given();
		
		// Create Response object to store response
		Response response = httpRequest.request(Method.GET, "/1");

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
	
	// Line to delete for git branch test

}

/**
 * 1xx (Informational): The request was received, continuing process 
 * 2xx (Successful): The request was successfully received, understood and accepted
 * 3xx (Redirection): Further action needs to be taken in order to complete the request 
 * 4xx (Client Error): The request contains bad syntax or cannot be fulfilled 
 * 5xx (Server Error): The server failed to fulfill an apparently valid request
 */
