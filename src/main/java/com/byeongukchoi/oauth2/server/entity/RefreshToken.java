package com.byeongukchoi.oauth2.server.entity;

/**
 * RefreshToken interface
 */
public interface RefreshToken {
    public String getToken();
    public String getUsername();
    public Boolean isExpired();
    public int getExpiresIn();
}
