package net.voovo.enote.exception;

/**
 * 错误信息枚举
 */
public enum UpmsExceptionEnum {
	
	
	/**
	 * 用户已存在！
	 */
	userName_exists(1001 , "用户已存在！"),
	/**
	 * 用户名或密码错误!
	 */
	userName_or_password_error(1002 , "用户名或密码错误!"),
	/**
	 * 用户名或密码错误!
	 */
	userName_or_password_3error(1003 , "用户名或密码错误!"),	
	/**
	 * Smscode错误！
	 */
	smsCode_error(1004 , "Smscode错误！"),
	
	/**
	 * 用户名称不能为空
	 */
	userName_null(1005 , "手机号不能为空!"),
	/**
	 * 密码不能为空
	 */
	password_null(1006 , "密码不能为空"),
	/**
	 * 旧密码不能为空！
	 */
	old_password_null(1007 , "旧密码不能为空！"),
	/**
	 * 新密码不能为空！
	 */
	new_password_null(1008 , "新密码不能为空！"),
	/**
	 * 验证码不能为空
	 */
	smsCode_null(1009 , "验证码不能为空"),
	/**
	 * 用户角色不存在，请联系管理员配置！
	 */
	role_not_exists(1010 , "用户角色不存在，请联系管理员配置！"),

	/**
	 * 手机号格式错误!
	 */
	mobile_error(1011 , "手机号格式错误!"),
	/**
	 * 用户Id不能为空!
	 */
	userId_null(1012 , "用户Id不能为空!"),
	/**
	 * 旧密码不正确!
	 */
	old_password_error(1013 , "旧密码不正确!"),
	/**
	 * 密码16进制加密异常
	 */
	encryptedPwd_error(1014 , "密码16进制加密异常"),
	/**
	 * 用户不存在
	 */
	user_not_exists(1015 , "用户不存在"),
	/**
	 * token验证用户不存在!
	 */
	token_user_not_exists(1016 , "token验证用户不存在!"),

	/**
	 * 终端不能为空
	 */
	app_null(1017 , "终端不能为空"),
	/**
	 * 手机号不能为空
	 */
	mobile_null(1018 , "手机号不能为空"),
	/**
	 * 用途不能为空
	 */
	use_null(1019 , "用途不能为空"),
	/**
	 * 用户连续错误登陆3次，验证码不能为空
	 */
	user3ErrorLogin_smsCode_null(1020 , "用户连续错误登陆3次，验证码不能为空"),
	/**
	 * 验证码读取错误
	 */
	smsCode_redis_error(1021 , "验证码读取错误！"),
	/**
	 * 验证码超时
	 */
	smsCode_timeOut_error(1022 , "验证码超时！"),
	
	SERVICE_DEFAULT_EXCEPTION;

	private UpmsExceptionEnum() {
		this.code = 500;
		this.message = "服务异常";
	}

	private UpmsExceptionEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	private int code;
	private String message;

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
