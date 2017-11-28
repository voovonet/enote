package net.voovo.enote.exception;

/**
 * 公共错误信息枚举，定义固定为3位长度。
 */
public enum CommonExceptionEnum {
	
	/**
	 * token不能空！
	 */
	token_null(101 , "token不能空！"),
	/**
	 * appId或userId为空!
	 */
	appId_or_userId_null(102 , "appId或userId为空!"),
	/**
	 * token已经过期
	 */
	token_expired(103 , "token已经过期!"),	
	/**
	 * 登陆源变更，需要重新登陆！
	 */
	source_changed(104 , "登陆源变更，需要重新登陆！"),
	
	/**
	 * 登陆用户Id异常
	 */
	userId_error(105 , "登陆用户Id异常!"),
	/**
	 * 设备号发生变更，需要重新登陆
	 */
	appId_changed(106 , "设备号发生变更，需要重新登陆"),
	/**
	 * 用户小区权限为空
	 */
	user_community_null(107 , "用户小区权限为空！"),
	/**
	 * 必填超级系统管理员权限
	 */
	must_be_power_admin(108 , "必填超级系统管理员权限！"),
	/**
	 * 必填系统管理员权限
	 */
	must_be_admin(109 , "必填系统管理员权限！"),
	/**
	 * 必填区长权限
	 */
	must_be_manager(110 , "必填区长权限！"),
	/**
	 * 必填城主权限
	 */
	must_be_cityManager(111 , "必填城主权限！"),
	/**
	 * 必填物流员权限
	 */
	must_be_logisticsManager(112 , "必填物流员权限！"),
	/**
	 * 必填物业管理处权限
	 */
	must_be_propertyManager(113 , "必填物业管理处权限！"),
	
	SERVICE_DEFAULT_EXCEPTION;

	private CommonExceptionEnum() {
		this.code = 500;
		this.message = "服务异常";
	}

	private CommonExceptionEnum(int code, String message) {
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
