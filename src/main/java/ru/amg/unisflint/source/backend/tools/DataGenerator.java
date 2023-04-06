package ru.amg.unisflint.source.backend.tools;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import ru.amg.unisflint.source.backend.requiests.EndPoints;
import ru.amg.unisflint.source.backend.requiests.Json;
import static io.restassured.RestAssured.given;

public class DataGenerator {

    RestSpecificationBuilder restSpecificationBuilder = new RestSpecificationBuilder();
    Json json = new Json();
    EndPoints endPoints = new EndPoints();
    private String id;

    //Метод createApp создает тестовое приложение

    public void createApp () {
        Response response = RestAssured.given().
                contentType("application/json").spec(restSpecificationBuilder.tokenAuthTestUser()).
                body(Json.createTestApp).
                when().
                post(EndPoints.applications).
                then().
                statusCode(200).
                extract().response();
        String id = response.path("id");
        System.out.println(id);
        this.id = id;
    }

    //Метод deleteApp удаляет тестовое приложение
    public void deleteApp () {
        given().spec(restSpecificationBuilder.tokenAuthTestUser()).delete(EndPoints.applications+id).then().extract().response();
    }


}
