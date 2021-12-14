package scan.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Author：Weiyu
 * @Version:
 * @Since:
 * @date：2021-12-14_周二 22:00
 **/

//<context:property-placeholder location="classpath:jdbc.properties" />
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {
    //spring会从容器中将值jdbc.driverClassName赋给变量driver
    @Value("${jdbc.driverClassName}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private  String password;

    //@Bean("comboPooledDataSource")//Spring会将当前方法的返回值以指定名称存储到Spring容器中,并为返回值取名字为@Bean()的默认参数
    //public DataSource getC3p0DataSource() throws PropertyVetoException {
    //    //1.创建数据源对象
    //    ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
    //    //2..设置数据源的基本连接数据
    //    comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
    //    comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8&useUnicode=yes");
    //    comboPooledDataSource.setUser("root");
    //    comboPooledDataSource.setPassword("123456");
    //    return comboPooledDataSource;
    //}
    @Bean("druidDataSource")
    public DataSource getDruidDataSource() throws PropertyVetoException {
        //1.创建数据源对象
        DruidDataSource druidDataSource=new DruidDataSource();
        //2..设置数据源的基本连接数据
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }
}
