package com.byeongukchoi.oauth2.server.application;

import com.byeongukchoi.oauth2.server.application.dto.AuthorizationRequestDto;
import com.byeongukchoi.oauth2.server.application.dto.TokenDto;
import com.byeongukchoi.oauth2.server.domain.AccessToken;
import com.byeongukchoi.oauth2.server.domain.RefreshToken;
import com.byeongukchoi.oauth2.server.domain.repository.AccessTokenRepository;
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
public class RefreshTokenGrantTest {

    private final String CLIENT_ID = "test-client-id";
    private final String REDIRECT_URI = "test-redirect-uri";

    private final String ACCESS_TOKEN = "test-access-token";
    private final String REFRESH_TOKEN = "test-refresh-token";

    @Mock
    private AuthorizationRequestDto authorizationRequestDto;

    @Mock
    private AccessToken accessToken;
    @Mock
    private RefreshToken refreshToken;

    @Mock
    private AccessTokenRepository<AccessToken, String> accessTokenRepository;
    @Mock
    private RefreshTokenRepository<RefreshToken, String> refreshTokenRepository;

    @Test
    public void issueTokenSuccess() throws OAuth2ServerException {

        // Mock
        // authorizationRequestDto
        //when(authorizationRequestDto.getGrantType()).thenReturn(GRANT_TYPE);
        when(authorizationRequestDto.getClientId()).thenReturn(CLIENT_ID);
        //when(authorizationRequestDto.getRedirectUri()).thenReturn(REDIRECT_URI);
        when(authorizationRequestDto.getRefreshToken()).thenReturn(REFRESH_TOKEN);

        // refreshToken
        when(refreshToken.isExpired()).thenReturn(false);
        // refreshtokenRepository
        when(refreshTokenRepository.findByTokenAndClientId(eq(REFRESH_TOKEN), eq(CLIENT_ID))).thenReturn(refreshToken);

        // accessToken
        when(accessToken.getToken()).thenReturn(ACCESS_TOKEN);
        // accessTokenRepository
        when(accessTokenRepository.getNewToken(authorizationRequestDto)).thenReturn(accessToken);

        // refreshToken
        when(refreshToken.getToken()).thenReturn(REFRESH_TOKEN);
        // accessTokenRepository
        when(refreshTokenRepository.getNewToken(authorizationRequestDto, accessToken.getToken())).thenReturn(refreshToken);

        // issue token
        RefreshTokenGrant refreshTokenGrant = new RefreshTokenGrant(accessTokenRepository, refreshTokenRepository);
        TokenDto tokenDto = refreshTokenGrant.issueToken(authorizationRequestDto);

        // verify
        assertSame(tokenDto.getAccessToken(), ACCESS_TOKEN);
        assertSame(tokenDto.getRefreshToken(), REFRESH_TOKEN);
    }

    @Test
    public void issueTokenFailExpiredRefreshToken() {

        // Mock
        // authorizationRequestDto
        //when(authorizationRequestDto.getGrantType()).thenReturn(GRANT_TYPE);
        when(authorizationRequestDto.getClientId()).thenReturn(CLIENT_ID);
        //when(authorizationRequestDto.getRedirectUri()).thenReturn(REDIRECT_URI);
        when(authorizationRequestDto.getRefreshToken()).thenReturn(REFRESH_TOKEN);

        // refreshToken
        when(refreshToken.isExpired()).thenReturn(true);
        // refreshTokenRepository
        when(refreshTokenRepository.findByTokenAndClientId(eq(REFRESH_TOKEN), eq(CLIENT_ID))).thenReturn(refreshToken);

        // issue token
        RefreshTokenGrant refreshTokenGrant = new RefreshTokenGrant(accessTokenRepository, refreshTokenRepository);

        // expected exception
        assertThrows(Exception.class, () -> refreshTokenGrant.issueToken(authorizationRequestDto));
    }
}
