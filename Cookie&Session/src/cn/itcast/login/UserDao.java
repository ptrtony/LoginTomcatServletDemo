package cn.itcast.login;

import cn.itcast.login.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());;

    public UserBean login(UserBean userBean){
        try {
            String sql = "select * from user where username=? and password=?";
            UserBean userBean1 = template.queryForObject(sql, new BeanPropertyRowMapper<UserBean>(UserBean.class), userBean.getUsername(), userBean.getPassword());
            return userBean1;
        }catch (Exception e){
            return null;
        }
    }
}
