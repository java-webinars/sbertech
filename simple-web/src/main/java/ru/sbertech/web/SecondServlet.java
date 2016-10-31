package ru.sbertech.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by anton on 10/20/16.
 */
@WebServlet(name = "SecondServlet", urlPatterns = {"second", "second2"})
public class SecondServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.setAttribute("SESSION", "SESSION DATA");

        resp.setContentType("text/html");

        resp.getWriter().print("<strong>Second</strong>");
    }
}
