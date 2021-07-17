package com.byeongukchoi.oauth2.server.error.exception;

import lombok.Getter;

public class OAuth2ServerException extends RuntimeException {
    @Getter
    private ErrorCode errorCode;

    public OAuth2ServerException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
