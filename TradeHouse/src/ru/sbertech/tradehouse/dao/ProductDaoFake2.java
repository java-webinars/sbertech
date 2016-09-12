package ru.sbertech.tradehouse.dao;

import ru.sbertech.tradehouse.domain.Product;
import ru.sbertech.tradehouse.exception.DaoException;

import java.util.*;

public class ProductDaoFake2 implements ProductDao
{
    private Map<Long, Product> productMap = new HashMap<>();

    @Override
    public Long addProduct(Product product) throws DaoException {
        if(product.getProductId() != null) {
            throw new DaoException("ProductId is not NULL", 9L);
        }
        Long pId = Math.round(Math.random() * 1000000);
        product.setProductId(pId);
        productMap.put(pId, product);
        return pId;
    }

    @Override
    public void updateProduct(Product product) throws DaoException {
        productMap.put(product.getProductId(), product);
    }

    @Override
    public Product getProduct(Long productId) throws DaoException {
        return productMap.get(productId);
    }

    @Override
    public void deleteProduct(Long productId) throws DaoException {
        productMap.remove(productId);
    }

    @Override
    public List<Product> findProduct() throws DaoException {
        List<Product> result = new ArrayList<>(productMap.values());

        Collections.sort(result, new ProductComparator());

        Collections.sort(result, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getProductName().compareTo(p2.getProductName());
            }
        });

        Collections.sort(result,
                (p1, p2) -> p1.getProductName().compareTo(p2.getProductName()));

        return result;
    }
}


class ProductComparator implements Comparator<Product>
{

    @Override
    public int compare(Product p1, Product p2) {
        return p1.getProductName().compareTo(p2.getProductName());
    }
}