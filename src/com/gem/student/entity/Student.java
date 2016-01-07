/**@Author 炳华儿
   创建时间：2016年1月6日 上午10:39:48
 * 
 */
package com.gem.student.entity;

import java.util.Date;

/**
* @author 炳华儿 E-mail: 574583006@qq.com
* @date  创建时间：2016年1月6日 上午10:39:48 
* @parameter   
* @return 
*/
/**
 * @author Administrator
 *
 */
public class Student 
{
	private int id;
	private String name;
	private String sno;
	private String password;
	private Date birthday;
	private int sex;
	private int polity;
	private String brief;
	public Student() {
		super();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getPolity() {
		return polity;
	}
	public void setPolity(int polity) {
		this.polity = polity;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sno=" + sno + ", password=" + password + ", birthday="
				+ birthday + ", sex=" + sex + ", polity=" + polity + ", brief=" + brief + "]";
	}

}
