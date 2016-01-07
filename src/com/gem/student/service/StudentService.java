package com.gem.student.service;

import com.gem.student.dao.StudentDao;

/**
* @author 炳华儿 E-mail: 574583006@qq.com
* @date  创建时间：2016年1月7日 上午8:56:09 
* @parameter   
* @return 
*/
/**
 * @author Administrator
 *注意，web层获取从浏览器获取的信息之后，调用service层处理数据，而Service层不联结数据库,需要数据的时候，去Dao层找方法
 *所以，就是说涉及到查询数据库，都是用Dao层，增删改查判断，返回尸体对象
 */
public class StudentService 
{
	private StudentDao sDao;//作为成员变量
	//方法，判断学号与密码是否正确
	public boolean canLogin (String sno, String password)
	{
		//找出sno学生（与数据库有关，），判断这个学生的密码是否与password相等
		return false;
	}

}
