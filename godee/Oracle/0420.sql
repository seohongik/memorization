--부서 정보를 저장하기 위한 테이블 생성하기 

CREATE TABLE DEPT(
    dno     NUMBER(2),
    dname   VARCHAR2(14),
    LOC     VARCHAR2(13)
);

COMMIT;

DESC dept;

--서브 쿼리문으로 부서 테이블의 구조와 데이터 복사하기

CREATE TABLE DEPT_SECOND
AS
SELECT *
FROM department;

COMMIT;

DESC dept_second;

SELECT *
FROM dept_second;

--20번 수버 소속 사원에 대한 정보를 포함한 DEPT20 테이블 생성하기 

CREATE TABLE DEPT20
AS
SELECT eno, ename, salary*12 annsal
FROM employee
WHERE dno=20;

COMMIT;

SELECT *
FROM dept20;

--부서 테이블을 구조만 복사하기
CREATE TABLE DEPT_THIRD
AS
SELECT dno, dname
FROM department
WHERE 0=1;

COMMIT;

SELECT * 
FROM dept_third;

--사원 테이블에 날짜 타입을 가지는 birth 칼럼 추가하기

ALTER TABLE DEPT20
ADD(birth date);

COMMIT;

DESC dept20;

SELECT *
FROM dept20;

--사원 이름 컬럼, 크기 변경하기 

ALTER TABLE DEPT20
MODIFY ename VARCHAR2(30);

COMMIT;

SELECT*
FROM dept20;

--사원 테이블에서 사원이름 컬럼 제거하기 

ALTER TABLE DEPT20
DROP COLUMN ename;


COMMIT;

DESC dept20;

SELECT*
FROM dept20;

--사원 테이블에서 사원번호 제거하기 

ALTER TABLE DEPT20
SET UNUSED (eno);

COMMIT;

DESC dept20;

SELECT*
FROM dept20;

--현재 UNUSED로 표시된 모든 컬럼 제거하기 

ALTER TABLE DEPT20
DROP UNUSED COLUMNS;

COMMIT;

DESC dept20;

SELECT *
FROM dept20;

--테이블명 변경하기 

RENAME dept20 TO emp20;

COMMIT;

DESC dept20;

DESC emp20;

-- 테이블 제거하기
DROP TABLE emp20;

COMMIT;

DESC emp20;

--테이블의 모든 데이터 제거하기 

TRUNCATE TABLE dept_second;

COMMIT;

DESC dept_second;

SELECT *
FROM dept_second;
