package pl.programautomatycy.cart.service.test.tasks.task_7;

/*
 Kroki do wykonania:
Dodaj jeden dowolny produkt do koszyka
Wyślij Request metodą GET na endpoint “/cocart/v1/totals” z parametrem “html” z wartością “true”
Odczytaj i wydrukuj wartości poniższych kluczy z otrzymanego Response:
“subtotal” (za pomocą jsonPath)
“cart_contents_tax” (za pomocą jsonPath)
“cart_contents_taxes” -> wartość z klucza “1” (za pomocą JSONObject)
“total” (za pomocą JSONObject)
*/

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;

import java.util.HashMap;
import java.util.Map;

class Task7 {

    private final ServiceHelper serviceHelper = new ServiceHelper();
    private Response response;

    private void addItemTask7() {

        // adding item to cart
        Map<String, Object> queryParamsBody = new HashMap<>();
        queryParamsBody.put("product_id", 142);
        queryParamsBody.put("quantity", 1);
        queryParamsBody.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(queryParamsBody, endpoint);
    }
    private void getTotalsTask7() {

        String endpoint = "/cocart/v1/totals";
        boolean html = true;

        response = serviceHelper.sendGetRequest(endpoint + "?html=" + html);
    }

    @Test
    public void readValuesFromResponseTask7() { // with adding one item
        addItemTask7();
        getTotalsTask7();
        String subtotal = response.getBody().jsonPath().getString("subtotal");
        String cartContentsTax = response.getBody().jsonPath().getString("cart_contents_tax");

        JSONObject obj = new JSONObject(response.getBody().prettyPrint());
        Double cartContentsTaxesKey1 = obj.getJSONObject("cart_contents_taxes").getDouble("1");
        String total = obj.getString("total");

        System.out.println("Subtotal: " + subtotal + "\nCart Contents Tax: " + cartContentsTax +
                "\nCart Contents Taxes -> 1. " + cartContentsTaxesKey1 + "\nTotal: " + total);
    }

}
