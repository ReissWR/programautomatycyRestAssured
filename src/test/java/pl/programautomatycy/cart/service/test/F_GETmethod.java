package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

class F_GETmethod {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void getCartContents() {
        String endpoint = "/cocart/v1/get-cart";
        Response response = serviceHelper.sendGetRequest(endpoint);

        response.getBody().prettyPrint();
    }

    @Test
    public void countItems() {
        String endpoint = "/cocart/v1/count-items";

        Response response = serviceHelper.sendGetRequest(endpoint);
        response.getBody().prettyPrint();
    }

    @Test
    public void restoreItemToCartWithParams() {
        String key = "5cf21ce30208cfffaa832c6e44bb567d";
        boolean returnCart = true;
        String endpoint = "/cocart/v1/item";

        String params = "?cart_item_key=" + key + "&return_cart=" + returnCart;

        Response response = serviceHelper.sendGetRequest(endpoint + params);
        response.getBody().prettyPrint();
    }

    @Test
    public void restoreItemToCartBody() {
        String bodyRequest = "{\n" +
                "    \"cart_item_key\": \"4921f95baf824205e1b13f22d60357a1\",\n" +
                "    \"return_cart\": \"true\"\n" +
                "}";
        String endpoint = "/cocart/v1/item";

        Response response = serviceHelper.sendGetRequest(bodyRequest, endpoint);
        response.getBody().prettyPrint();
    }
}
