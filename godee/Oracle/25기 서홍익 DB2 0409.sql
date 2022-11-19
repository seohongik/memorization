--2장 문제 6번 1981년 2월 20일 부터 1981년 5월 1일 사이에 입사한 사원의 이름 담당 업무 입사일을 출력하시오

SELECT ename, job, hiredate
FROM employee
WHERE hiredate >= '81/02/20' AND hiredate <= '81/05/01';

--2장 문제 7번 부서번호가 20및 30에 속한 사원의 이름과 부서번호를 출력하되 이름을 기준(내림차순)으로 영문자순으로 출력하시오

SELECT ename, dno
FROM employee
WHERE dno IN(20,30)
ORDER BY ename DESC;

--2장 문제 8번 사원의 급여가 2000에서 3000사이에 포함되고 부서번호가 20또는 30인 사원의 이름 급여와 부서번호를 출력하되 이름순(오름차순)으로 출력하시오

SELECT ename, salary, dno
FROM employee
WHERE salary >=2000 AND salary <= 3000 AND (dno=20 OR dno=30)
ORDER BY ename;

SELECT ename, salary, dno
FROM employee
WHERE salary >=2000 AND salary <= 3000 AND dno IN(20,30)
ORDER BY ename;

SELECT ename, salary, dno
FROM employee
WHERE salary >=2000 AND salary <= 3000 AND dno!=10
ORDER BY ename;



--2장 문제 9번 1981년도에 입사한 사원의 이름과 입사일을 출력하시오
SELECT ename, hiredate
FROM employee
WHERE hiredate >= '1981/01/01' AND hiredate <= '1981/12/31'
ORDER by hiredate ASC;


DESC employee;

--2장 문제 10번 상사 직원이 없는 사원의 이름과 담당업무를 출력하시오
SELECT ename, job
FROM employee
WHERE manager IS NULL;

--2장 문제 11번 커미션을 받을 수 있는 자격이 되는 사원의 이름 급여 커미션을 출력하되 급여및 서미션을 기준으로 내림차순 정렬하여 표시하시오

SELECT ename, salary, commision
FROM employee
WHERE commision IS NOT NULL 
ORDER BY salary DESC;

--2장 문제 12번 이름의 세번째 문자가 R인사원의 이름을 표시하시오


SELECT ename
FROM employee
WHERE ename LIKE '__r%';

--2문제 13번 이름에 A와 E를 모두 포함하고 있는 사원의 이름을 표시하시오

SELECT ename
FROM employee
WHERE ename LIKE '%A%' AND ename LIKE '%E%' ;

--*****2문제 14번 담당 업무가 사무원(clerk) 또는 영업사원 (salesman)이면서 급여가 $1600,$950,$1300이 아닌 사원의 이름 담당업무 급여를 출력하시오

SELECT ename, job , salary
FROM employee
WHERE salary !=1600 OR salary != 950 OR salary != 1300 AND job = 'clerk' AND job ='salesman';


--2문제 15번 커미션이 $500이상인 사원의 이름과 급여및 커미션을 출력하시오

SELECT ename, salary, commision
FROM employee
WHERE commision >= 500;

