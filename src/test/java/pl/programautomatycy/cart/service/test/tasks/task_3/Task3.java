package pl.programautomatycy.cart.service.test.tasks.task_3;
/*
Kroki do wykonania:
Dodaj dowolny produkt do koszyka w ilości 10 (wykonaj ten krok w Intellij)
Wyślij parametry w body jako JSONObject skonwertowany do String
Pobierz wszystkie produkty z koszyka (wykonaj ten krok w Postmanie)
Skopiuj klucz nowo dodanego produktu
Zrób aktualizację ilości produktów (wykonaj ten krok w Intellij)
Metoda – POST
Endpoint – “/cocart/v1/item”
Nowa ilość produktów: 2
Użyj skopiowanego klucza
Wyślij parametry w body jako JSONObject skonwertowany do String
*/
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;

class Task3 {
    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyJSONObjectTask3() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 1690);
        bodyRequest.put("quantity", 10);
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint); // JSON to String
    }

    @Test
    public void actualizationItemWithBodyJSONObjectTask3() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("cart_item_key", "d43ab110ab2489d6b9b2caa394bf920f");
        bodyRequest.put("return_cart", true);
        bodyRequest.put("quantity", 2);

        String endpoint = "/cocart/v1/item";
        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
    }
}
