package com.byeongukchoi.oauth2.server.application;

import com.byeongukchoi.oauth2.server.application.dto.AuthorizationRequestDto;
import com.byeongukchoi.oauth2.server.application.dto.TokenDto;

/**
 * AbstractGrant abstract class
 */
public abstract class AbstractGrant {
    /**
     *
     * @param authorizationRequestDto request Data
     * @return TokenDto
     * @throws Exception throw exception
     */
    public abstract TokenDto issueToken(AuthorizationRequestDto authorizationRequestDto) throws Exception;
}
