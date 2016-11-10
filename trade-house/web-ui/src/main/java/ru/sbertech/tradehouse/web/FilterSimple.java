package ru.sbertech.tradehouse.web;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by anton on 11/10/16.
 */
public class FilterSimple implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
