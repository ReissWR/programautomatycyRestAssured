package pl.programautomatycy.cart.service.test.tasks.task_8;
/*
Kroki do wykonania:
Dodaj dowolny produkt do koszyka w ilości 10
Wykorzystaj Serializację do wysłania Requestu
Ustaw parametr “return_cart” na false
Odczytaj wartość z klucza “key” z Response i przypisz do zmiennej o nazwie key
Zrób aktualizację ilości produktów za pomocą Serializacji
Metoda – POST
Endpoint – “/cocart/v1/item”
Nowa ilość produktów: 2
Użyj zmiennej key z kluczem dla parametru “cart_item_key”
Wskazówki:
1. Do Serializacji weź pod uwagę następujące parametry: cart_item_key, return_cart, quantity
2. Weź przykład z endpointu, który odpowiada za dodawanie produktów
 */

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;
import pl.programautomatycy.cart.service.test.serialising.ActualizationItemRequestPOJO;
import pl.programautomatycy.cart.service.test.serialising.AddItemToCartRequestPOJO;

class Task8 {
    private final ServiceHelper serviceHelper = new ServiceHelper();
    private Response response;


    private void addItemTask8() {
        int productId = 140;
        int quantity = 10;
        boolean returnCart = false;

        AddItemToCartRequestPOJO bodyRequest = new AddItemToCartRequestPOJO(productId, quantity, returnCart);
        String endpoint = "/cocart/v1/add-item";

        response = serviceHelper.sendPostRequestResponsive(bodyRequest, endpoint);
//        response.getBody().prettyPrint();
    }
    @Test
    public void actualizationItemTask8() {
        addItemTask8();
        int quantity = 2;
        boolean returnCart = false;

        JSONObject obj = new JSONObject(response.getBody().asString());
        String key = obj.getString("key");

        ActualizationItemRequestPOJO bodyRequest = new ActualizationItemRequestPOJO(key, returnCart, quantity);
        String endpoint = "/cocart/v1/item";

        serviceHelper.sendPostRequestResponsive(bodyRequest, endpoint);
    }
}
