package com.cbw0916.oauth2.server.grant;

import com.cbw0916.oauth2.server.dto.AuthorizationRequestDto;
import com.cbw0916.oauth2.server.dto.TokenDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefreshTokenGrantTest {

    @Test
    public void issueToken() {

        AuthorizationRequestDto authorizationRequestDto = new AuthorizationRequestDto();
        // TODO: test

        // issue token
        AuthorizationCodeGrant authorizationCodeGrant = new AuthorizationCodeGrant();
        TokenDto tokenDto = authorizationCodeGrant.issueToken(authorizationRequestDto);

        // verify
        Assertions.assertSame(tokenDto, TokenDto.builder()
                .build());

        // TODO: verify

    }
}
