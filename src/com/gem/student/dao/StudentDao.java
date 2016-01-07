package com.gem.student.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.gem.student.entity.Student;
import com.gem.student.exception.DaoRunTimeException;
import com.gem.student.utils.DBConnection;

/**
* @author 炳华儿 E-mail: 574583006@qq.com
* @date  创建时间：2016年1月6日 上午11:02:18 
* @parameter   
* @return 
*/
/**
 * @author Administrator
 *
 */
//凡是和数据库有关的代码，都写在此处
public class StudentDao {
	 //详细设计，都需要什么样的方法，由需求决定确定
	//保存学生信息
	public void saveStudent (Student student) 
	{
		Connection connection=null;
		PreparedStatement pStatement = null;
		//1.连接数据库
		 try {
			connection= DBConnection.getConnection();
			//2.SQL语句
			String sql ="insert into student(name,sno,password,sex,polity,birthday,brief) "
					+ "values(?,?,?,?,?,?,?)";
			//3.获得PrepareStatement对象
			pStatement =connection.prepareStatement(sql);
			//4.设置？的值
			pStatement.setString(1, student.getName());
			pStatement.setString(2, student.getSno());
			pStatement.setString(3, student.getPassword());
			pStatement.setInt(4, student.getSex());
			pStatement.setInt(5, student.getPolity());
			pStatement.setDate(6, new Date(student.getBirthday().getTime()));
			pStatement.setString(7, student.getBrief());
			//5.执行语句
			pStatement.executeUpdate();
		} catch (ClassNotFoundException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoRunTimeException("Class文件未找到");
		} catch (SQLException e) {
			// 一定要处理异常
			e.printStackTrace();
			throw new DaoRunTimeException("数据库出错");
		}
		//6.关闭资源
		 finally{
			 
			 DBConnection.release(connection, pStatement, null);
		 }
		
	}
	//根据主键获取学生信息
	public Student getStudentById(int id)
	{
		Connection coon =null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		Student student = null;
		try {
			coon=DBConnection.getConnection();
			String sql ="select * from student where id=?";
			pStatement = coon.prepareStatement(sql);
			pStatement.setInt(1, id);
			rs = pStatement.executeQuery();
			//取到数据，撞到一个学生对象中，由于查询的只是一个，所以说，不使用while，而是if进行判断
			if (rs.next())
			{ 
				student = new Student();
				student.setId(id);
				student.setName(rs.getString("name"));
				student.setPassword(rs.getString("password"));
				student.setSno(rs.getString("sno"));
				student.setSex(rs.getInt("sex"));
				student.setPolity(rs.getInt("polity"));
				student.setBrief(rs.getString("brief"));
				//rs.getDate("birthday")是java.sql.Date，是需要传进值的java。utils.date的子类，当然可以穿进去
				student.setBirthday(rs.getDate("birthday"));	
			}
		} catch (ClassNotFoundException e) 
		{
			PrintStream s = null;
			try 
			{
				s = new PrintStream(new FileOutputStream("C:\\Users\\Administrator\\workspace\\student\\src\\exceptionLog.txt", true));
				java.util.Date date = new java.util.Date();
				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
				String x =sFormat.format(date);
				s.println(x);
				s.flush();
			} catch (FileNotFoundException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 输出错误日志，加上时间？
			e.printStackTrace(s);
			s.close();
			System.out.println("error");
		
			throw new DaoRunTimeException("Class发现不了");
		} catch (SQLException e)
		{
			PrintStream s = null;
			try 
			{
				s = new PrintStream(new FileOutputStream("src\\exceptionLog.txt", true));
				java.util.Date date = new java.util.Date();
				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
				String x =sFormat.format(date);
				s.println(x);
			} catch (FileNotFoundException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 输出错误日志，加上时间？
			e.printStackTrace(s);
			System.out.println("error");
			throw new DaoRunTimeException("SQL出现问题");
		}finally {
			
			DBConnection.release(coon, pStatement, rs);
		}
		return student;
	}
	//...
	
	//删除学生,批量删除
	public void deleteStudent (int[] id)
	{
		Connection coon =null;
		PreparedStatement pStatement = null;
		try {
			coon=DBConnection.getConnection();
		/*	String sql=null;
			for (int i=0;i<id.length;++i)
			{
				 sql="delete from student where id=?";
				 pStatement=coon.prepareStatement(sql);
				 pStatement.setInt(1, id[i]);
				int num = pStatement.executeUpdate();
				if (num>0) 
				{
					System.out.println("id号为"+id[i]+"的记录已经删除！！");
				}
			}*/
			String sql="delete from student where id in (";
			for (int i = 0; i < id.length; i++)
			{
			 if (i<id.length-1)
			 {
			   sql=sql+id[i]+",";	
			}
			 else
			 {
				
				 sql =sql+id[i]+")";
			}
			}
			System.out.println(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoRunTimeException("class类型错误");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoRunTimeException("SQL类型错误");
		}finally 
		{
			DBConnection.release(coon, pStatement, null);
		}
		
	}
	//修改,(将学生更新过来的数据，根据学号，来重新写入到数据库了)
	public void update (Student student, String sno)
	{
		Connection coon = null;
		PreparedStatement pStatement = null;
		try {
			coon =DBConnection.getConnection();
			String sql ="update student set name=?,sno=?,password=?,birthday=?,sex=?,polity=?,brief=? where sno=?";
			pStatement = coon.prepareStatement(sql);
			pStatement.setString(1, student.getName());
			pStatement.setString(2, student.getSno());
			pStatement.setString(3, student.getPassword());
			pStatement.setDate(4, new java.sql.Date(student.getBirthday().getTime()));
			pStatement.setInt(5, student.getSex());
			pStatement.setInt(6, student.getPolity());
			pStatement.setString(7, student.getBrief());
			pStatement.setString(8, sno);
			int num =pStatement.executeUpdate();
			if (num>0)
			{
			 System.out.println("数据更新成功");	
			}
		} catch (ClassNotFoundException e) {
			// 自定义运行时异常，方便程序员快速定位到底是哪个层出问题了。
			e.printStackTrace();
			throw new DaoRunTimeException("class类型错误");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoRunTimeException("SQL类型错误");
		}finally 
		{
			DBConnection.release(coon, pStatement, null);
		}
		
	}
	//获得所有学生对象
	public List<Student> getAllStudent ()
	{
		List<Student> list = new ArrayList<>();
		Connection coon=null;
		PreparedStatement pStatement = null;
		ResultSet rs=null;
		try {
			coon =DBConnection.getConnection();
			String sql = "select * from student";
			pStatement=coon.prepareStatement(sql);
			rs=pStatement.executeQuery();
			Student s=null;
			while (rs.next())
			{
				s=new Student();
				s.setName(rs.getString("name"));
				s.setId(rs.getInt("id"));
				s.setPassword(rs.getString("password"));
				s.setSex(rs.getInt("sex"));
				s.setPolity(rs.getInt("polity"));
				s.setBrief(rs.getString("brief"));
				s.setSno(rs.getString("sno"));
				s.setBirthday(rs.getDate("birthday"));
				list.add(s);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoRunTimeException("class类型错误");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoRunTimeException("SQL类型错误");
		}finally {
			DBConnection.release(coon, pStatement, rs);
		}
		//遍历集合
		for (Student student : list) 
		{
			System.out.println(student);
		}
		return list;
	}
	
	//根据学号找到学生对象。
	//如果学生没有，返回null
	
  
	//分页查询， 显示第几页，每页显示的记录个数
	public List<Student> getPagedStudents(int curPage,int pageSize)
	{
		//核心 select * from student limit ?,?;
		List<Student> list = new ArrayList<>();
		Connection coon=null;
		PreparedStatement pStatement = null;
		ResultSet rs=null;
		try {
			coon =DBConnection.getConnection();
			String sql ="select * from student limit ?,?";
			pStatement = coon.prepareStatement(sql);
			pStatement.setInt(1, (curPage-1)*pageSize);
			pStatement.setInt(2, pageSize);
			rs=pStatement.executeQuery();
			Student s=null;
			while (rs.next())
			{
				s=new Student();
				s.setName(rs.getString("name"));
				s.setId(rs.getInt("id"));
				s.setPassword(rs.getString("password"));
				s.setSex(rs.getInt("sex"));
				s.setPolity(rs.getInt("polity"));
				s.setBrief(rs.getString("brief"));
				s.setSno(rs.getString("sno"));
				s.setBirthday(rs.getDate("birthday"));
				list.add(s);	
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoRunTimeException("class类型错误");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoRunTimeException("SQL类型错误");
		}finally {
			DBConnection.release(coon, pStatement, rs);
		}
		//遍历集合
				for (Student student : list) 
				{
					System.out.println(student);
				}
		return list;
		
	}
	
	//模糊查询
}
