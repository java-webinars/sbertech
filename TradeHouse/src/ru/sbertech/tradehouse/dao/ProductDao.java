package ru.sbertech.tradehouse.dao;

import ru.sbertech.tradehouse.domain.Product;
import ru.sbertech.tradehouse.exception.DaoException;

import java.util.List;

public interface ProductDao
{
    Long addProduct(Product product) throws DaoException;
    void updateProduct(Product product) throws DaoException;
    Product getProduct(Long productId) throws DaoException;
    void deleteProduct(Long productId) throws DaoException;
    List<Product> findProduct() throws DaoException;
}
