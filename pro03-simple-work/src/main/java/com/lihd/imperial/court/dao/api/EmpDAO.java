package com.lihd.imperial.court.dao.api;

import com.lihd.imperial.court.entity.Emp;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/7/23 10:04
 */
public interface EmpDAO {


    Emp selectEmpByLogin(String username, String password);

}
