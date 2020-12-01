package steps;

import config.Config;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.PetStoreOrder;
import net.thucydides.core.annotations.Step;
import testData.PetStoreTestData;
import utils.EnvironmentPropertyLoader;

import java.util.Properties;


public class EndUserSteps {

    PetStoreTestData petStoreTestData = new PetStoreTestData();

    protected static Properties envProperties = EnvironmentPropertyLoader.loadByEnvironment();

    private String getBaseUrl() {
        String baseUrl = envProperties.getProperty("baseURL");
        return baseUrl;
    }

    @Step
    public void postPet() {
        RestAssured.given()
                .spec(baseSpecification())
                .body(petStoreTestData.createTestPetObject())
                .when()
                .post(Config.CREATE_PET)
                .then()
                .statusCode(200);
    }

    @Step
    public void postPetOrder() {
        RestAssured.given()
                .spec(baseSpecification())
                .body(petStoreTestData.createTestPetOrderObject())
                .when()
                .post(Config.CREATE_ORDER)
                .then()
                .statusCode(200);
    }

    @Step
    public void deletePetOrder() {
        RestAssured.given()
                .spec(baseSpecification())
                .when()
                .delete(String.format(Config.ORDER_BY_ID, petStoreTestData.getPetStoreOrder().getId()))
                .then()
                .statusCode(200);
    }

    @Step
    public void deletePet() {
        RestAssured.given()
                .spec(baseSpecification())
                .when()
                .delete(String.format(Config.DELETE_PET, petStoreTestData.getPet().getId()))
                .then()
                .statusCode(200);
    }

    public Response getPetOrderByOrderId(long orderId) {
        return RestAssured.given()
                .spec(baseSpecification())
                .get(String.format(Config.ORDER_BY_ID, orderId));
    }

    @Step
    public PetStoreOrder getPetOrder() {

        PetStoreOrder petStoreOrder = getPetOrderByOrderId(petStoreTestData.getPetStoreOrder().getId())
                .then()
                .statusCode(200)
                .and()
                .extract().response().body().as(PetStoreOrder.class, ObjectMapperType.JACKSON_2);

        return petStoreOrder;
    }

    @Step
    public PetStoreOrder getTestPetOrder() {
        return petStoreTestData.getPetStoreOrder();
    }

    public RequestSpecification baseSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(getBaseUrl())
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

}
