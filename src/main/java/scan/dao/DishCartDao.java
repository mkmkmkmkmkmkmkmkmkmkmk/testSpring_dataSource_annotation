package scan.dao;


import scan.model.DishCart;

import java.util.List;

public interface DishCartDao {
    /**
     * 传入用户id，查找该用户的所有餐车记录
     * @param customerId
     * @return
     */
    public List<DishCart> getDish(int customerId);

    /**
     * 传入新增的餐车记录，返回修改的行数
     * @param dishCart
     * @return
     */
    public boolean insetDishCart(DishCart dishCart);

    /**
     ** 传入用户id，和想要删除的购物车中菜品id，返回修改的行数
     * @param customerId
     * @param dishId
     * @return
     */
    public boolean delDishCart(int customerId, int dishId);

    /**
     * 传入用户id，菜品id，想修改的数量，返回影响行数
     * @param customerId
     * @param dishId
     * @param num
     * @return
     */
    public boolean modDishCart(int customerId, int dishId, int num);

    /**
     * 传入用户id，删除所有用户购物车记录
     * @param customerId
     * @return
     */
    public boolean clear(int customerId);

}
