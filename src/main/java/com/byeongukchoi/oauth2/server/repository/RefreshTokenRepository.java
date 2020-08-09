package com.byeongukchoi.oauth2.server.repository;

import com.byeongukchoi.oauth2.server.dto.AuthorizationRequestDto;
import com.byeongukchoi.oauth2.server.entity.RefreshToken;

/**
 * RefreshTokenRepository interface
 */
public interface RefreshTokenRepository<T extends RefreshToken, ID> {
    public T getNewToken(AuthorizationRequestDto authorizationRequestDto, String accessToken);
    public void saveNewToken(T refreshToken);
    public RefreshToken findByTokenAndClientId(ID refreshToken, String clientId);
    public void expireToken(T refreshToken);
}
