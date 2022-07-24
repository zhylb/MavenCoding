package com.lihd.imperial.court.servlet.module;

import com.lihd.imperial.court.entity.Memorials;
import com.lihd.imperial.court.service.api.MemorialsService;
import com.lihd.imperial.court.service.impl.MemorialsServiceImpl;
import com.lihd.imperial.court.servlet.base.ModelBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/7/23 20:06
 */
@WebServlet(urlPatterns = "/work")
public class MemorialsServlet extends ModelBaseServlet {
    private final MemorialsService memorialsService = new MemorialsServiceImpl();
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Memorials> memorials = memorialsService.txAllMemorials();
        request.setAttribute("memorials", memorials);
        processTemplate("list",request,response);
    }

    protected void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int idNum;
        try {
            idNum = Integer.parseInt(id);
        } catch (Exception e) {
            throw new RuntimeException("请不要攻击我！");
        }



        Memorials m = memorialsService.txMemorialsById(idNum);

        if (m.getMemorialsStatus() == 0) {
            memorialsService.txUpdateStatus(idNum);
        }

        request.setAttribute("m", m);
        processTemplate("info", request, response);
    }

    protected void reply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String reply = request.getParameter("reply");
        int idNum;
        try {
            idNum = Integer.parseInt(id);
        } catch (Exception e) {
            throw new RuntimeException("请不要攻击我！");
        }
        memorialsService.txToReply(idNum, reply);
        request.getRequestDispatcher("/work?method=list").forward(request, response);
    }


    protected void renew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        memorialsService.txUpdateRenew();
        request.getRequestDispatcher("/work?method=list").forward(request, response);
    }
}
