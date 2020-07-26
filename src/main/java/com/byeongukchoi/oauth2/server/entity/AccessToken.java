package com.byeongukchoi.oauth2.server.entity;

/**
 * AccessToken interface
 */
public interface AccessToken {
    public String getToken();
    public Boolean isExpired();
}
