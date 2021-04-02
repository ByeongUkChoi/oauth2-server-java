package com.byeongukchoi.oauth2.server.domain.repository;

import com.byeongukchoi.oauth2.server.application.dto.AuthorizationRequestDto;
import com.byeongukchoi.oauth2.server.domain.RefreshToken;

/**
 * RefreshTokenRepository interface
 */
public interface RefreshTokenRepository<T extends RefreshToken, ID> {
    public T getNewToken(AuthorizationRequestDto authorizationRequestDto, String accessToken);
    public void saveNewToken(T refreshToken);
    public RefreshToken findByTokenAndClientId(ID refreshToken, String clientId);
    public void expireToken(T refreshToken);
}
