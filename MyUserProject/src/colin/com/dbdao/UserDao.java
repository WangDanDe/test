package colin.com.dbdao;

import java.util.List;

import colin.com.bean.User;


public interface UserDao {
	
	//增
	public void add(User user); 
	//删
	public void delete(int id);
	//改
	public void update(User user);
	//查
	//通过id查询
	public User findById(int id);
	//查询全部用户信息
	public List<User> findAllUser();
	//查询帐号密码是否存在
	public User findByNameAndPwd(String username,String password);
}
