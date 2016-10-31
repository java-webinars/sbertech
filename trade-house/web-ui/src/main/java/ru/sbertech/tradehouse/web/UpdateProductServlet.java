package ru.sbertech.tradehouse.web;

import ru.sbertech.tradehouse.business.ProductManager;
import ru.sbertech.tradehouse.dao.ProductDao;
import ru.sbertech.tradehouse.dao.ProductDaoImpl;
import ru.sbertech.tradehouse.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by anton on 10/31/16.
 */
@WebServlet(name="UpdateProductServlet", urlPatterns = "updateProduct")
public class UpdateProductServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        ProductManager pm = new ProductManager();
        ProductDao dao = new ProductDaoImpl();
        pm.setDao(dao);

        String productName = req.getParameter("productName");
        if(productName != null && !productName.trim().isEmpty()) {
            Product p = new Product();
            p.setProductName(productName);

            String idStr = req.getParameter("productId");
            if(idStr != null & !idStr.trim().isEmpty()) {
                Long id = Long.parseLong(idStr);
                p.setProductId(id);
                pm.updateProduct(p);
            } else {
                pm.addProduct(p);
            }
        }

        resp.sendRedirect(req.getContextPath() + "/listProduct");
    }
}
