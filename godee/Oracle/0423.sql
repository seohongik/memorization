commit;


CREATE TABLE    CUSTOMER(
    id          VARCHAR2(20)    CONSTRAINT customer_id PRIMARY KEY,
    pwd         VARCHAR2(20)    ,
    name        VARCHAR2(20)   ,
    phone       VARCHAR2(30), 
    adress      VARCHAR2(100)  

);

--FORIEN KEY 제약조건 지정하기

CREATE TABLE    emp_second(
    eno         NUMBER(4)           CONSTRAINT  emp_second_eno_pk  PRIMARY KEY,
    ename       VARCHAR2(10),
    job         VARCHAR2(9),
    dno         NUMBER(2)           CONSTRAINT emp_second_dno_fk REFERENCES department

);

COMMIT;

INSERT INTO emp_second
VALUES(8000,'이진영','강사',50);

SELECT*
FROM department;

--CHECK 제약 조건 지정하기 

DROP TABLE emp_second;
COMMIT;



CREATE TABLE emp_second(
    eno         NUMBER(4)           CONSTRAINT  emp_second_eno_pk  PRIMARY KEY,
    ename       VARCHAR2(10),
    salary      NUMBER(7,2)         CONSTRAINT  emp_second_salary CHECK(salary>0)        

);

COMMIT;

INSERT INTO emp_second
VALUES(8000,'펭수',-200);

CREATE TABLE emp_second(
    eno         NUMBER(4)           CONSTRAINT  emp_second_eno_pk  PRIMARY KEY,
    ename       VARCHAR2(10),
    salary      NUMBER(7,2)         DEFAULT 3000        

);

COMMIT;
INSERT INTO emp_second
(eno,ename)
VALUES(8000,'펭수');
COMMIT;

SELECT *
FROM emp_second;



--PRIMARY KEY 제약 조건 추가하기 

DESC dept_copy;
SELECT table_name, constraint_name
FROM user_constraints
WHERE table_name IN('DEPT_COPY');

DESC emp_copy;

ALTER TABLE dept_copy
ADD CONSTRAINT dept_copy_dno_pk PRIMARY KEY(dno);

DESC dept_copy;

SELECT *
FROM dept_copy;

INSERT INTO dept_copy 
VALUES (10,'ACCOUNTINGS','한국');


--FOREIGN KEY 제약 조건 추가하기

ALTER TABLE emp_copy
ADD CONSTRAINT emp_copy_dno_fk FOREIGN key(dno) REFERENCES dept_copy(dno);

COMMIT;

SELECT*
FROM emp_copy;

--NULL 값 허용하지 않기 
ALTER TABLE emp_copy
MODIFY ename CONSTRAINT emp_copy_ename_nn NOT NULL;

--제약 조건 제거하기

ALTER TABLE dept_copy
DROP PRIMARY KEY CASCADE;
COMMIT;

--NOT NULL제약 조건 제거하기 
ALTER TABLE emp_copy
DROP CONSTRAINT emp_copy_ename_nn;

COMMIT;

--제약 조건 비활성화
CREATE TABLE emp_second(
    eno         NUMBER(4)           CONSTRAINT  emp_second_eno_pk  PRIMARY KEY,
    ename       VARCHAR2(10),
    job         VARCHAR2(9),
    dno         NUMBER(2)           CONSTRAINT emp_second_dno_fk REFERENCES department

);

COMMIT;

INSERT INTO emp_second
(eno,ename,job, dno)
VALUES(8000,'이진영','강사',50);

ALTER TABLE emp_second
DISABLE CONSTRAINT emp_second_dno_fk;

COMMIT;

INSERT INTO emp_second
(eno,ename,job, dno)
VALUES(8000,'이진영','강사',50);

SELECT *
FROM emp_second;

--제약조건 활성화하기
DELETE emp_second
WHERE dno=50;

ALTER TABLE emp_second
ENABLE CONSTRAINT emp_second_dno_fk;

