package cn.itcast.servlet.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static String username;
    private static String password;
    private static Properties properties;
    private static DataSource ds;
    static {
        try {
            properties = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            String driverClassName = properties.getProperty("driverClassName");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            ds = DruidDataSourceFactory.createDataSource(properties);
            Class.forName(driverClassName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() throws Exception {
        return ds.getConnection(username,password);
    }

    /**
     * 释放资源
     * @param connection
     * @param statement
     */
    public static void close(Connection connection, Statement statement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet, Connection connection, Statement statement) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
