package com.byeongukchoi.oauth2.server.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Access Token
 * Kv2gk5ZV3Hpc2En6KGeu0No9CvzcEDl9yM6Q3Qo9c04AAAFzZLkR5w
 * Token Type
 * bearer
 * refresh_token
 * EFTBp9nZvlKhFynuFbaxkh8UHJwLbI7oFhAUhAo9c04AAAFzZLkR5g
 * expires_in
 * 21599
 * scope
 * profile
 * refresh_token_expires_in
 * 5183999
 */
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TokenDto {
    private String tokenType;
    private String accessToken;
    @Setter
    private int expiresIn;
    private String refreshToken;
    @Setter
    private int refreshTokenExpiresIn;
    private String scope;

    @Builder
    public TokenDto(String tokenType,
                    @NonNull String accessToken,
                    int expiresIn,
                    @NonNull String refreshToken,
                    int refreshTokenExpiresIn) {
        this.tokenType = tokenType;
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
        this.refreshTokenExpiresIn = refreshTokenExpiresIn;
    }
}
