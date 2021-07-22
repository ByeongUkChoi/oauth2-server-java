package com.byeongukchoi.oauth2.server.domain.repository;

import com.byeongukchoi.oauth2.server.application.dto.AuthorizationRequestDto;
import com.byeongukchoi.oauth2.server.domain.RefreshToken;

/**
 * RefreshTokenRepository interface
 */
public interface RefreshTokenRepository<T extends RefreshToken, ID> {
    T getNewToken(AuthorizationRequestDto authorizationRequestDto, String accessToken);

    void saveNewToken(T refreshToken);

    RefreshToken findByTokenAndClientId(ID refreshToken, String clientId);

    void expireToken(T refreshToken);
}
