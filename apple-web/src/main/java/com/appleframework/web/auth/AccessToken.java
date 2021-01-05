package com.appleframework.web.auth;

import java.io.Serializable;

/**
 * @author tanghc
 */
public class AccessToken implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 过期时间,毫秒 */
    private long expireTimeMillis;
    private OpenUser openUser;
    private String refreshToken;

    /**
     * @param expireIn 有效时长，秒
     * @param openUser
     */
    public AccessToken(long expireIn, OpenUser openUser) {
        super();
        if(expireIn <= 0) {
            throw new IllegalArgumentException("expireIn必须大于0");
        }
        this.expireTimeMillis = System.currentTimeMillis() + (expireIn * 1000);
        this.openUser = openUser;
    }

    public boolean isExpired() {
        return expireTimeMillis < System.currentTimeMillis();
    }

    public long getExpireTimeMillis() {
        return expireTimeMillis;
    }

    public void setExpireTimeMillis(long expireTimeMillis) {
        this.expireTimeMillis = expireTimeMillis;
    }

    public OpenUser getOpenUser() {
        return openUser;
    }

    public void setOpenUser(OpenUser openUser) {
        this.openUser = openUser;
    }

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
