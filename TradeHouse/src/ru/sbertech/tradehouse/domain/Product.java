package ru.sbertech.tradehouse.domain;

/**
 * Created by anton on 8/29/16.
 */
public class Product extends Object
{
    private Long productId;
    private String productName;

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String toString() {
        return productId + ":" + productName;
    }
}
