SELECT *
FROM department;

SELECT *
FROM employee;

--카디시안곱
SELECT *
FROM department,employee;

--EQUI JOIN 각 사원들이 소속된 부서 정보 출력하기 
SELECT *
FROM employee, department
WHERE employee.dno = department.dno;

--EQUI JOIN 사원번호, 사원이름 , 소속부서를 출력하기
SELECT eno, ename, dname
FROM employee, department
WHERE employee.dno = department.dno;

--EQUI JOIN scott 사원번호, 사원이름 , 소속부서를 출력하기 
SELECT eno, ename, dname
FROM employee, department
WHERE employee.dno = department.dno
AND eno=7788;

--주의사항
SELECT eno, ename, dname, dno
FROM employee, department
WHERE employee.dno = department.dno
AND eno=7788;

--컬럼명 앞에 테이블명 명시하기
SELECT employee.eno, employee.ename, department.dname, employee.dno
FROM employee, department
WHERE employee.dno = department.dno
AND eno=7788;

--부분적으로 컬럼명 앞에 테이블 명시하기 

SELECT eno, ename, dname, employee.dno
FROM employee, department
WHERE employee.dno = department.dno
AND eno=7788;

--테이블에 별칭사용하기(별칭과 테이블명 혼용금지)

SELECT e.eno, e.ename, d.dname, e.dno
FROM employee e, department d
WHERE e.dno = d.dno
AND eno=7788;


--주의사항

SELECT e.eno, e.ename, d.dname, e.dno
FROM employee e NATURAL JOIN department d
WHERE e.eno=7788;


--조인 컬럼에 테이블 별칭을 사용하지 않은 경우(NATURAL JOIN을 할 때는 같이 걸려있으면 별칭을 빼라)
SELECT e.eno, e.ename, d.dname, dno
FROM employee e NATURAL JOIN department d
WHERE e.eno=7788;

--USING 절 사용하기

SELECT e.eno, e.ename, d.dname, dno
FROM employee e JOIN department d
USING(dno)
WHERE e.eno=7788;

--ON 절 사용하기  (e.dno와 d.dno가 겹치니까 ON절 사용하기)
SELECT e.eno, e.ename, d.dname, e.dno 
FROM employee e JOIN department d
ON e.dno = d.dno
WHERE e.eno=7788;


--ON 절 사용하기 주의  (e.dno와 d.dno가 겹치니까 ON절 사용하기)
SELECT e.eno, e.ename, d.dname, dno 
FROM employee e JOIN department d
ON e.dno = d.dno
WHERE e.eno=7788;



--사원별로 급여 등급 출력하기 
desc salgrade;

SELECT ename, salary, grade 
FROM employee, salgrade 
WHERE salary BETWEEN losal AND hisal;

SELECT ename, salary, grade 
FROM employee, salgrade 
WHERE salary>=losal AND salary<=hisal;




--3개의 테이블 조인하기 

SELECT e.ename, d.dname, e.salary, s.grade 
FROM employee e,department d ,salgrade s 
WHERE e.dno =d.dno
AND salary BETWEEN losal AND hisal;

--WHERE 절을 사용한 SELF JOIN
SELECT employees.ename"사원이름", manager.ename"직속상관이름"
FROM employee employees, employee manager
WHERE employees.manager = manager.eno;

--JOIN ~ON 절을 사용한 SELF JOIN  // ||(concat)

SELECT employees.ename || '의 직속 상관은' || manager.ename
FROM employee employees JOIN employee manager
ON employees.manager = manager.eno;

--직속 상관(매니저)가 없은 사원의 이름도 출력하기 

SELECT employees.ename || '의 직속 상관은' || manager.ename
FROM employee employees JOIN employee manager
ON employees.manager = manager.eno(+);

-- 주의사항

SELECT employees.ename || '의 직속 상관은' || manager.ename
FROM employee employees JOIN employee manager
ON employees.manager(+) = manager.eno;

--직속 상관(매니저)가 없은 사원의 이름도 출력하기
SELECT employees.ename || '의 직속 상관은' || manager.ename
FROM employee employees LEFT OUTER JOIN employee manager
ON employees.manager = manager.eno;

--left OUTER JOIN 기준 오른쪽 왼쪽은 null righter outer JOIN 기운 왼쪽 오른쪽은 null


