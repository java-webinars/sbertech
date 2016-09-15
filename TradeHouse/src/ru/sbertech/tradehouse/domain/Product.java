package ru.sbertech.tradehouse.domain;

/**
 * Created by anton on 8/29/16.
 */
public class Product implements Comparable<Product>
{
    private Long productId;
    private String productName;

    public Product() {
    }

    public Product(Long productId, String productName) {
        this.productId = productId;
        this.productName = productName;
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

    @Override
    public int compareTo(Product product) {
        return productName.compareTo(product.getProductName());
    }
}
