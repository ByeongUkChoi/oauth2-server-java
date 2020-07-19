package com.cbw0916.oauth2.server.grant;

import com.cbw0916.oauth2.server.dto.AuthorizationRequestDto;
import com.cbw0916.oauth2.server.dto.TokenDto;

public class AuthorizationCodeGrant extends AbstractGrant {
    @Override
    public TokenDto issueToken(AuthorizationRequestDto authorizationRequestDto) {
        return null;
    }
}
