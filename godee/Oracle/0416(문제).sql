--4장 문제 1번 모든사원의 급여 최고액 최저액 총액 및 평균급여를 출력하시오
--컬럼의 별칭은 결과 화면과 동일하게 지정하고 평균에 대해서는 정수로 반올림 하시오

SELECT MAX(salary) AS Maximun , MIN(salary) AS Minimum , SUM(Salary) AS Sum, ROUND(AVG(salary)) AS Average
FROM employee;


--4장 문제 2번 각 담당 업무 유형별로 급쳐 최고, 최저액 ,총액 및 평균액을 출력하시오 . 
--칼럼의 별칭은 결과 화면과 동일하게 지정하고 평균에 대해서는 정수로 반올림하시오


SELECT job, MAX(salary)AS Maximun  , MIN(salary)AS Minimum , SUM(Salary) AS Sum , ROUND(AVG(salary))AS Average
FROM employee
GROUP BY job;

--4장 문제 3번 담당 업무유형별로 사원수를 출력하시오 칼럼명칭은 결과 화면과 동일하게 지정하시오.


SELECT job, COUNT(*)AS 사원수
FROM employee
GROUP BY job;

--4장 문제4번 상사의 수를 나열하시오 칼럼명의 별칭은 결과 화면과 동일하게 지정하시오

SELECT COUNT(job)
FROM employee
GROUP BY job;


--4장 문제 5번 모든 사원의 급여 최고액 최저액의 차액을 출력하시오. 칼럼의 별칭은 결과화면과 동일하게 지정하시오


SELECT MAX(salary)-MIN(salary) AS 차액
FROM employee;

--********4장 문제 6번 직급(업무별) 사원의 최저급여를 출력하시오 상사를 알수 없는 사원및 최저 급여가 2000미만인 그룹은 제외시키고 
-- 결과를 급여에 대한 내림차순으로 정렬하여 출력하시오
SELECT job, 
FROM employee
GROUP BY job



--4장 문제 7번 각 부서에 대해서 부서번호 사원수 부서 내의 모든 사원의 평균 급여를 출력하시오
--칼럼의 별칭은 결과 화면과 동일하게 지정하시오.
--평균 급여는 소수점 둘째 자리로 반올림하시오

SELECT dno,COUNT(job) "Number of People", ROUND(AVG(Salary),2) "Salary"
FROM employee
GROUP BY dno
ORDER By dno;

--**4장 - 문제 8번 각 부서에 대해서 부서번호 이름 지역명 사원수 부서내의 모든 사워의 평균 급여를 출력하시오
--칼럼의 별칭은 화면과 동일하게 저장하고 평균 급여는 정수로 반올림하시오

SELECT dname, loc AS location
FROM department;



--4장- 문제 9번 업무를 표시한 다음 해당 업므에 대해 부서번호별 급여및 부서 10,20,30, 의 급여 총액을 각각 출력하시오
--칼럼의 별칭은 결과 화면과 동일하게 지정하시오

SELECT dno 
FROM department
WHERE 
    emp IN( SELECT SUM (salary) FROM employee) ;






