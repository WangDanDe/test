package colin.com.dbdao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import colin.com.bean.User;


public class UserDaoImpl implements UserDao {

	private Connection conn = null;
	
	public UserDaoImpl(java.sql.Statement createStatement) {
		// TODO �Զ����ɵĹ��캯�����
		
	}public UserDaoImpl() {
		// TODO �Զ����ɵĹ��캯�����
	}

	
	
	


	@Override
	public void add(User user) {
			PreparedStatement prepareStatement =null;
		try {
			String sql = "INSERT INTO user(username,password,age,sex,power) VALUES(?,?,?,?,?,?,?)";
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, user.getUsername());
			prepareStatement.setString(2, user.getPassword());
			prepareStatement.setInt(3, user.getAge());
			prepareStatement.setString(4, user.getSex());
			prepareStatement.setInt(5, user.getPower());//1Ϊ����Ա��0Ϊ��ͨ�û�
			
			int count = prepareStatement.executeUpdate();
			if(count > 0){
				System.out.println("��ӳɹ�");
			}else{
				System.out.println("���ʧ��");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		PreparedStatement ps=null;
		try {
			String sql = "DELETE FROM user WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			if(count>0){
				System.out.println("ɾ���ɹ�");
			}else{
				System.out.println("���ɹ�");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(User user) {
		PreparedStatement ps=null;
		try {
			String sql = "UPDATE user SET username=?,age=?,power=? WHERE id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getAge());
			ps.setString(4, user.getSex());
			ps.setInt(5, user.getPower());//1Ϊ����Ա��0Ϊ��ͨ�û�
			
			
			int count = ps.executeUpdate();
			if(count>0){
				System.out.println("�޸ĳɹ�");
			}else{
				System.out.println("�޸�ʧ��");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User findById(int id) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql = "SELECT * FROM user WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			User user = new User();
			while(rs.next()){
				
				user.setAge(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setSex(rs.getString(5));
				
				user.setPower(rs.getInt(8));
				
			}
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> findAllUser() {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql = "SELECT * FROM user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()){
				User user = new User();
				user.setAge(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setSex(rs.getString(5));
				user.setPower(rs.getInt(6));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public User findByNameAndPwd(String username, String password) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql = "SELECT * FROM user WHERE username=? AND password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			User user = new User();
			if(rs!=null){
				while(rs.next()){
					user.setAge(rs.getInt(1));
					user.setUsername(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setAge(rs.getInt(4));
					user.setSex(rs.getString(5));
					
					user.setPower(rs.getInt(6));
					return user;
				}
			}
			return null;
				
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}}
