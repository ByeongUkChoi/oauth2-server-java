package com.cbw0916.oauth2.server.grant;

import com.cbw0916.oauth2.server.dto.AuthorizationRequestDto;
import com.cbw0916.oauth2.server.dto.TokenDto;
import com.cbw0916.oauth2.server.repository.AccessTokenRepository;
import com.cbw0916.oauth2.server.repository.AuthorizationCodeRepository;
import com.cbw0916.oauth2.server.repository.RefreshTokenRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

public class AuthorizationCodeGrantTest {

    private final String AUTHORIZATION_CODE = "test-auth-code";
    private final String ACCESS_TOKEN = "test-access-token";
    private final String REFRESH_TOKEN = "test-refresh-token";

    @Mock
    private AuthorizationRequestDto authorizationRequestDto;
    @Mock
    private AuthorizationCodeRepository authorizationCodeRepository;
    @Mock
    private AccessTokenRepository accessTokenRepository;
    @Mock
    private RefreshTokenRepository refreshTokenRepository;

    @Test
    public void issueToken() {
        /**
         *  토큰 발급
         *  grant_type, client_id, redirect_uri, code, client_secret
         *  토큰 갱신
         *  grant_type, client_id, refresh_token, client_secret
         */

        // authorization code 용 request 객체 생성
        when(authorizationRequestDto.getGrantType()).thenReturn("authorization_code");
        when(authorizationRequestDto.getClientId()).thenReturn("test-client-id");
        when(authorizationRequestDto.getRedirectUri()).thenReturn("test-redirect-uri");
        when(authorizationRequestDto.getCode()).thenReturn(AUTHORIZATION_CODE);
        // TODO: test 값 넣어주기

        // TODO: repository를 Mock 객체로 생성하여 주입하기
        when(authorizationCodeRepository.getNewCode());

        // 토큰 발급
        AuthorizationCodeGrant authorizationCodeGrant = new AuthorizationCodeGrant();
        TokenDto tokenDto = authorizationCodeGrant.issueToken(authorizationRequestDto);

        // 타입 검증
        //Assertions.assertSame(tokenDto, new TokenDto());

        // TODO: 값 검증

    }
}
