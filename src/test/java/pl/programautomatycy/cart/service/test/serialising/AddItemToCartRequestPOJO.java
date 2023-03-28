package pl.programautomatycy.cart.service.test.serialising;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddItemToCartRequestPOJO { // Plain Old Java Object

    @JsonProperty
    private int product_id;
    @JsonProperty
    private int quantity;
    @JsonProperty
    private boolean return_cart;

    public AddItemToCartRequestPOJO(int productId, int quantity, boolean returnCart) {
        this.product_id = productId;
        this.quantity = quantity;
        this.return_cart = returnCart;
    }

}
