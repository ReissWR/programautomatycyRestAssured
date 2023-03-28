package pl.programautomatycy.cart.service.test.tasks.task_9;
/*
Kroki do wykonania:
Wyślij Request metodą POST na endpoint “/cocart/v1/calculate” z parametrem “return” z wartością “true” dowolnym sposobem
Wykonaj deserializację Response
Wydrukuj wartości z poniższych kluczy wykorzystując deserializację:
“subtotal”
“subtotal_tax”
“cart_contents_taxes” -> wartość z klucza “1”
“total”
“total_tax”
*/


import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;
import pl.programautomatycy.cart.service.test.deserializing.task9.CalculateResponse;
import utils.JsonRequestBodyHelper;

public class Task9 {
    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void PostRequestCalculateTask9() {
        JSONObject bodyRequest = JsonRequestBodyHelper
                .getJsonFromFile("request-shop-calculate-task9", "calculate_task9");

        String endpoint = "/cocart/v1/calculate";

        Response response = serviceHelper.sendPostRequestResponsive(bodyRequest.toJSONString(), endpoint);

        CalculateResponse responseBody = response.as(CalculateResponse.class); // response into object

        System.out.println(responseBody.getSubtotal());
        System.out.println(responseBody.getSubtotal_tax());
        System.out.println(responseBody.getCart_contents_taxes().getCartContentsTaxes1());
        System.out.println(responseBody.getTotal());
        System.out.println(responseBody.getTotal_tax());
    }

}
