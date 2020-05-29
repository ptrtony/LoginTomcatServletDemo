package cn.itcast.servlet.test;

import cn.itcast.servlet.entity.UserBean;
import cn.itcast.servlet.entity.UserDao;
import cn.itcast.servlet.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class TestUtils {
    @Test
    public void test(){
        UserDao userDao = new UserDao();
        UserBean userBean = new UserBean(1,"zhangsan","123");
        UserBean login = userDao.login(userBean);
        if (login!=null){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }
}
