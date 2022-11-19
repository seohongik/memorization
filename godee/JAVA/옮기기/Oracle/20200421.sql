-- 사용자가 소유한 테이블에 대한 정보 조회하기
SELECT table_name
FROM user_tables;

SELECT sequence_name
FROM user_sequences;

SELECT view_name
FROM user_views;

-- 테이블에 대한 정보 조회하기
SELECT owner, table_name
FROM all_tables;

--ACCOUNTING 부서의 정보 입력하기
DESC dept_copy;
DROP TABLE dept_copy;
CREATE TABLE DEPT_COPY
AS
SELECT *
FROM department
WHERE 0=1;

COMMIT;

INSERT INTO dept_copy
VALUES(10, 'ACCONTING', 'NEW YORK');

COMMIT;

SELECT *
FROM dept_copy;

--RESEARCH 부서의 정보 입력하기
INSERT INTO dept_copy
VALUES(20,'RESEARCH','DALLAS');

SELECT *
FROM dept_copy;

SELECT *
FROM department;

-- 명시적으로 NULL값 삽입하기
INSERT INTO dept_copy
VALUES(30, 'OPERATIONS', NULL);

-- 공백 문자 삽입하기
INSERT INTO dept_copy
VALUES(50, 'COMPUTING', ' ');

COMMIT;

DELETE dept_copy
WHERE dno = 50;

SELECT *
FROM dept_copy;


-- 날짜 데이터 입력하기
DESC emp_copy;

CREATE TABLE emp_copy
AS
SELECT eno, ename, job, hiredate,dno
FROM employee
WHERE 0=1;

COMMIT;

INSERT INTO emp_copy
(eno, ename, job, hiredate,dno)
VALUES(7000, 'CANDY', 'MANAGER', SYSDATE, 10);

COMMIT;

SELECT *
FROM emp_copy;


-- 날짜 데이터 입력하기
INSERT INTO emp_copy
(eno, ename, job, hiredate, dno)
VALUES(7010, 'TOM', 'MANAGER', TO_DATE('2020,04,21', 'YYYY/MM/DD'),20);

COMMIT;

--현재 날짜 입력하기
INSERT INTO emp_copy
(eno, ename, job, hiredate, dno)
VALUES(7020, 'JERRY', 'SALESMAN', '2020/04/21', 30);

COMMIT;

SELECT *
FROM emp_copy;

-- 서브 쿼리로 다중 행 입력하기
DROP TABLE dept_copy;

COMMIT;

DESC dept_copy;

CREATE TABLE DEPT_COPY
AS
SELECT *
FROM department
WHERE 0 = 1;

COMMIT;

INSERT INTO dept_copy
SELECT *
FROM department;

COMMIT;

SELECT *
FROM dept_copy;

-- 특정 로우만 수정하기
SELECT *
FROM dept_copy
ORDER BY dno;

UPDATE dept_copy
SET dname = 'PROGRAMMING'
WHERE dno = 10;

COMMIT;

SELECT *
FROM dept_copy;

-- 모든 로우 수정하기
UPDATE  dept_copy
SET     dname='HR';

COMMIT;

SELECT *
FROM dept_copy;

-- 컬럼값 여러개 한번에 수정하기
SELECT *
FROM dept_copy
ORDER BY dno;

UPDATE dept_copy
SET dname='PROGRAMMING', loc='SEOUL'
WHERE dno = 10;

COMMIT;

SELECT *
FROM dept_copy
ORDER BY dno;

-- 10번 부서의 지역명을 20번 부서의 지역명으로 변경하기
UPDATE dept_copy
SET loc = (
            SELECT loc
            FROM dept_copy
            WHERE dno = 20
            )
WHERE dno = 10;

SELECT *
FROM dept_copy;

COMMIT;

-- 10번 부서의 부서명과 지역명을 30번 부서의 부서명과 지역명으로 변경하기
UPDATE dept_copy
SET loc = (
            SELECT loc
            FROM dept_copy
            WHERE dno = 30
            ),
    dname = (
            SELECT dname
            FROM dept_copy
            WHERE dno = 30  
              )
WHERE dno = 10;


SELECT *
FROM dept_copy;

COMMIT;

-- 특정 로우만 삭제하기
SELECT *
FROM dept_copy
ORDER BY dno;

DELETE dept_copy
WHERE dno = 10;

COMMIT;

SELECT *
FROM dept_copy
ORDER BY dno;

-- 모든 로우 삭제하기
DELETE dept_copy;

DESC dept_copy;

SELECT *
FROM dept_copy;

-- 영업부에 근무하는 사원 삭제
DESC emp_copy;

SELECT *
FROM emp_copy;

DROP TABLE emp_copy;

COMMIT;

CREATE TABLE EMP_COPY
AS 
SELECT *
FROM employee;

COMMIT;

SELECT *
FROM employee;

SELECT *
FROM emp_copy;

SELECT *
FROM department;

DELETE emp_copy
WHERE dno = (
                SELECT  dno
                FROM    department
                WHERE   dname='SALES'
            );

COMMIT;

SELECT *
FROM emp_copy;
