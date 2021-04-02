package com.byeongukchoi.oauth2.server.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * AuthorizationRequestDto
 */
@Getter
@Setter
@Builder
public class AuthorizationRequestDto {
    private String grantType;
    private String clientId;
    private String username;
    private String redirectUri;
    private String code;
    private String clientSecret;
    private String refreshToken;
}
