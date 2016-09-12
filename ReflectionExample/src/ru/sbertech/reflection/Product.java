package ru.sbertech.reflection;

/**
 * Created by anton on 9/12/16.
 */
public class Product
{
    static {
        System.out.println("Static");
    }

    private Long productId;
    private String productName;

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
}
