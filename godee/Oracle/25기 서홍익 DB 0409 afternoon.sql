--대소문자 변환함수 사용하기 
SELECT 'Oracle mania',
        UPPER('Oracle mania'),
        LOWER('Oracle mania'),
        INITCAP('Oracle mania')
FROM dual;

--대소문자 변환 함수를 컬럼에 사용하기
SELECT ename,LOWER(ename), job, INITCAP(job)
FROM employee;

--SCOTT사원을 소문자로 검색하기

SELECT *
FROM employee
WHERE LOWER(ename)='scott';

--SCOTT 사원의 이름만 첫글자만 대문자로 검색하기

SELECT *
FROM employee
WHERE INITCAP(ename)='Scott';

--SCOTT 사원을 대문자로 검색하기
SELECT *
FROM employee
WHERE UPPER(ename)='SCOTT';

--SCOTT 사원을 검색하기

SELECT *
FROM employee
WHERE ename='SCOTT';

--영문과 한글의 길이를 구하기

SELECT LENGTH('OracleMania'), LENGTH('오라클마니아')
FROM dual;

--영문과 한글의 바이트 수 구하기
--다국어는 LENGTHB 쓰기
SELECT LENGTHB('OracleMania'), LENGTHB('오라클마니아')
FROM dual;

--CONCAT는 문자열을 결합하는 함수입니다. 
-- 문자결합하기 

SELECT 'Oracle','mania',CONCAT('Oracle', 'mania')
FROM dual;

--SUBSTR은 기존 문자열에서 일부만 추출합니다. 
--문자열의 시작 위치부터 개수 만큼 문자만을 얻어옵니다.
--SUBSTR(대상,시작위치, 추출할 개수)

--문자열의 일부만 추철하기

SELECT SUBSTR('Oracle mania',4,3),SUBSTR('Oracle mania',-4,3)
FROM dual;

--이름이 N으로 끝나는 사원 표시하기

SELECT * 
FROM employee
WHERE SUBSTR(ename,-1,1)='N';


--SELECT ename, SUBSTR(ename,-1,1) 
--FROM employee;
--WHERE SUBSTR(ename,-1,1)='N';

SELECT *
FROM employee
WHERE ename LIKE '%N';

--87년도에 입사함 사원표시하기

SELECT *
FROM employee
WHERE SUBSTR(hiredate,1,2)='87';

SELECT *
FROM employee
WHERE hiredate LIKE '87%';

SELECT *
FROM employee
WHERE hiredate>='87/01/01' AND hiredate <='87/12/31';

SELECT *
FROM employee
WHERE hiredate BETWEEN'87/01/01' AND '87/12/31';

--영문 추출하기

SELECT SUBSTR('Oracle mania',4,3), SUBSTRB('Oracle mania',4,3)
FROM dual;

--한글 추출하기

SELECT SUBSTR('오라클매니아',3,4), SUBSTRB('오라클매니아',3,4)
FROM dual;

--INSTR 함수는 문자열 내에서 해당 문자가 어느 위치에 존재하는지를 알려줍니다. 
--INSTR(대상 , 찾을 글자 , 시작위치 , 몇 번째 발견)
--시작위치와 몇 번째 발견을 생략하면 모두 1로 간주한다. 

--문자 위치 찾기

SELECT  INSTR('Oracle Mania','a')
FROM dual;

--특정 위치 이후에 문자 위치 찾기
SELECT  INSTR('Oracle Mania','a',5,2)
FROM dual;

--세번째 자리가 'R'인 사원검색하기
--문자 위치와 결과값 맞추기
SELECT * 
FROM employee
WHERE INSTR(ename,'R',3,1)=3;

--SELECT ename, INSTR(ename,'R',3,1)
--FROM employee;


--LPAD (LEFT PADDING)함수는 컬럼이나 대상 문자열을 명시된 자릿수에서 오른쪽에 나타내고 , 남은 왼쪽자리를 특정기호로 채웁니다. 

--왼쪽 자리를 특정 기호로 채우기

SELECT LPAD(salary,10,'*') 
FROM employee;


--RPAD (RIGHT PADDING)함수는 컬럼이나 대상 문자열을 명시된 자릿수에서 왼쪽에 나타내고 , 남은 오른쪽자리를 특정기호로 채웁니다. 

--오른쪽 자리를 특정 기호로 채우기


SELECT RPAD(salary,10,'*') 
FROM employee;

--LTRIM 함수는 문자열의 왼쪽(앞)의 공백 문자들을 삭제하고,
--RTRIM 함수는 오른쪽(뒤)의 공백 문자를 잘라냅니다.

SELECT '     Oracle mania     ',LTRIM('     Oracle mania     '),RTRIM('     Oracle mania     ')
FROM dual;

--특정 문자 제거해기                    --매개변수
SELECT TRIM('  Oracle mania  '),TRIM( 'O' from 'Oracle mania')
FROM dual;

--앞뒤 공백 제거하기

SELECT TRIM('     Oracle mania    ')
FROM dual;