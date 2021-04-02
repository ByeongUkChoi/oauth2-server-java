package com.byeongukchoi.oauth2.server.domain;

/**
 * AccessToken interface
 */
public interface AccessToken {
    public String getToken();
    public Boolean isExpired();
    public int getExpiresIn();
}
