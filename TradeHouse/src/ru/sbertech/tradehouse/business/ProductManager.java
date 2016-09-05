package ru.sbertech.tradehouse.business;

import ru.sbertech.tradehouse.dao.ProductDao;
import ru.sbertech.tradehouse.domain.Product;
import ru.sbertech.tradehouse.exception.DaoException;

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
        dao.updateProduct(product);
    }

    public Product getProduct(Long productId) {
        return dao.getProduct(productId);
    }

    public void deleteProduct(Long productId) {
        dao.deleteProduct(productId);
    }

    public List<Product> findProduct() {
        return dao.findProduct();
    }
 }
