package pl.programautomatycy.cart.service.test.deserializing.task9;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculateResponse {
    @JsonProperty
    private String subtotal;
    @JsonProperty
    private double subtotal_tax;
    @JsonProperty
    private String shipping_total;
    @JsonProperty
    private double shipping_tax;
    @JsonProperty
    private Object shipping_taxes;
    @JsonProperty
    private double discount_total;
    @JsonProperty
    private double discount_tax;
    @JsonProperty
    private String cart_contents_total;
    @JsonProperty
    private double cart_contents_tax;
    @JsonProperty
    private CartContentsTaxes cart_contents_taxes;
    @JsonProperty
    private String fee_total;
    @JsonProperty
    private double fee_tax;
    @JsonProperty
    private Object fee_taxes;
    @JsonProperty
    private String total;
    @JsonProperty
    private double total_tax;

    public String getSubtotal() {
        return subtotal;
    }

    public double getSubtotal_tax() {
        return subtotal_tax;
    }

    public String getShipping_total() {
        return shipping_total;
    }

    public double getShipping_tax() {
        return shipping_tax;
    }

    public Object getShipping_taxes() {
        return shipping_taxes;
    }

    public double getDiscount_total() {
        return discount_total;
    }

    public double getDiscount_tax() {
        return discount_tax;
    }

    public String getCart_contents_total() {
        return cart_contents_total;
    }

    public double getCart_contents_tax() {
        return cart_contents_tax;
    }

    public CartContentsTaxes getCart_contents_taxes() {
        return cart_contents_taxes;
    }

    public String getFee_total() {
        return fee_total;
    }

    public double getFee_tax() {
        return fee_tax;
    }

    public Object getFee_taxes() {
        return fee_taxes;
    }

    public String getTotal() {
        return total;
    }

    public double getTotal_tax() {
        return total_tax;
    }
}
