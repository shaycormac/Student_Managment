package com.gem.student.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.gem.student.exception.DaoRunTimeException;

/**
* @author 炳华儿 E-mail: 574583006@qq.com
* @date  创建时间：2016年1月5日 上午11:18:27 
* @parameter   
* @return 
*/
public class DBConnection 
{
	private static Properties properties = new Properties();
	//静态代码快
	static
	{
		InputStream in = DBConnection.class.getResourceAsStream("mysql.properties");
		//URL url =DBConnection.class.getClassLoader().getResource("com/gem/student/utils/mysql.properties");
		try {
			//InputStream in = url.openStream();
		//	System.out.println(url.getPath());
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	

	//方法：通过
	public static Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		//配置文件： xml文件，properties文件，
		//从属性文件中读取联结信息
		/*Class.forName("com.mysql.jdbc.Driver");
		//2.联结数据库的url，用户名，密码
		String url ="jdbc:mysql://localhost:3306/mysqlday4";
		String use ="root";
		String pass ="root";
		//3.通过DriverManager上的getConnection方法获得Connection对象
*/		Class.forName(properties.getProperty("driver"));
		//2.联结数据库的url，用户名，密码
		String url =properties.getProperty("url");
		String use =properties.getProperty("user");
		String pass =properties.getProperty("paw");
		//3.通过DriverManager上的getConnection方法获得Connection对象
		
		return DriverManager.getConnection(url, use, pass);
	
	}
	
   //释放资源
	public static void release(Connection conn, Statement st, ResultSet rs) {

		if (rs != null) {
			try {
				rs.close(); // throw new
			} catch (Exception e) {
				e.printStackTrace();
				throw new DaoRunTimeException("关闭查询的结果集资源失败");
			}
			rs = null;
		}
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new DaoRunTimeException("关闭Statement资源失败");
			}
			st = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new DaoRunTimeException("关闭连接资源失败");
			}
		}

	}
	
	

}
