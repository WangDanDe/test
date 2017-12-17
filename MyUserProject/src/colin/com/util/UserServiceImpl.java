package colin.com.util;

import java.util.List;

import colin.com.bean.User;
import colin.com.dbdao.UserDao;
import colin.com.dbdao.UserDaoImpl;



public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	public UserServiceImpl() {
		UserDao userDao = new UserDaoImpl();
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) {
		userDao.add(user);
	}

	@Override
	public void deleteUser(int id) {
		userDao.delete(id);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	@Override
	public User nameAndPwd(String username,String password) {
		return userDao.findByNameAndPwd(username,password);
	}

}
