package com.cassini.sudha.restapi.steps;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class TestContext {

    private RequestSpecification request;
    private ValidatableResponse json;
    private Response response;


    public RequestSpecification getRequest() {
        return request;
    }

    public void setRequest(RequestSpecification request) {
        this.request = request;
    }

    public ValidatableResponse getJson() {
        return json;
    }

    public void setJson(ValidatableResponse json) {
        this.json = json;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}