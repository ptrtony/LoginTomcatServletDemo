package dao.impl;

import entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public void addUser(User user) {
//        StringBuffer sb = new StringBuffer();
//        sb.append("insert into user(id,name,gender,age,address,qq,email) values(")
//                .append(null + ",")
//                .append(user.getName() + ",")
//                .append(user.getGender() + ",")
//                .append(user.getAge() + ",")
//                .append(user.getAddress() + ",")
//                .append(user.getQq() + ",")
//                .append(user.getEmail() +
//                        ")");
        String sql = "insert into user(id,name,gender,age,address,qq,email) values(null,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void createTable() {

    }

    @Override
    public void deleteUser(User user) {
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql,user.getId());
    }

    @Override
    public User updateUser(int id) {
        String sql = "select * from user where id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void motifyUser(User user) {
        String sql = "update user set name=?,gender =?,age=?,address=?,qq=?,email=? where id=?";
        jdbcTemplate.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(), user.getId());
    }
}
