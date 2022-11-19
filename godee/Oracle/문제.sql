--3장 문제 1번 사원들의 입사한 년도와 입사한 달만 출력하시오

SELECT hiredate, SUBSTR(hiredate,1,2) AS 입사년도, SUBSTR(hiredate,4,2) AS 입사한달
FROM employee;

--SELECT TO_CHAR(hiredate,'YY')년도, TO_CHAR(hiredate,'MM')달
--FROM employee;

--****3장 문제 2번 4월에 입사한 사원을 출력하시오

SELECT *
FROM employee
WHERE TO_CHAR(hiredate,'MM')='04';

--SQL2]
--SELECT *
--FROM employee
--WHERE SUBSTR(TO_CHAR(hiredate),4,2)='04';

--SQL3]
--SELECT *
--FROM employee
--WHERE SUBSTR(TO_CHAR(hiredate,'YYMMDD'),3,2)='04';

--SQL2]
--SELECT *
--FROM employee
--WHERE SUBSTR(TO_CHAR(hiredate),4,2)='04';



--3장 문제 3번 사원번호가 짝수인 사원만 출력하시오

SELECT *
FROM employee
WHERE MOD(eno,2)=0;

SELECT *
FROM employee
WHERE SUBSTR(eno,-1,1)=IN(0,2,4,6,8);

--3장

