package com.byeongukchoi.oauth2.server.error.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    UNKNOWN_ERROR(1000, "UNKNOWN ERROR"),
    NOT_FOUND_AUTHORIZATION_CODE(1001, "Not found authorization code"),
    EXPIRED_AUTHORIZATION_CODE(1002, "Expired authorization code"),
    NOT_FOUND_REFRESH_TOKEN(1003, "Not found refresh token"),
    EXPIRED_REFRESH_TOKEN(1004, "Expired refresh token"),
    ;

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
