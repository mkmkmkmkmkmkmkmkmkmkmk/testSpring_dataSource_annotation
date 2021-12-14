package scan.config;


import org.springframework.context.annotation.*;



/**
 * @Author：Weiyu
 * @Version:
 * @Since:
 * @date：2021-12-14_周二 21:39
 **/
@Configuration//标志该类是spring的核心配置类
//<context:component-scan base-package="scan"/>
@ComponentScan("scan")
//<import resource=""/>//将SpringConfiguration作为核心配置时导入其它xml配置，用注解对应本质是config包下面的configuration类
@Import(DataSourceConfiguration.class)//导入多个配置文件时{Configuration1.class,Configuration2.class}
public class SpringConfiguration {

}
