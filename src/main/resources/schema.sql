CREATE TABLE oauth_clients (
  client_id         VARCHAR(86)     NOT NULL PRIMARY KEY,
  client_secret     VARCHAR(32),
  redirect_uri      VARCHAR(500),
  grant_type        VARCHAR(20),
);

CREATE TABLE oauth_authorization_codes (
  code              VARCHAR(86)     NOT NULL PRIMARY KEY,
  client_id         VARCHAR(32)     NOT NULL,
  username          VARCHAR(40)     NOT NULL,
  redirect_uri      VARCHAR(500),
  expired_at        TIMESTAMP       NOT NULL,
  created_at        TIMESTAMP       NOT NULL,
);

CREATE TABLE oauth_access_tokens (
  token             VARCHAR(400)    NOT NULL PRIMARY KEY,
  client_id         VARCHAR(32)     NOT NULL,
  username          VARCHAR(40)     NOT NULL,
  expired_at        TIMESTAMP       NOT NULL,
  created_at        TIMESTAMP       NOT NULL,
);

CREATE TABLE oauth_refresh_tokens (
  token             VARCHAR(400)    NOT NULL PRIMARY KEY,
  client_id         VARCHAR(32)     NOT NULL,
  username          VARCHAR(40)     NOT NULL,
  access_token      VARCHAR(400),
  expired_at        TIMESTAMP       NOT NULL,
  created_at        TIMESTAMP       NOT NULL,
);