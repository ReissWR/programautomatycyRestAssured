package pl.programautomatycy.cart.service.test.deserializing.task9;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartContentsTaxes {

    @JsonProperty("1")
    private Double CartContentsTaxes1;

    public Double getCartContentsTaxes1() {
        return CartContentsTaxes1;
    }
}

