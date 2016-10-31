package ru.sbertech.tradehouse.dao;

import ru.sbertech.tradehouse.domain.Product;
import ru.sbertech.tradehouse.exception.DaoException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by anton on 9/1/16.
 */
public class ProducDaoFake implements ProductDao
{
    private List<Product> productList = new ArrayList<>();

    @Override
    public Long addProduct(Product product) throws DaoException {
        System.out.println("Fake addProduct");
        if(product.getProductId() != null) {
            throw new DaoException("ProductId is not NULL", 9L);
        }
        Long pId = Math.round(Math.random() * 1000000);
        product.setProductId(pId);
        productList.add(product);
        return pId;
    }

    @Override
    public void updateProduct(Product product) throws DaoException {
        for(Product p : productList) {
            if(p.getProductId().equals(product.getProductId())) {
                p.setProductName(product.getProductName());
                break;
            }
        }
    }

    @Override
    public Product getProduct(Long productId) throws DaoException {
        for(Product p : productList) {
            if(p.getProductId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void deleteProduct(Long productId) throws DaoException {
        for (Iterator<Product> it = productList.iterator(); it.hasNext(); ) {
            Product tmp = it.next();
            if(tmp.getProductId().equals(productId)) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public List<Product> findProduct() throws DaoException {
        return productList;
    }
}
