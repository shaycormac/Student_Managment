/**@Author 炳华儿
   创建时间：2016年1月6日 上午11:28:38
 * 
 */
package com.gem.student.junits;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.gem.student.dao.StudentDao;
import com.gem.student.entity.Student;

/**
* @author 炳华儿 E-mail: 574583006@qq.com
* @date  创建时间：2016年1月6日 上午11:28:38 
* @parameter   
* @return 
*/
/**
 * @author Administrator
 *
 */
public class StudentDaoTest 
{
	@Test
	public void testSaveStudent ()
	{
		Student student = new Student();
		student.setName("花卉");
		student.setSno("01070230");
		student.setPassword("123456");
		student.setPolity(2);
		student.setSex(0);
		student.setBrief("伊斯兰教");
		String bir = "1982-08-23";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date =null;
		try {
			 date = sdf.parse(bir);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new RuntimeException("日期转换错误！！");
		}
		student.setBirthday(date);
		StudentDao sDao = new StudentDao();
		
			sDao.saveStudent(student);
		
		System.out.println("ok");
		
	}
	
	@Test
	public void testGetStudentById ()
	{
		StudentDao sDao = new StudentDao();
		Student student =sDao.getStudentById(24);
		System.out.println(student);	
	}
	
	@Test
	public void testUpdateStudent ()
	{
		Student student = new Student();
		student.setName("小青年");
		student.setSno("01070238");
		student.setPassword("87494");
		student.setPolity(1);
		student.setSex(0);
		student.setBrief("伊斯兰教");
		String bir = "1982-08-23";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date =null;
		try {
			 date = sdf.parse(bir);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new RuntimeException("日期转换错误！！");
		}
		student.setBirthday(date);
		StudentDao sDao = new StudentDao();
		sDao.update(student,"a009");
			
	}
	
	@Test
	public void testDeleteStudent ()
	{
		int [] id = {8,15,22};
		StudentDao sDao = new StudentDao();
		sDao.deleteStudent(id);
		/*id号为8的记录已经删除！！
		id号为15的记录已经删除！！
		id号为22的记录已经删除！！*/
	}
	
	@Test
	public void testGetAllStudent ()
	{
		StudentDao sDao = new StudentDao();
		sDao.getAllStudent();
		
	}
	
	@Test
	public void testGetPagedStudents ()
	{
		StudentDao sDao = new StudentDao();
		sDao.getPagedStudents(3, 4);
		
	}

}
