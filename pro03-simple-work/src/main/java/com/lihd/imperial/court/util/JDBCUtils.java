package com.lihd.imperial.court.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/7/22 21:43
 */
public class JDBCUtils {

    private static DataSource dataSource;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        try{
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            //将编译时异常转换为运行时异常，不要隐藏异常。
            throw new RuntimeException(e);
        }
    }


    public static Connection getConnection() {
        Connection conn = threadLocal.get();
        if (conn == null) {
            try{
                conn = dataSource.getConnection();
                threadLocal.set(conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            threadLocal.remove();
        }
    }

}
