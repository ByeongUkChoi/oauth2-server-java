package com.cbw0916.oauth2.server.grant;

import com.cbw0916.oauth2.server.dto.AuthorizationRequestDto;
import com.cbw0916.oauth2.server.dto.TokenDto;
import com.cbw0916.oauth2.server.entity.AccessToken;
import com.cbw0916.oauth2.server.entity.RefreshToken;
import com.cbw0916.oauth2.server.repository.AccessTokenRepository;
import com.cbw0916.oauth2.server.repository.RefreshTokenRepository;

public class RefreshTokenGrant extends AbstractGrant {

    private AccessTokenRepository accessTokenRepository;
    private RefreshTokenRepository refreshTokenRepository;

    /**
     * authorization_code
     *  grant_type, client_id, redirect_uri, code, client_secret
     *  refresh_token
     *  grant_type, client_id, refresh_token, client_secret
     */
    @Override
    public TokenDto issueToken(AuthorizationRequestDto authorizationRequestDto) {
        // 1. verify refresh token and client

        // 1-1. get refresh token
        RefreshToken refreshToken = refreshTokenRepository.findByTokenAndClientId(authorizationRequestDto.getRefreshToken(), authorizationRequestDto.getClientId());

        // TODO: 1-2. check expired
        if(refreshToken.isExpired()) {

        }

        // TODO: 1-3. verify client secret
        // TODO: client.verifyClientSecret();

        // 2. create access token & refresh token
        AccessToken accessToken = accessTokenRepository.getNewToken();
        RefreshToken newRefreshToken = refreshTokenRepository.getNewToken();

        // 3. save access token & refresh token
        accessTokenRepository.saveNewToken(accessToken);
        refreshTokenRepository.saveNewToken(newRefreshToken);

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
