package com.appleframework.exception;


/**
 * Base class for all custom exception thrown in AppleFramework
 * 
 * @author Cruise.Xu
 * @date: 2012-10-15
 *
 */
@Deprecated
public class DAOException extends AppleException {
	
	/**
     * uid used for serialization
     */
	private static final long serialVersionUID = 7696865849245536841L;
	
	/**
	 * 数据库操作,insert返回0
	 */
	public static final DAOException DB_INSERT_ERROR = new DAOException(9901, "数据库操作,insert返回0"); //INSET_ERROR

	/**
	 * 数据库操作,update返回0
	 */
	public static final DAOException DB_UPDATE_ERROR = new DAOException(9902, "数据库操作,update返回0"); //UPDATE_ERROR

	/**
	 * 数据库操作,selectOne返回null
	 */
	public static final DAOException DB_SELECTONE_IS_NULL = new DAOException(9903, "数据库操作,selectOne返回null"); //SELECTONE_IS_NULL

	/**
	 * 数据库操作,list返回null
	 */
	public static final DAOException DB_LIST_IS_NULL = new DAOException(9904, "数据库操作,list返回null"); //LIST_IS_NULL

    /**
     * 生成序列异常时
     */
    public static final DAOException DB_GET_SEQ_NEXT_VALUE_ERROR = new DAOException(9905, "序列生成超时"); //GET_SEQ_NEXT_VALUE_ERROR
	
    
    public DAOException(Integer code, String messageFormat, Object... args) {
        super(String.format(messageFormat, args));
        this.code = code;
        this.msg = String.format(messageFormat, args);
    }

    public DAOException() {
        super();
    }

    public DAOException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String msg) {
        super(msg);
    }

    /**
     * 实例化异常
     * 
     * @param messageFormat
     * @param args
     * @return
     */
    public DAOException newInstance(String messageFormat, Object... args) {
        return new DAOException(this.code, messageFormat, args);
    }
	
}

