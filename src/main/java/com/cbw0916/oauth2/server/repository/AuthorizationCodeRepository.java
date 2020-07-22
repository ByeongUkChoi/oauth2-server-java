package com.cbw0916.oauth2.server.repository;

import com.cbw0916.oauth2.server.entity.AuthorizationCode;

public interface AuthorizationCodeRepository {
    public AuthorizationCode getNewAuthorizationCode();
}
