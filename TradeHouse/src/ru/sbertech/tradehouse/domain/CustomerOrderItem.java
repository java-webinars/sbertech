package ru.sbertech.tradehouse.domain;

public class CustomerOrderItem
{
    private Long customerOrderItemId;
    private CustomerOrder customerOrder;
    private Product product;
    private Integer quantity;
    private Double price;

    public Long getCustomerOrderItemId() {
        return customerOrderItemId;
    }

    public void setCustomerOrderItemId(Long customerOrderItemId) {
        this.customerOrderItemId = customerOrderItemId;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
