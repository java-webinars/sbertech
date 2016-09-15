package ru.sbertech.db;

/**
 * Created by anton on 9/15/16.
 */
public class Product
{
    private Long productId;
    private String porductName;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getPorductName() {
        return porductName;
    }

    public void setPorductName(String porductName) {
        this.porductName = porductName;
    }
}
