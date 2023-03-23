package pl.programautomatycy.cart.service.test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.GetPropertyValues;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class ServiceHelper {

    GetPropertyValues getPropertyValues = new GetPropertyValues();
    private final String LOGIN = getPropertyValues.getPropValue("login");
    private final String PASSWORD = getPropertyValues.getPropValue("password");
    private final String BASE_URI = getPropertyValues.getPropValue("shopServerUrl");
    private final SampleRest SAMPLE_REST = new SampleRest();


    public void addItem(int productId, int quantity, boolean returnCart, String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .queryParam("product_id", productId)
                .queryParam("quantity", quantity)
                .queryParam("return_cart", returnCart)
                .baseUri(BASE_URI)
                .post(endpoint);
    }

    public void sendPostRequest(Map<String, Object> queryParamsBody, String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .queryParams(queryParamsBody)
                .baseUri(BASE_URI)
                .post(endpoint);

    }

    public void sendPostRequest(String body, String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .contentType(ContentType.JSON)
                //.contentType("application/json") // alternatively
                //.header("Content-Type", "application/json) // alternatively
                .body(body)
                .baseUri(BASE_URI)
                .post(endpoint);

    }

}

class SampleRest {
    public Response response;
}
