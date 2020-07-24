package com.cbw0916.oauth2.server.repository;

import com.cbw0916.oauth2.server.entity.RefreshToken;

public interface RefreshTokenRepository {
    public RefreshToken getNewToken();
}
