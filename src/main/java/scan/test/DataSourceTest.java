package scan.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource; //1.导入数据源的坐标和数据库驱动坐标
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @Author：Weiyu
 * @Version:
 * @Since:  数据源的开发步骤
 * @date：2021-12-14_周二 18:21
 **/
public class DataSourceTest {
    @Test
    public void testSpringGenerateDataSource() throws SQLException {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
       //因为applicationContext.xml中,dataSource就只有一个所以可以使用.class
        DataSource dataSource = app.getBean(DataSource.class);
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }
    @Test
    public void testC3p0() throws PropertyVetoException, SQLException {
        //2.创建数据源对象
        ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
        //3.设置数据源的基本连接数据
        comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8&useUnicode=yes");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("123456");
        //4.使用数据源获取连接资源
        final Connection connection = comboPooledDataSource.getConnection();
        //5.归还连接资源
        connection.close();

    }
    @Test
    public void testDruid() throws PropertyVetoException, SQLException {
        //2.创建数据源对象
        DruidDataSource dataSource=new DruidDataSource();
        //3.设置数据源的基本连接数据
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8&useUnicode=yes");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        //4.使用数据源获取连接资源
        final Connection connection = dataSource.getConnection();
        //System.out.println(connection);
        //5.归还连接资源
        connection.close();
    }

    /**
     * 测试手动创建Druid的数据源（加载jdbc。properties配置文件）
     * @throws PropertyVetoException
     * @throws SQLException
     */
    @Test
    public void testAutonDruid() throws PropertyVetoException, SQLException {
       //1.读取配置文件getBundle("")路径为相对resource项目的路径，专门对properties进行读取
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("jdbc.driverClassName");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");
        String url = rb.getString("jdbc.url");
        String initialSize = rb.getString("jdbc.initialSize");
        String maxActive = rb.getString("jdbc.maxActive");
        String maxWait = rb.getString("jdbc.maxWait");

        //2.创建数据源对象
        DruidDataSource dataSource=new DruidDataSource();
        //3.设置数据源的基本连接数据
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(Integer.parseInt(initialSize));
        dataSource.setMaxActive(Integer.parseInt(maxActive));
        dataSource.setMaxWait(Integer.parseInt(maxWait));
        //4.使用数据源获取连接资源
        final Connection connection = dataSource.getConnection();
        //System.out.println(connection);
        //5.归还连接资源
        connection.close();


    }
}
