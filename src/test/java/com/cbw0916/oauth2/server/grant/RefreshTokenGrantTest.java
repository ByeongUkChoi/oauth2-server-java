package com.cbw0916.oauth2.server.grant;

import com.cbw0916.oauth2.server.dto.AuthorizationRequestDto;
import com.cbw0916.oauth2.server.dto.TokenDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class RefreshTokenGrantTest {

    @Test
    public void issueToken() {
        assertSame(1, 1 + 0);

        AuthorizationRequestDto authorizationRequestDto = new AuthorizationRequestDto();
        // TODO: test

        // issue token
        RefreshTokenGrant refreshTokenGrant = new RefreshTokenGrant();
        TokenDto tokenDto = refreshTokenGrant.issueToken(authorizationRequestDto);

        // verify
        Assertions.assertSame(tokenDto, TokenDto.builder()
                .build());

        // TODO: verify

    }
}
