package com.lihd.imperial.court.filter;

import com.lihd.imperial.court.util.JDBCUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/7/23 13:03
 */
@WebFilter(urlPatterns = "/*")
public class TransactionFilter implements Filter {

    private static Set<String> set = new HashSet<>();

    static {
        set.add(".png");
        set.add(".jpg");
        set.add(".css");
        set.add(".js");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //排除对静态资源的事务


        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String uri = httpServletRequest.getRequestURI();
        if (uri.contains(".")) {
            String end = uri.substring(uri.lastIndexOf("."));
            if (set.contains(end)) {
                System.out.println(end);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            filterChain.doFilter(servletRequest, servletResponse);
            conn.commit();
        } catch (Exception e) {

            servletRequest.setAttribute("allErr",e.getMessage());
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {

            }
        }finally {
            JDBCUtils.closeConnection(conn);
        }
    }

    @Override
    public void destroy() {

    }
}
