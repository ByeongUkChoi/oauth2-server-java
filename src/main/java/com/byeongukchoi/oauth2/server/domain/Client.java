package com.byeongukchoi.oauth2.server.domain;

import com.byeongukchoi.oauth2.server.application.dto.AuthorizationRequestDto;

/**
 * Client interface
 */
public interface Client {
    boolean verifyClient(AuthorizationRequestDto authorizationRequestDto);
}
