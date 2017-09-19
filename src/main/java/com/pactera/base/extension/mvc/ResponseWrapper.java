package com.pactera.base.extension.mvc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: ResponseWrapper
 * @date 2017年9月18日 下午5:57:18
 * @author ToniR
 * @Description: 封装返回结果
 */
@Getter
@Setter
@ApiModel("返回封装对象")
public class ResponseWrapper {

	/**
	 * 类型
	 */
	public enum Status {
		/**
		 * 成功
		 */
		SUCCESS,

		/**
		 * 错误
		 */
		ERROR
	}

	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态")
	private Status status;

	/**
	 * 内容
	 */
	@ApiModelProperty(value = "内容")
	private String message;

	/**
	 * 错误码
	 */
	@ApiModelProperty(value = "错误码")
	private Integer errorCode;

	/**
	 * 返回数据
	 */
	@ApiModelProperty(value = "返回数据")
	private Object data;

	/**
	 * @author ToniR
	 * @since 2017年9月18日 下午5:57:41
	 * @title ResponseWrapper
	 * @description Empty Constructor
	 */
	public ResponseWrapper() {

	}

	/**
	 * @author ToniR
	 * @since 2017年9月18日 下午5:58:05
	 * @title ResponseWrapper
	 * @description Full Constructor
	 */
	public ResponseWrapper(Status status, Integer errorCode, String message, Object data) {
		this.status = status;
		this.errorCode = errorCode;
		this.message = message;
		this.data = data;
	}

	/**
	 * @author ToniR
	 * @since 2017年9月18日 下午5:58:39
	 * @title success
	 * @description Only Success
	 * @return ResponseWrapper
	 */
	public static ResponseWrapper success() {
		return new ResponseWrapper(Status.SUCCESS, null, null, null);
	}

	/**
	 * @author ToniR
	 * @since 2017年9月18日 下午5:58:55
	 * @title success
	 * @description Success Return Message
	 * @return ResponseWrapper
	 */
	public static ResponseWrapper success(String message) {
		return new ResponseWrapper(Status.SUCCESS, null, message, null);
	}

	/**
	 * @author ToniR
	 * @since 2017年9月18日 下午5:59:14
	 * @title success
	 * @description Success Return Data
	 * @return ResponseWrapper
	 */
	public static ResponseWrapper success(Object data) {
		return new ResponseWrapper(Status.SUCCESS, null, null, data);
	}

	/**
	 * @author ToniR
	 * @since 2017年9月18日 下午5:59:30
	 * @title success
	 * @description Success Return Message, Data
	 * @return ResponseWrapper
	 */
	public static ResponseWrapper success(String message, Object data) {
		return new ResponseWrapper(Status.SUCCESS, null, message, data);
	}

	/**
	 * @author ToniR
	 * @since 2017年9月18日 下午5:59:43
	 * @title error
	 * @description Only Error
	 * @return ResponseWrapper
	 */
	public static ResponseWrapper error() {
		return new ResponseWrapper(Status.ERROR, null, null, null);
	}

	/**
	 * @author ToniR
	 * @since 2017年9月18日 下午5:59:59
	 * @title error
	 * @description Error Return Message
	 * @return ResponseWrapper
	 */
	public static ResponseWrapper error(String message) {
		return new ResponseWrapper(Status.ERROR, null, message, null);
	}

	/**
	 * @author ToniR
	 * @since 2017年9月18日 下午6:00:22
	 * @title error
	 * @description Error Return ErrorCode
	 * @return ResponseWrapper
	 */
	public static ResponseWrapper error(Integer errorCode) {
		return new ResponseWrapper(Status.ERROR, errorCode, null, null);
	}

	/**
	 * @author ToniR
	 * @since 2017年9月18日 下午6:00:36
	 * @title error
	 * @description Error Return Message, ErrorCode
	 * @return ResponseWrapper
	 */
	public static ResponseWrapper error(Integer errorCode, String message) {
		return new ResponseWrapper(Status.ERROR, errorCode, message, null);
	}
}