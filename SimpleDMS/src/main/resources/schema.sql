-- Table , 시퀀스 등 구조 정의
DROP SEQUENCE SQ_FAQ;
CREATE SEQUENCE SQ_FAQ START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SQ_QNA;
CREATE SEQUENCE SQ_QNA START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SQ_QUESTION;
CREATE SEQUENCE SQ_QUESTION START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SQ_ANSWER;
CREATE SEQUENCE SQ_ANSWER START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SQ_RESERVATION;
CREATE SEQUENCE SQ_RESERVATION START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SQ_ANNOUNCE;
CREATE SEQUENCE SQ_ANNOUNCE START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SQ_FREE;
CREATE SEQUENCE SQ_FREE START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SQ_REVIEW;
CREATE SEQUENCE SQ_REVIEW START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SQ_DINER;
CREATE SEQUENCE SQ_DINER START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SQ_MENU;
CREATE SEQUENCE SQ_MENU START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SQ_SCORE;
CREATE SEQUENCE SQ_SCORE START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SQ_COLUMN;
CREATE SEQUENCE SQ_COLUMN START WITH 1 INCREMENT BY 1;

DROP TABLE TB_FAQ CASCADE CONSTRAINTS;
DROP TABLE TB_QNA CASCADE CONSTRAINTS;
DROP TABLE TB_QUESTION CASCADE CONSTRAINTS;
DROP TABLE TB_ANSWER CASCADE CONSTRAINTS;
DROP TABLE TB_RESERVATION CASCADE CONSTRAINTS;
DROP TABLE TB_ANNOUNCE CASCADE CONSTRAINTS;
DROP TABLE TB_FREE CASCADE CONSTRAINTS;
DROP TABLE TB_REVIEW CASCADE CONSTRAINTS;
DROP TABLE TB_DINER CASCADE CONSTRAINTS;
DROP TABLE TB_MENU CASCADE CONSTRAINTS;
DROP TABLE TB_SCORE CASCADE CONSTRAINTS;
DROP TABLE TB_COLUMN CASCADE CONSTRAINTS;


CREATE TABLE TB_DINER
(
    DNO         NUMBER NOT NULL PRIMARY KEY,
    DNAME       VARCHAR2(255),
    SCORE       VARCHAR2(255),
    LOC         VARCHAR2(255),
    PHONE       VARCHAR2(255),
    MENU        VARCHAR2(255),
    THEME       VARCHAR2(255),
    REVIEW      VARCHAR2(255),
    PHOTO       VARCHAR2(255),
    DELETE_YN   VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME VARCHAR2(255),
    UPDATE_TIME VARCHAR2(255),
    DELETE_TIME VARCHAR2(255)
);

CREATE TABLE TB_FAQ
(
    NO          NUMBER NOT NULL PRIMARY KEY,
    TITLE       VARCHAR2(255),
    CONTENT     VARCHAR2(255),
    DELETE_YN   VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME VARCHAR2(255),
    UPDATE_TIME VARCHAR2(255),
    DELETE_TIME VARCHAR2(255)
);

CREATE TABLE TB_QNA
(
    QNO         NUMBER NOT NULL PRIMARY KEY,
    TITLE       VARCHAR2(255),
    CONTENT     VARCHAR2(255),
    QUESTIONER  VARCHAR2(255),
    DELETE_YN   VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME VARCHAR2(255),
    UPDATE_TIME VARCHAR2(255),
    DELETE_TIME VARCHAR2(255)
);

-- TODO: QNA 테이블 세분화
CREATE TABLE TB_QUESTION
(
    QUESTION_NO NUMBER NOT NULL PRIMARY KEY,
    TITLE       VARCHAR2(255),
    CONTENT     VARCHAR2(255),
    WRITER      VARCHAR2(255),
    DELETE_YN   VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME VARCHAR2(255),
    UPDATE_TIME VARCHAR2(255),
    DELETE_TIME VARCHAR2(255)
);

CREATE TABLE TB_ANSWER
(
    ANSWER_NO   NUMBER NOT NULL PRIMARY KEY,
    QUESTION_NO NUMBER,
    CONTENT     VARCHAR2(255),
    WRITER      VARCHAR2(255),
    DELETE_YN   VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME VARCHAR2(255),
    UPDATE_TIME VARCHAR2(255),
    DELETE_TIME VARCHAR2(255)
);

CREATE TABLE TB_ANNOUNCE
(
    ANO         NUMBER NOT NULL PRIMARY KEY,
    TITLE       VARCHAR2(255),
    CONTENT     VARCHAR2(255),
    WRITER      VARCHAR2(255),
    DELETE_YN   VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME VARCHAR2(255),
    UPDATE_TIME VARCHAR2(255),
    DELETE_TIME VARCHAR2(255)
);

CREATE TABLE TB_FREE
(
    FNO         NUMBER NOT NULL PRIMARY KEY,
    WRITER      VARCHAR2(255),
    TITLE       VARCHAR2(255),
    CONTENT     VARCHAR2(4000),
    DELETE_YN   VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME VARCHAR2(255),
    UPDATE_TIME VARCHAR2(255),
    DELETE_TIME VARCHAR2(255)
);

CREATE TABLE TB_RESERVATION
(
    RID                  NUMBER NOT NULL PRIMARY KEY,
    RESTAURANT           VARCHAR2(1000),
    RNAME                VARCHAR2(1000),
    RCOUNT               VARCHAR2(1000),
    PHONE                VARCHAR2(1000),
    DNO                  NUMBER, -- 식당번호(조인용 컬럼)
    RESERVATION_DATE     VARCHAR2(1000),
    RESERVATION_TIME     VARCHAR2(1000),
    DELETE_YN            VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME          VARCHAR2(255),
    UPDATE_TIME          VARCHAR2(255),
    DELETE_TIME          VARCHAR2(255)
);

-- TB_DINER 과 DNO 를 FOREIGN KEY 사용해서 참조 연결 -> 에러나서 일단 주석처리
CREATE TABLE TB_REVIEW
(
    RNO            NUMBER NOT NULL PRIMARY KEY,
--     DNO            NUMBER NOT NULL,
    REVIEW_TITLE   VARCHAR2(255),
    REVIEW_CONTENT VARCHAR2(2000),
    REVIEW_PHOTO   VARCHAR2(255),
    REVIEW_WRITER  VARCHAR2(255),
    DELETE_YN      VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME    VARCHAR2(255),
    UPDATE_TIME    VARCHAR2(255),
    DELETE_TIME    VARCHAR2(255)
);
-- 외래키를 쓰는게 좋을지 아닐지... 필요없으면 삭제 예정
-- ALTER TABLE TB_REVIEW
--     ADD CONSTRAINT TB_REVIEW_DNO FOREIGN KEY (DNO)
--         REFERENCES TB_DINER (DNO);


CREATE TABLE TB_MENU
(
    MENU_ID        NUMBER NOT NULL PRIMARY KEY,
    MENU_NAME      VARCHAR2(255),
    MENU_PRICE     VARCHAR2(2000),
    DELETE_YN      VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME    VARCHAR2(255),
    UPDATE_TIME    VARCHAR2(255),
    DELETE_TIME    VARCHAR2(255)
);


CREATE TABLE TB_SCORE
(
    SID            NUMBER NOT NULL PRIMARY KEY,
    TASTE          NUMBER,
    SERVICE        NUMBER,
    LOC            NUMBER,
    MOOD           NUMBER,
    COST           NUMBER,
    DELETE_YN      VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME    VARCHAR2(255),
    UPDATE_TIME    VARCHAR2(255),
    DELETE_TIME    VARCHAR2(255)
);


CREATE TABLE TB_COLUMN
(
    CID             NUMBER NOT NULL PRIMARY KEY,
    COLUMN_TITLE    VARCHAR2(255),
    COLUMN_CONTENT  VARCHAR2(2000),
    COLUMN_PHOTO    VARCHAR2(255),
    COLUMN_WRITER   VARCHAR2(255),
    DELETE_YN       VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME     VARCHAR2(255),
    UPDATE_TIME     VARCHAR2(255),
    DELETE_TIME     VARCHAR2(255)
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
                        ID          NUMBER NOT NULL PRIMARY KEY,
                        USERNAME    VARCHAR2(1000),
                        EMAIL       VARCHAR2(1000),
                        PASSWORD    VARCHAR2(1000),
                        NAME        VARCHAR2(1000),
                        BIRTHDAY    VARCHAR2(1000),
                        GENDER      VARCHAR2(1000),
                        PHONE       VARCHAR2(1000),
                        ADDRESS     VARCHAR2(1000),
                        DELETE_YN   VARCHAR2(1) DEFAULT 'N',
                        INSERT_TIME VARCHAR2(255),
                        UPDATE_TIME VARCHAR2(255),
                        DELETE_TIME VARCHAR2(255)
);
-- 역할 테이블 : ROLE_USER, ROLE_ADMIN
CREATE TABLE TB_ROLE(
                        RID         NUMBER NOT NULL PRIMARY KEY,
                        RNAME       VARCHAR2(1000) UNIQUE,
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
--
-- DROP SEQUENCE SQ_USER;
-- CREATE SEQUENCE SQ_USER
--     INCREMENT BY 1 START WITH 1
--     MINVALUE 1
--     MAXVALUE 99999999;
--
-- DROP SEQUENCE SQ_ROLE;
-- CREATE SEQUENCE SQ_ROLE
--     INCREMENT BY 1 START WITH 1
--     MINVALUE 1
--     MAXVALUE 99999999;
--
-- DROP TABLE TB_USER CASCADE CONSTRAINTS;
-- DROP TABLE TB_ROLE CASCADE CONSTRAINTS;
-- DROP TABLE TB_USER_ROLE CASCADE CONSTRAINTS;
--
-- -- 유저 테이블
-- CREATE TABLE TB_USER(
--                         ID NUMBER NOT NULL PRIMARY KEY,
--                         EMAIL VARCHAR2(1000),
--                         PASSWORD VARCHAR2(1000),
--                         USERNAME VARCHAR2(1000),
--                         DELETE_YN   VARCHAR2(1) DEFAULT 'N',
--                         INSERT_TIME VARCHAR2(255),
--                         UPDATE_TIME VARCHAR2(255),
--                         DELETE_TIME VARCHAR2(255)
-- );
-- -- 역할 테이블 : ROLE_USER, ROLE_ADMIN
-- CREATE TABLE TB_ROLE(
--                         RID NUMBER NOT NULL PRIMARY KEY,
--                         NAME VARCHAR2(1000) UNIQUE,
--                         DELETE_YN   VARCHAR2(1) DEFAULT 'N',
--                         INSERT_TIME VARCHAR2(255),
--                         UPDATE_TIME VARCHAR2(255),
--                         DELETE_TIME VARCHAR2(255)
-- );
-- -- 매핑테이블 : TB_USER vs TB_ROLE 연결시켜주는 테이블 ( Many To Many 관계에서 사용 )
-- CREATE TABLE TB_USER_ROLE (
--                               USER_ID NUMBER NOT NULL,
--                               ROLE_ID NUMBER NOT NULL,
--                               PRIMARY KEY (USER_ID, ROLE_ID) -- 복합키 ( 속성 2이상을 조합해서 기본키로 만드는것 )
-- );

COMMIT;








