package com.byeongukchoi.oauth2.server.grant;

import com.byeongukchoi.oauth2.server.dto.AuthorizationRequestDto;
import com.byeongukchoi.oauth2.server.dto.TokenDto;
import com.byeongukchoi.oauth2.server.entity.AccessToken;
import com.byeongukchoi.oauth2.server.entity.RefreshToken;
import com.byeongukchoi.oauth2.server.repository.AccessTokenRepository;
import com.byeongukchoi.oauth2.server.repository.RefreshTokenRepository;

/**
 * RefreshTokenGrant
 */
public class RefreshTokenGrant extends AbstractGrant {

    public RefreshTokenGrant(
            AccessTokenRepository accessTokenRepository,
            RefreshTokenRepository refreshTokenRepository) {
        this.accessTokenRepository = accessTokenRepository;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    private AccessTokenRepository accessTokenRepository;
    private RefreshTokenRepository refreshTokenRepository;

    /**
     * authorization_code
     *  grant_type, client_id, redirect_uri, code, client_secret
     *  refresh_token
     *  grant_type, client_id, refresh_token, client_secret
     */
    @Override
    public TokenDto issueToken(AuthorizationRequestDto authorizationRequestDto) throws Exception {
        // 1. verify refresh token and client

        // 1-1. get refresh token
        RefreshToken refreshToken = refreshTokenRepository.findByTokenAndClientId(authorizationRequestDto.getRefreshToken(), authorizationRequestDto.getClientId());
        if(refreshToken == null) {
            throw new Exception("Not Found Token");
        }

        // 1-2. check expired
        if(refreshToken.isExpired()) {
            throw new Exception("Expired Code");
        }

        // 2. create access token & refresh token
        AccessToken accessToken = accessTokenRepository.getNewToken();
        RefreshToken newRefreshToken = refreshTokenRepository.getNewToken();

        // 3. save access token & refresh token
        accessTokenRepository.saveNewToken(accessToken);
        refreshTokenRepository.saveNewToken(newRefreshToken);

        // 4. create token dto from access token and refresh token
        // TODO: test
        TokenDto tokenDto = TokenDto.builder()
                .accessToken(accessToken.getToken())
                //.expiresIn(accessToken.getExpiresIn())
                .refreshToken(newRefreshToken.getToken())
                //.refreshTokenExpiresIn(refreshToken.getExpiresIn())
                .build();

        // 5. expire refresh token
        refreshTokenRepository.expireToken(refreshToken);


        return tokenDto;
    }
}
