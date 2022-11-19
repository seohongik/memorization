SHOW USER;
DESC employee;

-- 반올림 하기
SELECT  ROUND(1234.5678), ROUND(1234.5678,2), ROUND(1234.5678,-1)
FROM dual;

-- 잘라내기
SELECT TRUNC(1234.5678), TRUNC(1234.5678, 2), TRUNC(1234.5678, -1)
FROM dual;

-- 나머지 반환하기
SELECT MOD(31,2), MOD(31,5), MOD(31,8)
FROM dual;

-- 모든 사원의 급여를 500으로 나눈 나머지를 계산해주세요.
SELECT ename,salary,MOD(salary, 500)as "나머지"
FROM employee;

-- 현재 날짜 표시하기
SELECT SYSDATE
FROM dual;

-- 날짜 계산하기
SELECT SYSDATE - 1 어제, SYSDATE 오늘, SYSDATE + 1 내일
FROM dual;

-- 모든 사원들의 근무 일수 계산하기
SELECT eno, ename, dno, ROUND(SYSDATE-hiredate) AS 근무일수
FROM employee;

-- 특정 날짜에서 월을 기준으로 버림한 날짜 구하기
SELECT hiredate, TRUNC(hiredate, 'MONTH'), ROUND(hiredate, 'MONTH')
FROM employee;

-- 모든 사원들의 근무 개월수 계산하기
SELECT eno, ename, dno, ROUND(MONTHS_BETWEEN(SYSDATE,hiredate)) AS "근무 개월수"
FROM employee;

SELECT eno, ename, hiredate, ADD_MONTHS(hiredate, 6) as "입사 후 6개월 뒤"
FROM employee;

-- 오늘을 기준으로 최초로 도래하는 토요일 구하기
SELECT SYSDATE, NEXT_DAY(SYSDATE, 7)
FROM dual;

SELECT SYSDATE, LAST_DAY(SYSDATE)
FROM dual;

-- 각 사원들의 입사한 달의 마지막 날 구하기
SELECT eno,ename,dno,hiredate,LAST_DAY(hiredate) as "마지막날"
FROM employee;

SELECT ename, hiredate, TO_CHAR(hiredate, 'YY/MM'), TO_CHAR(hiredate, 'YYYY/MM/DD DAY')
FROM employee;

-- 현재 날짜와 시간 출력하기
SELECT TO_CHAR(SYSDATE, 'YYYY,MM.DD HH:MI:SS'), TO_CHAR(SYSDATE, 'YYYY,MM/DD HH24:MI:SS')
FROM dual;

-- 각 사원의 급여를 출력하면서 통화기호 덧붙이기
SELECT ename, TO_CHAR(salary,'L999,999'),TO_CHAR(salary,'L000,000')
FROM employee;

-- 1981년 2월 20일에 입사한 사원을 검색하기
SELECT ename, hiredate, TO_DATE(hiredate, 'YY/MM/DD')
FROM employee
WHERE hiredate= TO_DATE(19810220, 'YYYY/MM/DD');

-- 수치 형태로 변환한 후 빼기
SELECT TO_NUMBER('100,000', '999,999') - TO_NUMBER('50,000', '999,999') AS 금액
FROM dual;

-- NULL값 처리하기
SELECT ename, job, NVL(commision, 0), salary*12+NVL(commision,0)
FROM employee
ORDER BY job;

-- NULL값 처리하기
SELECT ename, job, salary, commision, NVL2(commision, salary*12+commision ,salary*12)
FROM employee;

-- NULL값 처리하기
SELECT NULLIF('A', 'A'), NULLIF('A', 'B')
FROM dual;

-- NULL 값 처리하기
-- 만일 모든 expr가 모두 NULL이면 0을 출력합니다.
SELECT ename, salary, commision, COALESCE(COMMISION, SALARY)
FROM employee
ORDER BY job;

-- DECODE로 부서 이름 출력하기
SELECT ename, dno,
        DECODE (dno,    10,'ACCOUNTING',
                        20,'RESEARCH',
                        30,'SALES',
                        40,'OPERATIONS',
                        'DEFAULT'
                        ) as "dname"
FROM employee
ORDER BY dno;

-- 부서 이름 출력하기
SELECT ename, dno, 
       CASE 
            WHEN dno=10 THEN 'ACCOUNTING'
            WHEN dno=20 THEN 'RESEARCH'
            WHEN dno=30 THEN 'SALES'
            ELSE 'DEFAULT'
            END AS "dname"       
FROM employee
ORDER BY dno;