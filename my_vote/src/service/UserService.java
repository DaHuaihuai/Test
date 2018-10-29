package service;

import java.sql.SQLException;

import dao.UserDao;
import bean.User;

/*
 * 业务逻辑层
 */
public class UserService {
	//service依赖dao
	private UserDao userDao = new UserDao();
	
	public void regist(User user) throws UserException {
		//在数据库中查找该name的user
		User db_user = null;
		try {
			db_user = userDao.findByName(user.getUsername());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//若存在，抛出异常；否则为数据库添加该用户
		if(db_user != null)
			throw new UserException("用户名"+user.getUsername()+"已被注册！");
		else {
			try {
				userDao.addUser(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}
	
	/*
	 * 登录
	 */

	public User login(User form) throws UserException{
		// TODO Auto-generated method stub
		User user = null;
		try {
			user = userDao.findByName(form.getUsername());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(user==null){
			throw new UserException("用户名不存在！");
		}
		
		if(!form.getPassword().equals(user.getPassword())){
			throw new UserException("密码错误！");
		}
		
		return user;
	}

}
