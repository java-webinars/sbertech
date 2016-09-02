package ru.sbertech.tradehouse.dao;

import ru.sbertech.tradehouse.domain.Product;
import ru.sbertech.tradehouse.exception.DaoException;

import java.util.List;

public interface ProductDao
{
    Long addProduct(Product product) throws DaoException;
    void updateProduct(Product product);
    Product getProduct(Long productId);
    void deleteProduct(Long productId);
    List<Product> findProduct();
}
