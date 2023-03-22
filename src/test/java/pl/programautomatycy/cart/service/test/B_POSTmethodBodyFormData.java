package pl.programautomatycy.cart.service.test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class B_POSTmethodBodyFormData {
    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyFormData() {
        int productId = 142;
        int quantity = 10;
        boolean returnCart = true;

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.addItem(productId, quantity, returnCart, endpoint);
    }

    @Test
    public void addItemWithBodyMap() {
        Map<String, Object> queryParamsBody = new HashMap<>();
        queryParamsBody.put("product_id", 142);
        queryParamsBody.put("quantity", 5);
        queryParamsBody.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(queryParamsBody, endpoint);
    }

    @Test
    public void calculateWithBodyMap() {
        Map<String, Object> queryParamsBody = new HashMap<>();
        queryParamsBody.put("return", true);

        String endpoint = "/cocart/v1/calculate";

        serviceHelper.sendPostRequest(queryParamsBody, endpoint);
    }
}