package com.byeongukchoi.oauth2.server.entity;

/**
 * Client interface
 */
public interface Client {
    public void verifyClient(String redirectUri, String clientSecret);
}
