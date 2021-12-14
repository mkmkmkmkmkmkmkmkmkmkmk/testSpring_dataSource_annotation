package scan.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import scan.config.SpringConfiguration;
import scan.service.DishCartService;

/**
 * @Author：Weiyu
 * @Version:
 * @Since:
 * @date：2021-12-14_周二 20:34
 **/
public class AnnotationTest {
    /**
     * 测试applicationContext.xml配置文件
     */
    @Test
    public void testAnnotation_xml(){
        //为了看到applicationContext.xml中id为dataSourceDruid的destroy-method可以使用：似乎没有生效果
        ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        DishCartService dishCartService=app.getBean(DishCartService.class);
        System.out.println(dishCartService.toStr());
        app.close();
    }
    @Test
    public void testAnnotation_getDishCart(){
        //为了看到applicationContext.xml中id为dataSourceDruid的destroy-method可以使用：似乎没有生效果
        ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        DishCartService dishCartService=app.getBean(DishCartService.class);
        System.out.println(dishCartService.findDishCartByCustomer(2));
        app.close();
    }

    /**
     * 所有通过SpringConfiguration注解测试
     */
    @Test
    public void testAnnotation_configuration_class(){
        //为了看到applicationContext.xml中id为dataSourceDruid的destory-method可以使用：似乎没有生效果
        ApplicationContext app=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        DishCartService dishCartService=app.getBean(DishCartService.class);
        System.out.println(dishCartService.toStr());
    }
}
