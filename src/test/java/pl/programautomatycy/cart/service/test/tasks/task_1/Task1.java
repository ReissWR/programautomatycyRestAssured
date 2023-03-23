package pl.programautomatycy.cart.service.test.tasks.task_1;

/* Kroki do wykonania:
        Dodaj jeden dowolny produkt do koszyka (wykonaj ten krok w Intellij)
        Wyślij parametry w .queryParams jako mapa
        Pobierz wszystkie produkty z koszyka (wykonaj ten krok w Postmanie)
        Skopiuj klucz nowo dodanego produktu
        Zrób aktualizację ilości produktów (wykonaj ten krok w Intellij)
        Metoda – POST
        Endpoint – “/cocart/v1/item”
        Nowa ilość produktów – 10
        Użyj skopiowanego klucza
        Wyślij parametry w .queryParams jako mapa */

import org.junit.jupiter.api.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;
import java.util.HashMap;
import java.util.Map;


class Task1 {

    private final ServiceHelper serviceHelper = new ServiceHelper();
    @Test
    public void task1AddingItem() {
        int productId = 142;
        int quantity = 1;
        boolean returnCart = true;

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.addItem(productId, quantity, returnCart, endpoint);
    }
    @Test
    public void task1ActualizationWithBodyMap() {
        Map<String, Object> queryParamsBody = new HashMap<>();
        queryParamsBody.put("cart_item_key", "a8baa56554f96369ab93e4f3bb068c22");
        queryParamsBody.put("quantity", 10);
        queryParamsBody.put("return_cart", true);

        String endpoint = "/cocart/v1/item";

        serviceHelper.sendPostRequest(queryParamsBody, endpoint);
    }
}
