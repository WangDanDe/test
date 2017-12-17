package colin.com.dbdao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbConnection {

	private Connection conn = null;
	private static final String mysqlurl = "jdbc:mysql://";

	public static final String mysql = "mysql";
	public static final String oracle = "oracle";
	private static final String oracleurl = "jdbc:oracle:thin:@";
    private DataSource ds=null; 
	public DbConnection(String name, String password, String dbName, String ip, String port, String dbtype) {
		// TODO 自动生成的构造函数存根
		String url = "";
		if (mysql.equals(dbtype)) {
			url = url + mysqlurl;
			url = url + ip + ":" + port + "/" + dbName;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if (oracle.equals(dbtype)) {
			url = url + oracleurl;
			url = url + ip + ":" + port + ":" + dbName;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

		try {
			conn = DriverManager.getConnection(url, name, password);
		    System.out.println(dbName+"数据库连接成功");
		    
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public DbConnection() {
		// TODO 自动生成的构造函数存根
		ds= new ComboPooledDataSource("mysqlId");
		
	}
	public Connection getConn() {
		if(null==conn){
			try {
				conn=ds.getConnection();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO 自动生成的方法存根
		super.finalize();
		if (this.conn != null) {
			conn.close();
		}
	}

	public Statement  prepareStatement()
	{
		Statement st;
		if(this.conn==null)
		{
			getConn();
		}
		try {
			
			st = this.conn.prepareStatement(null);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		return st;
	}
}
