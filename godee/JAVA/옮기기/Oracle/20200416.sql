-- 모든 사원의 급여 최고액, 최저액, 총액 및 평균 급여를 출력하시오. 
-- 칼럼의 별칭은 결과 화면과 동일하게 지정하고 평균에 대해서는 정수로 반올림하시오.
SELECT MAX(salary) "Maximun", MIN(salary) "Minimum", SUM(salary)"Sum", ROUND(AVG(salary)) "Average"
FROM employee;

-- 각 담당 업무 유형별로 급여 최고액, 최저액, 총액 및 평균액을 출력하시오. 칼럼의 별칭은 결과 화면과 동일하게 지정하고 평균에 대해서는 정수로 반올림하시오
SELECT job, MAX(salary) "Maximun", MIN(salary) "Minimum", SUM(salary)"Sum", ROUND(AVG(salary)) "Average"
FROM employee
GROUP BY job;

-- 담당 업무 유형별로 사원수를 출력하시오. 칼럼의 별칭은 결과 화면과 동일하게 지정하시오.
SELECT JOB, COUNT(job) "사원수"
FROM employee
GROUP BY job;

--상사의 수를 나열하시오. 칼럼의 별칭은 결과 화면과 동일하게 지정하시오.
SELECT COUNT(MANAGER) "상사수"
FROM employee;

-- 모든 사원의 급여 최고액, 최저액의 차액을 출력하시오. 칼럼의 별칭은 결과 화면과 동일하게 지정하시오.
SELECT (MAX(salary)-MIN(salary)) "차액"
FROM employee;

-- 직급(업무_별 사원의 최저 급여를 출력하시오. 상사를 알 수 없는 사원 및 최저 급여가 2000 미만인 그룹은 제외시키고 결과를 급여에 대한 내림차순으로 정렬하여 출력하시오.
SELECT job, MIN(salary) "최저급여"
FROM employee
WHERE MANAGER IS NOT NULL
GROUP BY job
HAVING MIN(salary) >= 2000
ORDER BY MIN(salary) DESC;

-- 각 부서에 대해서 부서번호, 사원수, 부서 내의 모든 사원의 평균 급여를 출력하시오. 칼럼의 별칭은 결과 화면과 동일하게 지정하시오.
-- 평균 급여는 소수점 둘째 자리로 반올림하시오.
SELECT dno, COUNT(dno) as "Number of People", ROUND(AVG(Salary), 2)
FROM employee
GROUP BY dno
ORDER BY dno ASC;

DESC employee;



SELECT job, MIN(salary) "최저급여"
FROM employee
WHERE MANAGER IS NOT NULL
GROUP BY job
HAVING MIN(salary) > 2000
ORDER BY MIN(salary) DESC;

-- 각 부서에 대해서 부서번호 이름, 지역명, 사원수, 부서 내의 모든 사원의 평균 급여를 출력하시오. 칼럼의 별칭은 결과 화면과 동일하게 지정하고 평균 급여는 정수로 반올림하시오.
SELECT dno, COUNT(*) as "Number of People", ROUND(AVG(Salary))
FROM employee
GROUP BY dno
ORDER BY dno ASC;

--업무를 표시한 다음 해당 업무에 대해 부서번호별 급여 및 부서 10,20,30의 급여 총액을 각각 출력하시오. 칼럼의 별칭은 결과 화면과 동일하게 지정하시오.
SELECT job, dno, SUM(salary) "부서 10", SUM(salary) "부서 20", SUM(salary) "부서 30", SUM(salary)
FROM employee
GROUP BY job, dno
ORDER BY dno;

SELECT *
FROM department;

SELECT *
FROM employee;

SELECT *
FROM employee, department;

-- 각 사원들이 소속된 부서정보 출력하기
SELECT *
FROM employee, department
WHERE employee.dno = department.dno;

-- 사원번호, 사원이름, 소속부서를 출력하기
SELECT eno, ename ,dname
FROM employee, department
WHERE employee.dno = department.dno
AND eno = 7788;

-- 주의사항
SELECT eno, ename ,dname, dno
FROM employee, department
WHERE employee.dno = department.dno
AND eno = 7788;

-- 컬럼명 앞에 테이블명 명시하기
SELECT employee.eno, employee.ename ,department.dname, employee.dno
FROM employee, department
WHERE employee.dno = department.dno
AND eno = 7788;

-- 부분적으로 컬럼명 앞에 테이블 명시하기
SELECT eno, ename, dname, employee.dno
FROM employee, department
WHERE employee.dno = department.dno
AND eno = 7788;

-- 테이블에 별칭사용하기
SELECT e.eno, e.ename, d.dname, e.dno
FROM employee e, department d
WHERE e.dno = d.dno
AND eno = 7788;


-- 조인 컬럼에 테이블 별칭을 사용하지 않은 경우
SELECT e.eno, e.ename, d.dname, dno
FROM employee e NATURAL JOIN department d
WHERE e.eno=7788;

-- USING 절 사용하기
SELECT e.eno, e.ename, d.dname, dno
FROM employee e JOIN department d
USING (dno)
WHERE e.eno=7788;

-- ON 절 사용하기
SELECT e.eno, e.ename, d.dname, e.dno
FROM employee e JOIN department d
ON e.dno = d.dno
WHERE e.eno = 7788;

-- 사원별로 급여 등급 출력하기
SELECT ename, salary, grade
FROM employee, salgrade
WHERE salary BETWEEN losal AND hisal;

SELECT ename, salary, grade
FROM employee, salgrade
WHERE salary >= losal AND salary <= hisal;

-- 3개의 테이블 조인하기
SELECT e.ename, d.dname, e.salary, s.grade
FROM employee e, department d, salgrade s
WHERE e.dno = d.dno
AND salary BETWEEN losal AND hisal;

-- WHERE 절을 사용한 SELF JOIN
SELECT employees.ename "사원이름", manager.ename "직속상관이름"
FROM employee employees, employee manager
WHERE employees.manager = manager.eno;

-- JOIN ~ ON절을 사용한 SELF JOIN
SELECT employees.ename || '의 직속 상관은' || manager.ename
FROM employee employees JOIN employee manager
ON employees.manager = manager.eno;

-- 직속상관 (매니저)가 없는 사원의 이름도 출력하기
SELECT employees.ename || '의 직속 상관은' || manager.ename
FROM employee employees LEFT OUTER JOIN employee manager
ON employees.manager = manager.eno;