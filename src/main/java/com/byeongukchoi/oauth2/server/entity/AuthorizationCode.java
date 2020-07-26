package com.byeongukchoi.oauth2.server.entity;

/**
 * AuthorizationCode interface
 */
public interface AuthorizationCode {
    public String getCode();
    public Boolean isExpired();
}
