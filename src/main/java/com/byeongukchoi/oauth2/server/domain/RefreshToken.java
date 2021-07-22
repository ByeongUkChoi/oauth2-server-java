package com.byeongukchoi.oauth2.server.domain;

/**
 * RefreshToken interface
 */
public interface RefreshToken {
    String getToken();

    String getUsername();

    boolean isExpired();

    int getExpiresIn();

    String getClientId();
}
