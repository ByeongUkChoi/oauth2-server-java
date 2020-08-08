package com.byeongukchoi.oauth2.server.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

/**
 *
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
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TokenDto {
    private String tokenType;
    private String accessToken;
    private int expiresIn;
    private String refreshToken;
    private int refreshTokenExpiresIn;
    private String scope;
}
