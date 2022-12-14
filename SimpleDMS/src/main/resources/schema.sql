-- TODO: DEPT/EMP/FAQ 테이블/시퀀스

DROP SEQUENCE SQ_FAQ;
CREATE SEQUENCE SQ_FAQ START WITH 5 INCREMENT BY 1;

DROP TABLE TB_FAQ CASCADE CONSTRAINTS;

CREATE TABLE TB_FAQ
(
--   카멜/언더바 단축키 : alt + shift + u ( CamelCase 플러그인 설치 )
--   대/소문자 단축키 : ctrl + shift + u
    NO          NUMBER NOT NULL PRIMARY KEY,
    TITLE       VARCHAR2(255),
    CONTENT     VARCHAR2(255),
    DELETE_YN   VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME VARCHAR2(255),
    UPDATE_TIME VARCHAR2(255),
    DELETE_TIME VARCHAR2(255)
);

-- TODO: login 관련 테이블/시퀀스
DROP SEQUENCE SQ_USER;
CREATE SEQUENCE SQ_USER
    INCREMENT BY 1 START WITH 1
    MINVALUE 1
    MAXVALUE 99999999;

DROP SEQUENCE SQ_ROLE;
CREATE SEQUENCE SQ_ROLE
    INCREMENT BY 1 START WITH 1
    MINVALUE 1
    MAXVALUE 99999999;

DROP TABLE TB_USER CASCADE CONSTRAINTS;
DROP TABLE TB_ROLE CASCADE CONSTRAINTS;
DROP TABLE TB_USER_ROLE CASCADE CONSTRAINTS;

-- 유저 테이블
CREATE TABLE TB_USER(
                        ID NUMBER NOT NULL PRIMARY KEY,
                        EMAIL VARCHAR2(1000),
                        PASSWORD VARCHAR2(1000),
                        USERNAME VARCHAR2(1000),
                        DELETE_YN   VARCHAR2(1) DEFAULT 'N',
                        INSERT_TIME VARCHAR2(255),
                        UPDATE_TIME VARCHAR2(255),
                        DELETE_TIME VARCHAR2(255)
);
-- 역할 테이블 : ROLE_USER, ROLE_ADMIN
CREATE TABLE TB_ROLE(
                        RID NUMBER NOT NULL PRIMARY KEY,
                        NAME VARCHAR2(1000) UNIQUE,
                        DELETE_YN   VARCHAR2(1) DEFAULT 'N',
                        INSERT_TIME VARCHAR2(255),
                        UPDATE_TIME VARCHAR2(255),
                        DELETE_TIME VARCHAR2(255)
);
-- 매핑테이블 : TB_USER vs TB_ROLE 연결시켜주는 테이블 ( Many To Many 관계에서 사용 )
CREATE TABLE TB_USER_ROLE (
                              USER_ID NUMBER NOT NULL,
                              ROLE_ID NUMBER NOT NULL,
                              PRIMARY KEY (USER_ID, ROLE_ID) -- 복합키 ( 속성 2이상을 조합해서 기본키로 만드는것 )
);


COMMIT;