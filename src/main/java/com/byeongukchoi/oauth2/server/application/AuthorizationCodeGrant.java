package com.byeongukchoi.oauth2.server.application;

import com.byeongukchoi.oauth2.server.application.dto.AuthorizationRequestDto;
import com.byeongukchoi.oauth2.server.application.dto.TokenDto;
import com.byeongukchoi.oauth2.server.domain.AccessToken;
import com.byeongukchoi.oauth2.server.domain.AuthorizationCode;
import com.byeongukchoi.oauth2.server.domain.RefreshToken;
import com.byeongukchoi.oauth2.server.domain.repository.AccessTokenRepository;
import com.byeongukchoi.oauth2.server.domain.repository.AuthorizationCodeRepository;
import com.byeongukchoi.oauth2.server.domain.repository.RefreshTokenRepository;
import com.byeongukchoi.oauth2.server.error.exception.ErrorCode;
import com.byeongukchoi.oauth2.server.error.exception.OAuth2ServerException;

/**
 * AuthorizationCodeGrant
 */
public class AuthorizationCodeGrant extends AbstractGrant {

    private AuthorizationCodeRepository<AuthorizationCode, String> authorizationCodeRepository;
    private AccessTokenRepository<AccessToken, String> accessTokenRepository;
    private RefreshTokenRepository<RefreshToken, String> refreshTokenRepository;

    public AuthorizationCodeGrant(
            AuthorizationCodeRepository<AuthorizationCode, String> authorizationCodeRepository,
            AccessTokenRepository<AccessToken, String> accessTokenRepository,
            RefreshTokenRepository<RefreshToken, String> refreshTokenRepository) {
        this.authorizationCodeRepository = authorizationCodeRepository;
        this.accessTokenRepository = accessTokenRepository;
        this.refreshTokenRepository = refreshTokenRepository;
    }
    /**
     * authorization_code
     *  grant_type, client_id, redirect_uri, code, client_secret
     *  refresh_token
     *  grant_type, client_id, refresh_token, client_secret
     */
    @Override
    public TokenDto issueToken(AuthorizationRequestDto authorizationRequestDto) {
        // 1. verify code and client
        // 1-1. get authorization code
        AuthorizationCode authorizationCode = authorizationCodeRepository.findByCodeAndClientId(authorizationRequestDto.getCode(), authorizationRequestDto.getClientId());
        if(authorizationCode == null) {
            throw new OAuth2ServerException(ErrorCode.NOT_FOUND_AUTHORIZATION_CODE);
        }

        // 1-2. check expired
        if(authorizationCode.isExpired()) {
            throw new OAuth2ServerException(ErrorCode.EXPIRED_AUTHORIZATION_CODE);
        }

        // 2. set username
        authorizationRequestDto.setUsername(authorizationCode.getUsername());

        // 3. create access token & refresh token
        AccessToken accessToken = accessTokenRepository.getNewToken(authorizationRequestDto);
        RefreshToken refreshToken = refreshTokenRepository.getNewToken(authorizationRequestDto, accessToken.getToken());

        // 4. save access token & refresh token
        accessTokenRepository.saveNewToken(accessToken);
        refreshTokenRepository.saveNewToken(refreshToken);

        // 5. create token dto from access token and refresh token
        TokenDto tokenDto = TokenDto.builder()
                .accessToken(accessToken.getToken())
                .expiresIn(accessToken.getExpiresIn())
                .refreshToken(refreshToken.getToken())
                .refreshTokenExpiresIn(refreshToken.getExpiresIn())
                .build();

        // 6. expire authorization code
        authorizationCodeRepository.expireCode(authorizationCode);

        return tokenDto;
    }
}
