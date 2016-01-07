package com.gem.student.exception;
/**
* @author 炳华儿 E-mail: 574583006@qq.com
* @date  创建时间：2016年1月7日 上午9:45:06 
* @parameter   
* @return 
* service层的运行时异常，是不想要告诉客户，而告诉程序员的具体位置，转换成自定义的运行异常。
*/
public class ServiceRunTimeException extends RuntimeException {

	public ServiceRunTimeException() {
		// TODO Auto-generated constructor stub
	}

	public ServiceRunTimeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ServiceRunTimeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceRunTimeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceRunTimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
