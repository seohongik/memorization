SELECT table_name
FROM user_tables;

--PRIMARY KEY 제약조건 지정하기
DROP TABLE customer;

COMMIT;

CREATE TABLE CUSTOMER(
    id         VARCHAR2(20),
    pwd        VARCHAR2(20)     CONSTRAINT custommer_pwd_nn    NOT NULL,
    name       VARCHAR2(20)     CONSTRAINT custommer_name_nn   NOT NULL,
    phone      VARCHAR2(30),
    address    VARCHAR2(100),
    CONSTRAINT costomer_id_pk   PRIMARY KEY(id)
);

COMMIT;

INSERT INTO customer
VALUES('scott', 'tiger', '스캇1', '000-1111-2222', '제주도');

INSERT INTO customer
VALUES('scott', 'tiger', '스캇1', '000-1111-2222', '제주도');

INSERT INTO customer
VALUES(NULL, 'tiger', '스캇1', '000-1111-2222', '제주도');

COMMIT;

--FOREIGN KEY 제약조건 지정하기
DESC emp_second;

CREATE TABLE EMP_SECOND(
    eno     NUMBER(4)       CONSTRAINT emp_second_eno_pk    PRIMARY KEY,
    ename   VARCHAR2(10),
    job     VARCHAR2(9),
    dno     NUMBER(2)       CONSTRAINT emp_second_dno_fk    REFERENCES department
);

COMMIT;

SELECT dno
FROM department;

INSERT INTO emp_second
VALUES(3000, '김예찬', '대학생', 50);

-- CHECK 제약조건 지정하기
DROP TABLE emp_second;

CREATE TABLE EMP_SECOND(
    eno     NUMBER(4)       CONSTRAINT emp_second_eno_pk        PRIMARY KEY,
    ename   VARCHAR2(10),
    salary  NUMBER(7,2)     DEFAULT 3000
);

INSERT INTO emp_Second
VALUES(8000, '펭수', -200);

DROP TABLE emp_second;

COMMIT;

INSERT INTO emp_second(eno, ename)
VALUES(8000, '펭수');

SELECT *
FROM emp_second;

-- PRIMARY KEY 제약조건 추가하기
DESC dept_copy;
SELECT table_name, constraint_name
FROM user_constraints
WHERE table_name IN('dept_copy');

DESC dept_copy;
ALTER TABLE dept_copy
ADD CONSTRAINT dept_copy_dno_pk PRIMARY KEY(dno);
COMMIT;
DESC dept_copy;

SELECT *
FROM dept_copy;

INSERT INTO dept_copy
VALUES(10, 'ACCOUNTING2','한국');

--FOREIGN KEY 제약조건 추가하기
ALTER TABLE emp_copy
ADD CONSTRAINT emp_copy_dno_fk FOREIGN KEY(dno) REFERENCES dept_copy(dno);

COMMIT;

SELECT *
FROM emp_copy;

-- NULL값 허용하기 않기??
--ALTER TABLE emp_copy
--MODIFY ename CONSTRAINT emp_copy_ename_n NULL;

--제약 조건 제거하기
ALTER TABLE dept_copy
DROP PRIMARY KEY CASCADE;

COMMIT;

-- NOT NULL 제약 조건 제거하기
ALTER TABLE emp_copy
DROP CONSTRAINT emp_copy_ename_nn;

SELECT table_name, constraint_name
FROM user_constraints
WHERE table_name IN('EMP_COPY','DEPT_COPY');


-- 제약 조건 비활성화
DROP TABLE emp_second;

CREATE TABLE EMP_SECOND(
    eno     NUMBER(4)       CONSTRAINT emp_second_eno_pk    PRIMARY KEY,
    ename   VARCHAR2(10),
    job     VARCHAR2(9),
    dno     NUMBER(2)       CONSTRAINT emp_second_dno_fk    REFERENCES department
);

COMMIT;

INSERT INTO emp_second(eno,ename,job,dno)
VALUES(8000,'김예찬','대학생',50);

ALTER TABLE emp_second
DISABLE CONSTRAINT emp_second_dno_fk;

COMMIT;


INSERT INTO emp_second(eno,ename,job,dno)
VALUES(8000,'김예찬','대학생',50);

SELECT *
FROM emp_second;

-- 제약조건 활성화하기
ALTER TABLE emp_second
ENABLE CONSTRAINT emp_second_dno_fk;

DELETE emp_second
WHERE dno=50;

ALTER TABLE emp_second
ENABLE CONSTRAINT emp_second_dno_fk;

COMMIT;
