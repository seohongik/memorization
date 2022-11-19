

DROP TABLE DEPT_COPY;
COMMIT;


DESC dept_copy;


CREATE TABLE DETP_COPY

AS
SELECT *
FROM department;

ROLLBACK;


CREATE TABLE DEPT_COPY
AS
SELECT *
FROM department;


--ROLLBACK 실행하기 

DELETE dept_copy;

SELECT *
FROM dept_copy;

ROLLBACK;


SELECT *
FROM dept_copy;

--PRIMARY KEY 지정하기 
DROP TABLE dept_second;

COMMIT;

DESC DEPT_THIRD;

DROP TABLE DEPT_THIRD;

COMMIT;

CREATE TABLE DEPT_THIRD(
    dno     NUMBER(2),  
    dname   VARCHAR2(14),
    LOC     VARCHAR2(13),
    CONSTRAINT pk_dept_third PRIMARY KEY(dno)  
);
COMMIT;

--NOT NULL 사용하기 

CREATE TABLE CUSTOMER(
    id          VARCHAR2(20)    NOT NULL,
    pwd         VARCHAR2(20)    NOT NULL,
    name        VARCHAR2(20)    NOT NULL,
    phone       VARCHAR2(30), 
    adress      VARCHAR2(100) 

);

COMMIT;
DESC CUSTOMER;

--UNIQUE 사용하기 

DROP TABLE CUSTOMER;

CREATE TABLE CUSTOMER(
    id          VARCHAR2(20)    UNIQUE,
    pwd         VARCHAR2(20)    NOT NULL,
    name        VARCHAR2(20)    NOT NULL,
    phone       VARCHAR2(30), 
    adress      VARCHAR2(100) 

);

COMMIT;

--데이터 삽입하기

INSERT INTO customer
VALUES('scott','tiger','스캇','000-1111-2222','서울시' );
COMMIT;

SELECT*
FROM customer;

INSERT INTO customer
VALUES('null','TIGER1','스캇1','000-1111-2222','제주도' );

COMMIT;

SELECT *
FROM customer;

DROP TABLE CUSTOMER;

CREATE TABLE CUSTOMER(
    id          VARCHAR2(20)    NOT NULL,
    pwd         VARCHAR2(20)    NOT NULL,
    name        VARCHAR2(20)    NOT NULL,
    phone       VARCHAR2(30), 
    adress      VARCHAR2(100) 

);

INSERT INTO customer
VALUES(NULL,'tiger','스캇','000-1111-2222','서울시' );

INSERT INTO customer ----NOT NULL은 중복은 허용
VALUES('scott','tiger','스캇','000-1111-2222','서울시' );

INSERT INTO customer
VALUES('scott','tiger','스캇','000-1111-2222','서울시' );

SELECT*
FROM customer;

--NOT NULL은 중복은 허용하고 UNIQUE는 NULL을 허용한다

CREATE TABLE CUSTOMER2(
    id          VARCHAR2(20)    UNIQUE,
    pwd         VARCHAR2(20)    NOT NULL,
    name        VARCHAR2(20)    NOT NULL,
    phone       VARCHAR2(30), 
    adress      VARCHAR2(100) 

);


INSERT INTO customer2 ----UNIQUE키 NULL 허용
VALUES(NULL,'tiger','스캇','000-1111-2222','서울시' );

INSERT INTO customer2 -- UNIQUE키 중복 안됨
VALUES('scott','tiger','스캇','000-1111-2222','서울시' );

INSERT INTO customer2
VALUES('scott','tiger','스캇','000-1111-2222','서울시' );

--제약 조건 이름 지정하기 
DROP TABLE CUSTOMER;

CREATE TABLE CUSTOMER(
    id          VARCHAR2(20)    CONSTRAINT customer_id_uk UNIQUE,
    pwd         VARCHAR2(20)    CONSTRAINT customer_pwd_nn NOT NULL,
    name        VARCHAR2(20)   CONSTRAINT customer_name_nn NOT NULL,
    phone       VARCHAR2(30), 
    adress      VARCHAR2(100) 

);

COMMIT;

--제약 조건 확인하기 
SELECT table_name, constraint_name
FROM user_constraints
WHERE table_name in('CUSTOMER');


