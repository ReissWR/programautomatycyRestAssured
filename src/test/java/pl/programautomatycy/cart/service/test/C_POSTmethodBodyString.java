package pl.programautomatycy.cart.service.test;

import org.junit.jupiter.api.Test;

class C_POSTmethodBodyString {
    private final ServiceHelper serviceHelper = new ServiceHelper();
    @Test
    public void addItemWithBodyString() {
        int productId = 142;
        int quantity = 5;
        boolean returnCart = true;
        // JSON
        String bodyRequest = "{\n" +
                "    \"product_id\": " + productId + ",\n" +
                "    \"quantity\": " + quantity + ",\n" +
                "    \"return_cart\": " + returnCart + "\n" +
                "}";

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(bodyRequest, endpoint);
    }

    @Test
    public void calculateWithBodyString() {
        boolean returnCart = true;

        //JSON
        String bodyRequest = "{\n" +
                "    \"return\": " + returnCart + "\n" +
                "}";

        String endpoint = "/cocart/v1/calculate";

        serviceHelper.sendPostRequest(bodyRequest, endpoint);

    }
}
