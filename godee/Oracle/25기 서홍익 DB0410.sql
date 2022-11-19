--반올림하기 

SELECT  ROUND(1234.5678),
        ROUND(1234.5678,2),
        ROUND(1234.5678,-1)
FROM dual;

--잘라내기

SELECT  TRUNC (1234.5678),
        TRUNC (1234.5678,2),
        TRUNC (1234.5678,-1)
FROM dual;


--나머지 반환하기 

SELECT  MOD(31,2),
        MOD(31,5),
        MOD(31,8)

FROM dual;

--모든 사원의 급여를 500으로 나눈 나머지를 계산해주세요
--이름 , 급여 , 나머지 

SELECT ename 이름, salary 급여, MOD(salary,500) AS 나머지
FROM employee;

--현재 날짜 포기하기

SELECT SYSDATE
FROM dual;

--날짜 계산하기

SELECT SYSDATE-1 어제, SYSDATE 오늘 , SYSDATE+1 내일
FROM dual;

--모든 사원들의 근무일수 계산하기

SELECT eno, ename, dno, ROUND(SYSDATE -hiredate) AS 근무일수
FROM employee;

--특정 날짜에서 월을 기준으로 버림한 날짜 구하기 

SELECT hiredate, TRUNC(hiredate,'MONTH')
FROM employee;

-- 각 사원들이 근무한 개월수 구하기 

SELECT eno, ename, dno, TRUNC(MONTHS_BETWEEN(SYSDATE,hiredate)) "근무개월수"
FROM employee;

--각 사원들이 입사한지 6개월이 지난 날짜 구하기

SELECT eno, ename, dno, hiredate, ADD_MONTHS(hiredate,6) AS "입사후 6개월"
FROM employee;

--오늘을 기준으로 최초로 도래하는 토요일 구하기
--오라클은 일요일이 1이므로 토요일은 7
--다른랭귀지는 일요일이0 이므로 토요일은 6

SELECT SYSDATE, NEXT_DAY(SYSDATE,'토요일')
FROM dual;

SELECT SYSDATE, NEXT_DAY(SYSDATE,7)
FROM dual;

--각 사원들의 입사한 달의 마지막 날 구하기

SELECT eno, ename, dno, hiredate, LAST_DAY(hiredate) AS 마지막날
FROM employee;

-- 날짜 함수 사용하기 

SELECT ename, hiredate,
        TO_CHAR(hiredate, 'YY/MM'),
        TO_CHAR(hiredate, 'YYY/MM/DD DAY')
FROM employee;

-- 현재 날짜와 시간 출력하기
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH:MI:SS'),
        TO_CHAR(SYSDATE, 'YYYY/MM/DD HH24:MI:SS')
FROM dual;

--각 자원의 급여를 출력하면서 통화기호 덧붙이기 
SELECT ename,
        TO_CHAR(salary, 'L999,999'),
        TO_CHAR(salary, 'L000,000')
FROM employee;

--8881981년 2월 20일에 입사한 사원을 검색하기 

SELECT eno, ename,hiredate
FROM employee
WHERE hiredate ='81/02/20';

SELECT eno, ename,hiredate
FROM employee
WHERE hiredate = TO_DATE(19810220,'YYYYMMDD');


--***수치 형태로 변환한 후 빼기

SELECT TO_NUMBER('100,000','999,999')- TO_NUMBER('50,000','999,999') AS 급액
FROM dual;

--NULL 값 처리하기 

SELECT ename, job, NVL(commision,0), salary*12+NVL(commision,0)
FROM employee
ORDER BY job;

--NULL 값 처리하기


SELECT ename, job, salary, commision, NVL2(commision,salary*12+commision,salary*12) 
FROM employee
ORDER BY job;

--NULL 값 처리하기 (ex 자동입력 방지) NULLIF는 널이 아닐경우 첫번째 값 반환
SELECT NULLIF('A','A'), NULLIF('A','B')
FROM dual;


--NULL값 처리하기 
--만일 커미션과 급여가 모두 NULL이면 0을 출력합니다.
SELECT  commision, salary, ename , COALESCE(commision,salary,0)
FROM employee
ORDER BY job;

--부서이름 출력하기 

SELECT ename, dno, 
        DECODE(
            dno,10,'ACCONTING',
                20,'RESERCH',
                30,'SALES',
                40,'OPERATIONS',
                'DEFAULT'
        ) AS dname
FROM employee
ORDER BY dno;

--부서이름 출력하기 

SELECT ename, dno,
    CASE 
        WHEN dno=10 THEN'ACCOUNTING'
        WHEN dno=20 THEN'RESERCH'
        WHEN dno=30 THEN'SALES'
        WHEN dno=40 THEN'OPERATIONS'
        ELSE 'DEFAULT'
    END AS dname
FROM employee
ORDER BY dno;
