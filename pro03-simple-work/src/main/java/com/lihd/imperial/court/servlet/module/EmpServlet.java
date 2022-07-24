package com.lihd.imperial.court.servlet.module;

import com.lihd.imperial.court.entity.Emp;
import com.lihd.imperial.court.exception.LoginException;
import com.lihd.imperial.court.service.api.EmpService;
import com.lihd.imperial.court.service.impl.EmpServiceImpl;
import com.lihd.imperial.court.servlet.base.ModelBaseServlet;
import com.lihd.imperial.court.util.MD5Util;
import javafx.fxml.LoadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/7/23 16:53
 */
@WebServlet(urlPatterns = "/emp")
public class EmpServlet extends ModelBaseServlet {

    private EmpService empService = new EmpServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //加密操作
        password = MD5Util.encode(password);

        try {
            //这个地方可能会抛出异常
            Emp emp = empService.txEmpByLogin(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("emp", emp);
            //跳转到指定的页面 可是我现在不知道先到哪里
            request.getRequestDispatcher("/work?method=list").forward(request,response);
        } catch (Exception e) {
            if (e instanceof LoginException) {
                request.setAttribute("errMes","账号或者密码有误！");
//                request.getRequestDispatcher("/").forward(request,response);
                processTemplate("index",request,response);
            } else {
                throw new RuntimeException(e);
            }
        }
    }


    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //销毁session
        request.getSession().invalidate();
        processTemplate("index",request,response);
    }
}
