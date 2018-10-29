package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import bean.User;
import cn.itcast.jdbc.JdbcUtils;
import cn.itcast.jdbc.TxQueryRunner;



/*
 * 数据类
 * 实现两个方法：添加用户、按用户名查找用户
 */
public class UserDao {
	
	//注册用户时为数据库添加纪录
	public void addUser(User user) throws SQLException{
		
		QueryRunner qRunner = new TxQueryRunner();
		//先写出sql模板
		String sql = "insert into user values(null,?,?,?,?)";
		//为sql模板添加参数
		Object[] params = {user.getUsername(),user.getPassword(),user.getPhone(),user.getEmail()};
		qRunner.update(sql, params);
	}
	
	//按用户名查找用户是否存在
	public User findByName(String username) throws SQLException {
		QueryRunner qRunner = new TxQueryRunner();
		String sql = "select * from user where username=? ";
			
		Object[] params = {username};
		User user = qRunner.query(sql, new BeanHandler<User>(User.class) , params);
		return user;
	}
	
}
