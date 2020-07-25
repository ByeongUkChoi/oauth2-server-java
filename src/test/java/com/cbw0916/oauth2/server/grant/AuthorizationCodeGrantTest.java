package com.cbw0916.oauth2.server.grant;

import com.cbw0916.oauth2.server.dto.AuthorizationRequestDto;
import com.cbw0916.oauth2.server.dto.TokenDto;
import com.cbw0916.oauth2.server.entity.AccessToken;
import com.cbw0916.oauth2.server.repository.AccessTokenRepository;
import com.cbw0916.oauth2.server.repository.AuthorizationCodeRepository;
import com.cbw0916.oauth2.server.repository.RefreshTokenRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // open mocks
public class AuthorizationCodeGrantTest {

    private final String AUTHORIZATION_CODE = "test-auth-code";
    private final String ACCESS_TOKEN = "test-access-token";
    private final String REFRESH_TOKEN = "test-refresh-token";

    @Mock
    private AuthorizationRequestDto authorizationRequestDto;

    @Mock
    private AccessToken accessToken;

    @Mock
    private AuthorizationCodeRepository authorizationCodeRepository;
    @Mock
    private AccessTokenRepository accessTokenRepository;
    @Mock
    private RefreshTokenRepository refreshTokenRepository;

    @Test
    public void issueToken() {
        /**
         * authorization_code
         *  grant_type, client_id, redirect_uri, code, client_secret
         *  refresh_token
         *  grant_type, client_id, refresh_token, client_secret
         */

        // Mock
        // authorizationRequestDto
        when(authorizationRequestDto.getGrantType()).thenReturn("authorization_code");
        when(authorizationRequestDto.getClientId()).thenReturn("test-client-id");
        when(authorizationRequestDto.getRedirectUri()).thenReturn("test-redirect-uri");
        when(authorizationRequestDto.getCode()).thenReturn(AUTHORIZATION_CODE);

        // authorizationCodeRepository
        // TODO: add check code
        //when(authorizationCodeRepository).thenReturn();

        // accessToken
        when(accessToken.getToken()).thenReturn(ACCESS_TOKEN);

        // accessTokenRepository
        when(accessTokenRepository.getNewToken()).thenReturn(accessToken);

        // issue token
        AuthorizationCodeGrant authorizationCodeGrant = new AuthorizationCodeGrant();
        TokenDto tokenDto = authorizationCodeGrant.issueToken(authorizationRequestDto);

        // verify
        Assertions.assertSame(tokenDto, TokenDto.builder()
                .accessToken(ACCESS_TOKEN)
                .refreshToken(REFRESH_TOKEN)
                .build());
    }
}
