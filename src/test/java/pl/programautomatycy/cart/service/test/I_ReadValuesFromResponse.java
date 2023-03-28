package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Map;

class I_ReadValuesFromResponse {
    private Response responseToRead;
    private final ServiceHelper serviceHelper = new ServiceHelper();

    private void calculateValuesJsonPath() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        String endpoint = "/cocart/v1/calculate";
        responseToRead = serviceHelper.sendPostRequestResponsive(bodyRequest.toString(), endpoint);
        responseToRead.getBody().prettyPrint();
        System.out.println("---------------------------------------------------------------------" +
                "\n READ FROM VALUES:" +
                "\n---------------------------------------------------------------------");
    }

    @Test
    public void readCalculateValuesJsonPath() {
        calculateValuesJsonPath();

        String subtotal = responseToRead.getBody().jsonPath().getString("subtotal");
        Double subtotalTax = responseToRead.getBody().jsonPath().getDouble("subtotal_tax");

        // Two ways to get same object using Map
        Object cartContentsTaxes_1 = responseToRead.getBody().jsonPath().getMap("cart_contents_taxes").get("1");
        Map<String, Double> cartContentsTaxesMap = responseToRead.getBody().jsonPath()
                .getMap("cart_contents_taxes");
    }
    @Test
    public void addItemAndReadValuesJsonObject() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 142);
        bodyRequest.put("quantity", 1);
        bodyRequest.put("return_cart", false);

        String endpoint = "/cocart/v1/add-item";

        responseToRead = serviceHelper.sendPostRequestResponsive(bodyRequest.toString(), endpoint);// JSON to String

        String jsonString = responseToRead.getBody().prettyPrint();
        JSONObject obj = new JSONObject(jsonString);

        String key = obj.getString("key");
        int productId = obj.getInt("product_id");
        String productName = obj.getString("product_name");

        Double total = obj.getJSONObject("line_tax_data").getJSONObject("total").getDouble("1");

        System.out.println(key + "\n" + productId + " " + productName + "\n" + total);
    }

    @Test
    public void readValuesAddItemJsonObjectByKey() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 1696);
        bodyRequest.put("quantity", 1);
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";

        responseToRead = serviceHelper.sendPostRequestResponsive(bodyRequest.toString(), endpoint);// JSON to String

        String jsonString = responseToRead.getBody().prettyPrint();
        JSONObject obj = new JSONObject(jsonString);

        int productId = obj.getJSONObject("5cf21ce30208cfffaa832c6e44bb567d")
                .getInt("product_id");
        String productPrice = obj.getJSONObject("5cf21ce30208cfffaa832c6e44bb567d")
                .getString("product_price");
        System.out.println("---------------------------------------------------------------------" +
                "\n READ FROM VALUES:" +
                "\n---------------------------------------------------------------------");
        System.out.println("Product_ID: " + productId + "\nProduct_price: " + productPrice);

    }

    @Test
    public void getCartContentsMap() {
        String endpoint = "/cocart/v1/get-cart";

        Response responseToRead = serviceHelper.sendGetRequest(endpoint);
//        responseToRead.getBody().prettyPrint(); // print whole cart

        Map<String, Object> products = responseToRead.getBody().jsonPath().get(); // without key to get all products

        for (Map.Entry<String, Object> product : products.entrySet()) {
            product.getKey();
            Map<String, Object> values = (Map<String, Object>) product.getValue(); // cast to Map
            System.out.println(values.get("product_name") + " - product ID: " + values.get("product_id") );

            Map<String, Object> lineTaxData = (Map<String, Object>) values.get("line_tax_data"); // cast to Map
            Map<String, Double> total = (Map<String, Double>) lineTaxData.get("total");
            System.out.println(total.get("1"));
        }
    }
}
