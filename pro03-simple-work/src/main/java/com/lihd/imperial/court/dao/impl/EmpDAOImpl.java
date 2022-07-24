package com.lihd.imperial.court.dao.impl;

import com.lihd.imperial.court.dao.BaseDAO;
import com.lihd.imperial.court.dao.api.EmpDAO;
import com.lihd.imperial.court.entity.Emp;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/7/23 10:05
 */
public class EmpDAOImpl extends BaseDAO<Emp> implements EmpDAO {


    @Override
    public Emp selectEmpByLogin(String username, String password) {
        String sql = "select emp_id empId," +
                " emp_name empName," +
                " emp_position empPosition," +
                "login_account loginAccount," +
                "login_password loginPassword " +
                "from t_emp " +
                "where login_account = ? and login_password = ?";
        return super.getBean(sql,Emp.class,username, password);
    }
}
