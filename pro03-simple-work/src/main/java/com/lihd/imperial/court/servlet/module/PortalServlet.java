package com.lihd.imperial.court.servlet.module;

import com.lihd.imperial.court.servlet.base.ModelBaseServlet;
import com.lihd.imperial.court.servlet.base.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/7/23 15:45
 */
@WebServlet(urlPatterns = "/")
public class PortalServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.processTemplate("index",req,resp);
    }
}
