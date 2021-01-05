
package com.appleframework.model.page;

import java.io.Serializable;

/**
 * 分页参数传递工具类 .
 * 
 * @author cruise.xu
 */
public class PageParam implements Serializable {

	private static final long serialVersionUID = 5069215312548081707L;

	/**
     * 默认为第一页.
     */
    public static final int DEFAULT_PAGE_NO = 1;

    /**
     * 默认每页记录数(10).
     */
    public static final int DEFAULT_PAGE_SIZE = 10;
    
    /**
     * 针对APP或瀑布流分页模式 =0普通模式 =1瀑布流向下 =2瀑布流向上
     */
    public static final int DEFAULT_PAGE_TYPE = 0; //普通模式

    /**
     * 最大每页记录数(100).
     */
    public static final int MAX_PAGE_SIZE = 100;

    private long pageNo = DEFAULT_PAGE_NO; // 当前页数

    private long pageSize; // 每页记录数
    
    private int pageType = DEFAULT_PAGE_TYPE; // 上拉下滑

    private long startIndex; // 瀑布流模式分页的索引下标

    /**
     * 默认构造函数
     */
    public PageParam(){}

    /**
     * 带参数的构造函数
     * @param pageNo
     * @param pageSize
     */
    public PageParam(long pageNo , long pageSize){
    	this.pageNo = pageNo;
    	this.pageSize = pageSize;
    }
    
    /**
     * 带参数的构造函数
     * @param pageNo
     * @param pageSize
     */
    public PageParam(long pageNo , long pageSize, int pageType, long startIndex){
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.pageType = pageType;
		this.startIndex = startIndex;
    }

    /** 当前页数 */
    public long getPageNo() {
        return pageNo;
    }

    /** 当前页数 */
    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    /** 每页记录数 */
    public long getPageSize() {
        return pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
    }

    /** 每页记录数 */
    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

	public int getPageType() {
		return pageType;
	}

	public void setPageType(int pageType) {
		this.pageType = pageType;
	}

	public long getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(long startIndex) {
		this.startIndex = startIndex;
	}

}
