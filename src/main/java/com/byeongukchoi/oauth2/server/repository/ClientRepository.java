package com.byeongukchoi.oauth2.server.repository;

/**
 * ClientRepository interface
 */
public interface ClientRepository<T, ID> {
    public T getOne(ID id);
}
