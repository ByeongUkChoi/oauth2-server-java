package com.byeongukchoi.oauth2.server.domain.repository;

import com.byeongukchoi.oauth2.server.application.dto.AuthorizationRequestDto;
import com.byeongukchoi.oauth2.server.domain.AccessToken;

/**
 * AccessTokenRepository interface
 */
public interface AccessTokenRepository<T extends AccessToken, ID> {
    T getNewToken(AuthorizationRequestDto authorizationRequestDto);

    void saveNewToken(T accessToken);
}
