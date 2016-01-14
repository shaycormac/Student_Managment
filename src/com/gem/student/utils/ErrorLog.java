package com.gem.student.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

/**
* @author 炳华儿 E-mail: 574583006@qq.com
* @date  创建时间：2016年1月7日 上午10:15:03 
* @parameter   
* @return 
*/
/**
 * @author Administrator
 *
 */
public class ErrorLog 
{

	/**
	 * 创建一个方法，用来输出错误日志
	 */
	public static void printErrorLog (PrintStream s,Exception e)
	{
		try {
			//普通的io读取的相对路径，是编译期的路径，即工程作为根目录
			s = new PrintStream(new FileOutputStream("src\\exceptionLog.txt", true));
			java.util.Date date = new java.util.Date();
			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
			String x =sFormat.format(date);
			s.println("-----------------------------------");
			s.flush();
			s.println(x);
			s.flush();
		} catch (FileNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
			//一定要处理啊
			throw new RuntimeException("文件找不到！");
		}
		e.printStackTrace(s);
		s.println("-----------------------------------");
		s.flush();
		s.close();
		System.out.println("error");
		
	}

}
