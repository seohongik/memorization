SELECT table_name
FROM    user_tables;

-- 단순 뷰 생성하기
DESC emp_second;
DESC dept_second;

SELECT *
FROM emp_second;

DROP TABLE emp_second;
DROP TABLE dept_second;

CREATE TABLE EMP_SECOND
AS
SELECT *
FROM employee;

CREATE TABLE DEPT_SECOND
AS
SELECT *
FROM department;

COMMIT;


-- 단순 뷰 정의하기
CREATE view v_emp_job(사번,사원이름,부서번호,담당업무)
AS
SELECT eno,ename,dno,job
FROM emp_second
WHERE job LIKE 'SALESMAN';

-- 뷰 사용하기
SELECT *
FROM v_emp_job;

-- 뷰 정의하기
CREATE VIEW V_EMP_JOB2
AS
SELECT eno,ename,dno,job
FROM emp_second
WHERE job LIKE 'SALESMAN';

SELECT *
FROM v_emp_job2;

-- 보안을 위한 뷰 활용하기
CREATE VIEW V_EMP_JOB_SAMPLE
AS
SELECT eno,ename,job,manager,dno
FROM emp_second;

COMMIT;

SELECT *
FROM v_emp_job_sample;

-- 정보를 쉽게 얻기 위해서 뷰 활용하기
CREATE VIEW V_EMP_COMPLEX2
AS
SELECT e.eno, e.ename, e.salary, dno, d.dname, d.loc
FROM emp_second e NATURAL JOIN dept_second d;

SELECT *
FROM v_emp_complex2;

-- USER_VIEWS 데이터 사전 살피기
SELECT view_name, text
FROM USER_VIEWS;

-- 뷰를 통해 기본 테이블에 데이터 추가하기
INSERT INTO v_emp_job
VALUES(8000,'펭수',30,'SALASMAN');

COMMIT;

SELECT *
FROM v_emp_job;

SELECT *
FROM emp_second;

-- 뷰에 그룹함수 사용하기(별칭 사용)
CREATE VIEW V_EMP_SALARY
AS 
SELECT dno, SUM(salary) AS "SAL_SUM", AVG(salary) AS "SAL_AVG"
FROM emp_second
GROUP BY dno;

COMMIT;

-- 뷰 사용하기
SELECT *
FROM v_emp_salary;

-- 주의 사항
CREATE VIEW V_EMP_SALARY
AS 
SELECT dno, SUM(salary), AVG(salary) AS
FROM emp_second
GROUP BY dno; -- 작동 안됩니다.

-- 주의 사항
SELECT *
FROM v_emp_salary;

INSERT INTO v_emp_salary
VALUES(8010,1000,300);


-- 뷰 제거하기
DROP VIEW V_EMP_JOB;
COMMIT;

SELECT *
FROM v_emp_job;

-- 뷰 내용 변경하기
SELECT *
FROM v_emp_job2;

CREATE OR REPLACE VIEW v_emp_job2
AS 
SELECT eno,ename,dno,job
FROM emp_second
WHERE job LIKE 'MANAGER';

SELECT *
FROM v_emp_job2;

-- 주의 사항
CREATE OR REPLACE VIEW v_emp_NOTABLE
AS 
SELECT eno,ename,dno,job
FROM emp_notable
WHERE job LIKE 'MANAGER';

-- 기존 테이블이 존재하지 않더라도 뷰 생성하기
CREATE OR REPLACE FORCE VIEW V_EMP_NOTABLE
AS
SELECT eno,ename,dno,job
FROM emp_notable
WHERE job LIKE 'MANAGER';

SELECT view_name, text
FROM USER_VIEWS
WHERE view_name IN('V_EMP_NOTABLE');

-- 담당 업무가 MANAGER인 사원들을 조회하는 뷰 생성하기
CREATE OR REPLACE FORCE VIEW V_EMP_NOCHK
AS
SELECT eno,ename,dno,job
FROM emp_second
WHERE job LIKE 'MANAGER';

-- 뷰 조회하기
SELECT *
FROM v_emp_nochk;

-- 뷰에 사원을 추가하되 담당업무를 SALESMAN으로 지정하기
INSERT INTO v_emp_nochk
VALUES(9000,'라이언',30,'SALESMAN');

INSERT INTO v_emp_nochk
VALUES(9010,'무지',30,'MANAGER');

COMMIT;

SELECT *
FROM v_emp_nochk;

SELECT *
FROM emp_second;

CREATE OR REPLACE FORCE VIEW V_EMP_CHK
AS
SELECT eno,ename,dno,job
FROM emp_second
WHERE job LIKE 'MANAGER' WITH CHECK OPTION;

INSERT INTO v_emp_chk
VALUES(9020,'어피치',30,'SALESMAN');

-- 담당 업무가 MANAGER

CREATE OR REPLACE FORCE VIEW V_EMP_READONLY
AS
SELECT eno,ename,dno,job
FROM emp_second
WHERE job LIKE 'MANAGER' WITH READ ONLY;

COMMIT;

-- 뷰에 담당업무가 MANAGER인 사원 추가하기
INSERT INTO v_emp_readonly
VALUES(9020,'어피치',30,'MANAGER');
