package scan.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import scan.dao.DishCartDao;
import scan.model.DishCart;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import scan.utils.JDBCUtils;

import java.util.List;
import java.util.Map;
import java.util.Properties;
//<bean id="dishCartDao" class="scan.dao.impl.DishCartDaoImpl"></bean>
@Repository("dishCartDao")
public class DishCartDaoImpl implements DishCartDao {
    //依赖注入（对应applicationContext.xml)
    private List<String> stringList;
    private Map<String,DishCart> DishCartMap;
    private Properties properties;

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }



    public void setProperties(Properties properties) {
        this.properties = properties;
    }



    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<DishCart> getDish(int customerId) {
        String sql="select * from dishcart where uid=?";
        return template.query(sql,new BeanPropertyRowMapper<DishCart>(DishCart.class),customerId);
    }

    @Override
    public boolean insetDishCart(DishCart dishCart) {
        String sql="insert into dishcart value(0,?,?,?)";
        return template.update(sql,dishCart.getUid(),dishCart.getDid(),dishCart.getNumber())==1;
    }

    @Override
    public boolean delDishCart(int customerId, int dishId) {
        String sql="delete from dishcart where uid=? and did=?";
        return template.update(sql,customerId,dishId)==1?true:false;
    }

    @Override
    public boolean modDishCart(int customerId, int dishId, int num) {
        String sql="update dishcart set number=? where uid=? and did=?";
        return template.update(sql,num,customerId,dishId)==1;
    }

    @Override
    public boolean clear(int customerId) {
        String sql="delete from dishcart where uid=?";
        return template.update(sql,customerId)==1;
    }
    @Override
    public String toString() {
        return "DishCartDaoImpl{" +
                "stringList=" + stringList +
                ", DishCartMap=" + DishCartMap +
                ", properties=" + properties +
                '}';
    }


}
