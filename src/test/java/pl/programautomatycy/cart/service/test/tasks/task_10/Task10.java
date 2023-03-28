package pl.programautomatycy.cart.service.test.tasks.task_10;
/*
Dodaj dowolny produkt do koszyka w ilości 10
Wykorzystaj Serializację do wysłania Requestu
Ustaw parametr “return_cart” na false
Odczytaj wartość z klucza “key” z Response i przypisz do zmiennej o nazwie key
Odczytaj wartość z klucza “product_name” i przypisz do zmiennej o nazwie productName
Zrób aktualizację ilości produktów za pomocą Serializacji
Metoda – POST
Endpoint – “/cocart/v1/item”
Nowa ilość produktów: 2
Użyj zmiennej key dla parametru “cart_item_key”
Parametr “return_cart” ustaw na false
Zrób asercje dla poniższych wartości z Response:
Wartość oczekiwana dla “messsage” ma być równa: “The quantity for \”<Tu wstaw nazwę produktu jako zmienną>\” has decreased to \”2\”.”
Wartość oczekiwana dla “quantity” ma być równa: 2
Zrób ponowną aktualizację ilości produktów za pomocą Serializacji z tymi samymi ustawieniami co w kroku 2
Nowa ilość produktów: 7
Zrób asercje dla poniższych wartości z Response:
Wartość oczekiwana dla “messsage” ma być równa: “The quantity for \”<Tu wstaw nazwę produktu jako zmienną>\” has increased to \”7\”.”
Wartość oczekiwana dla “quantity” ma być równa: 7
 */

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;
import pl.programautomatycy.cart.service.test.serialising.ActualizationItemRequestPOJO;
import pl.programautomatycy.cart.service.test.serialising.AddItemToCartRequestPOJO;

public class Task10 {

    private final ServiceHelper serviceHelper = new ServiceHelper();
    private Response response;
    private Response responseUpdate;
    private String key;
    private String productName;

    private void addItemTask10(int quantity) {
        int productId = 1696;
        boolean returnCart = false;

        AddItemToCartRequestPOJO bodyRequest = new AddItemToCartRequestPOJO(productId, quantity, returnCart);
        String endpoint = "/cocart/v1/add-item";

        response = serviceHelper.sendPostRequestResponsive(bodyRequest, endpoint);
    }
    private void actualizationItemTask10(int quantity) {
        key = response.getBody().jsonPath().getString("key");
        productName = response.getBody().jsonPath().getString("product_name");
        String endpointUpdate = "/cocart/v1/item";
        ActualizationItemRequestPOJO bodyRequest = new ActualizationItemRequestPOJO(key, false, quantity);
        responseUpdate = serviceHelper.sendPostRequestResponsive(bodyRequest, endpointUpdate);
    }

    @Test
    public void assertionsTask10() {
        addItemTask10(10);
        actualizationItemTask10(2);
        int quantity = 2;
        Assertions.assertEquals("The quantity for \"" + productName + "\" has decreased to \"" + quantity + "\".",
                responseUpdate.getBody().jsonPath().getString("message"));
        actualizationItemTask10(7);
        quantity = 7;
        Assertions.assertEquals("The quantity for \"" + productName + "\" has increased to \"" + quantity + "\".",
                responseUpdate.getBody().jsonPath().getString("message"));
    }

}
