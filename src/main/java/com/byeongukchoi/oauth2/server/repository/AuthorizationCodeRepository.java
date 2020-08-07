package com.byeongukchoi.oauth2.server.repository;

import com.byeongukchoi.oauth2.server.entity.AuthorizationCode;

/**
 * AuthorizationCodeRepository interface
 */
public interface AuthorizationCodeRepository {
    public AuthorizationCode getNewCode(String clientId, String username, String redirectUri);
    public AuthorizationCode findByCodeAndClientId(String code, String clientId);
    public void save(AuthorizationCode authorizationCode);
}
