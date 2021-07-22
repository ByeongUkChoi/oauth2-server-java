package com.byeongukchoi.oauth2.server.domain.repository;

import com.byeongukchoi.oauth2.server.domain.AuthorizationCode;

/**
 * AuthorizationCodeRepository interface
 */
public interface AuthorizationCodeRepository<T extends AuthorizationCode, ID> {
    T getNewCode(String clientId, String username, String redirectUri);

    T findByCodeAndClientId(String code, String clientId);

    <S extends T> S save(S authorizationCode);

    void expireCode(T authorizationCode);
}
