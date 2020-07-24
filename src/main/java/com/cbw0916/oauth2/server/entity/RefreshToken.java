package com.cbw0916.oauth2.server.entity;

public interface RefreshToken {
    public String getToken();
    public Boolean isExpired();
}
