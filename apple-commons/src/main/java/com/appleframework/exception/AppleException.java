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
 * @author cruise.xu
 * @version 1.0
 */
public class AppleException extends RuntimeException {

	private static final long serialVersionUID = -4379801359412979859L;
	
	public static final String SVC = "svc.";
	
	public static final String ERROR = "-error:";

	protected Integer code;

    protected String msg;

    protected String solution;
    
    protected String clazz;

    protected Object[] params;

    public AppleException() {
    }
    
    public AppleException(Throwable throwable) {
    	super(throwable);
    }
    
    public AppleException(String msg, Throwable throwable) {
    	super(msg, throwable);
    	this.msg = msg;
    }

	public AppleException(Integer code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	public AppleException(Integer code, String msg, Throwable throwable) {
		super(msg, throwable);
		this.code = code;
		this.msg = msg;
	}
    
    public AppleException(String msg) {
    	super(msg);
    	this.msg = msg;
    }

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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
     * @param serviceName
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
			return SVC + "." + code;
		else
			return SVC + transform(clazz) + ERROR + code;
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