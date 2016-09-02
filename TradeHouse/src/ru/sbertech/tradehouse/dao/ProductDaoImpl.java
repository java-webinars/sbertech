package ru.sbertech.tradehouse.dao;

import ru.sbertech.tradehouse.domain.Product;
import ru.sbertech.tradehouse.exception.DaoException;

import java.util.List;

public class ProductDaoImpl implements ProductDao
{
    public Long addProduct(Product product) throws DaoException {
        System.out.println("Impl - метод addProduct");
        if(false) {
            DaoException e = new DaoException("Error", 199L);
            throw e;
        }
        return 99L;
    }

    public void updateProduct(Product product) {

    }

    public Product getProduct(Long productId) {
        return null;
    }

    public void deleteProduct(Long productId) {

    }

    public List<Product> findProduct() {
        return null;
    }

}
