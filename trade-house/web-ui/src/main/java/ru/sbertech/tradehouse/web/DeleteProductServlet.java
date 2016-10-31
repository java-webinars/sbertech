package ru.sbertech.tradehouse.web;

import ru.sbertech.tradehouse.business.ProductManager;
import ru.sbertech.tradehouse.dao.ProductDao;
import ru.sbertech.tradehouse.dao.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by anton on 10/31/16.
 */
@WebServlet(name="DeleteProductServlet", urlPatterns = "deleteProduct")
public class DeleteProductServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductManager pm = new ProductManager();
        ProductDao dao = new ProductDaoImpl();
        pm.setDao(dao);

        String idStr = req.getParameter("productId");
        if(idStr != null & !idStr.trim().isEmpty()) {
            Long id = Long.parseLong(idStr);
            pm.deleteProduct(id);
        }

        resp.sendRedirect(req.getContextPath() + "/listProduct");
    }
}
