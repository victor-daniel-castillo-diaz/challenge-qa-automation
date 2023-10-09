package com.saucedemo.api.ep;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class Endpoint 
{   public Endpoint() {
        RestAssured.baseURI = "https://www.mercadolibre.com.mx";
    }

    public Response getDepartments() {
        String endpoint = "/menu/departments";   
        Response response = given().contentType(ContentType.JSON).when().get(endpoint);
        return response;
    }
}
