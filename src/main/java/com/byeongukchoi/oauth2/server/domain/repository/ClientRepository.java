package com.byeongukchoi.oauth2.server.domain.repository;

import com.byeongukchoi.oauth2.server.domain.Client;

/**
 * ClientRepository interface
 */
public interface ClientRepository<T extends Client, ID> {
    T getOne(ID id);
//    T getNewCient(String name, String redirectUri, String username, boolean isClientSecret);
}
