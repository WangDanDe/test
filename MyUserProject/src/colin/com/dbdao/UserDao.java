package colin.com.dbdao;

import java.util.List;

import colin.com.bean.User;


public interface UserDao {
	
	//��
	public void add(User user); 
	//ɾ
	public void delete(int id);
	//��
	public void update(User user);
	//��
	//ͨ��id��ѯ
	public User findById(int id);
	//��ѯȫ���û���Ϣ
	public List<User> findAllUser();
	//��ѯ�ʺ������Ƿ����
	public User findByNameAndPwd(String username,String password);
}
