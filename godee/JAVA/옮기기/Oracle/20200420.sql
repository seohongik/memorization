-- SCOTT과 동일한 부서에서 근무하는 사원 출력하기
SELECT  ename, dno
FROM    employee
WHERE   dno = ( 
            SELECT  dno
            FROM    employee
            WHERE   ename='SCOTT'
);  

-- 최소 급여를 받는 사원의 이름, 담다업무, 급여 출력하기
SELECT ename, job, salary
FROM employee
WHERE salary = (
                SELECT MIN(salary)
                FROM employee
                );
                
-- 부서번호가 30번인 사원의 최소급여를 구한후, 부서별 최소 급여가 구한 최소 급여보다 큰 부서만 출력하기
SELECT dno, MIN(salary)
FROM employee
GROUP BY dno
HAVING MIN(salary) > (
                        SELECT MIN(salary) 
                        FROM employee
                        WHERE dno= 30
                      );
            
                      
-- IN 연산자 사용하기
SELECT eno, ename
FROM employee
WHERE salary IN (
                SELECT MIN(salary)
                FROM employee
                GROUP BY dno
                );

-- 직급이 SALESMAN이 아니면서 급여가 임의의 SALESMAN보다 낮은 사원 출력하기
-- 최대 급여

SELECT eno, ename, job, salary
FROM employee
WHERE salary <ANY(
                    SELECT salary
                    FROM employee
                    WHERE job = 'SALESMAN'
)
AND job <> 'SALESMAN';


최소급여
SELECT MIN(salary)
FROM employee
WHERE job = 'SALESMAN';


-- 직급이 SALESMAN이 아니면서 직급이 SALESMAN인 사원보다 급여가 적은 사원 출력하기
SELECT eno, ename, job, salary
FROM employee
WHERE salary <ALL (
                    SELECT MIN(salary)
                    FROM employee
                    WHERE job = 'SALESMAN'
)
AND job <> 'SALESMAN';


-- 부서 정보를 저장하기 위한 테이블 생성하기
CREATE TABLE DEPT (
    dno         NUMBER(2),
    dname       VARCHAR2(14),
    loc         VARCHAR2(13)
);

COMMIT;

DESC dept;

-- 서브 쿼리 문으로 부서 테이블의 구조와 데이터 복사합기
CREATE TABLE DEPT_SECOND
AS
SELECT *
FROM department;


commit;

DESC dept_second;

SELECT *
FROM dept_second;

--20번 부서 소속 사원에 대한 정보를 포함한 DEPT20 테이블 생성하기
CREATE TABLE DEPT20
AS
SELECT eno, ename, salary*12 "annsal"
FROM employee
WHERE dno=20;

COMMIT;

SELECT *
FROM dept20;

-- 부서 테이블을 구조만 복사하기
CREATE TABLE DEPT_THIRD
AS
SELECT dno, dname
FROM department
WHERE 0=1;

COMMIT;

SELECT *
FROM dept_third;

--사원 테이블에 날짜 타입을 가지는 birth 컬럼 추가하기
ALTER TABLE DEPT20
ADD(
    birth date);
);

COMMIT;

SELECT *
FROM DEPT20;

-- 사원이름 컬럼 크기 변경하기
ALTER TABLE DEPT20
MODIFY ename VARCHAR2(30);

COMMIT;

DESC dept20;

SELECT *
FROM dept20;

-- 사원 테이블에서 사원이름 컬럼 제거하기
ALTER TABLE DEPT20
DROP COLUMN ename;

COMMIT;

DESC dept20;

SELECT *
FROM dept20;

-- 사원 테이블에서 사원번호 제거하기
ALTER TABLE DEPT20
SET UNUSED (eno);

COMMIT;

DESC dept20;

SELECT *
FROM dept20;

-- 현재 unused로 표시된 모든 컬럼을 제거하기
ALTER TABLE DEPT20
DROP UNUSED COLUMNS;

DESC dept20;

SELECT *
FROM dept20;

-- 테이블명 변경하기
RENAME dept20 TO emp20;

COMMIT;

DESC emp20;

-- 테이블 제거하기
DROP TABLE emp20;

COMMIT;

DESC emp20;

-- 테이블의 모든 데이터 제거하기
TRUNCATE TABLE dept_second;

COMMIT;

DESC dept_second;

SELECT *
FROM dept_second;



