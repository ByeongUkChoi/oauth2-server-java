package com.cbw0916.oauth2.server.grant;

import com.cbw0916.oauth2.server.dto.AuthorizationRequestDto;
import com.cbw0916.oauth2.server.dto.TokenDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefreshTokenGrantTest {

    @Test
    public void issueToken() {

        // authorization code 용 request 객체 생성
        AuthorizationRequestDto authorizationRequestDto = new AuthorizationRequestDto();
        // TODO: test 값 넣어주기

        // 토큰 발급
        AuthorizationCodeGrant authorizationCodeGrant = new AuthorizationCodeGrant();
        TokenDto tokenDto = authorizationCodeGrant.issueToken(authorizationRequestDto);

        // 타입 검증
        Assertions.assertSame(tokenDto, new TokenDto());

        // TODO: 값 검증

    }
}
