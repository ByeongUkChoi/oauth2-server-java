package com.cbw0916.oauth2.server.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class AuthorizationRequestDto {
    private String grantType;
    private String clientId;
    private String redirectUri;
    private String code;
    private String clientSecret;
    private String refreshToken;
}
