package com.byeongukchoi.oauth2.server.domain;

/**
 * RefreshToken interface
 */
public interface RefreshToken {
    public String getToken();
    public String getUsername();
    public Boolean isExpired();
    public int getExpiresIn();
    public String getClientId();
}
