package com.appleframework.test;

/**
 * <p>
 * test 异常
 * </p>
 *
 * @package: com.appleframework.test
 * @description: test 异常
 * @author: cruise.xu
 */
class AppleTestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	AppleTestException(String message) {
        super(message);
    }
}
