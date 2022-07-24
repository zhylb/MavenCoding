package com.lihd.imperial.court.filter;

import com.lihd.imperial.court.util.ImperialCourtConst;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/7/23 23:09
 */
@WebFilter(urlPatterns = "/work")
public class LoginFilter implements Filter {




    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object emp = session.getAttribute("emp");
        if (emp != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            httpServletRequest.setAttribute("errMes", ImperialCourtConst.ACCESS_DENIED_MESSAGE);
            httpServletRequest.getRequestDispatcher("/").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
