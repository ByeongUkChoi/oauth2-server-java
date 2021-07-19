package com.byeongukchoi.oauth2.server.application;

import com.byeongukchoi.oauth2.server.application.dto.AuthorizationRequestDto;
import com.byeongukchoi.oauth2.server.application.dto.TokenDto;
import com.byeongukchoi.oauth2.server.error.exception.OAuth2ServerException;

/**
 * AbstractGrant abstract class
 */
public abstract class AbstractGrant {
    /**
     *
     * @param authorizationRequestDto request Data
     * @return TokenDto
     */
    public abstract TokenDto issueToken(AuthorizationRequestDto authorizationRequestDto) throws OAuth2ServerException;
}
