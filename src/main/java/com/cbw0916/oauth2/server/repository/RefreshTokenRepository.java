package com.cbw0916.oauth2.server.repository;

import com.cbw0916.oauth2.server.entity.RefreshToken;

public interface RefreshTokenRepository {
    public RefreshToken getNewToken();
    public void saveNewToken(RefreshToken refreshToken);

    public RefreshToken findByTokenAndClientId(String refreshToken, String clientId);
}
