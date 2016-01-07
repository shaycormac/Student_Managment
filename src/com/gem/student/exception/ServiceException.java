package com.gem.student.exception;
/**
* @author 炳华儿 E-mail: 574583006@qq.com
* @date  创建时间：2016年1月7日 上午9:45:42 
* @parameter   
* @return
* service层的自定义编译异常，要求客户必须处理！！ 
*/
public class ServiceException extends Exception {

	public ServiceException() {
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
