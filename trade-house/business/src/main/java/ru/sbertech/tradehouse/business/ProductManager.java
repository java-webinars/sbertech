package ru.sbertech.tradehouse.business;

import ru.sbertech.tradehouse.dao.ProductDao;
import ru.sbertech.tradehouse.domain.Product;
import ru.sbertech.tradehouse.exception.DaoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProductManager
{
    //Create Read Update Delete

    private ProductDao dao;

    public void setDao(ProductDao dao) {
        this.dao = dao;
    }

    public Long addProduct(Product product) {
        Long id = 0L;
        try {
            id = dao.addProduct(product);
        } catch (DaoException de) {
            de.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {

        }
        return id;
    }

    public void updateProduct(Product product) {
        try {
            dao.updateProduct(product);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public Product getProduct(Long productId) {
        try {
            return dao.getProduct(productId);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteProduct(Long productId) {
        try {
            dao.deleteProduct(productId);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public List<Product> findProduct() {
        try {
            return dao.findProduct();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
 }
