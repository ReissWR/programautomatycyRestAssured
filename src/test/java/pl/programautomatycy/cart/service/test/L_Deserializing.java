package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import pl.programautomatycy.cart.service.test.deserializing.AddItemResponse;

import java.util.Map;

class L_Deserializing {
    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemResponseDeserializing(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 140);
        bodyRequest.put("quantity", 1);
        bodyRequest.put("return_cart", false);

        String endpoint = "/cocart/v1/add-item";
        Response response = serviceHelper.sendPostRequestResponsive(bodyRequest.toString(), endpoint);

        AddItemResponse responseBody = response.as(AddItemResponse.class); // response into object
        System.out.println(responseBody.getKey());
        System.out.println(responseBody.getQuantity());

//        Map<String, String> total = (Map<String, String>) responseBody.getLine_tax_data().getTotal();
//        System.out.println(total.get("1").toString());

        System.out.println(responseBody.getLine_tax_data().getSubtotal().getSubtotal1());
        response.getBody().prettyPrint();
    }

}
