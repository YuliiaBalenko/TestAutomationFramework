package com.epam.steps.serenity;

import config.Config;
import endpoints.PetStorePetEndpoint;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import models.PetStoreOrder;
import net.thucydides.core.annotations.Step;
import testData.PetStoreTestData;


public class EndUserSteps {

    PetStorePetEndpoint petStorePetEndpoint = new PetStorePetEndpoint();
    PetStoreTestData petStoreTestData = new PetStoreTestData();

    @Step
    public PetStoreOrder getPetOrder(String baseUrl) {

        PetStoreOrder petStoreOrder = petStorePetEndpoint.getPetOrderByOrderId(petStoreTestData.getPetStoreOrder().getId(),baseUrl)
                .then()
                .statusCode(200)
                .and()
                .extract().response().body().as(PetStoreOrder.class, ObjectMapperType.JACKSON_2);

        return petStoreOrder;
    }

    @Step
    public void postPet(String baseUrl) {
        petStorePetEndpoint.given(baseUrl)
                .body(petStoreTestData.createTestPetObject())
                .contentType(ContentType.JSON)
                .when()
                .post(Config.CREATE_PET)
                .then()
                .statusCode(200);
    }

    @Step
    public void postPetOrder(String baseUrl) {
        PetStoreOrder petStoreOrder = petStoreTestData.createTestPetOrderObject();
        petStorePetEndpoint.given(baseUrl)
                .body(petStoreOrder)
                .contentType(ContentType.JSON)
                .when()
                .post(Config.CREATE_ORDER)
                .then()
                .statusCode(200);
    }

    @Step
    public void deletePetOrder(String baseUrl) {
        petStorePetEndpoint.given(baseUrl)
                .baseUri(baseUrl)
                .when()
                .delete(String.format(Config.ORDER_BY_ID, petStoreTestData.getPetStoreOrder().getId()))
                .then()
                .statusCode(200);
    }

    @Step
    public void deletePet(String baseUrl) {
        petStorePetEndpoint.given(baseUrl)
                .baseUri(baseUrl)
                .when()
                .delete(String.format(Config.DELETE_PET, petStoreTestData.getPet().getId()))
                .then()
                .statusCode(200);
    }

    @Step
    public PetStoreOrder getTestPetOrder() {
        return petStoreTestData.getPetStoreOrder();
    }

}
