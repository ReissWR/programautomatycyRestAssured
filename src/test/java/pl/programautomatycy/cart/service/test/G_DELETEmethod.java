package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

class G_DELETEmethod {
    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void removeItemFromCart() {
        String key = "a8baa56554f96369ab93e4f3bb068c22";
        boolean returnCart = true;

        String endpoint = "/cocart/v1/item";
        String params = "?cart_item_key=" + key + "&return_cart=" + returnCart;

        Response response = serviceHelper.sendDeleteRequest(endpoint + params);

        response.getBody().prettyPrint();
    }

    @Test
    public void removeItemWithBody() {
        String bodyRequest = "{\n" +
                "    \"cart_item_key\": a8baa56554f96369ab93e4f3bb068c22,\n" +
                "    \"return_cart\":  true\n" +
                "}";
        String endpoint = "/cocart/v1/item";

        Response response = serviceHelper.sendDeleteRequest(bodyRequest, endpoint);
        response.getBody().prettyPrint();
    }
}
