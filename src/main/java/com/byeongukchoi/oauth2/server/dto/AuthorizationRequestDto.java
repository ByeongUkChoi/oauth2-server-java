package com.byeongukchoi.oauth2.server.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * AuthorizationRequestDto
 */
@Getter
@Setter
public class AuthorizationRequestDto {
    private String grantType;
    private String clientId;
    private String redirectUri;
    private String code;
    private String clientSecret;
    private String refreshToken;
}
