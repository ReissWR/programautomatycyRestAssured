package pl.programautomatycy.cart.service.test;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class D_POSTmethodJSONObject {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyJSONObject() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 140);
        bodyRequest.put("quantity", 15);
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint); // JSON to String
    }

    @Test
    public void calculateWithBodyJSONObject() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        String endpoint = "/cocart/v1/item";

        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
    }
}
