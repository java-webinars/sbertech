package ru.sbertech.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by anton on 10/20/16.
 */
public class FirstServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String data = new String("1234567890");

        req.setAttribute("MODEL", data);

        getServletContext()
                .getRequestDispatcher("/first.jsp").forward(req, resp);
    }
}
