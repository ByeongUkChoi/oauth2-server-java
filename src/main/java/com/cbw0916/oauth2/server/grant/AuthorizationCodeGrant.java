package com.cbw0916.oauth2.server.grant;

import com.cbw0916.oauth2.server.dto.AuthorizationRequestDto;
import com.cbw0916.oauth2.server.dto.TokenDto;
import com.cbw0916.oauth2.server.repository.AccessTokenRepository;
import com.cbw0916.oauth2.server.repository.AuthorizationCodeRepository;
import com.cbw0916.oauth2.server.repository.RefreshTokenRepository;
import jdk.nashorn.internal.parser.Token;

public class AuthorizationCodeGrant extends AbstractGrant {

    private AuthorizationCodeRepository authorizationCodeRepository;
    private AccessTokenRepository accessTokenRepository;
    private RefreshTokenRepository refreshTokenRepository;

    @Override
    public TokenDto issueToken(AuthorizationRequestDto authorizationRequestDto) {
        // TODO: test
        TokenDto tokenDto = TokenDto.builder()
                .accessToken("abc")
                .build();
        return tokenDto;
    }
}
