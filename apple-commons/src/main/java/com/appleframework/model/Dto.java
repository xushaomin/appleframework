package com.appleframework.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.appleframework.model.page.Pagination;

/**
 * 数据传输对象接口<br>
 * @author cruise.xu
 * @since 2011-05-03
 * @see Map
 */
public interface Dto extends Map<String, Object> {
	
	/**
	 * 以Boolean类型返回键值
	 * @param key 键名
	 * @return Integer 键值
	 */
	public Boolean getAsBoolean(String key);
	
	/**
	 * 以Integer类型返回键值
	 * @param key 键名
	 * @return Integer 键值
	 */
    public Integer getAsInteger(String pStr);
    
	/**
	 * 以Long类型返回键值
	 * @param key 键名
	 * @return Long 键值
	 */
    public Long getAsLong(String pStr);
    
	/**
	 * 以String类型返回键值
	 * @param key 键名
	 * @return String 键值
	 */
    public String getAsString(String pStr);
    
	/**
	 * 取出属性值
     * @param pStr 属性Key
     * @return Integer
	 */
    public BigDecimal getAsBigDecimal(String pStr);
    
	/**
	 * 取出属性值
     * @param pStr:属性Key
     * @return Integer
	 */
    public java.util.Date getAsDate(String pStr);
    
    /**
	 * 取出属性值
     * @param pStr:属性Key
     * @return Integer
	 */
    public java.sql.Date getAsSqlDate(String pStr);
    
	/**
	 * 以Timestamp类型返回键值
	 * @param key 键名
	 * @return Timestamp 键值
	 */
    public Timestamp getAsTimestamp(String pStr);
    
	/**
	 * 给Dto压入第一个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * @param pList 压入Dto的List对象
	 */
    public void setDefaultAList(List<?> pList);
    
	/**
	 * 给Dto压入第二个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * @param pList 压入Dto的List对象
	 */
    public void setDefaultBList(List<?> pList);
    
	/**
	 * 获取第一个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * @param pList 压入Dto的List对象
	 */
    public List<?> getDefaultAList();
    
	/**
	 * 获取第二个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * @param pList 压入Dto的List对象
	 */
    public List<?> getDefaultBList();
        
	/**
	 * 存储过程返回代码值<br>
	 * 在SQLMAP中定义的出参字段必须定义为code
	 * 
	 * @return
	 */
	public String getCode();
	
	/**
	 * 给Dto压入第一个状态<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param code
	 *            压入Dto的code对象
	 */
	public void setCode(String code);
    	
	/**
	 * 给Dto压入第一个默认PO对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param BO
	 *            压入Dto的BO对象
	 */
	public void setDefaultBo(Object bo);

	/**
	 * 获取第一个默认BO对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * @param BO 压入Dto的PO对象
	 */
	public Object getDefaultBo();
	
	/**
	 * 给Pagination压入第一个默认Pagination对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param Pagination
	 *            压入Dto的Pagination对象
	 */
	public void setDefaultPage(Pagination page);

	/**
	 * 获取第一个默认Pagination对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * @param Pagination 压入Pagination的PO对象
	 */
	public Pagination getDefaultPage();
	
	/**
	 * 给Operator压入第一个默认Operator对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param Operator
	 *            压入Dto的Operator对象
	 */
	public void setDefaultOperator(Operator operator);

	/**
	 * 获取第一个默认Operator对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * @param Operator 压入Operator的PO对象
	 */
	public Operator getDefaultOperator();	
	
	
	/**
	 * 给ids压入第一个默认ids对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param ids
	 *            压入Dto的ids对象
	 */
	public void setDefaultIds(String ids);

	/**
	 * 获取第一个默认ids对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * @param ids 压入ids的String
	 */
	public String getDefaultIds();
	
	
	/**
	 * 给id压入第一个默认id对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param id
	 *            压入Dto的id对象
	 */
	public void setDefaultId(Object id);

	/**
	 * 获取第一个默认id对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * @param id 压入id的PO对象
	 */
	public Object getDefaultId();
	
	/**
	 * 给id压入第一个默认status对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param status
	 *            压入Dto的status对象
	 */
	public void setDefaultStatus(Object status);

	/**
	 * 获取第一个默认status对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * @param status 压入status的PO对象
	 */
	public Object getDefaultStatus();
	
	public void setDefaultLocale(Locale locale);

	public Locale getDefaultLocale();
	
	//
	public void addParameters(Object... pairs);
	
	/**
	 * Add parameters to a new dto.
	 * 
	 * @param parameters
	 * @return A new URL 
	 */
    public void addParameters(Map<String, Object> parameters);
    
    public void addParameters(String key, Object value);
    
    public Object getParameter(String key);

    public String getParameter(String key, String defaultValue);
    
    public double getParameter(String key, double defaultValue);
    
    public float getParameter(String key, float defaultValue);

    public long getParameter(String key, long defaultValue);

    public int getParameter(String key, int defaultValue);

    public short getParameter(String key, short defaultValue);

    public byte getParameter(String key, byte defaultValue);
    
    public boolean getParameter(String key, boolean defaultValue);
	
}
