package endpoints;

import config.Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PetStorePetEndpoint {

    public Response getPetOrderByOrderId(long orderId, String baseUrl) {
        return given(baseUrl)
                .get(String.format(Config.ORDER_BY_ID, orderId));
    }

    public RequestSpecification given(String baseUrl) {
        return RestAssured.given()
                .log().uri()
                .log().body()
                .baseUri(baseUrl);
    }
}
