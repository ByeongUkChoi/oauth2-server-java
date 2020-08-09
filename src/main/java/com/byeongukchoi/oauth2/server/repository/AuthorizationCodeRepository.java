package com.byeongukchoi.oauth2.server.repository;

/**
 * AuthorizationCodeRepository interface
 */
public interface AuthorizationCodeRepository<T, ID> {
    public T getNewCode(String clientId, String username, String redirectUri);
    public T findByCodeAndClientId(String code, String clientId);
    public T save(T authorizationCode);
    public void expireCode(T authorizationCode);
}
