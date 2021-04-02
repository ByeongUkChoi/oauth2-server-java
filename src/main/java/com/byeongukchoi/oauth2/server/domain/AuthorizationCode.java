package com.byeongukchoi.oauth2.server.domain;

/**
 * AuthorizationCode interface
 */
public interface AuthorizationCode {
    public String getCode();
    public String getUsername();
    public Boolean isExpired();
    public String getClientId();
}
