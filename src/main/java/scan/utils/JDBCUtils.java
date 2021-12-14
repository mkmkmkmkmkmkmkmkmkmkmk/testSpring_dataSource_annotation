package scan.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    /*
        1. 声明静态数据源成员变量
        2. 创建连接池对象
        3. 定义公有的得到数据源的方法
        4. 定义得到连接对象的方法
        5. 定义关闭资源的方法
     */
    private static DataSource ds;

    static {
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties pp = new Properties();
        try {
            pp.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ds = DruidDataSourceFactory.createDataSource(pp);
        } catch (Exception e) {
            System.out.println("创建datasource失败");
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    // 6.重载关闭方法
    public static void close(Connection conn, Statement stmt) {
        close(conn, stmt, null);
    }
}
