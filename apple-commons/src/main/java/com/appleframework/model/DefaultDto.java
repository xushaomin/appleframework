package com.appleframework.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.appleframework.model.page.Pagination;
import com.appleframework.utils.TypeCaseHelper;

/**
 * 数据传输对象(DateTransferObject)<br>
 * 建议在参数传递过程中尽量使用Dto来传递<br>
 * 
 * @author cruise.xu
 * @since 2011-05-03
 * @see Dto
 * @see Serializable
 */
@XmlType(name = "Dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class DefaultDto extends HashMap<String, Object> implements Dto, Serializable {

	private static final long serialVersionUID = 6654280697600536538L;

	public DefaultDto() {
	}

	public DefaultDto(String key, Object value) {
		put(key, value);
	}

	/**
	 * 以BigDecimal类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return BigDecimal 键值
	 */
	public BigDecimal getAsBigDecimal(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "BigDecimal", null);
		if (obj != null)
			return (BigDecimal) obj;
		else
			return null;
	}

	/**
	 * 以Date类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Date 键值
	 */
	public java.util.Date getAsDate(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Date", "yyyy-MM-dd HH:mm:ss");
		if (obj != null)
			return (java.util.Date) obj;
		else
			return null;
	}
	
	/**
	 * 以Date类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Date 键值
	 */
	public java.sql.Date getAsSqlDate(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "SqlDate", "yyyy-MM-dd");
		if (obj != null)
			return (java.sql.Date) obj;
		else
			return null;
	}

	/**
	 * 以Integer类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Integer 键值
	 */
	public Integer getAsInteger(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Integer", null);
		if (obj != null)
			return (Integer) obj;
		else
			return null;
	}
	
	/**
	 * 以Boolean类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Integer 键值
	 */
	public Boolean getAsBoolean(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Boolean", null);
		if (obj != null)
			return (Boolean) obj;
		else
			return null;
	}

	/**
	 * 以Long类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Long 键值
	 */
	public Long getAsLong(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Long", null);
		if (obj != null)
			return (Long) obj;
		else
			return null;
	}

	/**
	 * 以String类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return String 键值
	 */
	public String getAsString(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "String", null);
		if (obj != null)
			return (String) obj;
		else
			return "";
	}

	/**
	 * 以Timestamp类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Timestamp 键值
	 */
	public Timestamp getAsTimestamp(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Timestamp",
				"yyyy-MM-dd HH:mm:ss");
		if (obj != null)
			return (Timestamp) obj;
		else
			return null;
	}

	/**
	 * 给Dto压入第一个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param pList
	 *            压入Dto的List对象
	 */
	public void setDefaultAList(List<?> pList) {
		put("defaultAList", pList);
	}

	/**
	 * 给Dto压入第二个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param pList
	 *            压入Dto的List对象
	 */
	public void setDefaultBList(List<?> pList) {
		put("defaultBList", pList);
	}

	/**
	 * 获取第一个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param pList
	 *            压入Dto的List对象
	 */
	public List<?> getDefaultAList() {
		return (List<?>) get("defaultAList");
	}

	/**
	 * 获取第二个默认List对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param pList
	 *            压入Dto的List对象
	 */
	public List<?> getDefaultBList() {
		return (List<?>) get("defaultBList");
	}

	/**
	 * 给Dto压入第一个默认PO对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param PO
	 *            压入Dto的PO对象
	 */
	public void setDefaultBo(Object po) {
		put("defaultBo", po);
	}

	/**
	 * 获取第一个默认PO对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param PO
	 *            压入Dto的PO对象
	 */
	public Object getDefaultBo() {
		return get("defaultBo");
	}

	/**
	 * 给Pagination压入第一个默认Pagination对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param Pagination
	 *            压入Dto的Pagination对象
	 */
	public void setDefaultPage(Pagination page) {
		put("defaultPage", page);
	}

	/**
	 * 获取第一个默认Pagination对象<br>
	 * 为了方便存取(省去根据Key来存取和类型转换的过程)
	 * 
	 * @param Pagination
	 *            压入Pagination的PO对象
	 */
	public Pagination getDefaultPage() {
		return (Pagination) get("defaultPage");
	}

	@Override
	public void setDefaultOperator(Operator operator) {
		put("defaultOperator", operator);
	}

	@Override
	public Operator getDefaultOperator() {
		return (Operator) get("defaultOperator");
	}
	
	@Override
	public void setDefaultLocale(Locale locale) {
		put("defaultLocale", locale);
	}

	@Override
	public Locale getDefaultLocale() {
		Object object = get("defaultLocale");
		if(null == object)
			return Locale.CHINA;
		else
			return (Locale)object;
	}
	

	@Override
	public String getCode() {
		return (String) get("defaultCode");
	}

	@Override
	public void setCode(String code) {
		put("defaultCode", code);
	}

	@Override
	public void setDefaultIds(String ids) {
		put("defaultIds", ids);
	}

	@Override
	public String getDefaultIds() {
		return (String) get("defaultIds");
	}

	@Override
	public void setDefaultId(Object id) {
		put("defaultId", id);
	}

	@Override
	public Object getDefaultId() {
		return get("defaultId");
	}
	
	
	@Override
	public void setDefaultStatus(Object status) {
		put("defaultStatus", status);
	}

	@Override
	public Object getDefaultStatus() {
		return get("defaultStatus");
	}
	
	/**
	 * 给定一个分页对象，创建查询对象<br>
	 * 
	 * @param page
	 *            QueryPage
	 */
	public static DefaultDto create(Pagination page) {
		DefaultDto dto = new DefaultDto();
		dto.setDefaultPage(page);
		return dto;
	}
	
	public static DefaultDto create() {
		DefaultDto dto = new DefaultDto();
		return dto;
	}
	
	public static DefaultDto create(Pagination page, Map<String, Object> params) {
		DefaultDto dto = new DefaultDto();
		dto.setDefaultPage(page);
		dto.putAll(params);
		return dto;
	}
	
	public static DefaultDto create(Object... pairs) {
		DefaultDto dto = new DefaultDto();
		dto.addParameters(pairs);
		return dto;
	}
	
	public static DefaultDto create(Map<String, Object> params) {
		DefaultDto dto = new DefaultDto();
		if (params != null && params.size() > 0) {
			dto.putAll(params);
        }
		return dto;
	}
	
	public void addParameters(Object... pairs) {
        if (pairs == null || pairs.length == 0) {
            return;
        }
        if (pairs.length % 2 != 0) {
            throw new IllegalArgumentException("Map pairs can not be odd number.");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        int len = pairs.length / 2;
        for (int i = 0; i < len; i ++) {
            map.put((String)pairs[2 * i], pairs[2 * i + 1]);
        }
        putAll(map);
    }
	
	/**
	 * Add parameters to a new url.
	 * 
	 * @param parameters
	 * @return A new URL 
	 */
    public void addParameters(Map<String, Object> parameters) {
        if (parameters == null || parameters.size() == 0) {
            return;
        }
        putAll(parameters);
    }
    
    @Override
	public void addParameters(String key, Object value) {
		put(key, value);
	}

	public Object getParameter(String key) {
        return get(key);
    }

    public String getParameter(String key, String defaultValue) {
        Object value = getParameter(key);
        if (value == null) {
            return defaultValue;
        }
        return String.valueOf(value);
    }
    
    public double getParameter(String key, double defaultValue) {
        Object value = getParameter(key);
        if (value == null) {
            return defaultValue;
        }
        return (Double)value;
    }
    
    public float getParameter(String key, float defaultValue) {
        Object value = getParameter(key);
        if (value == null) {
            return defaultValue;
        }
        return (Float)value;
    }

    public long getParameter(String key, long defaultValue) {
        Object value = getParameter(key);
        if (value == null) {
            return defaultValue;
        }
        return (Long)value;
    }

    public int getParameter(String key, int defaultValue) {
        Object value = getParameter(key);
        if (value == null) {
            return defaultValue;
        }
        return (Integer)value;
    }

    public short getParameter(String key, short defaultValue) {
        Object value = getParameter(key);
        if (value == null) {
            return defaultValue;
        }
        return (Short)value;
    }

    public byte getParameter(String key, byte defaultValue) {
        Object value = getParameter(key);
        if (value == null) {
            return defaultValue;
        }
        return (Byte)value;
    }
    
    public boolean getParameter(String key, boolean defaultValue) {
        Object value = getParameter(key);
        if (value == null) {
            return defaultValue;
        }
        return (Boolean)value;
    }

}
