CREATE TABLE STOCK(
    SYMBOL VARCHAR(255) PRIMARY KEY,
    NAME VARCHAR(255)
    );

CREATE TABLE STOCK_SUBSCRIPTION(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    EMAIL VARCHAR(255),
    SYMBOL VARCHAR(255)
    );

CREATE TABLE APP_USER(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    EMAIL VARCHAR(255),
    FIRST_NAME VARCHAR(255),
    LAST_NAME VARCHAR(255),
    PASSWORD VARCHAR(255),
    ROLES VARCHAR(1000)
    );
--
--CREATE TABLE APP_ROLE(
--    ID BIGINT PRIMARY KEY,
--    NAME VARCHAR(255)
--    );

--CREATE TABLE APP_USERS_ROLES(
--    USER_ID BIGINT,
--    ROLE_ID BIGINT
----    ,FOREIGN KEY (ROLE_ID) REFERENCES ROLE,
----    FOREIGN KEY (USER_ID) REFERENCES USER
--)