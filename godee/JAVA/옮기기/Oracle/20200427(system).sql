-- 사용자의 이름과 암호를 지정하여 사용자 생성하기
CREATE USER usertest01
IDENTIFIED BY pass1;

COMMIT;

GRANT CREATE SESSION 
TO usertest01;

COMMIT;

-- 테이블 생성 권한 부여하기
GRANT CREATE TABLE
TO usertest01;

COMMIT;

-- 테이블 스페이스 확인하기
SELECT username,default_tablespace
FROM dba_users
WHERE username IN ('USERTEST01');

-- 영역 할당하기
ALTER USER usertest01
QUOTA 100M ON USERS;

COMMIT;

GRANT UNLIMITED TABLESPACE
TO usertest01;

COMMIT;

-- HR 계정 권한 부여하기
ALTER USER hr
ACCOUNT UNLOCK;
COMMIT;

ALTER USER HR
IDENTIFIED BY 1234;

COMMIT;

-- 암호 변경하기
ALTER USER usertest01
IDENTIFIED BY 5678;
COMMIT;

CONN usertest01/5678;

-- 계정확인하기
SHOW USER;

-- 권한 제거하기
REVOKE CREATE SESSION
FROM usertest01;

COMMIT;

-- 권한 재부여하기
GRANT CREATE SESSION
TO usertest01;

COMMIT;

-- 시스템 권한 조회하기
SELECT *
FROM session_privs;

-- 사용자 생성 후 시스템 권한 부여하기
CREATE USER usertest02
IDENTIFIED BY pass2;

CREATE USER usertest03
IDENTIFIED BY pass3;

GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW
TO usertest02;

GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW
TO usertest03;

COMMIT;

-- 소유자로부터 객체 권한 부여하기
GRANT SELECT 
ON hr.employee
TO usertest02
WITH GRANT OPTION;