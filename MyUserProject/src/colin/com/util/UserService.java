package colin.com.util;

import java.util.List;

import colin.com.bean.User;


public interface UserService {
	
	//注册用户
	public void addUser(User user);
	//注销用户
	public void deleteUser(int id);
	//修改用户信息
	public void updateUser(User user);
	//通过id查询指定用户信息
	public User findById(int id);
	
	//查询所有用户信息
	public List<User> findAllUser();
	
	//通过帐号密码确认有无该用户
	public User nameAndPwd(String username,String password);
}
