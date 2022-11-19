SHOW USER;
DESC employee;
DESC department;
DESC salgrade;

SELECT *
FROM employee;

CREATE TABLE RRRR 
(
A   NUMBER(2) NOT NULL,
B   NUMBER NOT NULL,
C   NUMBER,
D   VARCHAR2(13) NOT NULL,
CONSTRAINT PK_RR PRIMARY KEY(A)
);

SELECT *
FROM RRRR;

DESC RRRR;

DROP TABLE RRRR;
COMMIT;

-- 사원들의 입사한 년도와 입사한 달만 출력하시오.
SELECT TO_CHAR(hiredate, 'YY/MM')
FROM employee;

-- 4월에 입사한 사원을 출력하시오.
SELECT *
FROM employee
WHERE TO_CHAR(hiredate, 'MM')=4;

SELECT *
FROM employee
WHERE TO_DATE(19810402, 'YYYY/MM/DD')=hiredate;

SELECT *
FROM employee
WHERE TO_DATE(TRUNC(hiredate, 'DAY'), 'YY/MM')='8104';

-- 사원번호가 짝수인 사원만 출력하시오
SELECT *
FROM employee
WHERE MOD(eno, 2)=0;


-- 입사일을 연도는 2자리(YY), 월은 숫자(MON)로 표시하고 요일은(DY)로 지정하여 출력하시오
SELECT hiredate, TO_CHAR(hiredate, 'YY/MON/DY')
FROM employee;

-- 올해 며칠이 지났는지 출력하시오. 현재 날짜에서 올해 1월 1일을 뺀 결과를 출력하고 테이형을 일치시키시오.
SELECT SYSDATE AS "오늘 날짜", TRUNC((SYSDATE - TO_DATE(20200101, 'YYYY/MM/DD')), 0)
FROM dual;

-- 사원들의 상사 사원번호를 출력하되 상사가 없는 사원에 대해서는 NULL 값 대신 0으로 출력하시오.
SELECT eno, ename, NVL(manager, 0) AS "MANAGER"
FROM employee;

-- 직급에 따라 급여를 인상하도록 하시오. 직급이 'ANALYST인 사원은 200, 'SALESMAN'인 사원은 180, 'MANAGER'인 사원은 150, 'CLERK'인 사원은 100을 인상하시오.

SELECT eno, ename, job, salary,
        DECODE (job,    'ANALYST', (salary+200),
                        'SALESMAN', (salary+180),
                        'MANAGER', (salary+150),
                        'CLERK', (salary+100),
                        salary
                        ) AS "인상된 급여"
FROM employee;

SELECT eno, ename, job, salary,
       CASE 
            WHEN job= 'ANALYST' THEN salary + 200
            WHEN job ='SALESMAN' THEN salary + 180
            WHEN job = 'MANAGER' THEN salary + 150
            WHEN job = 'CLERK' THEN salary + 100
            ELSE salary
            END AS "인상된 급여"       
FROM employee
ORDER BY dno;

SELECT ename, salary, commision, COALESCE(COMMISION, SALARY)
FROM employee
ORDER BY job;

-- 사원들의 급여 총액, 평균액, 최고액, 최소액을 출력하기
SELECT  SUM(salary) as "급여총액",
        AVG(salary) as "급여평균",
        MAX(salary) as "최대급여",
        MIN(salary) AS "최소급여"
FROM employee;

-- 최근에 입사한 사원과 가장 오래전에 입사한 사원의 입사일을 출력하기
SELECT MAX(hiredate), MIN(hiredate)
FROM employee;

-- 사원들의 커미션 총액을 출력하기
SELECT SUM(commision) "커미션 총액"
FROM employee;

-- 전체 사원 수를 구하기
SELECT COUNT(*) "사원의 수"
FROM employee;


-- 커미션을 받는 애들 구하기
SELECT *
FROM employee
WHERE commision IS NOT NULL;

SELECT COUNT(commision) as "커미션 받는 사원 수"
FROM employee;

-- 업무 종류의 개수를 출력하기
SELECT COUNT(DISTINCT job) "직업 종류의 개수"
FROM employee;

-- 주의 사항 오류 발생
SELECT ename, MAX(salary)
FROM employee;
--ORA-00937: not a single-group group function
--00937. 00000 -  "not a single-group group function"
--*Cause:    
--*Action:

-- 소속 부서별 평균 급여를 부서번호와 함께 출력하기
SELECT dno "부서번호", AVG(salary) "급여평균"
FROM employee
GROUP BY dno;

-- 소속 부서별 평균 급여 구하기
SELECT AVG(salary) "급여평균"
FROM employee
GROUP BY dno;

-- 주의사항
SELECT dno, ename, AVG(salary)
FROM employee
GROUP BY dno;
--ORA-00979: not a GROUP BY expression
-- 00979. 00000 -  "not a GROUP BY expression"

-- 다중컬럼을 이용하여 그룹별로 검색하기
SELECT dno, job, COUNT(*), SUM(salary)
FROM employee
GROUP BY dno, job
ORDER BY dno, job;

-- 부서별 급여 총액이 3000 이상인 부서의 번호와 부서별 급여 총액 구하기
SELECT dno, SUM(salary)
FROM employee
GROUP BY dno
HAVING MAX(salary) >= 3000;

-- MANAGER를 제외하고 급여 총액이 5000 이상인 직급(업무)별 급여 총액 구하기
SELECT job "직급", COUNT(*) "사원수", SUM(salary) "급여 총액"
FROM employee
WHERE job != 'MANAGER'
GROUP BY job
HAVING SUM(salary) >= 5000
ORDER BY SUM(salary);

-- 평균 급여 중 최고 급여를 출력하기
SELECT MAX(AVG(salary)) 
FROM employee
GROUP BY dno;

-- 주의할것
SELECT AVG(MAX(salary)) 
FROM employee
GROUP BY dno;

SELECT dno, AVG(salary)
FROM employee
GROUP BY dno;

