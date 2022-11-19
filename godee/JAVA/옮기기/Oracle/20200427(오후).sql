SHOW user;

SELECT *
FROM hr.employees;

-- hr 계정
-- 소유자로부터 객체 권한 부여하기

GRANT SELECT 
ON hr.employees
TO usertest03;

COMMIT;

-- usertest03 계정
-- 객체 권한 승계하기
GRANT SELECT 
ON hr.employees
TO usertest01;

-- hr 계정
-- SELECT 권한을 부여하기
SELECT *
FROM hr.departments;

GRANT SELECT
ON hr.departments
TO PUBLIC;

COMMIT;

-- usertest01
-- 모든 사용자 조회하기
SELECT *
FROM hr.departments;

-- usertest02
SELECT *
FROM hr.departments;

-- usertest03
SELECT *
FROM hr.departments;

-- 시스템 롤 부여하기
-- system 계정
CREATE USER usertest04
IDENTIFIED BY pass4;

GRANT CONNECT 
TO usertest04;

GRANT RESOURCE 
TO usertest04;

COMMIT;

-- 사용자 정의 롤 생성 및 권한 부여
CREATE ROLE roletest01;
GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW
TO roletest01;

GRANT roletest01
TO usertest01;

COMMIT;

-- SYSTEM 계정
-- 시스템 권한 정보 확인하기
SELECT *
FROM ROLE_SYS_PRIVS
WHERE ROLE LIKE '%TEST%';

-- usertest01
-- 사용자에게 부여된 롤 정보 확인
SELECT *
FROM USER_ROLE_PRIVS;

--system
DROP ROLE roletest01;

COMMIT;

-- 객체 권한을 롤에 부여하기
CREATE ROLE roletest02;
COMMIT;

--hr 계정
GRANT SELECT 
ON employees
TO roletest02;

-- system 
-- 롤을 사용자에게 부여하기
GRANT roletest02
TO usertest01;
COMMIT;

-- 사용자에게 롤이 부여되었는지 확인하기
-- usertest01
SELECT *
FROM hr.employees;

-- 데이터 사전 확인하기
SELECT *
FROM user_role_privs;

SELECT *
FROM role_tab_privs;