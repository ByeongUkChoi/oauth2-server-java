package com.cbw0916.oauth2.server.repository;

import com.cbw0916.oauth2.server.entity.AccessToken;

public interface AccessTokenRepository {
    public AccessToken getNewToken();
    public void saveNewToken(AccessToken accessToken);
}
