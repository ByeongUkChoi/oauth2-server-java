package com.cbw0916.oauth2.server.grant;

import com.cbw0916.oauth2.server.dto.AuthorizationRequestDto;
import com.cbw0916.oauth2.server.dto.TokenDto;

public abstract class AbstractGrant {

    /**
     * 토큰 발급
     * @return
     */
    public abstract TokenDto issueToken(AuthorizationRequestDto authorizationRequestDto) throws Exception;
}
