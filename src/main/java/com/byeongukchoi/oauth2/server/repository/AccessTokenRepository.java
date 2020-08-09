package com.byeongukchoi.oauth2.server.repository;

import com.byeongukchoi.oauth2.server.dto.AuthorizationRequestDto;

/**
 * AccessTokenRepository interface
 */
public interface AccessTokenRepository<T, ID> {
    public T getNewToken(AuthorizationRequestDto authorizationRequestDto);
    public void saveNewToken(T accessToken);
}
