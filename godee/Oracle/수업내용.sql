--전체 사원 출력하기
SELECT *
FROM employee;

--사원 번호와 사원명만 출력하기

SELECT eno, ename 
FROM employee;

--연봉 구하기
SELECT ename, salary, salary*12
FROM employee;

--커미션을 더한 연봉 구하기

SELECT ename, salary, job, dno, commission, salary*12, salary*12+commission
FROM employee;



-- NVA 함수 사용하기 

SELECT ename, salary, job, dno, NVA(commission,0) , salary*12, salary*12+NVA(commission,0)
FROM employee;

-- 컬럼명에 별칭 지정하기

SELECT ename, salary*12+NVL(commission,0) 연봉
FROM employee;

--컬럼명과 별칭 사이에 AS 추가하기


SELECT ename, salary*12+NVL(commission,0) AS 연봉
FROM employee;


SELECT ename, salary*12+NVL(commission,0) AS "연 봉"
FROM employee;

--사원테이블에서, 부서번호를 한번씩만 출력하기 

SELECT dno DISTRICT
FROM employee;

-- DUAL 테이블의 구조 확인하기
DESC dual;

--DUMMY 컬럼값 확인하기 
SELECT *
FROM dual;

--오늘 날짜 출력하기 

SELECT sysdate
FROM dual;