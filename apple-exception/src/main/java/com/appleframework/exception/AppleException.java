/**
 *
 * 日    期：12-2-10
 */
package com.appleframework.exception;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 徐少敏
 * @version 1.0
 */
public class AppleException extends Exception {

	private static final long serialVersionUID = -4379801359412979859L;
	
	public static final String RSP = "rsp.";
	
	public static final String ERROR = "-error:";

    protected String code;

    protected String message;

    protected String solution;
    
    protected String clazz;

    protected Object[] params;

    public AppleException() {
    }
    
    public AppleException(Throwable throwable) {
    	super(throwable);
    }

    public AppleException(String code, Throwable throwable) {
    	super(code, throwable);
    }
    
    public AppleException(String code) {
    	super(code);
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    /**
     * 对服务名进行标准化处理：如book.upload转换为book-upload，
     *
     * @param method
     * @return
     */
    public String transform(String serviceName) {
        if(serviceName != null){
        	serviceName = serviceName.replace(".", "-");
            return serviceName;
        }else{
            return "LACK_SERVICE";
        }
    }
    
	public String getInterfaceName(Class<?> clazz) {
		Class<?>[] clazzs = clazz.getInterfaces();
		if(clazzs.length > 0) {
			return clazzs[0].getName();
		}
		else {
			return clazz.getName();
		}
	}
	
	public String getKey() {
		if(null == clazz)
			return RSP + "." + code;
		else
			return RSP + transform(clazz) + ERROR + code;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

}