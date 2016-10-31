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
import java.util.List;

/**
 * Created by anton on 10/31/16.
 */
@WebServlet(name = "ProductListServlet",urlPatterns = "listProduct")
public class ProductListServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductManager pm = new ProductManager();
        ProductDao dao = new ProductDaoImpl();
        pm.setDao(dao);

        List<Product> product = pm.findProduct();
        req.setAttribute("products", product);

        getServletContext().getRequestDispatcher("/listProduct.jsp").forward(req, resp);
    }
}
