-- SCOTT과 동일한 부서에서 근무하는 사원 출력
SELECT ename,dno
FROM   employee
WHERE  dno=(
            SELECT dno
            FROM employee
            WHERE ename='SCOTT'
            );

SELECT ename, dno
FROM employee
WHERE ename='SCOTT';



--최소 급여를 받는 사원의 이름 담당업무 급여 출력하기
SELECT ename, job ,salary
FROM employee
WHERE salary=(
            SELECT MIN(salary)
            FROM employee 
            );

-- 부서번호가 30번인 사원의 최소급여를 구한 후 부서별 최소 급여가 구한 최소급여(950)보다 큰 부서만 출력하기 
SELECT dno, MIN(salary)
FROM employee
GROUP BY dno
HAVING MIN(salary)>(
                    SELECT MIN(salary)
                    FROM employee
                    WHERE dno=30                
                  );
                  
                  
--IN 연산자 사용하기 
SELECT eno, ename
FROM employee
WHERE salary IN(
            SELECT MIN(salary)
            FROM employee
            GROUP BY dno
                );


SELECT MIN(salary)
FROM employee
GROUP BY dno;

--직급이 SAESMAN 이 아니면서 급여가 임의의 SALESMAN 보다 낮은 사원 출력하기 

--최대 급여 
SELECT eno, ename, job, salary
FROM employee
WHERE salary <ANY(
            SELECT salary
            FROM employee
            WHERE job='SALESMAN'
            )
            
AND job != 'SALESMAN';

SELECT MAX(salary)
FROM employee
WHERE job='SALESMAN';

--최소급여
SELECT MIN(salary)
FROM employee
WHERE job='SALESMAN';

-- 직급이 'SALESMAN'이 아니면서 직급이 SALESMAN인 사원 보다 급여가 적은 사원 출력하기

SELECT eno, ename, job, salary
FROM employee
WHERE salary < ALL(
            SELECT MIN(salary)
            FROM employee
            WHERE job='SALESMAN'
            )
AND job!='SALESMAN';