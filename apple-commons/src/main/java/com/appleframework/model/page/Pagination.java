package com.appleframework.model.page;

import java.util.List;

/**
 * 列表分页。包含list属性。
 * 
 * @author cruise.xu
 * 
 */
public class Pagination extends SimplePage implements java.io.Serializable, Paginable {

	private static final long serialVersionUID = 1385145241579184848L;
	
	public static Pagination create() {
		return new Pagination();
	}
	
	public static Pagination create(long pageNo, long pageSize) {
		return new Pagination(pageNo, pageSize);
	}
	
	public static Pagination create(long pageNo, long pageSize, long totalCount) {
		return new Pagination(pageNo, pageSize, totalCount);
	}
	
	public static Pagination create(long pageNo, long pageSize, long totalCount, List<?> list) {
		return new Pagination(pageNo, pageSize, totalCount, list);
	}

	public Pagination() {
	}
	
	/**
	 * 构造器
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 */
	public Pagination(long pageNo, long pageSize) {
		super(pageNo, pageSize);
	}

	/**
	 * 构造器
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 */
	public Pagination(long pageNo, long pageSize, long totalCount) {
		super(pageNo, pageSize, totalCount);
	}

	/**
	 * 构造器
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 * @param list
	 *            分页内容
	 */
	public Pagination(long pageNo, long pageSize, long totalCount, List<?> list) {
		super(pageNo, pageSize, totalCount);
		this.list = list;
	}

	/**
	 * 当前页的数据
	 */
	private List<?> list;
	
	/**
	 * 获得分页内容
	 * 
	 * @return
	 */
	public List<?> getList() {
		return list;
	}

	/**
	 * 设置分页内容
	 * 
	 * @param list
	 */
	public void setList(List<?> list) {
		this.list = list;
	}
	
	
	/**
	 * 当前页几条数据
	 */
	public long getPageCount() {
		if(null != list)
			return list.size();
		else
			return 0;
	}
	
}
