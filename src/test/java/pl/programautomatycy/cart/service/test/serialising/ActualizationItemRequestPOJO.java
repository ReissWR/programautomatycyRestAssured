package pl.programautomatycy.cart.service.test.serialising;

import com.fasterxml.jackson.annotation.JsonProperty;

// TASK 8
public class ActualizationItemRequestPOJO {
    @JsonProperty
    private String cart_item_key;
    @JsonProperty
    private boolean return_cart;
    @JsonProperty
    private int quantity;

    public ActualizationItemRequestPOJO(String cart_item_key, boolean return_cart, int quantity) {
        this.cart_item_key = cart_item_key;
        this.return_cart = return_cart;
        this.quantity = quantity;
    }
}
