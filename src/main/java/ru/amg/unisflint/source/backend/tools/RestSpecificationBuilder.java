package ru.amg.unisflint.source.backend.tools;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.amg.unisflint.source.backend.requiests.EndPoints;
import ru.amg.unisflint.source.backend.requiests.Json;
import ru.amg.unisflint.source.utilities.loggerFilters.RestAssuredRequestFilter;
import ru.amg.unisflint.source.backend.requiests.pojo.AuthPojo;

public class RestSpecificationBuilder {

    Json json = new Json();
    EndPoints endPoints = new EndPoints();
    private Response response;
    AuthPojo authPojo = new AuthPojo("sodp_admin_test","admin123");

    public RequestSpecification tokenAuthTestUser() {
        return new RequestSpecBuilder()
                .addHeader("Content-type", "application/json")
                .addHeader("Authorization", "Bearer " + getTokenForAuthTestUser())
                .addFilter(new RestAssuredRequestFilter()).build();
    }

    public String getTokenForAuthTestUser() {
        RequestSpecification spec = RestAssured.given();
        spec.header("Content-Type", "application/json");
        Response responseFromGenerateToken = spec.body(Json.authTestUser).filter(new RestAssuredRequestFilter()).post(EndPoints.login);
        responseFromGenerateToken.prettyPrint();
        String jsonString = responseFromGenerateToken.getBody().asString();
        String tokenGenerated = JsonPath.from(jsonString).get("token");
        spec.header("Authorization", "Bearer " + tokenGenerated).then().log().all().statusCode(200); return tokenGenerated;
    }

    public String getTokenForAuthSodpAdmin () {
        RequestSpecification spec = RestAssured.given();
        spec.header("Content-Type", "application/json");
        Response responseFromGenerateToken = spec.body(authPojo).filter(new RestAssuredRequestFilter()).post(EndPoints.loginApp);
        responseFromGenerateToken.prettyPrint();
        String jsonString = responseFromGenerateToken.getBody().asString();
        String tokenGenerated = JsonPath.from(jsonString).get("token");
        spec.header("Authorization", "Bearer " + tokenGenerated).then().log().all().statusCode(200); return tokenGenerated;
    }

    public RequestSpecification tokenAuthSodpAdmin () {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + getTokenForAuthSodpAdmin())
                .addFilter(new RestAssuredRequestFilter()).build();
    }

}
