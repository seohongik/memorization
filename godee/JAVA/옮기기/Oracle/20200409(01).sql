SHOW USER;
DESC employee;
DESC department;
DESC salgrade;

SELECT *
FROM employee;

SELECT *
FROM department;

SELECT ename, salary, dno as 부서, NVL(commision, 0) AS commision
FROM employee
WHERE ename LIKE '_l%'
ORDER BY dno DESC;

-- 1981년 2월 20일부터 1981년 5월 1일 사이에 입사한 사원의 이름, 담당 업무, 입사일을 출력하시오.
SELECT eno, job, hiredate
FROM employee
WHERE hiredate BETWEEN '1981/2/20' AND '1981/5/1';

SELECT eno, job, hiredate
FROM employee
WHERE hiredate >= '1981/2/20' AND hiredate <= '1981/5/1';


-- 부서번호가 20 및 30에 속한 사원의 이름과 부서번호를 출력하되 이름을 기준(내림차순)으로 영문자순으로 출력하시오.
SELECT ename, dno
FROM employee
WHERE dno = 20 or dno =30
ORDER BY ename DESC;

SELECT ename, dno
FROM employee
WHERE dno IN (20, 30)
ORDER BY ename DESC;


-- 사원의 급여가 2000에서 3000 사이에 포함되고 부서번호가 20 또는 30인 사원의 이름, 급여와 부서번호를 출력하되 이름 순(오름차순)으로 출력하시오.
SELECT ename, salary, dno
FROM employee
WHERE salary >=2000 AND salary <= 3000 AND dno IN(20,30)
ORDER BY ename ASC;

SELECT ename, salary, dno
FROM employee
WHERE salary BETWEEN 2000 AND 3000 AND dno IN(20,30)
ORDER BY ename ASC;

-- 1981년도에 입사한 사원의 이름과 입사일을 출력하시오.
SELECT ename, hiredate
FROM employee
WHERE hiredate BETWEEN '1981/1/1' AND '1981/12/31';

SELECT ename, hiredate
FROM employee
WHERE hiredate >= '1981/1/1' AND hiredate <= '1981/12/31';

SELECT ename, hiredate
FROM employee
WHERE NOT hiredate < '1981/1/1' AND NOT hiredate > '1981/12/31';


-- 상사 직원이 없는 사원의 이름과 담당 업무를 출력하시오
SELECT ename, job
FROM employee
WHERE manager IS NULL;

SELECT ename, job
FROM employee
WHERE manager IS NULL;

-- 커미션을 받을 수 있는 자격이 되는 사원의 이름, 급여, 커미션을 출력하되 급여 및 커미션을 기준으로 내림차순 정렬하여 표시하시오.
SELECT ename, salary, commision
FROM employee
WHERE commision IS NOT NULL
ORDER BY salary DESC, commision DESC;

SELECT ename, salary, commision
FROM employee
WHERE commision >= 0
ORDER BY salary DESC, commision DESC;

SELECT ename, salary, commision
FROM employee
WHERE NOT commision < 0
ORDER BY salary DESC, commision DESC;

SELECT ename, salary, commision
FROM employee
WHERE NOT commision IS NULL
ORDER BY salary DESC, commision DESC;

-- 이름의 세 번째 문자가 R인 사원의 이름을 표시하시오.
SELECT ename
FROM employee
WHERE ename LIKE '__R%';

-- 이름에 A와 E를 모두 포함하고 있는 사원의 이름을 표시하시오.
SELECT ename
FROM employee
WHERE ename LIKE '%A%E%';

SELECT ename
FROM employee
WHERE NOT(ename NOT LIKE '%A%') OR (ename NOT LIKE '%E%');

SELECT ename
FROM employee
WHERE (ename LIKE '%A%') AND (ename LIKE '%E%');

SELECT ename
FROM employee
WHERE NOT(ename NOT LIKE '%A%') AND NOT (ename NOT LIKE '%E%');

-- 담당 업무가 사무원(CLERK) 또는 영업사원(SALESMAN)이면서 급여가 $1600, $950, $1300이 아닌 사원의 이름, 담당업무, 급여를 출력하시오
SELECT ename, job, salary
FROM employee
WHERE (job='CLERK' OR job='SALESMAN') AND (salary != 1600 AND salary != 950 AND salary != 1300);

SELECT ename, job, salary
FROM employee
WHERE (job='CLERK' OR job='SALESMAN') AND (salary ^= 1600 AND salary ^= 950 AND salary ^= 1300);

SELECT ename, job, salary
FROM employee
WHERE (job='CLERK' OR job='SALESMAN') AND (salary <> 1600 AND salary <> 950 AND salary <> 1300);

SELECT ename, job, salary
FROM employee
WHERE NOT(job!='CLERK' AND job!='SALESMAN') AND (salary != 1600 AND salary != 950 AND salary != 1300);

SELECT ename, job, salary
FROM employee
WHERE NOT(job!='CLERK' AND job!='SALESMAN') AND NOT(salary = 1600 OR salary = 950 OR salary = 1300);

SELECT ename, job, salary
FROM employee
WHERE NOT((job!='CLERK' AND job!='SALESMAN') OR (salary = 1600 OR salary = 950 OR salary = 1300));


-- 커미션이 $500 이상인 사원의 이름과 급여 및 커미션을 출력하시오.
SELECT ename, salary, commision
FROM employee
WHERE commision >= 500;

SELECT ename, salary, commision
FROM employee
WHERE NOT commision < 500;
