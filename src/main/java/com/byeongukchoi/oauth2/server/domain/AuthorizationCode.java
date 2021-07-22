package com.byeongukchoi.oauth2.server.domain;

/**
 * AuthorizationCode interface
 */
public interface AuthorizationCode {
    String getCode();

    String getUsername();

    boolean isExpired();

    String getClientId();
}
