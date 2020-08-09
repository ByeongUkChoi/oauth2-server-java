package com.byeongukchoi.oauth2.server.repository;

import com.byeongukchoi.oauth2.server.entity.AuthorizationCode;

/**
 * AuthorizationCodeRepository interface
 */
public interface AuthorizationCodeRepository<T extends AuthorizationCode, ID> {
    public T getNewCode(String clientId, String username, String redirectUri);
    public T findByCodeAndClientId(String code, String clientId);
    public <S extends T> S save(S authorizationCode);
    public void expireCode(T authorizationCode);
}
