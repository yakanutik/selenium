package api.config;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class Request {

    public Response post(RequestSpecification request, String body, String endpoint) {
        return given()
                .spec(request)
                .body(body)
                .post(endpoint);
    }

    public ValidatableResponse post(RequestSpecification request, String body, String endpoint, ResponseSpecification response) {
        return given()
                .spec(request)
                .body(body)
                .post(endpoint)
                .then()
                .spec(response);
    }

    public ValidatableResponse get(RequestSpecification request, String endpoint, ResponseSpecification response, Object... param) {
        return given()
                .spec(request)
                .get(endpoint, param)
                .then()
                .spec(response);
    }

    public Response put() {
        return null;
    }

    public Response delete() {
        return null;
    }
}

