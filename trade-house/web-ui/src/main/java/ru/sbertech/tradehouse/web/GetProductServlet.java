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
@WebServlet(name="GetProductServlet", urlPatterns = "getProduct")
public class GetProductServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStr = req.getParameter("productId");
        if(idStr != null & !idStr.trim().isEmpty()) {
            Long id = Long.parseLong(idStr);
            ProductManager pm = new ProductManager();
            ProductDao dao = new ProductDaoImpl();
            pm.setDao(dao);
            Product p = pm.getProduct(id);
            req.setAttribute("product", p);
            System.out.println("Product:" + p.getProductId() + ":" + p.getProductName());
        }

        getServletContext().getRequestDispatcher("/editProduct.jsp").forward(req, resp);
    }
}
