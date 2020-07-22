CREATE TABLE oauth_clients (
  id                INT             NOT NULL AUTO_INCREMENT PRIMARY KEY,
  client_id         VARCHAR(86),
  client_secret     VARCHAR(32),
  redirect_uri      VARCHAR(500),
  grant_type        VARCHAR(20),
  username          VARCHAR(40),
  PRIMARY KEY (client_id)
);

CREATE TABLE oauth_authorization_codes (
  code              VARCHAR(86)     NOT NULL PRIMARY KEY,
  client_id         VARCHAR(32)     NOT NULL,
  username          VARCHAR(40),
  redirect_uri      VARCHAR(500),
  expires           TIMESTAMP       NOT NULL,
);

CREATE TABLE oauth_access_tokens (
  token             VARCHAR(400)     NOT NULL PRIMARY KEY,
  client_id         VARCHAR(32)     NOT NULL,
  username          VARCHAR(40),
  expires           TIMESTAMP       NOT NULL,
);

CREATE TABLE oauth_refresh_tokens (
  token             VARCHAR(400)     NOT NULL PRIMARY KEY,
  client_id         VARCHAR(32)     NOT NULL,
  username          VARCHAR(40),
  expires           TIMESTAMP       NOT NULL,
);