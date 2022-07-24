package com.lihd.imperial.court.service.impl;

import com.google.protobuf.Service;
import com.lihd.imperial.court.dao.api.EmpDAO;
import com.lihd.imperial.court.dao.impl.EmpDAOImpl;
import com.lihd.imperial.court.entity.Emp;
import com.lihd.imperial.court.exception.LoginException;
import com.lihd.imperial.court.service.api.EmpService;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/7/23 16:50
 */
public class EmpServiceImpl implements EmpService {

    private EmpDAO empDAO = new EmpDAOImpl();

    @Override
    public Emp txEmpByLogin(String username, String password) {
        Emp emp = empDAO.selectEmpByLogin(username, password);
        if (emp == null) {
            throw new LoginException("登录信息有误");
        }
        return emp;
    }
}
