package com.byeongukchoi.oauth2.server.application;

import com.byeongukchoi.oauth2.server.application.dto.AuthorizationRequestDto;
import com.byeongukchoi.oauth2.server.application.dto.TokenDto;
import com.byeongukchoi.oauth2.server.domain.AccessToken;
import com.byeongukchoi.oauth2.server.domain.AuthorizationCode;
import com.byeongukchoi.oauth2.server.domain.RefreshToken;
import com.byeongukchoi.oauth2.server.domain.repository.AccessTokenRepository;
import com.byeongukchoi.oauth2.server.domain.repository.AuthorizationCodeRepository;
import com.byeongukchoi.oauth2.server.domain.repository.RefreshTokenRepository;
import com.byeongukchoi.oauth2.server.error.exception.OAuth2ServerException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // open mocks
public class AuthorizationCodeGrantTest {

    private final String CLIENT_ID = "test-client-id";
    private final String REDIRECT_URI = "test-redirect-uri";

    private final String AUTHORIZATION_CODE = "test-auth-code";
    private final String ACCESS_TOKEN = "test-access-token";
    private final String REFRESH_TOKEN = "test-refresh-token";

    @Mock
    private AuthorizationRequestDto authorizationRequestDto;

    @Mock
    private AccessToken accessToken;
    @Mock
    private RefreshToken refreshToken;

    @Mock
    private AuthorizationCode authorizationCode;

    @Mock
    private AuthorizationCodeRepository<AuthorizationCode, String> authorizationCodeRepository;
    @Mock
    private AccessTokenRepository<AccessToken, String> accessTokenRepository;
    @Mock
    private RefreshTokenRepository<RefreshToken, String> refreshTokenRepository;

    /**
     * authorization_code
     *  grant_type, client_id, redirect_uri, code, client_secret
     *  refresh_token
     *  grant_type, client_id, refresh_token, client_secret
     */
    @Test
    public void testIssueTokenSuccess() throws OAuth2ServerException {

        // Mock
        // authorizationRequestDto
        //when(authorizationRequestDto.getGrantType()).thenReturn(GRANT_TYPE);
        when(authorizationRequestDto.getClientId()).thenReturn(CLIENT_ID);
        //when(authorizationRequestDto.getRedirectUri()).thenReturn(REDIRECT_URI);
        when(authorizationRequestDto.getCode()).thenReturn(AUTHORIZATION_CODE);

        // authorizationCode
        when(authorizationCode.isExpired()).thenReturn(false);
        // authorizationCodeRepository
        when(authorizationCodeRepository.findByCodeAndClientId(eq(AUTHORIZATION_CODE), eq(CLIENT_ID))).thenReturn(authorizationCode);

        // accessToken
        when(accessToken.getToken()).thenReturn(ACCESS_TOKEN);
        // accessTokenRepository
        when(accessTokenRepository.getNewToken(authorizationRequestDto)).thenReturn(accessToken);

        // refreshToken
        when(refreshToken.getToken()).thenReturn(REFRESH_TOKEN);
        // accessTokenRepository
        when(refreshTokenRepository.getNewToken(authorizationRequestDto, accessToken.getToken())).thenReturn(refreshToken);

        // issue token
        AuthorizationCodeGrant authorizationCodeGrant = new AuthorizationCodeGrant(authorizationCodeRepository, accessTokenRepository, refreshTokenRepository);
        TokenDto tokenDto = authorizationCodeGrant.issueToken(authorizationRequestDto);

        // verify
        assertSame(tokenDto.getAccessToken(), ACCESS_TOKEN);
        assertSame(tokenDto.getRefreshToken(), REFRESH_TOKEN);
    }
    @Test
    public void testIssueTokenFailExpiredCode() {

        // Mock
        // authorizationRequestDto
        //when(authorizationRequestDto.getGrantType()).thenReturn(GRANT_TYPE);
        when(authorizationRequestDto.getClientId()).thenReturn(CLIENT_ID);
        //when(authorizationRequestDto.getRedirectUri()).thenReturn(REDIRECT_URI);
        when(authorizationRequestDto.getCode()).thenReturn(AUTHORIZATION_CODE);

        // authorizationCode
        when(authorizationCode.isExpired()).thenReturn(true);
        // authorizationCodeRepository
        when(authorizationCodeRepository.findByCodeAndClientId(eq(AUTHORIZATION_CODE), eq(CLIENT_ID))).thenReturn(authorizationCode);

        // issue token
        AuthorizationCodeGrant authorizationCodeGrant = new AuthorizationCodeGrant(authorizationCodeRepository, accessTokenRepository, refreshTokenRepository);
        // expected exception
        assertThrows(Exception.class, () -> {
            authorizationCodeGrant.issueToken(authorizationRequestDto);
        });
    }
}
