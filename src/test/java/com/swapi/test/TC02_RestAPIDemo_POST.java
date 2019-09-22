package com.swapi.test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_RestAPIDemo_POST {
	
	@Test(description = "", enabled = true)
	public void restAPIDemoQA_POST() {
		
		// Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		// Specify Request Object to Send Request
		RequestSpecification httpRequest = RestAssured.given();
		
		// Request Pay-load sending along with Post Request
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("FirstName", "Sumit123");
		requestParams.put("LastName", "Paliwal123");
		requestParams.put("UserName", "SumPal123");
		requestParams.put("Password", "Welcome123");
		requestParams.put("Email", "sumit123@gmail.com");
		
		httpRequest.header("Content-Type", "application/json");
		
		// Attached above data to the request
		httpRequest.body(requestParams.toJSONString());
		
		// Create Response object to store response
		Response response = httpRequest.request(Method.POST, "/register");

		// Print and Assert Response Status Code
		int responseStatusCode = response.getStatusCode();
		System.out.println("Response Status Code is : "+responseStatusCode);
		Assert.assertEquals(responseStatusCode, 201);
		
		// Print and Assert Response Body
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);	
		
		String responseSuccessCode = response.jsonPath().get("SuccessCode");
		System.out.println("Success Code is : "+responseStatusCode);
		Assert.assertEquals(responseSuccessCode, "OPERATION_SUCCESS");
		
	}

}
