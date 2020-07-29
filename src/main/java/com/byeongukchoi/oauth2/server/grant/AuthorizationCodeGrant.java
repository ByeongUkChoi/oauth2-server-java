package com.byeongukchoi.oauth2.server.grant;

import com.byeongukchoi.oauth2.server.repository.AccessTokenRepository;
import com.byeongukchoi.oauth2.server.dto.AuthorizationRequestDto;
import com.byeongukchoi.oauth2.server.dto.TokenDto;
import com.byeongukchoi.oauth2.server.entity.AccessToken;
import com.byeongukchoi.oauth2.server.entity.AuthorizationCode;
import com.byeongukchoi.oauth2.server.entity.RefreshToken;
import com.byeongukchoi.oauth2.server.repository.AuthorizationCodeRepository;
import com.byeongukchoi.oauth2.server.repository.RefreshTokenRepository;

/**
 * AuthorizationCodeGrant
 */
public class AuthorizationCodeGrant extends AbstractGrant {

    private AuthorizationCodeRepository authorizationCodeRepository;
    private AccessTokenRepository accessTokenRepository;
    private RefreshTokenRepository refreshTokenRepository;

    public AuthorizationCodeGrant(
            AuthorizationCodeRepository authorizationCodeRepository,
            AccessTokenRepository accessTokenRepository,
            RefreshTokenRepository refreshTokenRepository) {
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
    public TokenDto issueToken(AuthorizationRequestDto authorizationRequestDto) throws Exception {
        // 1. verify code and client
        // 1-1. get authorization code
        AuthorizationCode authorizationCode = authorizationCodeRepository.findByCodeAndClientId(authorizationRequestDto.getCode(), authorizationRequestDto.getClientId());
        if(authorizationCode == null) {
            throw new Exception("Not Found Code");
        }

        // 1-2. check expired
        if(authorizationCode.isExpired()) {
            throw new Exception("Expired Code");
        }

        // TODO: 1-3. verify client secret
        // TODO: client.verifyClientSecret();

        // 2. create access token & refresh token
        AccessToken accessToken = accessTokenRepository.getNewToken();
        RefreshToken refreshToken = refreshTokenRepository.getNewToken();

        // 3. save access token & refresh token
        accessTokenRepository.saveNewToken(accessToken);
        refreshTokenRepository.saveNewToken(refreshToken);

        // 4. return token dto from access token and refresh token

        // TODO: test
        TokenDto tokenDto = TokenDto.builder()
                .accessToken(accessToken.getToken())
                //.expiresIn(accessToken.getExpiresIn())
                .refreshToken(refreshToken.getToken())
                //.refreshTokenExpiresIn(refreshToken.getExpiresIn())
                .build();
        return tokenDto;
    }
}