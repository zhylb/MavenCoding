package com.lihd.imperial.court.dao;

import com.lihd.imperial.court.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/7/22 23:11
 */
public class BaseDAO<T> {

    QueryRunner queryRunner = new QueryRunner();

    public T getBean(String sql,Class<T> clazz, Object ... args) {
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<>(clazz), args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<T> getBeanList(String sql,Class<T> clazz, Object ... args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<>(clazz), args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int update(String sql, Object... args) {
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.update(connection,sql, args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
