package com.byeongukchoi.oauth2.server.domain.repository;

import com.byeongukchoi.oauth2.server.application.dto.AuthorizationRequestDto;
import com.byeongukchoi.oauth2.server.domain.AccessToken;

/**
 * AccessTokenRepository interface
 */
public interface AccessTokenRepository<T extends AccessToken, ID> {
    public T getNewToken(AuthorizationRequestDto authorizationRequestDto);
    public void saveNewToken(T accessToken);
}
