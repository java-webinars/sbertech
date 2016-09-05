package ru.sbertech.tradehouse.dao;

import ru.sbertech.tradehouse.domain.Product;
import ru.sbertech.tradehouse.exception.DaoException;

import java.util.Date;
import java.util.List;

/**
 * Created by anton on 9/1/16.
 */
public class ProducDaoFake implements ProductDao
{
    @Override
    public Long addProduct(Product product) throws DaoException {
        System.out.println("Fake addProduct");
        if(product.getProductId() != null) {
            throw new DaoException("ProductId is not NULL", 9L);
        }
        return null;
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public Product getProduct(Long productId) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public List<Product> findProduct() {
        return null;
    }
}
