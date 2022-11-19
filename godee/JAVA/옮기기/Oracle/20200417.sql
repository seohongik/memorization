
-- SCOTT 사원의 이름과 부서번호 및 부서이름을 출력하시오. 칼럼의 별칭은 '사원명', '부서번호', '부서명' 순으로 정합니다.
SELECT e.ename "사원명", e.dno "부서번호", d.dname "부서명"
FROM employee e, department d
WHERE e.dno = d.dno
AND e.ename='SCOTT';

SELECT *
FROM department;

-- 사원이름과 함께 그 사원이 소속된 부서이름과 지역명을 출력하시오. 칼럼의 별칭은 '사원명', '부서명', '지역명' 순으로 정합니다.
SELECT e.ename "사원명", d.dname "부서명", d.doc "지역명"
FROM employee e, department d
WHERE e.dno = d.dno;

-- 10번 부서에 속하는 모든 담당 업무의 고유 목록(한 번씩만 표시)을 부서의 지역명을 포함하여 출력하시오.
-- 칼럼의 별칭은 '부서번호', '담당업무', '지역명' 순으로 정합니다.
SELECT d.dno "부서번호", e.job "담당업무", d.doc "지역명"
FROM employee e, department d
WHERE e.dno = d.dno
AND e.dno = 10;

-- 커미션을 받는 모든 사원의 이름, 부서이름, 지역명을 포함하여 출력하시오. 칼럼의 별칭은 '사원명', '부서명', '지역명' 순으로 정합니다.
SELECT e.ename "사원명", d.dname "부서명", d.doc "지역명"
FROM employee e, department d
WHERE e.dno = d.dno
AND commision > 0;

-- 이름에 A가 포함된 모든 사원의 이름과 부서이름을 출력하시오. 칼럼의 별칭은 '사원명', '부서명' 순으로 정합니다.
SELECT e.ename "사원명", d.dname "부서명"
FROM employee e, department d
WHERE e.dno = d.dno
AND ename LIKE '%A%';

-- NEW YORK에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오. 칼럼의 별칭은 '사원명', '담당업무', '부서번호', '부서명' 순으로 정합니다.
SELECT e.ename "사원명", e.job "담당업무", e.dno "부서번호", d.dname "부서명"
FROM employee e, department d
WHERE e.dno = d.dno
AND d.doc = 'NEW YORK';


-- 사원의 이름 및 사원번호를 관리자(상사) 이름 및 관리자(상사) 번호와 함께 출력하시오. 칼럼의 별칭은 '사원명', '사원번호', '관리자이름', '관리자번호' 순으로 정합니다.
SELECT e.ename "사원명", e.eno "사원번호", ee.ename "관리자이름", ee.eno "관리자번호"
FROM employee e, employee ee
WHERE e.manager = ee.eno;

--관리자(상사)가 없는 사원을 포함하여 사원번호를 기준으로 내림차순 정렬하여 출력하시오. 칼럼의 별칭은 '사원명', '사원번호', '관리자이름', '관리자번호' 순으로 정합니다.
-- NULL인 경우 0 또는 'NONE'으로 표시합니다.
SELECT e.ename "사원명", e.eno "사원번호", NVL(ee.ename, 0) "관리자이름", NVL(ee.eno, 0) "관리자번호"
FROM employee e, employee ee
WHERE e.manager = ee.eno(+)
ORDER BY e.eno DESC;

-- 'SCOTT' 사원의 이름, 부서번호, 지정한 사원과 동일한 부서에서 근무하는 사원을 출력하시오. 칼럼의 별칭은 '사원명', '부서번호', '동료명' 순으로 정합니다.
SELECT e.ename "사원명", e.dno "부서번호", ee.ename "동료명"
FROM employee e, employee ee
WHERE e.dno = ee.dno
AND e.ename = 'SCOTT'
AND ee.ename != 'SCOTT';


SELECT ename, hiredate
FROM employee;

-- 이름이 'WARD'라는 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오. 칼럼의 별칭은 '사원명', '입사일' 순으로 정합니다.
SELECT e.ename "사원명", e.hiredate "입사일"
FROM employee e, employee ee
WHERE ee.ename = 'WARD' 
AND ee.hiredate < e.hiredate
ORDER BY e.hiredate ASC;


-- 관리자(상사)보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자(상사)의 이름 및 입사일과 함께 출력하시오.
-- 칼럼의 별칭은 '사원명', '입사일', '관리자명', '관리자입사일' 순으로 정합니다.
SELECT e.ename "사원명", e.hiredate "입사일", ee.ename "관리자명", ee.hiredate "관리자입사일"
FROM employee e, employee ee
WHERE e.manager = ee.eno 
AND e.hiredate < ee.hiredate;


