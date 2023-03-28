package pl.programautomatycy.cart.service.test;

import org.junit.jupiter.api.Test;
import pl.programautomatycy.cart.service.test.serialising.AddItemToCartRequestPOJO;

class K_Serializing {

    private final ServiceHelper serviceHelper = new ServiceHelper();
    @Test
    public void addItem() {
        int productId = 142;
        int quantity = 1;
        boolean returnCart = true;

        AddItemToCartRequestPOJO bodyRequest = new AddItemToCartRequestPOJO(productId, quantity, returnCart);
        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequestResponsive(bodyRequest, endpoint);
    }
}
