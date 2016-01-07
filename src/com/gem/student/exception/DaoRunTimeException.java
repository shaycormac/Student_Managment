package com.gem.student.exception;
/**
* @author 炳华儿 E-mail: 574583006@qq.com
* @date  创建时间：2016年1月6日 下午2:01:06 
* @parameter   
* @return 
* 作为dao层的异常处理，出现问题，让程序员快速定位到这个层。
*/
public class DaoRunTimeException extends RuntimeException {

	public DaoRunTimeException() {
		// TODO Auto-generated constructor stub
	}

	public DaoRunTimeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DaoRunTimeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DaoRunTimeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DaoRunTimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
