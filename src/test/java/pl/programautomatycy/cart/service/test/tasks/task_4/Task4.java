package pl.programautomatycy.cart.service.test.tasks.task_4;
/* Kroki do wykonania:
        Dodaj dowolny produkt do koszyka w ilości 10 (wykonaj ten krok w Intellij)
        Wyślij parametry w body z pliku, skonwertowane do JSONString
        Pobierz wszystkie produkty z koszyka (wykonaj ten krok w Postmanie)
        Skopiuj klucz nowo dodanego produktu
        Zrób aktualizację ilości produktów (wykonaj ten krok w Intellij)
        Metoda – POST
        Endpoint – “/cocart/v1/item”
        Nowa ilość produktów – 2
        Użyj skopiowanego klucza
        Wyślij parametry w body z pliku, skonwertowane do JSONString
        Utwórz nowy plik w folderze testData
        Umieść Body w pliku (pamiętaj o dodaniu klucza w strukturze) */

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;
import utils.JsonRequestBodyHelper;

class Task4 {
    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyFromFileTask4() {
        JSONObject bodyRequest = JsonRequestBodyHelper
                .getJsonFromFile("request-shop-add-item-to-cart", "add_item_body_task4");

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(bodyRequest.toJSONString(), endpoint);
    }

    @Test
    public void actualizationItemAmountWithBodyFromFileTask4() {
        JSONObject bodyRequest = JsonRequestBodyHelper
                .getJsonFromFile("request-shop-actualization-item-amount", "actualization-item-amount-task4");

        String endpoint = "/cocart/v1/item";

        serviceHelper.sendPostRequest(bodyRequest.toJSONString(), endpoint);
    }

}
