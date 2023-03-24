package pl.programautomatycy.cart.service.test.tasks.task_6;
/* Kroki do wykonania:
        Dodaj dowolny produkt do koszyka w ilości 10 (wykonaj ten krok w Intellij)
        Wyślij parametry w body jako JSONObject skonwertowany do String
        Pobierz wszystkie produkty z koszyka (wykonaj ten krok w Intellij)
        Wydrukuj Response za pomocą metody preetyPrint()
        Skopiuj klucz nowo dodanego produktu
        Usuń nowo dodany produkt (wykonaj ten krok w Intellij)
        Metoda – DETELE
        Endpoint – “/cocart/v1/item”
        Użyj skopiowanego klucza
        Wyślij parametry w body jako JSONObject skonwertowany do String
        Sprawdź na stronie sklepu, czy produkt został usunięty
        Wskazówka: Do wysłania Requestu z metodą DELETE weź przykład z klasy D_POSTmethodBodyJSONObject */

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;

class Task6 {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    // Step 1
    @Test
    public void addItemWithJsonTask6() {

    JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 1692);
        bodyRequest.put("quantity", 10);
        bodyRequest.put("return_cart", true);

    String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequestResponsive(bodyRequest.toString(), endpoint);// JSON to String
        response.getBody().prettyPrint();
}
    // Step 2
    @Test
    public void removeItemWithJsonTask6() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("cart_item_key", "4921f95baf824205e1b13f22d60357a1");
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/item";

        serviceHelper.sendDeleteRequest(bodyRequest.toString(), endpoint);
    }
}
