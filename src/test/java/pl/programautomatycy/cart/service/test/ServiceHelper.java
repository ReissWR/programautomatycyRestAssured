package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import utils.GetPropertyValues;

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
}

class SampleRest {
    public Response response;
}
