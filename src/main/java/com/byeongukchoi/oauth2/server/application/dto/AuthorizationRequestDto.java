package com.byeongukchoi.oauth2.server.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
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

    @Builder
    public AuthorizationRequestDto(@NonNull String clientId, @NonNull String redirectUri, @NonNull String username) {
        this.clientId = clientId;
        this.redirectUri = redirectUri;
        this.username = username;
    }

    @Builder
    public AuthorizationRequestDto(@NonNull String grantType,
                                   @NonNull String clientId,
                                   @NonNull String redirectUri,
                                   @NonNull String code,
                                   @NonNull String refreshToken,
                                   @NonNull String clientSecret) {
        this.grantType = grantType;
        this.clientId = clientId;
        this.redirectUri = redirectUri;
        this.code = code;
        this.refreshToken = refreshToken;
        this.clientSecret = clientSecret;
    }
}
