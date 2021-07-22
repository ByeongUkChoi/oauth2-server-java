package com.byeongukchoi.oauth2.server.domain;

/**
 * AccessToken interface
 */
public interface AccessToken {
    String getToken();

    boolean isExpired();

    int getExpiresIn();
}
