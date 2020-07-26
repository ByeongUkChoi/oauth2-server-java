package com.byeongukchoi.oauth2.server.entity;

/**
 * RefreshToken interface
 */
public interface RefreshToken {
    public String getToken();
    public Boolean isExpired();
}
