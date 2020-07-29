package com.byeongukchoi.oauth2.server.repository;

import com.byeongukchoi.oauth2.server.entity.Client;

/**
 * ClientRepository interface
 */
public interface ClientRepository {
    public Client findById(String clientId);
}
