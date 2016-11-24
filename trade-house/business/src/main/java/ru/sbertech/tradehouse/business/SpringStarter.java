package ru.sbertech.tradehouse.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sbertech.tradehouse.domain.Product;

import java.util.List;

/**
 * Created by anton on 11/17/16.
 */
public class SpringStarter
{
    private static Logger log = LoggerFactory.getLogger(SpringStarter.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"trade-house.xml"});

        ProductManager pm = context.getBean(ProductManager.class);

        Product p = new Product();
        p.setProductName("SpringContext Product");
        pm.addProduct(p);

        List<Product> products = pm.findProduct();

        log.error("", new RuntimeException());
        if(log.isDebugEnabled()) {
            for (Product pr : products) {
                log.trace("Product: {}, {}", pr.getProductId(), pr.getProductName());
//            System.out.println("Product:" + pr.getProductId() + ":" + pr.getProductName());
            }
        }
    }
}
