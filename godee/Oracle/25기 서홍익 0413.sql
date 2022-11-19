--사원들의 급여 총액, 평균액,최고액, 최소액 출력하기 

SELECT  SUM(salary) AS 급여총액,
        AVG(salary) AS 급여평균,
        MAX(salary) AS 최대급여,
        MIN(salary) AS 최소급여
FROM employee;

--최근에 입사한 사원과 가장 오래전의 입사한 사원의 입사일 출력하기

SELECT MAX(hiredate), MIN(hiredate)
FROM employee;

--사원들의 커미션 총액을 출력하기 
--널값제외하고 출력
SELECT SUM(commision) "커미션 총액"
FROM employee;

--전체 사원 수를 구하기

SELECT COUNT(*) "사원의 수"
FROM employee;

-- 커미션을 받는 사원수를 구하기

SELECT *
FROM employee
WHERE commision IS NOT NULL;

SELECT COUNT(commision) "커미션 받는 사원수"
FROM employee;

--NULL값 추가 여부 확인
SELECT COUNT(*) "NULL 포함 커미션 받는 사원수"
FROM employee;

SELECT COUNT(*) "커미션 받는 사원수"
FROM employee
WHERE commision IS NOT NULL;

SELECT *
FROM employee;


--직업(업무) 종류의 개수를 출력하기
SELECT COUNT(job)
FROM employee;

--중복배제하기
SELECT COUNT(DISTINCT job) "직업종류의 개수"
FROM employee;

--주의사항 (그룹함수는 일반컬럼과 같이 쓸 수 없다)

SELECT ename, MAX(salary)
FROM employee;

--소속 부서별 평균 급여를 '부서 번호와 함께'- 그룹으로 묶는다는 의미 출력하기 
SELECT dno "부서번호 ", AVG(salary) "급여평균"
FROM employee
GROUP BY dno;

--소속 부서별 평균 급여 구하기 

SELECT AVG(salary) "급여평균"
FROM employee
GROUP BY dno;

-- 주의사항

SELECT dno, ename, AVG(salary)
FROM employee
GROUP BY dno;

--다중 컬럼을 이용하여 그룹별로 검색하기 

SELECT dno, job, COUNT(*), SUM(salary)
FROM employee
GROUP BY dno,job
ORDER BY dno,job;

--부서별 급여(그룹바이) 총액이 3000 이상(조건이니 having)인 부서의 번호와 부서별 급여 총액 구하기

SELECT dno, MAX(salary) 
FROM employee
GROUP BY dno
HAVING SUM(salary) >=3000;


-- MANAGER을 제외하고 급여 총액이 5000이상인 직급(업무별) 급여 총액 구하기

SELECT job "직급", COUNT(*) "사원수", SUM(salary) "급여 총액"
FROM employee
WHERE job NOT LIKE '%MANAGER%'
GROUP BY job
HAVING SUM(salary) >=5000
ORDER BY SUM(salary);

-- 평균 급여중 최고 급여를 출력하기

SELECT MAX( AVG(salary))
FROM employee
GROUP BY dno;

--주의사항

SELECT dno, MAX( AVG(salary))
FROM employee
GROUP BY dno, salary;

-- 결과값이 다름

SELECT AVG( MAX(salary))
FROM employee
GROUP BY dno, salary;

--두개 까지만 주의사항

SELECT SUM( AVG( MAX(salary)))
FROM employee
GROUP BY dno;

