package com.byeongukchoi.oauth2.server.repository;

import com.byeongukchoi.oauth2.server.entity.AccessToken;

/**
 * AccessTokenRepository interface
 */
public interface AccessTokenRepository {
    public AccessToken getNewToken(String clientId, String username);
    public void saveNewToken(AccessToken accessToken);
}
