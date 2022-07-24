package com.lihd.imperial.court.dao.impl;

import com.lihd.imperial.court.dao.BaseDAO;
import com.lihd.imperial.court.dao.api.MemorialsDAO;
import com.lihd.imperial.court.entity.Memorials;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/7/23 10:05
 */
public class MemorialsDAOImpl extends BaseDAO<Memorials> implements MemorialsDAO {
    @Override
    public List<Memorials> selectAllMemorials() {
        String sql = " SELECT `memorials_id` memorialsId,\n" +
                " `memorials_title` memorialsTitle,\n" +
                " `memorials_content` memorialsContent,\n" +
                " `emp_name` memorialsEmpName,\n" +
                " `memorials_create_time` memorialsCreateTime,\n" +
                " `memorials_status` memorialsStatus\n" +
                " FROM t_memorials LEFT OUTER JOIN t_emp ON t_emp.`emp_id` = t_memorials.`memorials_emp`;";
       return super.getBeanList(sql, Memorials.class);
    }

    @Override
    public Memorials selectMemorialsById(int id) {
        String sql = " SELECT `memorials_id` memorialsId,\n" +
                " `memorials_title` memorialsTitle,\n" +
                " `memorials_content` memorialsContent,\n" +
                " `emp_name` memorialsEmpName,\n" +
                " `memorials_create_time` memorialsCreateTime,\n" +
                " `memorials_status` memorialsStatus,\n" +
                " `feedback_time` feedbackTime,\n" +
                " `feedback_content` feedbackContent\n" +
                " FROM t_memorials LEFT OUTER JOIN t_emp ON t_emp.`emp_id` = t_memorials.`memorials_emp`" +
                "where memorials_id = ?";
        return getBean(sql,Memorials.class,id);
    }

    @Override
    public void updateToReply(int id , String reply) {
        String curTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String sql = "update t_memorials set memorials_status = ? , feedback_time = ?, " +
                "feedback_content = ? where memorials_id = ?";
        super.update(sql, 2, curTime, reply, id);

    }

    @Override
    public void updateStatus(int id) {
        String sql = "update t_memorials set memorials_status = ? where memorials_id = ?";
        super.update(sql, 1, id);
    }

    @Override
    public void updateRenew() {
        String sql = " UPDATE t_memorials SET `feedback_time` = NULL, `feedback_content` = NULL,`memorials_status` = 0";
        super.update(sql);
    }
}
