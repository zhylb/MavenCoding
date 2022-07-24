package com.lihd.imperial.court.service.api;

import com.lihd.imperial.court.entity.Emp;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/7/23 16:50
 */
public interface EmpService {

    Emp txEmpByLogin(String username, String password);
}
