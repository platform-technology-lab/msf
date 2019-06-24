--
-- DB structure 
--

drop database if exists com;
create database com;
use com;

--
-- Table structure 
--

DROP TABLE IF EXISTS `oauth_client_details`;

create table oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove tinyint
);

DROP TABLE IF EXISTS `oauth_client_token`;

create table oauth_client_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255),
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);

DROP TABLE IF EXISTS `oauth_access_token`;

create table oauth_access_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255),
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication BLOB,
  refresh_token VARCHAR(255)
);

DROP TABLE IF EXISTS `oauth_refresh_token`;

create table oauth_refresh_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication BLOB
);

DROP TABLE IF EXISTS `oauth_code`;

create table oauth_code (
  code VARCHAR(255), authentication BLOB
);

--
-- Dumping data
--

INSERT INTO oauth_client_details (CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, WEB_SERVER_REDIRECT_URI, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY, ADDITIONAL_INFORMATION, AUTOAPPROVE) VALUES ('foo2', '', 'bar2', 'read', 'password,authorization_code,refresh_token', '', '', null, null, '{}',null);
