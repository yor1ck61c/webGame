package dao.impl;

import dao.UserDao;
import domain.Emp;
import domain.Rank;
import domain.User;
import druidUtils.druidUtils;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(druidUtils.getDataSource());
    @Override
    public User findUserByUsername(String username) {
        String sql = "select * from user where username = ?";
        try{
            return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public int userRegister(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String socialAccount = user.getSocialAccount();
        String sql = "insert into user values (null,?,?,?,?,?,?)";
        return template.update(sql,username,password,email,socialAccount,0,0);
    }

    @Override
    public User findUserByUP(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        try{
            return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void addOnline(int id) {
        String sql = "insert into online values (?)";
        try {
            template.update(sql,id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int findOnlinePlayers() {
        String sql = "select count(*) from online";
        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public void quit(int id) {
        String sql = "delete from online where id = ?";
        template.update(sql,id);
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id = ?";
        try{
            return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void changeUserInfoById(User user, int id) {
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String socialAccount = user.getSocialAccount();
        String sql = "update user set username = ?, password = ?, email = ?, socialAccount = ? where id = ?";
        template.update(sql,username,password,email,socialAccount,id);
    }

    @Override
    public Rank findRankById(int id) {
        String sql = "select * from ranking where id = ?";
        try {
            return template.queryForObject(sql,new BeanPropertyRowMapper<Rank>(Rank.class),id);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void updateRank(Rank rankById, int id) {
        String gamingTime = rankById.getGamingTime();
        String rank = rankById.getRanking();
        String sql = "update ranking set gamingTime = ?, ranking = ? where id = ?";
        template.update(sql,gamingTime,rank,id);
    }

    @Override
    public void insertUserIntoRank(int id, String username) {
        String sql = "insert into ranking values(?,?,0,0)";
        template.update(sql,id,username);
    }

    @Override
    public void updateUser(String ranking, String gamingTime, int id) {
        String sql = "update user set ranking = ?, gamingTime = ? where id = ?";
        template.update(sql,ranking,gamingTime,id);
    }

    @Override
    public List<Rank> findRankByPage(int start, int rows) {
        String sql = "select * from ranking limit ?,?";
        try {
            return template.query(sql,new BeanPropertyRowMapper<Rank>(Rank.class),start,rows);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public int findAllRank() {
        String sql = "select count(*) from ranking";
        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public List<Rank> findAllRankPage() {
        String sql = "select * from ranking";
        try {
            return template.query(sql,new BeanPropertyRowMapper<Rank>(Rank.class));
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Test
    public void selectAll(){
        String sql = "delete from emp where ENAME = ?";
        try{
            template.update(sql,"SMITH");
            System.out.println("执行成功");
        }catch (Exception e){
            System.out.println("执行失败");
            e.printStackTrace();
        }
    }
}
