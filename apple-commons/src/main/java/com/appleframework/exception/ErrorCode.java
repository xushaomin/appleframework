package com.appleframework.exception;

/**
 * 异常码定义类
 * <p>
 * 业务异常使用异常码定义，不要创建多个业务异常类
 * </p>
 */
public interface ErrorCode {

	/**
	 * 返回结果码英文简写
	 * <p>
	 * 结果码英文简写不能为空。 结果码应该规范化，由'svc'+业务前缀 +
	 * 结果码组成'，比如账号中心，业务前缀定义为'svc.acenter_login_fail'
	 *
	 * @return 结果码
	 */
	Integer getCode();

	/**
	 * 返回描述
	 * <p>
	 * 可以为空，描述仅用于日志，给用户提示的文案应该在配置文件中定义，防止修改文案还需要修改代码
	 *
	 * @return 描述
	 */
	String getMsg();

}
