package pl.programautomatycy.cart.service.test.deserializing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddItemResponse {

    @JsonProperty
    private String key;
    @JsonProperty
    private Integer product_id;
    @JsonProperty
    private Integer variation_id;
    @JsonProperty
    private Object variation;
    @JsonProperty
    private Integer quantity;
    @JsonProperty
    private String data_hash;
    @JsonProperty
    private LineTaxData line_tax_data;
    @JsonProperty
    private Double line_subtotal;
    @JsonProperty
    private Double line_subtotal_tax;
    @JsonProperty
    private Double line_total;
    @JsonProperty
    private Double line_tax;
    @JsonProperty
    private Object data;
    @JsonProperty
    private String product_name;
    @JsonProperty
    private String product_title;
    @JsonProperty
    private String product_price;

    public String getKey() {
        return key;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public Integer getVariation_id() {
        return variation_id;
    }

    public Object getVariation() {
        return variation;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getData_hash() {
        return data_hash;
    }

    public LineTaxData getLine_tax_data() {
        return line_tax_data;
    }

    public Double getLine_subtotal() {
        return line_subtotal;
    }

    public Double getLine_subtotal_tax() {
        return line_subtotal_tax;
    }

    public Double getLine_total() {
        return line_total;
    }

    public Double getLine_tax() {
        return line_tax;
    }

    public Object getData() {
        return data;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_title() {
        return product_title;
    }

    public String getProduct_price() {
        return product_price;
    }
}
