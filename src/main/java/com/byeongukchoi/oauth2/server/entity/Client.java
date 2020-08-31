package com.byeongukchoi.oauth2.server.entity;

import com.byeongukchoi.oauth2.server.dto.AuthorizationRequestDto;

/**
 * Client interface
 */
public interface Client {
    public boolean verifyClient(AuthorizationRequestDto authorizationRequestDto);
}
