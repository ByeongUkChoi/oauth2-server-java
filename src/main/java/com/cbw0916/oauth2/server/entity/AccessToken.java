package com.cbw0916.oauth2.server.entity;

public interface AccessToken {
    public String getToken();
    public Boolean isExpired();
}
