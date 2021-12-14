package scan.service;

import scan.model.DishCart;

import java.util.List;


public interface DishCartService {
    //查找用户餐车
    public List<DishCart> findDishCartByCustomer(int uid);
    //用户增加菜品
    public boolean addDishCart(DishCart dishCart);
    //用户修改菜品数量
    public boolean modDishCart(DishCart dishCart);
    //删除餐车中的菜品
    public boolean delDishCart(int uid, int did);
    //清空餐车
    public boolean claerDishCart(int uid);
    //使用application.xml给setDishCartDao()中引用类型dishCartDao赋值，最后调用DishCartDaoImpl中的toString()方法看是否赋值成功
    public String toStr();
}
