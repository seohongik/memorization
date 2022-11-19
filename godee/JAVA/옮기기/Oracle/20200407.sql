-- 테이블의 구조
DESC employee;
DESC department;
DESC salgrade;

-- 테이블 삭제하기
DROP TABLE employee;
DROP TABLE department;
DROP TABLE salgrade;
COMMIT;


-- 25기 김예찬 부서테이블 생성하기
CREATE TABLE DEPARTMENT 
(
DNO     NUMBER(2)           NOT NULL,          --부서번호
DNAME   VARCHAR2(14)        NOT NULL,          --부서명
LOC     VARCHAR2(13)        NOT NULL,          --지역명
CONSTRAINT PK_DEPT PRIMARY KEY(DNO)
);

COMMIT;



-- 25기 김예찬 부서테이블 구조 확인하기
DESC department;






-- 25기 김예찬 사원테이블 구조 생성하기(2)
CREATE TABLE EMPLOYEE 
(
ENO         NUMBER(4)       NOT NULL,                     -- 사원번호  
ENAME       VARCHAR2(10)    NOT NULL,                     -- 사원명
JOB         VARCHAR2(9)     NOT NULL,                     -- 업무명
MANAGER     NUMBER(4),                                    -- 해당사원의 상사번호 
HIREDATE    DATE            NOT NULL,                     -- 입사일
SALARY      NUMBER(7,2)     NOT NULL,                     -- 급여
COMMISION   NUMBER(7,2),                                  -- 커미션
DNO         NUMBER(2)       NOT NULL,                     -- 부서번호
CONSTRAINT PK_EMP PRIMARY KEY(ENO),
CONSTRAINT FK_DNO FOREIGN KEY(DNO) REFERENCES DEPARTMENT            
);

COMMIT;



-- 25기 김예찬 사원테이블 구조 확인하기(2)
DESC employee;



-- 25기 김예찬 급여테이블 생성하기(2)
CREATE TABLE SALGRADE
(
GRADE       NUMBER      NOT NULL,        -- 급여 등급
LOSAL       NUMBER      NOT NULL,        -- 급여 하한값
HISAL       NUMBER      NOT NULL,        -- 급여 상한값
CONSTRAINT PK_SAL PRIMARY KEY(GRADE)
);

COMMIT;



-- 25기 김예찬 급여테이블 구조 확인하기(2)
DESC salgrade;



INSERT INTO DEPARTMENT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPARTMENT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPARTMENT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPARTMENT VALUES (40,'OPERATIONS','BOSTON');

INSERT INTO EMPLOYEE VALUES
(7369,'SMITH','CLERK',    7902,to_date('17-12-1980','dd-mm-yyyy'),800,NULL,20);
INSERT INTO EMPLOYEE VALUES
(7499,'ALLEN','SALESMAN', 7698,to_date('20-2-1981', 'dd-mm-yyyy'),1600,300,30);
INSERT INTO EMPLOYEE VALUES
(7521,'WARD','SALESMAN',  7698,to_date('22-2-1981', 'dd-mm-yyyy'),1250,500,30);
INSERT INTO EMPLOYEE VALUES
(7566,'JONES','MANAGER',  7839,to_date('2-4-1981',  'dd-mm-yyyy'),2975,NULL,20);
INSERT INTO EMPLOYEE VALUES
(7654,'MARTIN','SALESMAN',7698,to_date('28-9-1981', 'dd-mm-yyyy'),1250,1400,30);
INSERT INTO EMPLOYEE VALUES
(7698,'BLAKE','MANAGER',  7839,to_date('1-5-1981',  'dd-mm-yyyy'),2850,NULL,30);
INSERT INTO EMPLOYEE VALUES
(7782,'CLARK','MANAGER',  7839,to_date('9-6-1981',  'dd-mm-yyyy'),2450,NULL,10);
INSERT INTO EMPLOYEE VALUES
(7788,'SCOTT','ANALYST',  7566,to_date('13-07-1987', 'dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMPLOYEE VALUES
(7839,'KING','PRESIDENT', NULL,to_date('17-11-1981','dd-mm-yyyy'),5000,NULL,10);
INSERT INTO EMPLOYEE VALUES
(7844,'TURNER','SALESMAN',7698,to_date('8-9-1981',  'dd-mm-yyyy'),1500,0,30);
INSERT INTO EMPLOYEE VALUES
(7876,'ADAMS','CLERK',    7788,to_date('13-07-1987', 'dd-mm-yyyy'),1100,NULL,20);
INSERT INTO EMPLOYEE VALUES
(7900,'JAMES','CLERK',    7698,to_date('3-12-1981', 'dd-mm-yyyy'),950,NULL,30);
INSERT INTO EMPLOYEE VALUES
(7902,'FORD','ANALYST',   7566,to_date('3-12-1981', 'dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMPLOYEE VALUES
(7934,'MILLER','CLERK',   7782,to_date('23-1-1982', 'dd-mm-yyyy'),1300,NULL,10);

INSERT INTO SALGRADE VALUES (1, 700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);

COMMIT;


-- 전체 사원 출력하기
SELECT * 
FROM employee;

--사원본호와 사원명만 출력하기
SELECT eno, ename 
FROM employee;


--연봉구하기
SELECT ename, salary, salary*12
FROM employee;


--커미션을 더한 연봉 구하기
SELECT ename, salary, job, dno, commision, salary*12, salary*12+commision
FROM employee;

--NVL 함수 사용하기
SELECT ename, salary, job, dno, NVL(commision,0), salary*12, salary*12+NVL(commision, 0)
FROM employee;


-- 칼럼명에 별칭 지정하기
SELECT ename, salary*12+NVL(commision, 0) 연봉
FROM employee;


-- 컬럼명과 별칭 사이에 AS추가하기
SELECT ename, salary*12+NVL(commision, 0) AS 연봉
FROM employee;


-- ""로 별칭 지정하기
SELECT ename, salary*12+NVL(commision, 0) AS "연    봉"
FROM employee;


--사원테이블에서 부서번호를 한번씩만 출력하기
SELECT DISTINCT dno 
FROM employee;

-- DUAL 테이블의 구조 확인
DESC dual;

-- DUMMY 컬럼값 확인하기
SELECT *
FROM dual;

-- 오늘 날짜 출력하기
SELECT sysdate
FROM department;

SELECT sysdate
FROM dual;

