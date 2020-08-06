package com.byeongukchoi.oauth2.server.entity;

/**
 * Client interface
 */
public interface Client {
    public boolean verifyClient(String redirectUri, String clientSecret);
}
