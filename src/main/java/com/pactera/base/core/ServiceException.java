package com.pactera.base.core;

/**
 * @ClassName: ServiceException 
 * @date 2017年9月18日 下午12:24:26 
 * @author ToniR  
 * @Description: 业务异常
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 2665747233764638572L;

	public ServiceException() {
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
