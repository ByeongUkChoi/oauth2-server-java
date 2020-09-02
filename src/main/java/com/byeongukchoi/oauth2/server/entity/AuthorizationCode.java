package com.byeongukchoi.oauth2.server.entity;

/**
 * AuthorizationCode interface
 */
public interface AuthorizationCode {
    public String getCode();
    public String getUsername();
    public Boolean isExpired();
    public String getClientId();
}
