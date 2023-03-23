package pl.programautomatycy.cart.service.test.tasks.task_2;

/* Kroki do wykonania:
Dodaj dowolny produkt do koszyka w ilości 5 (wykonaj ten krok w Intellij)
Wyślij parametry w body jako String
Pobierz wszystkie produkty z koszyka (wykonaj ten krok w Postmanie)
Skopiuj klucz nowo dodanego produktu
Zrób aktualizację ilości produktów (wykonaj ten krok w Intellij)
Metoda – POST
Endpoint – “/cocart/v1/item”
Nowa ilość produktów – 15
Użyj skopiowanego klucza
Wyślij parametry w body jako String */

import org.junit.jupiter.api.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;

class Task2 {
    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyStringTask2() {
        int productId = 138;
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
    public void actualizationItemAmountTask2() {
        String cart_item_key = "013d407166ec4fa56eb1e1f8cbe183b9";
        int quantity = 15;
        boolean returnCart = true;

        //JSON
        String bodyRequest = "{\n" +
                "    \"cart_item_key\": \"" + cart_item_key + "\",\n" +
                "    \"quantity\": " + quantity + ",\n" +
                "    \"return_cart\": " + returnCart + "\n" +
                "}";
        String endpoint = "/cocart/v1/item";

        serviceHelper.sendPostRequest(bodyRequest, endpoint);
    }

}
