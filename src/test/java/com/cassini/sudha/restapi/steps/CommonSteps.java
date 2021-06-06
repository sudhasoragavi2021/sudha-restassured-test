package com.cassini.sudha.restapi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class CommonSteps {

    private TestContext context;
    public CommonSteps(TestContext context) {
        this.context = context;
    }


    @Given("loaded {string} payload")
    public void loaded_payload(String payloadFileName) {
        String payload = CommonUtils.readPayload(CommonUtils.getFileName(payloadFileName));
        RequestSpecification request = RestAssured.with();
        request.given()
                .baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .body(payload);
        context.setRequest(request);
    }

    @When("post api for {string} is called")
    public void post_api_for_is_called(String urlLabel) {
        RequestSpecification request = context.getRequest();
        Response response = request.baseUri("https://reqres.in/").post(UriMapping.uriOfLabel(urlLabel));
        context.setResponse(response);
    }

    @When("get api for {string} is called")
    public void get_api_for_is_called(String urlLabel) {
        RequestSpecification request = RestAssured.with();
        request.given()
                .baseUri("https://reqres.in/")
                .contentType(ContentType.JSON);
        Response response = request.baseUri("https://reqres.in/").get(UriMapping.uriOfLabel(urlLabel));
        context.setResponse(response);
    }

    @Then("api should return response with status code {string}")
    public void api_should_return_response_with_status_code(String code) {
        context.getResponse().then().statusCode(Integer.parseInt(code));
    }
    @Then("{string} in response body should be {string}")
    public void in_response_body_should_be(String key, String expectedValue) {
        String response = context.getResponse().asString();
        JsonPath js = new JsonPath(response);
        Assert.assertEquals(js.get(key).toString() , expectedValue);
    }
}
