-- 급여(salary)가 1500 이상인 사워 축력하기

SELECT *
FROM employee
WHERE salary >= 1500;

--10번 부서 소속 사원 출력하기 

SELECT *
FROM employee
WHERE dno=10;

--이름이 SCOTT인 사원 출력하기

SELECT *
FROM employee
--WHERE ename='scott';
--WHERE ename="SCOTT";
WHERE ename='SCOTT';

--입사일(hiredate)이 1981년 1월 1일 ('1981/01/01') 이전(포함)에 입사함 사원을 출력하기

SELECT *
FROM employee
WHERE hiredate <= '1981/01/01';

-- 부서 번호가 10이고 직급이 'manager'인 사원만 출력하기
SELECT *
FROM employee
WHERE  dno=10 AND job='MANAGER';

--10번 부서에 소속된 사원만 제외하고 나머지 사원의 정보 출력하기
SELECT *
FROM employee
WHERE dno=20 or dno=30 or dno=40; 

SELECT *
FROM employee
WHERE dno!=10; 


SELECT *
FROM employee
WHERE dno<>10; 


SELECT *
FROM employee
WHERE dno^=10;


SELECT *
FROM employee
WHERE NOT dno=10;

--부서 번호가 10이거나 직급이'MANAGER'인 사원만 출력하기

SELECT *
FROM employee
WHERE dno=10 OR job='MANAGER';

--급여가 1000에서 1500 사이인 사원출력하가
SELECT *
FROM employee
WHERE SALARY >= 1000 AND SALARY <= 1500;

--급여가 1000미만 1500초과인 사원 출력하기
SELECT *
FROM employee
WHERE salary <1000 OR salary>1500;

--커미션이 300 이거나 500 이거나 1400인 사원출력하기

SELECT *
FROM employee
WHERE commision= 300 OR commision =500 OR commision =1400;

--급여가 1000이상 1500이하인 사원출력하기

SELECT *
FROM employee
WHERE salary BETWEEN 1000 AND 1500;

--급여가 1000미만 1500초과인 사원 출력
SELECT *
FROM employee
WHERE salary NOT BETWEEN 1000 AND 1500;

--급여가 1000미만 1500초과인 사원 출력
SELECT *
FROM employee
WHERE salary <1000 or salary>1500;

--1982년도에 입사한 사원 출력하기
SELECT *
FROM employee
WHERE hiredate BETWEEN '1982/01/01' AND '1982/12/31';

--1982년도에 입사한 사원 출력하기
SELECT *
FROM employee
WHERE hiredate >= '1982/01/01' AND hiredate <= '1982/12/31';


--커미션이 300 이거나 500 이거나 1400인 사원출력하기

SELECT *
FROM employee
WHERE commision IN(300,500,1400);

--커미션이 300,500,1400이 아닌 모든 사원 출력하기
SELECT *
FROM employee
WHERE commision NOT IN(300,500,1400);

SELECT *
FROM employee
WHERE commision !=300 AND commision != 500 AND commision != 1400;

SELECT *
FROM employee
WHERE commision <> 300 AND commision <> 500 AND commision <> 1400;

SELECT *
FROM employee
WHERE commision ^= 300 AND commision ^= 500 AND commision ^= 1400;

SELECT *
FROM employee
WHERE NOT commision = 300 AND NOT commision = 500 AND NOT commision = 1400;


--이름이 'F'로 시작하는 사원 출력하기 
SELECT *
FROM employee
WHERE ename LIKE 'F%';

--이름이 'M'이 포함되는 사원 출력하기 

SELECT *
FROM employee
WHERE ename LIKE '%M%';

--이름이 'N'으로 끝나는 사원 출력하기 
SELECT *
FROM employee
WHERE ename LIKE '%N';

--이름의 두 번째 글자가 'A'인 사원 출력하기 

SELECT *
FROM employee
WHERE ename LIKE '_A%';

--이름의 세번째 글자가 'A'인 사원 출력하기

SELECT *
FROM employee
WHERE ename LIKE '__A%';

--이름에 글자가 'A'가 포함된 사원 제외하고 출력하기

SELECT *
FROM employee
WHERE ename NOT LIKE '%A%' ;

--사원의 이름, 사원번호, 커미션, 부서번호를 출력하기

SELECT ename, eno, commision, dno
FROM employee;


-- 커미션이 NULL 아닌 사원 출력하기
SELECT *
FROM employee
-- 틀림 WHERE commision = null;
--NULL값 추출 WHERE commision IS NULL;
WHERE commision IS NOT NULL;
--NOT IS 아님

--커미션을 받는 사원 출력하기 

SELECT *
FROM employee  
Where commision>0;

--급여순으로 사원 출력 오름차순하기

SELECT *
FROM employee
ORDER BY salary ASC; 
-- WHERE 안들어감--

--급여순으로  사원 출력 내림차순하기 
SELECT *
FROM employee
ORDER BY salary DESC; 
--틀림 ORDER BY salary NOT DESC; 

--사원의 이름을 오름차순이름 정렬하기

SELECT *
FROM employee
ORDER BY ename; 
--ORDER BY ename ASC;

--사원의 이름을 내림차순으로 정렬하기
SELECT *
FROM employee
ORDER BY ename DESC; 

--최근에 입사한 사원순으로 정렬하기
SELECT *
FROM employee
ORDER BY hiredate DESC; 

--급여가 높은 순으로 이름은 ABC순으로 정렬하기
SELECT *
FROM employee
ORDER BY salary DESC, ename ASC;

--2장 - 문제 1번
SELECT ename, salary, salary+300 
FROM employee;


--문제 2번 사원의 이름 급여 연간 총수입을 총 수입이 많은 것부터 작은순으로 출력하시오 
연간 총 수입은 월글에 12를 곱한후 $100의 상여금을 더해서 계산하시오
SELECT ename, salary, salary*12+NVL(commision,100) 연간총수입
FROM employee
ORDER BY 연간총수입 DESC;

--** 문제 3번 급여가 2000을 넘는 사원의 이름과 급여를 급여가 많은 것부터 작은 순으로 출력하시오
SELECT ename, salary
FROM employee  
WHERE salary>= 2000
ORDER BY salary desc;

--문제 4번 사원번호가 7788인 사원의 이름과 부서번호를 출력하시오.
SELECT ename, dno
FROM employee
WHERE eno=7788;

--문제 5번 급여가 2000에서 3000사이에 포함되지 않는 사원의 이름과 급여를 출력하시오

SELECT ename, salary
FROM employee
WHERE salary NOT between 2000 and 3000;

