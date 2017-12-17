package colin.com.util;

import java.util.List;

import colin.com.bean.User;


public interface UserService {
	
	//ע���û�
	public void addUser(User user);
	//ע���û�
	public void deleteUser(int id);
	//�޸��û���Ϣ
	public void updateUser(User user);
	//ͨ��id��ѯָ���û���Ϣ
	public User findById(int id);
	
	//��ѯ�����û���Ϣ
	public List<User> findAllUser();
	
	//ͨ���ʺ�����ȷ�����޸��û�
	public User nameAndPwd(String username,String password);
}
