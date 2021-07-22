package com.byeongukchoi.oauth2.server.application.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * AuthorizationRequestDto
 */
@Getter
public class AuthorizationRequestDto {
    private String grantType;
    private String clientId;
    @Setter
    private String username;
    private String redirectUri;
    private String code;
    private String clientSecret;
    private String refreshToken;
}
