package scan.service.impl;

import org.springframework.context.annotation.Scope;
import scan.dao.DishCartDao;
import scan.model.DishCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import scan.service.DishCartService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;

//<bean id="dishCartService" class="scan.service.impl.DishCartServiceImpl"></bean>
@Service("dishCartService")//<bean id="dishCartService" class="scan.service.impl.DishCartServiceImpl" scope="Prototype"></bean>多例的
@Scope("prototype")
public class DishCartServiceImpl implements DishCartService {

     //注解替换<property name="dishCartDao" ref="dishCartDao"/>就不需要public void setDishCartDao(DishCartDao dishCartDao)
    //@Autowired//按照数据类型从Spring容器中进行匹配的
    //@Qualifier("dishCartDao")//是按照id值从容器中进行匹配的,但是主要@Qualifier必须结合@Autowired一起使用
    @Resource(name = "dishCartDao")// @Resource(name = "dishCartDao")=@Autowired+@Qualifier("dishCartDao")
    private DishCartDao dishCartDao;

    //<bean id="dataSourceDruid" class="com.alibaba.druid.pool.DruidDataSource"  init-method="" destroy-method="">
    @PostConstruct//在构造方法调用后之后
    public void init(){
        System.out.println("DishCartService对象的初始化方法");
    }
    @PreDestroy//在构造方法销毁前
    public void destory(){
        System.out.println("DishCartService对象的初始化方法");
    }


    /**
     * 调用dao实现注入数据并返回注入的字符串
     * @return
     */
    public String toStr() {
        return dishCartDao.toString();//dao层有返回值，所以不用写return

    }

    //通过application.xml给dishCartDao传递值
    //public void setDishCartDao(DishCartDao dishCartDao){
    //    this.dishCartDao=dishCartDao;
    //}

    @Override
    public List<DishCart> findDishCartByCustomer(int uid){
        return dishCartDao.getDish(uid);
    }

    @Override
    public boolean addDishCart(DishCart dishCart) {
        return dishCartDao.insetDishCart(dishCart);
    }

    @Override
    public boolean modDishCart(DishCart dishCart) {
        return dishCartDao.modDishCart(dishCart.getUid(),dishCart.getDid(),dishCart.getNumber());
    }

    @Override
    public boolean delDishCart(int uid, int did) {
        return dishCartDao.delDishCart(uid,did);
    }

    @Override
    public boolean claerDishCart(int uid) {
        return dishCartDao.clear(uid);
    }
}
